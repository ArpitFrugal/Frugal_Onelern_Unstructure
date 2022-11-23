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

public class LessonDeliveryLessonNameVerify extends Base {
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

    public void ThreadSleep2000() throws InterruptedException {
        Thread.sleep(2000);
    }
    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
    }


    public void LessonNameValidateTest(Boolean flag1, Boolean flag2, Boolean flag3) {
        System.out.println(flag1+" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    public boolean CheckHeading(String Expected, String Actual){
        return Actual.contains(Expected);
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LDFT_04")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teachersData")
    public void TeacherLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String ExpectedLessonName, ActualLessonName;
        boolean flag1, flag2, flag3;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.FirstLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag1 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.SecondLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag2 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.ThirdLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag3 = CheckHeading(ExpectedLessonName, ActualLessonName);

            LessonNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.FirstLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag1 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.SecondLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag2 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.ThirdLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag3 = CheckHeading(ExpectedLessonName, ActualLessonName);

            LessonNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.FirstLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag1 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.SecondLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag2 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.ThirdLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag3 = CheckHeading(ExpectedLessonName, ActualLessonName);

            LessonNameValidateTest(flag1, flag2, flag3);
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

            ExpectedLessonName = ld.FirstLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag1 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.SecondLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag2 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.ThirdLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag3 = CheckHeading(ExpectedLessonName, ActualLessonName);

            LessonNameValidateTest(flag1, flag2, flag3);
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

            ExpectedLessonName = ld.FirstLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag1 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.SecondLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag2 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.ThirdLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag3 = CheckHeading(ExpectedLessonName, ActualLessonName);

            LessonNameValidateTest(flag1, flag2, flag3);
        }
    }



    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
    
}
