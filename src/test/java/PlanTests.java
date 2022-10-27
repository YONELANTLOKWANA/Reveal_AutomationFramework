import PageObjects.PlanPage;
import PageObjects.SignInPage;
import Utilities.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlanTests extends BaseClass {
    @Test()
    public void createPlanTest() throws Throwable {
        PlanPage plan = PageFactory.initElements(getDriver(), PlanPage.class);
        SignInPage login = new SignInPage(getDriver());
        login.clickLogInBtn();
        login.signIn(prop.getProperty("username"),prop.getProperty("password"));
        plan.clickPlanManagementBtn();
        plan.enterPlanDetails();
        plan.submitPlan();
        plan.confirmSubmittedPlan();
        Assert.assertFalse(plan.isPlanOnTheTable(), "plan created not found in the table");
    }
}
