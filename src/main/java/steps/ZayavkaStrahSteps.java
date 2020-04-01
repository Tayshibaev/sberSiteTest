package steps;

import pages.ZayavkaStrahPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ZayavkaStrahSteps{

    ZayavkaStrahPage page;
    public ZayavkaStrahSteps()
    {
        page=new ZayavkaStrahPage();
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
