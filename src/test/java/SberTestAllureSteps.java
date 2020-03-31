import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Enum.*;

import java.util.GregorianCalendar;
import java.util.HashMap;

public class SberTestAllureSteps extends BaseSteps {

    @Test
    @Title("Сбер Страхование")
    public void test()
    {
        //На странице главное меню выбираем два пункта
        new MainSteps()
                .stepSelectMenuItem("Страхование")
                .stepSubMenuItem("Страхование путешественников");

        //Кликаем оформить онлайн
        new StrahovanieSteps().stepClickBtn();

        //На странице страхование выбираем минимальный тариф и нажимаем продолжить
        new ZayavkaStrahSteps()
                .stepClickMinimal()
                .stepClickOform();

        HashMap<TextFieldOformlenieEnum,String> textMap = new HashMap<>();
        HashMap<String,Date> dateMap = new HashMap<>();

        //Даты рождения
        Calendar dateBirthPeople = new GregorianCalendar(1999,02,13);
        Calendar documentDate = new GregorianCalendar(2019,03,13);
        Calendar dateBirthPerson = new GregorianCalendar(1995,04,15);


        textMap.put(TextFieldOformlenieEnum.НОМЕР_ПАСПОРТА,"654321");
        textMap.put(TextFieldOformlenieEnum.СЕРИЯ_ПАСПОРТА,"1234");
        textMap.put(TextFieldOformlenieEnum.ЗАСТРАХОВАННЫЙ_ИМЯ,"Pika");
        textMap.put(TextFieldOformlenieEnum.ЗАСТРАХОВАННЫЙ_фАМИЛИЯ,"Chu");
        textMap.put(TextFieldOformlenieEnum.СТРАХОВАТЕЛЬ_ИМЯ,"Рома");
        textMap.put(TextFieldOformlenieEnum.СТРАХОВАТЕЛЬ_ОТЧЕСТВО,"Рома");
        textMap.put(TextFieldOformlenieEnum.СТРАХОВАТЕЛЬ_ФАМИЛИЯ,"Роман");


        dateMap.put("Страхователь",dateBirthPeople.getTime());
        dateMap.put("Застрахованный",dateBirthPerson.getTime());
        dateMap.put("Паспорт",documentDate.getTime());

        new OformlenieSteps()
                .stepFillFields(textMap)
                .stepDateFillFields(dateMap)
                .stepSelectSex(SEX.ЖЕНСКИЙ)
                .stepClickContinue();

        new OformlenieSteps()
                .stepCheckFields(textMap)
                .stepDateCheckFields(dateMap)
                .stepCheckError();




    }

}
