import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class sberSiteTest {
    WebDriver driver;
    String url = "https://www.sberbank.ru/ru/person";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);//задаем тайм аут по умолчанию ожидания поиска
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get(url);

        //driver.findElement(By.xpath("//a[text()='Страхование']")).click();
        driver.findElement(By.xpath("//span[text()='Страхование']")).click();
        driver.findElement(By.xpath("//ul[@class='lg-menu__sub-list']//a[text()='Страхование путешественников']")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 15000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'top_40')]//h2[text()='Страхование путешественников']"))));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//b[text()='Оформить онлайн']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[text()='Страхование путешественников']"))));

        driver.findElement(By.xpath("//h3[contains(text(),'Минимал')]")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Оформить']")))).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//legend[contains(text(),'Застрахованные')]"))));
        driver.findElement(By.id("surname_vzr_ins_0")).sendKeys("Ivan");
        fillField(By.id("surname_vzr_ins_0"),"Ivanushka");
        


        try {
            Thread.sleep(2000);
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
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(val);
    }
}
