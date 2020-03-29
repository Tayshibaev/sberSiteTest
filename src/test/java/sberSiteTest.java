import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class sberSiteTest {
    WebDriver driver;
    String url = "https://www.sberbank.ru/ru/person";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);//задаем тайм аут по умолчанию ожидания поиска
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get(url);

        driver.findElement(By.xpath("//span[text()='Страхование']")).click();
        driver.findElement(By.xpath("//ul[@class='lg-menu__sub-list']//a[text()='Страхование путешественников']")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 3, 15000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'top_40')]//h2[text()='Страхование путешественников']"))));

        driver.findElement(By.xpath("//b[text()='Оформить онлайн']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[text()='Страхование путешественников']"))));

        driver.findElement(By.xpath("//h3[contains(text(),'Минимал')]")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Оформить']")))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//legend[contains(text(),'Застрахованные')]"))));

        //Даты рождения
        Calendar dateBirthPeople = new GregorianCalendar(1999,02,13);
        Calendar dateBirthPerson = new GregorianCalendar(1995,04,15);

        SimpleDateFormat smp = new SimpleDateFormat("dd.MM.YYYY");
        //Заполнение полей
        fillField(By.id("surname_vzr_ins_0"),"Ivanushka");
        fillField(By.id("name_vzr_ins_0"),"English");
        fillFieldDate(By.id("birthDate_vzr_ins_0"),dateBirthPeople.getTime());
        fillFieldDate(By.id("person_birthDate"),dateBirthPerson.getTime());
        fillField(By.id("person_lastName"),"Василий");
        fillField(By.id("person_firstName"),"Петрович");
        fillField(By.id("person_middleName"),"Магаданович");
        driver.findElement(By.xpath("//label[text()='Женский']")).click();

        //заполнение полей паспорта
        fillField(By.id("passportSeries"),"4456");
        fillField(By.id("passportNumber"),"445656");
        fillFieldDate(By.id("documentDate"),dateBirthPerson.getTime());



        Assert.assertEquals("Ivanushka",
                driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("English",
                driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));

        Assert.assertEquals("Василий",
                driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("Петрович",
                driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Магаданович",
                driver.findElement(By.id("person_middleName")).getAttribute("value"));

        Assert.assertEquals("4456",
                driver.findElement(By.id("passportSeries")).getAttribute("value"));
        Assert.assertEquals("445656",
                driver.findElement(By.id("passportNumber")).getAttribute("value"));

        Assert.assertEquals(smp.format(dateBirthPeople.getTime()),
                driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals(smp.format(dateBirthPerson.getTime()),
                driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        Assert.assertEquals(smp.format(dateBirthPerson.getTime()),
                driver.findElement(By.id("documentDate")).getAttribute("value"));

        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']"))));

        Assert.assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']")).getText());



        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void fillField(By by ,String val)
    {
        //клик для того, чтобы окно с выбором даты исчезло
        driver.findElement(by).click();

        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(val);
    }

    public void fillFieldDate(By by, Date date)
    {
        SimpleDateFormat simpliDateForm = new SimpleDateFormat("dd.MM.YYYY");
        String dateString = simpliDateForm.format(date);
        //клик для того, чтобы окно с выбором даты исчезло
        driver.findElement(by).click();

        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(dateString);

    }
}
