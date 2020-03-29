import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class sberSiteTest extends BaseTest {
    
    @Test
    public void test() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 3, 15000);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Страхование']")))).click();

   //     driver.findElement(By.xpath("//span[text()='Страхование']")).click();
        driver.findElement(By.xpath("//ul[@class='lg-menu__sub-list']//a[text()='Страхование путешественников']")).click();
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
}
