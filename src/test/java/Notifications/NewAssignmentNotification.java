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

public class NewAssignmentNotification extends Base {
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
    @Description("Examine whether or not the student can successfully view the notification for new assignment.")
    @Story("NOTIFS_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void StudentNewAssignmentNotificationCheck() throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);
        noti.rightswipemodules().click();
        Thread.sleep(1000);
        noti.rightswipemodules().click();

        noti.AssignmentsToggle().click();
        Thread.sleep(2000);

        noti.CreateNewBtn().click();

        noti.AssignmentName().click();
        noti.AssignmentName().sendKeys("New Assignment");

        Select AssignmentSubject = new Select(noti.AssignmentSubject());
        AssignmentSubject.selectByIndex(1);

        Select AssignmentRewardType = new Select(noti.AssignmentRewardType());
        AssignmentRewardType.selectByIndex(1);
//        Select AssignmentType = new Select(noti.AssignmentType());
//        AssignmentType.selectByIndex(1);
//        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();

        noti.AssignmentDetailsSubmitBtn().click();

        noti.QuestionDescription().click();
        noti.QuestionDescription().sendKeys("Question");

        noti.AttachLink().click();
        noti.LinkInputBox().click();
        noti.LinkInputBox().sendKeys("www.google.com");
        noti.AddLinkSubmit().click();

        for(WebElement webElement:noti.FileTypes()){
            webElement.click();
            Thread.sleep(500);
        }
        noti.FileSizeLimit().click();
        noti.FileSizeLimit().sendKeys("1");

        noti.AssignmentAssignStudentsBtn().click();
        Thread.sleep(2000);

        noti.AssignmentSelectStudentsBtn().click();
        Thread.sleep(2000);

        noti.SelectAllOption().click();

        noti.AddStudentsBtn().click();

        noti.ScheduleBtn().click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[@for='individual']")).click();

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String CurrDate = formatter.format(date);
        Calendar cal1 = Calendar.getInstance();
        try{
            cal1.setTime(formatter.parse(CurrDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal1.add(Calendar.DAY_OF_MONTH, 5);
        String str = formatter.format(cal1.getTime());
        System.out.println(str);
        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal2 = Calendar.getInstance();
        try{
            cal2.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal2.add(Calendar.DAY_OF_MONTH, 20);
        String dateAfter = formatter.format(cal2.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        noti.StartDateInputBox().click();
        noti.StartDateInputBox().sendKeys(currdate);
        noti.StartDateInputBox().sendKeys(currmonth);
        noti.StartDateInputBox().sendKeys(curryear);
        Thread.sleep(2000);
        noti.EndDateInputBox().click();
        noti.EndDateInputBox().sendKeys(enddate);
        noti.EndDateInputBox().sendKeys(endmonth);
        noti.EndDateInputBox().sendKeys(endyear);

        WebElement InstructionsTextBox = driver.findElement(By.xpath("//textarea"));

        InstructionsTextBox.click();
        InstructionsTextBox.sendKeys("instructions");

        noti.PublishBtn().click();

        Thread.sleep(3000);


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
        String expectedText = "ASSIGNMENT";
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
