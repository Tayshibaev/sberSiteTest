package steps;

import pages.OformleniePage;
import ru.yandex.qatools.allure.annotations.Step;
import Enum.TextFieldOformlenieEnum;
import Enum.SEX;

import java.util.Date;
import java.util.HashMap;

public class OformlenieSteps extends BaseSteps {
    OformleniePage page;

    public OformlenieSteps() {
        this.page = new OformleniePage(driver);
    }

    @Step("Заполнение поля {0} значением {1}")
    public OformlenieSteps stepFillField(TextFieldOformlenieEnum text,String s)
    {
        page.fillField(text,s);
        return this;
    }

    @Step("Заполнение текстовых полей: ")
    public OformlenieSteps stepFillFields(HashMap<TextFieldOformlenieEnum,String> map)
    {
        map.forEach(this::stepFillField);
        return this;
    }

    @Step("Заполнение поля {0} значением {1}")
    public OformlenieSteps stepDateFillField(String text, Date s)
    {
        page.fillDate(text,s);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Заполнение текстовых полей: ")
    public OformlenieSteps stepDateFillFields(HashMap<String,Date> map)
    {
        map.forEach(this::stepDateFillField);
        return this;
    }

    @Step("Выбор пола: {0}")
    public OformlenieSteps stepSelectSex(SEX sex)
    {
        page.selectSex(sex);
        return this;
    }

    @Step("Нажать кнопку продолжить")
    public OformlenieSteps stepClickContinue()
    {
        page.clickContinue();
        return this;
    }

    @Step("Проверка поля {0} и значеня {1}")
    public OformlenieSteps stepCheckField(TextFieldOformlenieEnum text,String s)
    {
        page.checkTextFieldValue(text,s);
        return this;
    }

    @Step("Проверка текстовых полей: ")
    public OformlenieSteps stepCheckFields(HashMap<TextFieldOformlenieEnum,String> map)
    {
        map.forEach(this::stepCheckField);
        return this;
    }

    @Step("Проверка поля {0} и значеня {1}")
    public OformlenieSteps stepDateCheckField(String text, Date s)
    {
        page.checkDate(text,s);
        return this;
    }

    @Step("Проверка текстовых полей: ")
    public OformlenieSteps stepDateCheckFields(HashMap<String,Date> map)
    {
        map.forEach(this::stepDateCheckField);
        return this;
    }

    @Step("Проверка ошибки")
    public OformlenieSteps stepCheckError()
    {
        page.checkError();
        return this;
    }






}
