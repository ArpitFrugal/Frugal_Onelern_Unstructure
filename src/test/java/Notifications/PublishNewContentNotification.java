package Notifications;

import io.qameta.allure.*;
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

public class PublishNewContentNotification extends Base {
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
    @Description("Examine whether or not the student can successfully view the notification for new published content.")
    @Story("NOTIFS_07")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void StudentPublishNewContentNotificationCheck() throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        noti.PublishToggle().click();
        Thread.sleep(5000);
        Thread.sleep(5000);
        noti.PublishNewContentBtn().click();
        Thread.sleep(5000);

        List<WebElement> ContentOptions = noti.ContentOptions();
        int i=0;
        for(WebElement webElement:ContentOptions){
            if(i==0 || i==3 || i==4){
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            else{
                webElement.sendKeys(Keys.ENTER);
            }
            i+=1;
            Thread.sleep(2000);
        }

        Thread.sleep(3000);


        String publishContent = "Grade 1 Content";

        noti.PublishContentDescriptionTextArea().click();
        noti.PublishContentDescriptionTextArea().sendKeys(publishContent);
        Thread.sleep(3000);
        noti.NextStepBtn().click();
        Thread.sleep(3000);
        List<WebElement> GradeSectionInput = noti.PublishGradeSectionInput();
        for(WebElement webElement : GradeSectionInput){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
        }
        Thread.sleep(3000);
        noti.FinalPublishBtn().click();
        Thread.sleep(5000);


        driver.navigate().to(prop.getProperty("website"));
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
        String expectedText = "PUBLISHED";
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
