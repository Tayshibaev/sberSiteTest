package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZayavkaStrahPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[text()='Страхование путешественников']")
    WebElement title;

    @FindBy(xpath = "//h3[contains(text(),'Минимал')]")
    WebElement btnMin;

    @FindBy(xpath = "//button[text()='Оформить']")
    WebElement btnOform;

    public ZayavkaStrahPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        (new WebDriverWait(driver,2,10)).until(ExpectedConditions.visibilityOf(title));
        this.driver = driver;
        this.wait = new WebDriverWait(driver,2,10);
    }

    public void clickMinimal() {
        btnMin.click();
    }

    public void clickOform() {
        wait.until(ExpectedConditions.visibilityOf(btnOform)).click();
    }
}
