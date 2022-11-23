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

public class LessonDeliveryLessonPlanCheck extends Base {
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
    public boolean CheckHeading(String Expected, String Actual){
        System.out.println(Expected+" "+ Actual);
        return Actual.contains(Expected);
    }

    public void LessonPlanNameValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1+" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson plan name should be clearly visible.")
    @Story("LDFT_05")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teachersData")
    public void TeacherLessonPlanNameCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String ExpectedLessonPlanName, ActualLessonPlanName;
        boolean flag1, flag2, flag3;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 1.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag1 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);
            ld.BackButton().click();
//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 2.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag2 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);
            ld.BackButton().click();

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 3.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag3 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);

            LessonPlanNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 1.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag1 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);
            ld.BackButton().click();

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 2.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag2 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);
            ld.BackButton().click();

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 3.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag3 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);

            LessonPlanNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 1.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag1 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);
            ld.BackButton().click();

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 2.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag2 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);
            ld.BackButton().click();

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 3.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag3 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);

            LessonPlanNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 1.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag1 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);
            ld.BackButton().click();

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 2.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag2 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);
            ld.BackButton().click();

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 3.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag3 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);

            LessonPlanNameValidateTest(flag1, flag2, flag3);
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
            ExpectedLessonPlanName = "Learning Plan 1.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag1 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);
            ld.BackButton().click();

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 2.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag2 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);
            ld.BackButton().click();

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            ExpectedLessonPlanName = "Learning Plan 3.1";
            ActualLessonPlanName = ld.WorkbookHeading().getText();

            flag3 = CheckHeading(ExpectedLessonPlanName, ActualLessonPlanName);

            LessonPlanNameValidateTest(flag1, flag2, flag3);
        }
    }

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}