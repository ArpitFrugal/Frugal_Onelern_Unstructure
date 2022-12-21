package Notifications;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notifications;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.util.List;

public class MarkedAttendanceleaveNotification extends Base {
    public Notifications noti;
    public LoginPage log;
    public WebDriver driver;

    String TeacherMob = "9000000101";
    String StudentMob = "9000000001";
    String password = "123456";

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        noti = new Notifications(driver);
        log = new LoginPage(driver);
    }

    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the notification for making attendance as absent or leave.")
    @Story("NOTIFS_04")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void StudentAttendanceMarkedLeaveNotificationCheck() throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);

        noti.AttendanceToggle().click();
        Thread.sleep(2000);

        if(!noti.editAttendanceBtn().isEnabled()){
            ValidateTest("pass", "pass");
        }
        else {
            noti.editAttendanceBtn().click();
            driver.findElement(By.xpath("//*[contains(@class,'present-mark-box')]")).click();

//            List<WebElement> AllStudentsAttendanceMark = driver.findElements(By.xpath("//*[contains(@class,'present-mark-box')]/div[contains(@class,'active')]/button[contains(@class,'present')]"));
//            for(WebElement webElement:AllStudentsAttendanceMark){
//                js.executeScript("arguments[0].scrollIntoView();", webElement);
//                webElement.click();
////                Thread.sleep(500);
//                noti.leavemarkoption().click();
////                Thread.sleep(500);
//            }
//
//            Thread.sleep(2000);
//
//            noti.AttendancesaveBtn().click();
//            Thread.sleep(2000);



//            for marking present from leave

            List<WebElement> AllStudentsAttendanceMark = driver.findElements(By.xpath("//*[contains(@class,'present-mark-box')]/div[contains(@class,'active')]/button[contains(@class,'leave')]"));
            for(WebElement webElement:AllStudentsAttendanceMark){
                js.executeScript("arguments[0].scrollIntoView();", webElement);
                webElement.click();
//                Thread.sleep(500);
                noti.presentmarkoption().click();
//                Thread.sleep(500);
            }

            Thread.sleep(2000);

            noti.AttendancesaveBtn().click();
            Thread.sleep(2000);


        }


        driver.navigate().to(prop.getProperty("website"));
        Thread.sleep(2000);
        noti.HomepageMenuBtn().click();
        WebElement logoutelement = noti.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        Thread.sleep(2000);
        logoutelement.click();
        driver.navigate().refresh();
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();


        user.userLogin("student", StudentMob, password);
        Thread.sleep(2000);
        noti.StudentImageClick().click();
        Thread.sleep(2000);

        noti.notificationsStudent().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "leave";
        ValidateTest(RecentNotificationTitle, expectedText);

    }

    public void ValidateTest(String displayedNotificationTitle, String expectedText) {
        System.out.println(displayedNotificationTitle +" "+ expectedText);
        if(displayedNotificationTitle.contains(expectedText)){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
