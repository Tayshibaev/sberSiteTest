package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step("Выбор пункта {0} из верхнего меню")
    public MainSteps stepSelectMenuItem(String item){
        new MainPage().selectMenuItem(item);
        return this;
    }

    @Step("Выбор пункта {0} из выпадающего меню")
    public MainSteps stepSubMenuItem(String item){
        new MainPage().selectSubMenuItem(item);
        return this;
    }

}
