package Notifications;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notifications;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NewAssessmentNotification extends Base {
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
    @Description("Examine whether or not the student can successfully view the notification for new assessment.")
    @Story("NOTIFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void StudentNewAssessmentNotificationCheck() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> QuestionTextBoxes;
        noti.AssessmentToggle().click();
        Thread.sleep(2000);

        noti.MyAssessmentsPage().click();
        Thread.sleep(2000);
//        if(noti.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(noti.ModalOverlay()));
        Thread.sleep(10000);
        noti.CreateNew().click();
        Thread.sleep(2000);

        String AssessmentName = "New Assessment";
        noti.NameOfAssessmentInput().click();
        noti.NameOfAssessmentInput().sendKeys(AssessmentName);

        Thread.sleep(2000);

        for (WebElement webElement: noti.AssessmentDetails()){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
        }

        noti.AssessmentFormat().click();
        Thread.sleep(1000);
        noti.AssessmentFormatOnline().click();
        Thread.sleep(1000);

        noti.SubmitBtn().click();

        noti.SectionBtn().click();

        noti.SectionName().click();
        noti.SectionName().sendKeys("Section");

        noti.SectionInstructions().click();
        noti.SectionInstructions().sendKeys("Instructions");

        noti.SubmitBtn().click();
        Thread.sleep(2000);

        // T/F Question

        noti.QuestionBtn().click();
        noti.TrueFalseOption().click();
//        if(noti.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(noti.ModalOverlay()));
        Thread.sleep(2000);

        noti.TrueOption().click();

        QuestionTextBoxes = noti.QuestionInputBoxes();
        int cnt=0;
        for(WebElement webElement: QuestionTextBoxes){
            if(cnt == 0){
                webElement.click();
                webElement.sendKeys("Question");
            } else if (cnt == 1) {
                webElement.click();
                webElement.sendKeys("Instructions");
            }else if (cnt == 2) {
                WebElement Element = QuestionTextBoxes.get(3);
                js.executeScript("arguments[0].scrollIntoView();", Element);
                webElement.click();
                webElement.sendKeys("Hints");
            }else if (cnt == 3) {
                webElement.click();
                webElement.sendKeys("Solution");
            }
            cnt++;
        }


        for(WebElement webElement: noti.QuestionsMetadata()){
            if(webElement.isEnabled()){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
                Thread.sleep(1500);
            }
        }
        noti.MarksInputBox().click();
        Thread.sleep(1000);
        noti.MarksInputBox().sendKeys("01");
        Thread.sleep(2000);


        noti.QuestionsMetadata().get(4).click();
        noti.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
        noti.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
//
        Actions action = new Actions(driver);
        for(int i=0;i<5;i++){
            action.sendKeys(Keys.TAB).perform();
            Thread.sleep(1000);
        }

        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);



        // --------------------------------------


        noti.PassMarks().click();
        Thread.sleep(2000);
        noti.PassMarks().sendKeys("1");
        Thread.sleep(2000);

        noti.AssessmentAssignStudentsBtn().click();
//        if(noti.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(noti.ModalOverlay()));
        Thread.sleep(1000);
        noti.AssessmentSelectStudentsBtn().click();

        noti.SelectAllStudents().click();
        Thread.sleep(2000);

        noti.AddStudents().click();
        Thread.sleep(2000);
        noti.ScheduleBtn().click();
        Thread.sleep(2000);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String dateString = dateFormat.format(new Date(Calendar.getInstance().getTimeInMillis() + 2*60*1000));
        String currhour = dateString.split("\\.")[0];
        String currmin  = dateString.split("\\.")[1].split(" ")[0];
        String ampm = dateString.split("\\.")[1].split(" ")[1];


        noti.DateInput().click();
        noti.DateInput().sendKeys(currdate);
        noti.DateInput().sendKeys(currmonth);
        noti.DateInput().sendKeys(curryear);

        noti.TimeInput().click();
        noti.TimeInput().sendKeys(currhour);
        noti.TimeInput().sendKeys(currmin);
        noti.TimeInput().sendKeys(ampm);

        noti.DurationInput().click();
        noti.DurationInput().sendKeys(Keys.ARROW_DOWN);

        noti.ShowScoresAfter().click();
        noti.ShowScoresAfter().sendKeys(Keys.ARROW_DOWN);

        noti.passwordInputTeacher().click();
        noti.passwordInputTeacher().sendKeys("password");

        driver.findElement(By.xpath("//h1")).click();
//        js.executeScript("arguments[0].scrollIntoView();", noti.instructionsInput());
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(@class,'hint-txt')]")));
        Thread.sleep(2000);
        noti.instructionsInput().click();
        noti.instructionsInput().sendKeys("Instructions");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//h1")).click();
        Thread.sleep(1000);
//        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(@class,'hint-txt')]")));
//        Thread.sleep(1000);
        noti.HintShowOption().click();
        Thread.sleep(1000);
        noti.PublishAssessmentBtn().click();
        Thread.sleep(2000);


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
        String expectedText = "ASSESSMENT";
        ValidateTest(RecentNotificationTitle, expectedText);

    }

    public void ValidateTest(String displayedNotificationTitle, String expectedText) {
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
