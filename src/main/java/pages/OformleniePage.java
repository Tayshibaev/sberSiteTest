package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Enum.TextFieldOformlenieEnum;
import Enum.SEX;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OformleniePage {

    WebDriver driver;

    @FindBy(xpath = "//legend[contains(text(),'Застрахованные')]")
    WebElement title;

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surnameVzr;

    @FindBy(id = "name_vzr_ins_0")
    WebElement nameVzr;

    @FindBy(id = "person_lastName")
    WebElement lastNamePerson;

    @FindBy(id = "person_firstName")
    WebElement firstNamePerson;

    @FindBy(id = "person_middleName")
    WebElement middleNamePerson;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDateVzr;

    @FindBy(id = "person_birthDate")
    WebElement birthDatePerson;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(xpath = "//form-control-label[@title='Пол']")
    WebElement sex;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    WebElement btnContinue;


    public OformleniePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        new WebDriverWait(driver, 2, 10).until(ExpectedConditions.visibilityOf(title));
    }

    public void clickContinue() {
        btnContinue.click();
    }

    public void fillField(TextFieldOformlenieEnum textField, String val) {
        switch (textField) {
            case ЗАСТРАХОВАННЫЙ_ИМЯ:
                fillField(nameVzr, val);
                break;
            case ЗАСТРАХОВАННЫЙ_фАМИЛИЯ:
                fillField(surnameVzr, val);
                break;
            case СТРАХОВАТЕЛЬ_ИМЯ:
                fillField(firstNamePerson, val);
                break;
            case СТРАХОВАТЕЛЬ_ФАМИЛИЯ:
                fillField(lastNamePerson, val);
                break;
            case СТРАХОВАТЕЛЬ_ОТЧЕСТВО:
                fillField(middleNamePerson, val);
                break;
            case СЕРИЯ_ПАСПОРТА:
                fillField(passportSeries, val);
                break;
            case НОМЕР_ПАСПОРТА:
                fillField(passportNumber, val);
                break;
        }
    }

    public void selectSex(SEX sexEnum) {
        String s = sexEnum.getSex();
        sex.findElement(By.xpath(".//label[text()='" + s + "']")).click();
    }

    public void fillDate(String name, Date date) {
        switch (name) {
            case "Страхователь":
                fillFieldDate(birthDatePerson, date);
                nameVzr.click();
                break;
            case "Застрахованный":
                fillFieldDate(birthDateVzr, date);
                nameVzr.click();
                break;
            case "Паспорт":
                fillFieldDate(documentDate, date);
                nameVzr.click();
                break;
            default:
                new AssertionError();
        }
    }

    private void fillField(WebElement by, String val) {
        //клик для того, чтобы окно с выбором даты исчезло
        by.click();

        by.clear();
        by.sendKeys(val);
    }

    public void fillFieldDate(WebElement by, Date date) {
        SimpleDateFormat simpliDateForm = new SimpleDateFormat("dd.MM.YYYY");
        String dateString = simpliDateForm.format(date);
        //клик для того, чтобы окно с выбором даты исчезло
        by.click();

        by.clear();
        by.sendKeys(dateString);
    }

    public void checkDate(String name,Date date)
    {
        SimpleDateFormat smp = new SimpleDateFormat("dd.MM.YYYY");
        switch (name)
        {
            case "Страхователь":
                Assert.assertEquals(smp.format(date),
                        birthDatePerson.getAttribute("value"));
                break;
            case "Застрахованный":
                Assert.assertEquals(smp.format(date),
                        birthDateVzr.getAttribute("value"));
                break;
            case "Паспорт":
                Assert.assertEquals(smp.format(date),
                        documentDate.getAttribute("value"));
                break;
            default:
                new AssertionError();
        }
    }

    public void checkTextField(WebElement elem, String expectedValue) {
        Assert.assertTrue("Поле не соответствует ожидаемому занчению", elem.getAttribute("value").equals(expectedValue));
    }

    public void checkTextFieldValue(TextFieldOformlenieEnum textField, String expectedValue) {
        switch (textField) {
            case ЗАСТРАХОВАННЫЙ_ИМЯ:
                checkTextField(nameVzr, expectedValue);
                break;
            case ЗАСТРАХОВАННЫЙ_фАМИЛИЯ:
                checkTextField(surnameVzr, expectedValue);
                break;
            case СТРАХОВАТЕЛЬ_ИМЯ:
                checkTextField(firstNamePerson, expectedValue);
                break;
            case СТРАХОВАТЕЛЬ_ФАМИЛИЯ:
                checkTextField(lastNamePerson, expectedValue);
                break;
            case СТРАХОВАТЕЛЬ_ОТЧЕСТВО:
                checkTextField(middleNamePerson, expectedValue);
                break;
            case СЕРИЯ_ПАСПОРТА:
                checkTextField(passportSeries, expectedValue);
                break;
            case НОМЕР_ПАСПОРТА:
                checkTextField(passportNumber, expectedValue);
                break;
        }
    }

    public void checkError()
    {
        WebDriverWait wait = new WebDriverWait(driver,2,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']"))));
        Assert.assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']")).getText());
    }
}
