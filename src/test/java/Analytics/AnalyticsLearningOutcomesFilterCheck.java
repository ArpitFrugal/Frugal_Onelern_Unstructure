package Analytics;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Analytics;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AnalyticsLearningOutcomesFilterCheck extends Base {
    public Analytics ana;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ana = new Analytics(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(boolean flag1, boolean flag2){
        System.out.println(flag1 + " "+flag2);
        if (flag1 && flag2) {
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or noti the teacher should be able to filter the learning outcomes according to the count needed.")
    @Story("ANAFT_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void LearningOutcomesFilterCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int no_of_LO_displayed;
        boolean flag1 = false, flag2 = false;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Select filterOptions = new Select(ana.LearningOutcomesFilterDropdown());

        filterOptions.selectByValue("1");
        Thread.sleep(2000);
        no_of_LO_displayed = ana.LearningOutcomes().size();
        System.out.println(no_of_LO_displayed);
        flag1 = valCompare(no_of_LO_displayed, 1);

        filterOptions.selectByValue("2");
        Thread.sleep(2000);
        no_of_LO_displayed = ana.LearningOutcomes().size();
        System.out.println(no_of_LO_displayed);
        if(no_of_LO_displayed<2){
            flag2 = valCompare(no_of_LO_displayed, 1);
        }
        else{
            flag2 = valCompare(no_of_LO_displayed, 2);
        }

        ValidateTest(flag1, flag2);
    }
    public boolean valCompare(int actual, int expected){
        return actual==expected;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
