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

    public void ValidateTest(String actual_header, String expected_header){
        System.out.println(actual_header+"\n"+expected_header);
        if (actual_header.contains(expected_header)) {
            System.out.println("Assignments Module is active");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or noti the teacher can successfully get inside the Assignments module.")
    @Story("ASGFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
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
        String expected_header = "Assignments";
        ValidateTest(actual_header, expected_header);
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or noti the student can successfully get inside the assignments module.")
    @Story("ASGFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        asg.StudentImageClick().click();
        asg.AssignmentsToggle().click();

        String actual_header = asg.GetHeader();
        String expected_header = "Scheduled Assignments";
        ValidateTest(actual_header, expected_header);

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }

}
