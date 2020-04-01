package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class ZayavkaStrahPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[text()='Страхование путешественников']")
    WebElement title;

    @FindBy(xpath = "//h3[contains(text(),'Минимал')]")
    WebElement btnMin;

    @FindBy(xpath = "//button[text()='Оформить']")
    WebElement btnOform;

    public ZayavkaStrahPage() {
        PageFactory.initElements(BaseSteps.getDriver(),this);

        this.driver = BaseSteps.getDriver();
        this.wait = new WebDriverWait(BaseSteps.getDriver(),2,10);
    }

    public void clickMinimal() {

        (new WebDriverWait(BaseSteps.getDriver(),2,10)).until(ExpectedConditions.visibilityOf(title));
        btnMin.click();
    }

    public void clickOform() {
        wait.until(ExpectedConditions.elementToBeClickable(btnOform)).click();
    }
}
