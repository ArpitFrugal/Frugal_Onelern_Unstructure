package Analytics;

import io.qameta.allure.*;
import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class AnalyticsEoLTAttemptedCountCheck extends Base {
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

    public void ValidateTest(int actual, int expected){
        System.out.println(actual+" "+expected);
        if(actual == expected){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to see total students successfully.")
    @Story("ANAFT_15")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void EoLTStudentsCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(3000);
        ana.PerformanceTab().click();
        boolean flag1, flag2, flag3;

        ana.ViewEoLT().click();
//        System.out.println(ana.recentLevelsTotalStudents());
        List<WebElement> LevelsStudents=ana.LevelsStudents();

        int count = 0;
        for(int i=0;i<LevelsStudents.size();i++){
            System.out.println(i);
            count+= Integer.parseInt(List.of(LevelsStudents.get(i).getText().split("\n")).get(0));
        }
        ValidateTest(count, ana.recentLevelsTotalStudents());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.

    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}, {"9000000105", "123456"}, {"9000000109", "123456"},
//                {"9000000113", "123456"}, {"9000000117", "123456"}};
        Object loginData[][] = {{"9000000101", "123456"}};
        return loginData;
    }
}
