package LessonDelivery;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LessonDelivery;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class LessonDeliveryLessonPlanOverviewCheck extends Base {
    public LessonDelivery ld;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ld = new LessonDelivery(driver);
        log = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson plan overview should be clearly visible.")
    @Story("LDFT_06")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teachersData")
    public void TeacherLessonPlanOverviewCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.LessonPlanOverviewBtn().click();

            ValidateTest(ld.LessonPlanOverviewModalHeader().getText().contains("Learning Plan Overview"), ld.ModalDialogBox().isDisplayed());

        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.LessonPlanOverviewBtn().click();

            ValidateTest(ld.LessonPlanOverviewModalHeader().getText().contains("Learning Plan Overview"), ld.ModalDialogBox().isDisplayed());

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.LessonPlanOverviewBtn().click();

            ValidateTest(ld.LessonPlanOverviewModalHeader().getText().contains("Learning Plan Overview"), ld.ModalDialogBox().isDisplayed());


        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.LessonPlanOverviewBtn().click();

            ValidateTest(ld.LessonPlanOverviewModalHeader().getText().contains("Learning Plan Overview"), ld.ModalDialogBox().isDisplayed());

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.LessonPlanOverviewBtn().click();

            ValidateTest(ld.LessonPlanOverviewModalHeader().getText().contains("Learning Plan Overview"), ld.ModalDialogBox().isDisplayed());


        }
    }

    public void ValidateTest(boolean HeaderCheck, boolean ModalBoxCheck) {
        if(HeaderCheck && ModalBoxCheck){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
