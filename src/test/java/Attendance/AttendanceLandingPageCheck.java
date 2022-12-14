package Attendance;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Attendance;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AttendanceLandingPageCheck extends Base {
    public Attendance att;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        att = new Attendance(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(String actual_header){
        if (actual_header.contains("Attendance")) {
            System.out.println("Attendance Module is active");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or noti the student can successfully get inside the Attendance module.")
    @Story("ATTFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        att.StudentImageClick().click();
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        String actual_header = att.GetHeader().getText();
        ValidateTest(actual_header);

    }

    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or noti the teacher can successfully get inside the Attendance module.")
    @Story("ATTFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        String actual_header = att.GetHeader().getText();
        ValidateTest(actual_header);
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
