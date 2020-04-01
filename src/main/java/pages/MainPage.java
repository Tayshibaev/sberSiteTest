package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage {

    //Элемент меню
    @FindBy(xpath = "//div[contains(@class,'lg-menu__row')]")
    WebElement menuItem;

    //подменю
    @FindBy(xpath = "//div[contains(@class,'lg-menu__col')]")
    WebElement subMenu;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void selectMenuItem(String item){
        menuItem.findElement(By.xpath(".//li//span[text()='"+item+"']")).click();
    }

    public void selectSubMenuItem(String item){
        menuItem.findElement(By.xpath("//li//a[text()='"+item+"']")).click();
    }
}
