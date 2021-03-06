package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.TestProperties;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    protected static WebDriver driver;
    protected static Properties properties = TestProperties.getINSTANCE().getProperties();
    protected static String baseUrl;

    @Before
    public static void setUp() {

        switch (properties.getProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
                driver = new ChromeDriver();
        }

        baseUrl = "https://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);//задаем тайм аут по умолчанию ожидания поиска
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public static void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void fillField(By by , String val)
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

    public void assertEqualsByIdAtrribut(String expected, String id)
    {
        Assert.assertEquals(expected,
                driver.findElement(By.id(id)).getAttribute("value"));
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
