package Assignments;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Assignments;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AssignmentCompletedPageCheck extends Base {
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

    public void ValidateTest(boolean flag){
        System.out.println(flag);
        if (flag) {
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the assignments in drafts page.")
    @Story("ASGFT_06")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherCompletedPageCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        asg.rightswipemodules().click();
        Thread.sleep(1000);
        asg.rightswipemodules().click();

        asg.AssignmentsToggle().click();
        Thread.sleep(2000);

        asg.CreateNewBtn().click();

        Thread.sleep(2000);
        asg.AssignmentName().click();
        asg.AssignmentName().sendKeys("New Assignment");

//        System.out.println(1);
        Select AssignmentSubject = new Select(asg.AssignmentSubject());
        AssignmentSubject.selectByIndex(1);
        Thread.sleep(2000);

//        System.out.println(2);
        Select AssignmentRewardType = new Select(asg.AssignmentRewardType());
        AssignmentRewardType.selectByIndex(1);
        Thread.sleep(2000);

//        System.out.println(3);
//        Select AssignmentType = new Select(asg.AssignmentType());
//        AssignmentType.selectByIndex(1);
//        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();


//        System.out.println(4);
        asg.AssignmentDetailsSubmitBtn().click();

        asg.QuestionDescription().click();
        asg.QuestionDescription().sendKeys("Question");

        asg.AttachLink().click();
        asg.LinkInputBox().click();
        asg.LinkInputBox().sendKeys("www.google.com");
        asg.AddLinkSubmit().click();

        for(WebElement webElement:asg.FileTypes()){
            webElement.click();
            Thread.sleep(500);
        }

        asg.AssignStudentsBtn().click();

        asg.SelectStudentsBtn().click();

        Thread.sleep(2000);
        asg.SelectAllOption().click();

        asg.AddStudentsBtn().click();

        asg.ScheduleBtn().click();

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal.add(Calendar.DAY_OF_MONTH, 2);
        String dateAfter = formatter.format(cal.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        asg.StartDateInputBox().click();
        asg.StartDateInputBox().sendKeys(currdate);
        asg.StartDateInputBox().sendKeys(currmonth);
        asg.StartDateInputBox().sendKeys(curryear);

        asg.EndDateInputBox().click();
        asg.EndDateInputBox().sendKeys(enddate);
        asg.EndDateInputBox().sendKeys(endmonth);
        asg.EndDateInputBox().sendKeys(endyear);

        WebElement InstructionsTextBox = driver.findElement(By.xpath("//textarea"));

        InstructionsTextBox.click();
        InstructionsTextBox.sendKeys("instructions");

        asg.PublishBtn().click();

        Thread.sleep(2000);
        asg.CompletedTabPage().click();
        boolean flag=true;
        for(WebElement webElement:asg.AssignmentStatus()){
            if(!(webElement.getText().contains("Evaluated") || webElement.getText().contains("Completed"))){
                flag= false;
                break;
            }
        }
        ValidateTest(flag);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
