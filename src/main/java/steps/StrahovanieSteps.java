package steps;

import pages.StrahovaniePage;
import ru.yandex.qatools.allure.annotations.Step;

public class StrahovanieSteps extends BaseSteps{

    @Step("На странице страхования кликаем кнопку Оформить онлайн")
    public void stepClickBtn()
    {
        new StrahovaniePage(driver).clickButton();
    }
}
