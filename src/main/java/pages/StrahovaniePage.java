package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StrahovaniePage {

    @FindBy(xpath = "//div[contains(@class,'top_40')]//h2[text()='Страхование путешественников']")
    WebElement title;

    //Оформить онлайн
    @FindBy(xpath = "//b[text()='Оформить онлайн']")
    WebElement btn;

    public StrahovaniePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        (new WebDriverWait(driver,2,10)).until(ExpectedConditions.visibilityOf(title));
    }

    public void clickButton(){
        btn.click();
    }
}
