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

public class CreateAssessment_PenPaper extends Base {
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
    @Description("Examine whether or not the teacher can successfully create Pen & paper assessment for the students.")
    @Story("ASSFT_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherCreateAssessment_PenPaper(String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(1000);
        ass.CreateNew().click();
        Thread.sleep(2000);

        String AssessmentName = "PP Assessment";
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
        ass.AssessmentFormatPenPaper().click();
        Thread.sleep(1000);

        ass.SubmitBtn().click();
//        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(1000);
        ass.SectionBtn().click();

        ass.SectionName().click();
        ass.SectionName().sendKeys("Section");

        ass.SectionInstructions().click();
        ass.SectionInstructions().sendKeys("Instructions");

        ass.SubmitBtn().click();
        Thread.sleep(2000);
        ass.QuestionBtn().click();

        ass.ShortAnswerOption().click();

//        if(ass.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(2000);

//        driver.findElement(By.xpath("//button[contains(@class, 'toolbar-btn')]")).click();
//        Thread.sleep(1000);
        List<WebElement> QuestionTextBoxes = ass.QuestionInputBoxes();
        int cnt=0;
        for(WebElement webElement: QuestionTextBoxes){
            if(cnt == 0){
                webElement.click();
                webElement.sendKeys("Question");
            } else if (cnt == 1) {
                webElement.click();
                webElement.sendKeys("Instructions");
            }else if (cnt == 2) {
                webElement.click();
                webElement.sendKeys("Hints");
            }else if (cnt == 3) {
                js.executeScript("arguments[0].scrollIntoView();", webElement);
                webElement.click();
                webElement.sendKeys("Solution");
            }
            cnt++;
        }

        for(WebElement webElement:ass.QuestionsMetadata()){
            if(webElement.isEnabled()){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
                Thread.sleep(1000);
            }
        }
        ass.QuestionsMetadata().get(4).click();
        ass.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
        ass.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);


        ass.MarksInputBox().click();
        Thread.sleep(1000);
        ass.MarksInputBox().sendKeys("5");
        Thread.sleep(2000);

        ass.AddThisQuestionBtn().click();
        Thread.sleep(2000);
        ass.PassMarks().click();
        Thread.sleep(2000);
        ass.PassMarks().sendKeys("2");
        Thread.sleep(2000);

        ass.AssignStudentsBtn().click();
//        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(1000);
        ass.SelectStudentsBtn().click();
        Thread.sleep(1000);
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

        ass.instructionsInput().click();
        ass.instructionsInput().sendKeys("Instructions");
        Thread.sleep(1000);

        ass.PublishAssessmentBtn().click();
        Thread.sleep(1000);
//        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));

        ValidateTest(ass.questionPaperPreview());
    }

    private void ValidateTest(WebElement questionPaperPreview) {
        if(questionPaperPreview.isDisplayed())
            System.out.println("PASSED");
        else
            Assert.fail();
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
