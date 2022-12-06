package Notebook;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class LessonNameVerify extends Base {
    public Notebook note;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        note = new Notebook(driver);
        log = new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void ValidateTest(String LessonName, String LessonHeading){
        System.out.println(LessonName+"\n"+LessonHeading);
        if(LessonName.equals(LessonHeading)){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("NOTFS_03")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData")
    public void StudentLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);

        note.StudentImageClick().click();
        Thread.sleep(5000);

        note.NotebookToggle().click();
        Thread.sleep(5000);

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String LessonName, LessonHeading;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            WebElement element = note.EnvironmentalCoursebookGrade1();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(5000);
            element.click();

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) { // Mathematics Coursebook - Part A
            WebElement element = note.MathematicsCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(5000);
            element.click();

            note.FirstLesson().click(); //2-Digit Numbers click()
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
        }

        else if (mob >= 9000000041l && mob <= 9000000060l) { // Social Workbook - Part A
            WebElement element = note.SocialStudiesCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

        }

        else if (mob >= 9000000061l && mob <= 9000000080l) { // Science Coursebook - Part A
            WebElement element = note.ScienceCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(5000);
            element.click();
            Thread.sleep(5000);
//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

        }

        else if (mob >= 9000000081l && mob <= 9000000100l) { // Social Studies Coursebook - Part A
            WebElement element = note.SocialStudiesCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(5000);
            element.click();
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
        }

    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("NOTFT_03")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);

        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(5000);

    	note.NotebookToggle().click();
        Thread.sleep(5000);

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String LessonName, LessonHeading;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            note.EnvironmentalCoursebookGrade1().click();
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // Mathematics Coursebook - Part A
            WebElement element = note.MathematicsCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(5000);
            element.click();

            note.FirstLesson().click(); //2-Digit Numbers click()
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Social Workbook - Part A
            WebElement element = note.SocialStudiesCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // Science Coursebook - Part A
            WebElement element = note.ScienceCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(5000);
            element.click();
            Thread.sleep(5000);
//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Social Studies Coursebook - Part A
            WebElement element = note.SocialStudiesCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(5000);
            element.click();
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            ValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
        }

    }

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
