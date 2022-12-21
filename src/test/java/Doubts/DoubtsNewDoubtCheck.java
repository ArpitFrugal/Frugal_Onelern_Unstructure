package Doubts;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Doubts;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoubtsNewDoubtCheck extends Base {
    Map<String, String> map  = new HashMap<String, String>() {{
        put("Grade 1", "New Doubt 1");
        put("Grade 2", "New Doubt 2");
        put("Grade 3", "New Doubt 3");
        put("Grade 4", "New Doubt 4");
        put("Grade 5", "New Doubt 5");
    }};
    public Doubts dou;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        dou = new Doubts(driver);
        log = new LoginPage(driver);
    }

    public void StudentValidateTest(String createdSubjectDetails, String selectedSubject, String selectedLesson, String createdQuestionDetails, String doubtContent) {
        selectedSubject = selectedSubject.split("-")[0].strip();
        System.out.println(createdSubjectDetails+"\n"+selectedSubject+"\n"+selectedLesson+"\n"+createdQuestionDetails+"\n"+doubtContent);
        if(createdSubjectDetails.contains(selectedSubject) && createdSubjectDetails.contains(selectedLesson) && createdQuestionDetails.contains(doubtContent)){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or noti the student can successfully ask his/her doubt.")
    @Story("DOUFS_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void studentAskNewDoubt(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        dou.StudentImageClick().click();
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);

        dou.AskDoubtBtn().click();
        Thread.sleep(2000);

        String selectedSubject = null, selectedLesson = null;
        List<WebElement> doubtoptions = driver.findElements(By.xpath("//*[contains(@class,'form-group')]//select"));

        for(WebElement webElement:doubtoptions){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
        }
        int i=0;
        for(WebElement webElement:doubtoptions){
            Select select = new Select(webElement);
            if(i==0){
                selectedSubject = select.getFirstSelectedOption().getText();
            }
            else if(i==1){
                selectedLesson = select.getFirstSelectedOption().getText();
            }
            i++;
            Thread.sleep(3000);
        }

        if (mob >= 9000000001l && mob <= 9000000020l) {// English
            dou.QuestionTextBox().click();
            dou.QuestionTextBox().sendKeys(map.get("Grade 1"));
            dou.SubmitBtn().click();

            Thread.sleep(5000);
            // verify created doubt content
            String CreatedSubjectDetails = dou.CreatedSubjectDetails().getText();
            String CreatedQuestionDetails = dou.CreatedQuestionDetails().getText();
            map.put("SubjectGrade1", CreatedSubjectDetails);
            StudentValidateTest(CreatedSubjectDetails, selectedSubject, selectedLesson, CreatedQuestionDetails, map.get("Grade 1"));
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {// English
            dou.QuestionTextBox().click();
            dou.QuestionTextBox().sendKeys(map.get("Grade 2"));
            dou.SubmitBtn().click();

            Thread.sleep(5000);
            // verify created doubt content
            String CreatedSubjectDetails = dou.CreatedSubjectDetails().getText();
            String CreatedQuestionDetails = dou.CreatedQuestionDetails().getText();
            map.put("SubjectGrade2", CreatedSubjectDetails);
            StudentValidateTest(CreatedSubjectDetails, selectedSubject, selectedLesson, CreatedQuestionDetails, map.get("Grade 2"));

        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {// English
            dou.QuestionTextBox().click();
            dou.QuestionTextBox().sendKeys(map.get("Grade 3"));
            dou.SubmitBtn().click();

            Thread.sleep(5000);
            // verify created doubt content
            String CreatedSubjectDetails = dou.CreatedSubjectDetails().getText();
            String CreatedQuestionDetails = dou.CreatedQuestionDetails().getText();
            map.put("SubjectGrade3", CreatedSubjectDetails);
            StudentValidateTest(CreatedSubjectDetails, selectedSubject, selectedLesson, CreatedQuestionDetails, map.get("Grade 3"));
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            dou.QuestionTextBox().click();
            dou.QuestionTextBox().sendKeys(map.get("Grade 4"));
            dou.SubmitBtn().click();

            Thread.sleep(5000);
            // verify created doubt content
            String CreatedSubjectDetails = dou.CreatedSubjectDetails().getText();
            String CreatedQuestionDetails = dou.CreatedQuestionDetails().getText();
            map.put("SubjectGrade4", CreatedSubjectDetails);
            StudentValidateTest(CreatedSubjectDetails, selectedSubject, selectedLesson, CreatedQuestionDetails, map.get("Grade 4"));
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            dou.QuestionTextBox().click();
            dou.QuestionTextBox().sendKeys(map.get("Grade 5"));
            dou.SubmitBtn().click();

            Thread.sleep(5000);
            // verify created doubt content
            String CreatedSubjectDetails = dou.CreatedSubjectDetails().getText();
            String CreatedQuestionDetails = dou.CreatedQuestionDetails().getText();
            map.put("SubjectGrade5", CreatedSubjectDetails);
            StudentValidateTest(CreatedSubjectDetails, selectedSubject, selectedLesson, CreatedQuestionDetails, map.get("Grade 5"));
        }

    }


    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or noti the teacher can successfully view the doubt asked by the students.")
    @Story("DOUFT-03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherViewNewDoubt(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);

        String subjectDetails = dou.CreatedSubjectDetails().getText();
        String contentDetails = dou.CreatedQuestionDetails().getText();
        if (mob >= 9000000101l && mob <= 9000000104l) {
            TeacherValidateTest(subjectDetails, map.get("SubjectGrade1"), contentDetails, map.get("Grade 1"));
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) {
            TeacherValidateTest(subjectDetails, map.get("SubjectGrade2"), contentDetails, map.get("Grade 2"));
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            TeacherValidateTest(subjectDetails, map.get("SubjectGrade3"), contentDetails, map.get("Grade 3"));
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            TeacherValidateTest(subjectDetails, map.get("SubjectGrade4"), contentDetails, map.get("Grade 4"));
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            TeacherValidateTest(subjectDetails, map.get("SubjectGrade5"), contentDetails, map.get("Grade 5"));
        }


    }

    public void TeacherValidateTest(String subjectDetails, String SubjectfromStudent, String contentDetails, String contentfromStudent) {
        System.out.println(subjectDetails+" | "+SubjectfromStudent+" | "+contentDetails+" | "+contentfromStudent);
        if (subjectDetails.contains(SubjectfromStudent) && contentDetails.contains(contentfromStudent)){
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
