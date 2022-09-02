package Attendance;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Attendance;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;

public class AttendanceMarkedCheck extends Base {
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

    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the attendance module is functioning properly or not.")
    @Story("ATTFS_01")
    @Severity(SeverityLevel.BLOCKER)
    public void AttendanceMainFunctionality() throws IOException, InterruptedException {
        String mobNumberStudent = "9000000001";
        String mobNumberTeacher = "9000000101";
        String password ="123456";
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumberTeacher, password);
        Thread.sleep(2000);
        att.StudentImageClick().click();
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);




    }


}
