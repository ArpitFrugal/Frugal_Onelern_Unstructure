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

public class AnalyticsLearningOutcomesStudentProfileCheck extends Base {
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
    @Description("Examine whether or not the teacher should be able to see the student's profile.")
    @Story("ANAFT_07")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void StudentProfileCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean flag1, flag2, flag3;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);
        ana.LearningOutcomeOpenBtn().click();
        Thread.sleep(3000);

        String DisplayedStudentName = ana.DisplayedStudentName().getText();
        ana.DisplayedStudentName().click();

        String heading = ana.GetHeader();
        flag1 = heading.contains(DisplayedStudentName);

        String path = ana.NavigationPath().getText();
        flag2 = path.contains(DisplayedStudentName);

        String StudentName = ana.StudentProfileName().getText();
        flag3 = StudentName.contains(DisplayedStudentName);

        ValidateTest(flag1, flag2, flag3);

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
