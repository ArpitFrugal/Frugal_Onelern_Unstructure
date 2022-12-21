package Attendance;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Attendance;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.util.Arrays;

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
    @Description("Examine whether or not the attendance module is functioning properly or noti.")
    @Story("ATTFS_01")
    @Severity(SeverityLevel.BLOCKER)
    public void AttendanceMainFunctionality() throws IOException, InterruptedException {
        String mobNumberStudent = "9000000001";
        String mobNumberTeacher = "9000000101";
        String password ="123456";

        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumberTeacher, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(!att.editAttendanceBtn().isEnabled()){
            ValidateTest(true);
        }
        else {
            boolean markedForToday = att.notMarkedTeacher().size() >0;
            if(!markedForToday){
                driver.findElement(By.xpath("//*[contains(@class,'active')]")).click();

            }
            else{
                att.editAttendanceBtn().click();
                driver.findElement(By.xpath("//*[contains(@class,'present-mark-box')]")).click();
                WebElement element = att.attendancemarkoption();
                js.executeScript("arguments[0].scrollIntoView();", element);

                element.click();
                Thread.sleep(2000);
                att.absentmarkoption().click();
                Thread.sleep(2000);

                att.attendancemarkoption().click();
                Thread.sleep(2000);
                att.leavemarkoption().click();
                Thread.sleep(2000);

                att.saveBtn().click();
                Thread.sleep(2000);
            }
        }



    }

    private void ValidateTest(boolean flag) {
        if(flag){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }


}
