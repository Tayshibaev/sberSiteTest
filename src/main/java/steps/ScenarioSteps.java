package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Enum.SEX;

public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();
    OformlenieSteps ofsteps = new OformlenieSteps();
    StrahovanieSteps strSteps = new StrahovanieSteps();
    ZayavkaStrahSteps zsteps = new ZayavkaStrahSteps();


    @When("^Выбран пункт меню \"(.*)\"$")
    public void stepSelectMenuItem(String item)
    {
        mainSteps.stepSelectMenuItem(item);
    }

    @When("^выбран вид страхования - \"(.*)\"")
    public void stepSubMainMenu(String menuItem)
    {
        mainSteps.stepSubMenuItem(menuItem);
    }

    @When("^выполнено нажатие на кнопку оформить онлайн")
    public void stepSendAppButton(){
        strSteps.stepClickBtn();
    }

    @When("^выран минимальный тариф")
    public void stepClickMinimal()
    {
        zsteps.stepClickMinimal();
    }

    @When("^нажатие на кнопку оформление")
    public void stepClickOform()
    {
        zsteps.stepClickOform();
    }

    @When("^заполняются текстовые поля:$")
    public void fillTextForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> ofsteps.stepFillField(field, value));
    }

    @Then("^проверяются текстовые поля:$")
    public void checkTextForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> ofsteps.stepCheckField(field, value));
    }



    @When("^заполняются поля с датами:$")
    public void fillDateForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> ofsteps.stepDateFillField(field, value));
    }

    @Then("^проверяются поля с датами:$")
    public void checkDateForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> ofsteps.stepDateFillField(field, value));
    }

    @When("^выбран пол - \"(.*)\"")
    public void stepSelectSex(String sex)
    {
        ofsteps.stepSelectSex(SEX.valueOf(sex));
    }

    @When("^нажатие на кнопку Продолжитьт")
    public void stepClickCont()
    {
        ofsteps.stepClickContinue();
    }

    @Then("^Проверка ошибки")
    public void stepCheckError()
    {
        ofsteps.stepCheckError();
    }

}
