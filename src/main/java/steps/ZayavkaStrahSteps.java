package steps;

import pages.ZayavkaStrahPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ZayavkaStrahSteps extends BaseSteps {

    ZayavkaStrahPage page;
    public ZayavkaStrahSteps()
    {
        page=new ZayavkaStrahPage(driver);
    }

    @Step("Выбираем минимальный тариф")
    public ZayavkaStrahSteps stepClickMinimal(){
        page.clickMinimal();
        return this;
    }

    @Step("Выбираем минимальный тариф")
    public ZayavkaStrahSteps stepClickOform(){
        page.clickOform();
        return this;
    }

}
