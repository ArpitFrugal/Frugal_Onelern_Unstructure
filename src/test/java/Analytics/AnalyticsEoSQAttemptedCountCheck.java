package Analytics;

import io.qameta.allure.*;
import org.openqa.selenium.By;
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
import java.util.List;

public class AnalyticsEoSQAttemptedCountCheck extends Base {
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

    public void ValidateTest(boolean flag1, boolean flag2, boolean flag3){
        System.out.println(flag1 + " "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to see attempted and non-attempted students successfully.")
    @Story("ANAFT_12")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void LearningOutcomesCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();
        boolean flag1, flag2, flag3;

        ana.ViewWEoSQ().click();

        ana.EoSQLesson1().click();
        ana.EoSQAttemptedTopic1().click();

        System.out.println(ana.AttemptedCount());
        System.out.println(List.of(ana.AttemptedCount().split(" ")));
        int attemptedCount = Integer.parseInt(List.of(ana.AttemptedCount().split(" ")).get(1));
        int displayedStudents = ana.AttemptedStudents().size();

        flag1 = CompareVal(attemptedCount, displayedStudents);
        Select attemptedSwitch = new Select(ana.AttemptedSwitch());
        attemptedSwitch.selectByValue("2");
        Thread.sleep(2000);
        System.out.println(ana.AttemptedCount());
        System.out.println(List.of(ana.AttemptedCount().split(" ")));
        int nonattemptedCount = Integer.parseInt(List.of(ana.AttemptedCount().split(" ")).get(2));
        displayedStudents = ana.AttemptedStudents().size();

        flag2 = CompareVal(nonattemptedCount, displayedStudents);

        flag3 = CompareVal(attemptedCount+ nonattemptedCount, Integer.parseInt(ana.overallScore().getText()));

        ValidateTest(flag1, flag2, flag3);
    }
    public boolean CompareVal(int actual, int expected){
        return actual == expected;
    }
    public boolean CompareText(String actual, String expected){
        return actual.contains(expected);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.

    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = {{"9000000101", "123456"}, {"9000000105", "123456"}, {"9000000109", "123456"},
                {"9000000113", "123456"}, {"9000000117", "123456"}};
//        Object loginData[][] = {{"9000000101", "123456"}};
        return loginData;
    }
}
