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

public class LessonTopicsVerify extends Base {
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
    public void Validate(String unitname, String text){
        System.out.println(unitname + "\n" + text);
        if(unitname.contains(text)){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFS_05")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "Studentdata")
    public void StudentLessonTopicCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        lib.StudentImageClick().click();

        ThreadSleep5000();
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitname, text;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
            lib.FirstLesson().click();
            ThreadSleep5000();


//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();
            ThreadSleep5000();
            text = lib.EnvFirstLessonFirstTopicRefGrade1().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EnvFirstLessonSecondTopicRefGrade1().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EnvFirstLessonThirdTopicRefGrade1().getText();
            ThreadSleep5000();

            Validate(unitname, text);

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
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonFirstTopicRefGrade2().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonSecondTopicRefGrade2().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonThirdTopicRefGrade2().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000041l && mob <= 9000000060l) { // Mathematics coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonFirstTopicRefGrade3().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonSecondTopicRefGrade3().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonThirdTopicRefGrade3().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000061l && mob <= 9000000080l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonFirstTopicRefGrade4().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonSecondTopicRefGrade4().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonThirdTopicRefGrade4().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000081l && mob <= 9000000100l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonFirstTopicRefGrade5().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonSecondTopicRefGrade5().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonThirdTopicRefGrade5().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

        }

    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFT_05")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "Teachersdata")
    public void TeacherLessonTopicCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
    	lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitname, text;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
            lib.FirstLesson().click();
            ThreadSleep5000();


//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();
            ThreadSleep5000();
            text = lib.EnvFirstLessonFirstTopicRefGrade1().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EnvFirstLessonSecondTopicRefGrade1().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EnvFirstLessonThirdTopicRefGrade1().getText();
            ThreadSleep5000();

            Validate(unitname, text);

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
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonFirstTopicRefGrade2().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonSecondTopicRefGrade2().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonThirdTopicRefGrade2().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonFirstTopicRefGrade3().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonSecondTopicRefGrade3().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonThirdTopicRefGrade3().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonFirstTopicRefGrade4().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonSecondTopicRefGrade4().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonThirdTopicRefGrade4().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonFirstTopicRefGrade5().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonSecondTopicRefGrade5().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonThirdTopicRefGrade5().getText();
            ThreadSleep5000();

            Validate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

        }


    }

    @DataProvider(name = "Studentdata")
    public Object[][] getstudentData() throws FileAlreadyExistsException {

        Object loginData[][] = { { "9000000001", "123456" }, { "9000000024", "123456" }, { "9000000046", "123456" },
                { "9000000069", "123456" }, { "9000000081", "123456" } };
//        Object loginData[][] = { { "9000000001", "123456" }};
        return loginData;
    }

    @DataProvider(name = "Teachersdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {

        Object loginData[][] = { { "9000000101", "123456" }, { "9000000105", "123456" }, { "9000000110", "123456" },
                { "9000000114", "123456" }, { "9000000120", "123456" } };
//        Object loginData[][] = { { "9000000101", "123456" }};
        return loginData;
    }
}
