package Library;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Library;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class LessonNameVerify extends Base {
    public Library lib;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        lib = new Library(driver);
        log = new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void ThreadSleep2000() throws InterruptedException {
        Thread.sleep(2000);
    }
    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFS_04")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData")
    public void StudentLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        lib.StudentImageClick().click();

        ThreadSleep5000();
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitName, text, insideHeading;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
            lib.FirstLesson().click();
            ThreadSleep5000();


//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            lib.ThirdLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000041l && mob <= 9000000060l) { // Mathematics coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000061l && mob <= 9000000080l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000081l && mob <= 9000000100l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

        }


    }

    private void Validate(String unitName, String text, String insideHeading) {
        System.out.println(unitName + "\n" + text +"\n" + insideHeading);
        if(unitName.equals(text) && text.equals(insideHeading)){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFT_04")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitName, text, insideHeading;
        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            lib.ThirdLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            Validate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

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
