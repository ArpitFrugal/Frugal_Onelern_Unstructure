package LessonDelivery;

import io.qameta.allure.*;
import org.openqa.selenium.By;
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

public class LessonDeliveryDeleteLearningPlan extends Base {
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
    @Description("Teacher should be able to able to delete the learning plan successfully.")
    @Story("LDFT_12")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherDeleteLearningPlanCheck(String mobNumber, String password) throws IOException, InterruptedException {
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
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }
        ld.FirstLesson().click();
        Thread.sleep(1000);

        ld.LessonPlanMode().click();
        Thread.sleep(2000);

        if(ld.LearningPlans().size() > 0){
            System.out.println(1);
            int initial_no_of_plans = ld.LearningPlans().size();
            ld.DeleteBtn().click();
            ld.ConfirmDeleteBtn().click();
            Thread.sleep(2000);
            int final_no_of_plans = ld.LearningPlans().size();

            ValidateTest(initial_no_of_plans, final_no_of_plans + 1);

        }
        else{
            System.out.println(2);
            // create
            ld.CreateLearningPlanBtn().click();
            Thread.sleep(2000);

            ld.LearningPlanInputs().get(1).click();
            ld.LearningPlanInputs().get(1).sendKeys("Description");

            ld.LearningPlanInputs().get(2).click();
            ld.LearningPlanInputs().get(2).sendKeys("Content");

            ld.LearningPlanSubmitBtn().click();
            Thread.sleep(2000);

            // delete
            int initial_no_of_plans = ld.LearningPlans().size();
            ld.DeleteBtn().click();
            ld.ConfirmDeleteBtn().click();
            Thread.sleep(2000);
            int final_no_of_plans = ld.LearningPlans().size();

            ValidateTest(initial_no_of_plans, final_no_of_plans + 1);
        }
    }

    private void ValidateTest(int initialCount, int FinalCount) {
        if(initialCount == FinalCount){
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
