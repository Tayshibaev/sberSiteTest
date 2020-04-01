package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class StrahovaniePage {

    @FindBy(xpath = "//div[contains(@class,'top_40')]//h2[text()='Страхование путешественников']")
    WebElement title;

    //Оформить онлайн
    @FindBy(xpath = "//b[text()='Оформить онлайн']")
    WebElement btn;

    public StrahovaniePage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void clickButton(){
        (new WebDriverWait(BaseSteps.getDriver(),2,10)).until(ExpectedConditions.visibilityOf(title));
        btn.click();
    }
}
