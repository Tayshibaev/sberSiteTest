package steps;

import pages.StrahovaniePage;
import ru.yandex.qatools.allure.annotations.Step;

public class StrahovanieSteps{

    @Step("На странице страхования кликаем кнопку Оформить онлайн")
    public void stepClickBtn()
    {
        new StrahovaniePage().clickButton();
    }
}
