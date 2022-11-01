package Assignments;

import io.qameta.allure.*;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Analytics;
import pageObjects.Assignments;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AssignmentsLandingPageCheck extends Base {
    public Assignments asg;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        asg = new Assignments(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(String actual_header){
        System.out.println(actual_header);
        if (actual_header.equals("Assignments")) {
            System.out.println("Assignments Module is active");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Assignments module.")
    @Story("ASGFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        asg.rightswipemodules().click();
        Thread.sleep(1000);
        asg.rightswipemodules().click();

        asg.AssignmentsToggle().click();
        Thread.sleep(2000);

        String actual_header = asg.GetHeader();
        Thread.sleep(1000);
        ValidateTest(actual_header);
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the assignments module.")
    @Story("ASGFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "Studentdata")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        asg.StudentImageClick().click();
        asg.AssignmentsToggle().click();

        String actual_header = asg.GetHeader();
        ValidateTest(actual_header);

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "Studentdata")
    public Object[][] getstudentData() throws FileAlreadyExistsException {

//        Object loginData[][] = { { "9000000001", "123456" }, { "9000000021", "123456" }, { "9000000041", "123456" },
//                { "9000000061", "123456" }, { "9000000081", "123456" } };
		Object loginData[][] = { { "9000000001", "123456" } };
        return loginData;
    }

    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}, {"9000000105", "123456"}, {"9000000109", "123456"},
//                {"9000000113", "123456"}, {"9000000117", "123456"}};
        Object loginData[][] = {{"9000000101", "123456"}};
        return loginData;
    }

}
