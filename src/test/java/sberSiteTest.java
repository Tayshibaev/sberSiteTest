
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.OformleniePage;
import pages.StrahovaniePage;
import pages.ZayavkaStrahPage;
import Enum.TextFieldOformlenieEnum;
import Enum.SEX;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class sberSiteTest extends BaseTest {

    @Test
    public void test() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 3, 15000);

        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Страхование");
        mainPage.selectSubMenuItem("Страхование путешественников");

        //Страница страхование
        StrahovaniePage strPage = new StrahovaniePage(driver);
        //Оформить онлайн
        strPage.clickButton();

        //Страница заявки
        ZayavkaStrahPage zpage = new ZayavkaStrahPage(driver);
        //выбор минимального тарифа
        zpage.clickMinimal();
        //Задержка пока кнопка оформление станет кликабельной
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Кликнуть оформление
        zpage.clickOform();

        //Ожидаем страницу оформление
        OformleniePage ofPage = new OformleniePage(driver);

        //Даты рождения
        Calendar dateBirthPeople = new GregorianCalendar(1999,02,13);
        Calendar dateBirthPerson = new GregorianCalendar(1995,04,15);
        Calendar documentDate = new GregorianCalendar(1991,01,01);

        //Фамилии, Имена, отчество, номер и серия папорта
        String surname_vzr = "Bobywhite";
        String name_vzr = "Bob";
        String namePerson = "Привет";
        String lastnamePerson = "Хай";
        String middlenamePerson = "Хаюшки";
        String passport = "4321654321";

        //Заполнение полей
        ofPage.fillField(TextFieldOformlenieEnum.ЗАСТРАХОВАННЫЙ_ИМЯ,name_vzr);
        ofPage.fillField(TextFieldOformlenieEnum.ЗАСТРАХОВАННЫЙ_фАМИЛИЯ,surname_vzr);
        ofPage.fillDate("Застрахованный",dateBirthPerson.getTime());

        ofPage.fillField(TextFieldOformlenieEnum.СТРАХОВАТЕЛЬ_ФАМИЛИЯ,lastnamePerson);
        ofPage.fillField(TextFieldOformlenieEnum.СТРАХОВАТЕЛЬ_ИМЯ,namePerson);
        ofPage.fillField(TextFieldOformlenieEnum.СТРАХОВАТЕЛЬ_ОТЧЕСТВО,middlenamePerson);
        ofPage.selectSex(SEX.ЖЕНСКИЙ);
        ofPage.fillDate("Страхователь",dateBirthPeople.getTime());

        ofPage.fillField(TextFieldOformlenieEnum.СЕРИЯ_ПАСПОРТА,passport.substring(0,4));
        ofPage.fillField(TextFieldOformlenieEnum.НОМЕР_ПАСПОРТА,passport.substring(4,10));
        ofPage.fillDate("Паспорт",documentDate.getTime());

        //Проверка полей
        ofPage.checkTextFieldValue(TextFieldOformlenieEnum.ЗАСТРАХОВАННЫЙ_ИМЯ,name_vzr);
        ofPage.checkTextFieldValue(TextFieldOformlenieEnum.ЗАСТРАХОВАННЫЙ_фАМИЛИЯ,surname_vzr);
        ofPage.checkDate("Застрахованный",dateBirthPerson.getTime());

        ofPage.checkTextFieldValue(TextFieldOformlenieEnum.СТРАХОВАТЕЛЬ_ФАМИЛИЯ,lastnamePerson);
        ofPage.checkTextFieldValue(TextFieldOformlenieEnum.СТРАХОВАТЕЛЬ_ИМЯ,namePerson);
        ofPage.checkTextFieldValue(TextFieldOformlenieEnum.СТРАХОВАТЕЛЬ_ОТЧЕСТВО,middlenamePerson);
        ofPage.checkDate("Страхователь",dateBirthPeople.getTime());

        ofPage.checkTextFieldValue(TextFieldOformlenieEnum.СЕРИЯ_ПАСПОРТА,passport.substring(0,4));
        ofPage.checkTextFieldValue(TextFieldOformlenieEnum.НОМЕР_ПАСПОРТА,passport.substring(4,10));
        ofPage.checkDate("Паспорт",documentDate.getTime());
        //Нажать на кнопку продолжить
        ofPage.clickContinue();
        //Проверка, что вылезло сообщение об ошибке
        ofPage.checkError();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
