package Analytics;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
import java.util.ArrayList;
import java.util.List;

public class AnalyticsEoSQStudentGradeCheck extends Base {
    public Analytics ana;
    public LoginPage log;
    public WebDriver driver;
    //Creating a List
    List<String> grade = new ArrayList<>();

    String[] grades = {"Grade 1", "Grade 2", "Grade 3", "Grade 4", "Grade 5"};

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ana = new Analytics(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(String Actual, String Expected){
        System.out.println(Actual + " "+Expected);
        if(Actual.contains(Expected)){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to see the student's grade in his/her profile.")
    @Story("ANAFT_08")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void StudentProfileGradeCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();

        ana.ViewWEoSQ().click();

        ana.EoSQLesson1().click();
        ana.EoSQAttemptedTopic1().click();

        ana.DisplayedStudentName().click();

        if(mob >= 9000000101l && mob <= 9000000104l){
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[0];

            ValidateTest(GradeSection, expectedgrade);
        }
        else if (mob >= 9000000105l && mob <= 9000000108l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[1];

            ValidateTest(GradeSection, expectedgrade);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[2];

            ValidateTest(GradeSection, expectedgrade);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[3];

            ValidateTest(GradeSection, expectedgrade);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[4];

            ValidateTest(GradeSection, expectedgrade);
        }

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
