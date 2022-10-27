package PageObjects;

import ActionDriver.Action;
import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PlanPage extends BaseClass {
    Action action= new Action();
    WebDriver driver;
    @FindBy(how = How.ID, using ="plans-button")
    WebElement pla_management_btn;

    @FindBy(how = How.ID, using ="create-button")
    WebElement create_plant_btn;

    @FindBy(how = How.ID, using ="plan-title-input")
    WebElement plan_title_input;

    @FindBy(how = How.ID, using ="start-date-picker")
    WebElement start_date_picker;

    @FindBy(how = How.ID, using ="end-date-picker")
    WebElement end_date_picker;

    @FindBy(how = How.ID, using ="react-select-2-input")
    WebElement select_hierarchy;

    @FindBy(how = How.ID, using ="react-select-5-input")
    WebElement select_intervention_type;

    @FindBy(how = How.ID, using ="create-plan-button")
    WebElement submit_plan;

    @FindBy(how = How.XPATH, using ="//*[contains(text(),'Confirm')]")
    WebElement confirm_submitted_plan;

    @FindBy(how = How.XPATH, using ="//*[contains(text(),'testing qa')]")
    WebElement confirm_plan_on_table;

    public PlanPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickPlanManagementBtn() throws Throwable{
       action.click(getDriver(),pla_management_btn);
    }

    public void enterPlanDetails() {
       action.type(plan_title_input,"testing qa");
        action.type(start_date_picker,getCurrentDate());
        action.type(plan_title_input,getCurrentDate());
        action.type(select_hierarchy,"default");
        action.type(select_intervention_type,"IRS");
    }

    private String getCurrentDate(){
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        return date;
    }

    public void submitPlan(){
       action.click(getDriver(),submit_plan);
    }
    public void confirmSubmittedPlan(){
        action.click(getDriver(),confirm_submitted_plan);
    }

    public boolean isPlanOnTheTable(){
       return action.isDisplayed(getDriver(),confirm_plan_on_table);
    }
}
