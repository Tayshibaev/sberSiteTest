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
    public void setUp()
      {
        System.setProperty("webdriver.chrome.driver","drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);//задаем тайм аут по умолчанию ожидания поиска
        driver.manage().window().maximize();
      }

      @Test
      public void test()
      {
          driver.get(url);
          driver.findElement(By.xpath("//a[text()='Страхование']")).click();
          Wait<WebDriver> wait = new WebDriverWait(driver,5,15000);
          wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
      }

      @After
      public void tearDown()
      {
          driver.quit();
      }
}
