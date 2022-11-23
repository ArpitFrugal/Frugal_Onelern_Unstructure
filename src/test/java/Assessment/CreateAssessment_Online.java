package Assessment;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
    @Test(dataProvider = "teacherData")
    public void teacherCreateAssessment_Online(String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> QuestionTextBoxes;
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);
//        if(ass.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(10000);
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

        // T/F Question

        ass.QuestionBtn().click();
        ass.TrueFalseOption().click();
//        if(ass.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(2000);

        ass.TrueOption().click();

        QuestionTextBoxes = ass.QuestionInputBoxes();
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


        for(WebElement webElement:ass.QuestionsMetadata()){
            if(webElement.isEnabled()){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
                Thread.sleep(1500);
            }
        }
        ass.MarksInputBox().click();
        Thread.sleep(1000);
        ass.MarksInputBox().sendKeys("01");
        Thread.sleep(2000);


        ass.QuestionsMetadata().get(4).click();
        ass.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
        ass.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
//
        Actions action = new Actions(driver);
        for(int i=0;i<5;i++){
            action.sendKeys(Keys.TAB).perform();
            Thread.sleep(1000);
        }

        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);


        // - -------------------------------------

//        ass.QuestionBtn().click();
//        ass.MCQOption().click();
////        if(ass.ModalOverlay().isDisplayed())
////            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
//        Thread.sleep(5000);
//
//        driver.findElement(By.xpath("//div[contains(@class,'check')]")).click();
//        Thread.sleep(1000);
//        QuestionTextBoxes = ass.QuestionInputBoxes();
//        cnt=0;
//        for(WebElement webElement: QuestionTextBoxes){
//            if(cnt == 0){
//                webElement.click();
//                webElement.sendKeys("Question");
//            } else if (cnt == 1) {
//                webElement.click();
//                webElement.sendKeys("Option1");
//            }else if (cnt == 2) {
//                WebElement Element = QuestionTextBoxes.get(4);
//                js.executeScript("arguments[0].scrollIntoView();", Element);
//                webElement.click();
//                webElement.sendKeys("Option2");
//            }else if (cnt == 3) {
//                webElement.click();
//                webElement.sendKeys("Option3");
//            }else if (cnt == 4) {
//                webElement.click();
//                webElement.sendKeys("Option4");
//            }else if (cnt == 5) {
//                WebElement Element = QuestionTextBoxes.get(QuestionTextBoxes.size() - 1);
//                js.executeScript("arguments[0].scrollIntoView();", Element);
//                webElement.click();
//                webElement.sendKeys("Instructions");
//            }else if (cnt == 6) {
//                webElement.click();
//                webElement.sendKeys("Hints");
//            }else if (cnt == 7) {
//                webElement.click();
//                webElement.sendKeys("Solution");
//            }
//            cnt++;
//        }
//
//        for(WebElement webElement:ass.QuestionsMetadata()){
//            if(webElement.isEnabled()){
//                webElement.click();
//                webElement.sendKeys(Keys.ARROW_DOWN);
//                webElement.sendKeys(Keys.ENTER);
//                Thread.sleep(1500);
//            }
//        }
//
//        ass.MarksInputBox().click();
//        Thread.sleep(1000);
//        ass.MarksInputBox().sendKeys("01");
//        Thread.sleep(2000);
//
//
//        ass.QuestionsMetadata().get(4).click();
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
//
////        Actions action = new Actions(driver);
//        for(int i=0;i<5;i++){
//            action.sendKeys(Keys.TAB).perform();
//            Thread.sleep(1000);
//        }
//
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(2000);
//
//
//        // --------------------------------------
//
//        ass.QuestionBtn().click();
//        ass.FillBlanksOption().click();
////        if(ass.ModalOverlay().isDisplayed())
////            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
//        Thread.sleep(2000);
//        QuestionTextBoxes = ass.QuestionInputBoxes();
//        cnt=0;
//        for(WebElement webElement: QuestionTextBoxes){
//            if(cnt == 0){
//                webElement.click();
//                webElement.sendKeys("Question");
//            } else if (cnt == 1) {
//                webElement.click();
//                webElement.sendKeys("Instructions");
//            }else if (cnt == 2) {
//                WebElement Element = QuestionTextBoxes.get(3);
//                js.executeScript("arguments[0].scrollIntoView();", Element);
//                webElement.click();
//                webElement.sendKeys("Hints");
//            }else if (cnt == 3) {
//                webElement.click();
//                webElement.sendKeys("Solution");
//            }
//            cnt++;
//        }
//
//        ass.FBCorrectAnswer().click();
//        ass.FBCorrectAnswer().sendKeys("Answer");
//
//
//
//        for(WebElement webElement:ass.QuestionsMetadata()){
//            if(webElement.isEnabled()){
//                webElement.click();
//                webElement.sendKeys(Keys.ARROW_DOWN);
//                webElement.sendKeys(Keys.ENTER);
//                Thread.sleep(1500);
//            }
//        }
//        ass.MarksInputBox().click();
//        Thread.sleep(1000);
//        ass.MarksInputBox().sendKeys("01");
//        Thread.sleep(2000);
//
//
//        ass.QuestionsMetadata().get(4).click();
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
//
////        Actions action = new Actions(driver);
//        for(int i=0;i<5;i++){
//            action.sendKeys(Keys.TAB).perform();
//            Thread.sleep(1000);
//        }
//
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(2000);
//
//        // ----------------------------------------------
//
//        ass.QuestionBtn().click();
//        ass.MRQOption().click();
////        if(ass.ModalOverlay().isDisplayed())
////            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath("//div[contains(@class,'check')]")).click();
//        QuestionTextBoxes = ass.QuestionInputBoxes();
//        cnt=0;
//        for(WebElement webElement: QuestionTextBoxes){
//            if(cnt == 0){
//                webElement.click();
//                webElement.sendKeys("Question");
//            } else if (cnt == 1) {
//                webElement.click();
//                webElement.sendKeys("Option1");
//            }else if (cnt == 2) {
//                WebElement Element = QuestionTextBoxes.get(4);
//                js.executeScript("arguments[0].scrollIntoView();", Element);
//                webElement.click();
//                webElement.sendKeys("Option2");
//            }else if (cnt == 3) {
//                webElement.click();
//                webElement.sendKeys("Option3");
//            }else if (cnt == 4) {
//                webElement.click();
//                webElement.sendKeys("Option4");
//            }else if (cnt == 5) {
//                WebElement Element = QuestionTextBoxes.get(QuestionTextBoxes.size() - 1);
//                js.executeScript("arguments[0].scrollIntoView();", Element);
//                webElement.click();
//                webElement.sendKeys("Instructions");
//            }else if (cnt == 6) {
//                webElement.click();
//                webElement.sendKeys("Hints");
//            }else if (cnt == 7) {
//                webElement.click();
//                webElement.sendKeys("Solution");
//            }
//            cnt++;
//        }
//
//
//        for(WebElement webElement:ass.QuestionsMetadata()){
//            if(webElement.isEnabled()){
//                webElement.click();
//                webElement.sendKeys(Keys.ARROW_DOWN);
//                webElement.sendKeys(Keys.ENTER);
//                Thread.sleep(1000);
//            }
//        }
//        ass.MarksInputBox().click();
//        Thread.sleep(1000);
//        ass.MarksInputBox().sendKeys("01");
//        Thread.sleep(2000);
//
//
//        ass.QuestionsMetadata().get(4).click();
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
//
////        Actions action = new Actions(driver);
//        for(int i=0;i<5;i++){
//            action.sendKeys(Keys.TAB).perform();
//            Thread.sleep(1000);
//        }
//
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(2000);


        // --------------------------------------


        ass.PassMarks().click();
        Thread.sleep(2000);
        ass.PassMarks().sendKeys("1");
        Thread.sleep(2000);

        ass.AssignStudentsBtn().click();
//        if(ass.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
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
        String dateString = dateFormat.format(new Date(Calendar.getInstance().getTimeInMillis() + 2*60*1000));
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
        Thread.sleep(2000);
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
    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
