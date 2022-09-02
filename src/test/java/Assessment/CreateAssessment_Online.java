package Assessment;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Assessment;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CreateAssessment_Online extends Base {
    public Assessment ass;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ass = new Assessment(driver);
        log = new LoginPage(driver);
    }

    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully create Online assessment for the students.")
    @Story("ASSFT_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void teacherCreateAssessment_Online(String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        ass.CreateNew().click();
        Thread.sleep(2000);

        String AssessmentName = "New Assessment";
        ass.NameOfAssessmentInput().click();
        ass.NameOfAssessmentInput().sendKeys(AssessmentName);

        Thread.sleep(2000);

        for (WebElement webElement:ass.AssessmentDetails()){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
        }

        ass.AssessmentFormat().click();
        Thread.sleep(1000);
        ass.AssessmentFormatOnline().click();
        Thread.sleep(1000);

        ass.SubmitBtn().click();

        ass.SectionBtn().click();

        ass.SectionName().click();
        ass.SectionName().sendKeys("Section");

        ass.SectionInstructions().click();
        ass.SectionInstructions().sendKeys("Instructions");

        ass.SubmitBtn().click();
        Thread.sleep(2000);
        ass.QuestionBtn().click();
        ass.TrueFalseOption().click();
        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));

        ass.TrueOption().click();

        List<WebElement> QuestionTextBoxes = ass.QuestionInputBoxes();
        QuestionTextBoxes.get(0).click();
        QuestionTextBoxes.get(0).sendKeys("Question");

        QuestionTextBoxes.get(1).click();
        QuestionTextBoxes.get(1).sendKeys("Instructions");

        js.executeScript("arguments[0].scrollIntoView();", QuestionTextBoxes.get(3));
        Thread.sleep(2000);

        QuestionTextBoxes.get(2).click();
        QuestionTextBoxes.get(2).sendKeys("Hints");

        QuestionTextBoxes.get(3).click();
        QuestionTextBoxes.get(3).sendKeys("Solution");


        for(WebElement webElement:ass.QuestionsMetadata()){
            if(webElement.isEnabled()){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
                Thread.sleep(1000);
            }
        }

        ass.MarksInputBox().click();
        Thread.sleep(1000);
        ass.MarksInputBox().sendKeys("01");
        Thread.sleep(2000);

        ass.AddThisQuestionBtn().click();
        Thread.sleep(2000);
        ass.PassMarks().click();
        Thread.sleep(2000);
        ass.PassMarks().sendKeys("1");
        Thread.sleep(2000);

        ass.AssignStudentsBtn().click();
        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(1000);
        ass.SelectStudentsBtn().click();

        ass.SelectAllStudents().click();
        Thread.sleep(2000);

        ass.AddStudents().click();
        Thread.sleep(2000);
        ass.ScheduleBtn().click();
        Thread.sleep(2000);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String dateString = dateFormat.format(new Date(Calendar.getInstance().getTimeInMillis() + 60*1000));
        String currhour = dateString.split("\\.")[0];
        String currmin  = dateString.split("\\.")[1].split(" ")[0];
        String ampm = dateString.split("\\.")[1].split(" ")[1];


        ass.DateInput().click();
        ass.DateInput().sendKeys(currdate);
        ass.DateInput().sendKeys(currmonth);
        ass.DateInput().sendKeys(curryear);

        ass.TimeInput().click();
        ass.TimeInput().sendKeys(currhour);
        ass.TimeInput().sendKeys(currmin);
        ass.TimeInput().sendKeys(ampm);

        ass.DurationInput().click();
        ass.DurationInput().sendKeys(Keys.ARROW_DOWN);

        ass.ShowScoresAfter().click();
        ass.ShowScoresAfter().sendKeys(Keys.ARROW_DOWN);

        ass.passwordInputTeacher().click();
        ass.passwordInputTeacher().sendKeys("password");

        ass.instructionsInput().click();
        ass.instructionsInput().sendKeys("Instructions");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//h1")).click();
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(@class,'hint-txt')]")));
        Thread.sleep(1000);
        ass.HintShowOption().click();
        Thread.sleep(1000);
        ass.PublishAssessmentBtn().click();
        Thread.sleep(1000);
        String DisplayedAssessmentName = ass.FirstAssessmentDisplayedTeacher().getText();

        ValidateTest(DisplayedAssessmentName, AssessmentName);
    }

    public void ValidateTest(String displayedAssessmentName, String assessmentName) {
        if(displayedAssessmentName.contains(assessmentName)){
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

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = {{"9000000101", "123456"}, {"9000000105", "123456"}, {"9000000109", "123456"},
                {"9000000113", "123456"}, {"9000000117", "123456"}};
//        Object loginData[][] = {{"9000000101", "123456"}};
        return loginData;
    }
}
