package Notifications;

import io.qameta.allure.*;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notifications;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NewDoubtNotification extends Base {
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
    @Description("Examine whether or not the teacher can successfully view the notification for new doubt.")
    @Story("NOTIFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void TeacherNewDoubtNotificationCheck() throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", StudentMob, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        noti.StudentImageClick().click();
        Thread.sleep(2000);
        noti.DoubtsToggle().click();
        Thread.sleep(2000);

        noti.AskDoubtBtn().click();
        Thread.sleep(2000);

        List<WebElement> doubtoptions = driver.findElements(By.xpath("//*[contains(@class,'form-group')]//select"));

        for(WebElement webElement:doubtoptions){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
        }


        noti.QuestionTextBox().click();
        noti.QuestionTextBox().sendKeys("New Doubt Content");

        driver.findElement(By.xpath("//*[contains(@class,'react-switch-handle')]")).click();
        WebElement TeacherNameInput = driver.findElement(By.xpath("//*[contains(@placeholder,'teacher')]"));
        TeacherNameInput.click();
        TeacherNameInput.sendKeys("Suhas");
        TeacherNameInput.sendKeys(Keys.ENTER);

        noti.DoubtsSubmitBtn().click();


        driver.navigate().to(prop.getProperty("website"));
        noti.HomepageMenuBtn().click();
        WebElement logoutelement = noti.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        Thread.sleep(2000);
        logoutelement.click();
        driver.navigate().refresh();
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();

        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);


        noti.notificationsTeacher().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "DOUBT";
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
