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

public class LessonDeliveryLessonPlanComponentsCheck extends Base {
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

    public boolean ColorCheck(String actual, String expected){
        System.out.println(actual+" "+expected);
        return actual.equals(expected);
    }
    public void ValidateTest(boolean flag1, boolean flag2, boolean flag3, boolean flag4) {
        System.out.println(flag1+" "+flag2+" "+flag3+" "+flag4);
        if(flag1 && flag2 && flag3 && flag4){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson plan components should be clearly visible.")
    @Story("LDFT_07")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "Teachersdata")
    public void TeacherLessonPlanComponentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String blackColor = "#131536";
        String blueColor = "rgba(71, 75, 255, 1)";
        boolean flag1, flag2, flag3, flag4;
        String color;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.TeachComponent().click();
            Thread.sleep(5000);
            color = ld.TeachComponent().getCssValue("color");
            flag1 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.TeachComponent().click();

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            color = ld.ApplyComponent().getCssValue("color");
            flag2 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            ld.AssessComponent().click();
            Thread.sleep(5000);
            color = ld.AssessComponent().getCssValue("color");
            flag3 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.AssessComponent().click();

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            color = ld.ReviewComponent().getCssValue("color");
            flag4 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            ValidateTest(flag1, flag2, flag3, flag4);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.TeachComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag1 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.TeachComponent().click();

            ld.ApplyComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag2 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            ld.AssessComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag3 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.AssessComponent().click();

            ld.ReviewComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag4 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            ValidateTest(flag1, flag2, flag3, flag4);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.TeachComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag1 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.TeachComponent().click();

            ld.ApplyComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag2 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            ld.AssessComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag3 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.AssessComponent().click();

            ld.ReviewComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag4 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            ValidateTest(flag1, flag2, flag3, flag4);
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

            ld.TeachComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag1 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.TeachComponent().click();

            ld.ApplyComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag2 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            ld.AssessComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag3 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.AssessComponent().click();

            ld.ReviewComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag4 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            ValidateTest(flag1, flag2, flag3, flag4);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.TeachComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag1 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.TeachComponent().click();

            ld.ApplyComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag2 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            ld.AssessComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag3 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.AssessComponent().click();

            ld.ReviewComponent().click();
            color = ld.TeachComponent().getCssValue("color");
            flag4 = ColorCheck(color, blueColor);
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            ValidateTest(flag1, flag2, flag3, flag4);
        }
    }


    @DataProvider(name = "Teachersdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {

        Object loginData[][] = { { "9000000101", "123456" }, { "9000000105", "123456" }, { "9000000110", "123456" },
                { "9000000114", "123456" }, { "9000000120", "123456" } };
//        Object loginData[][] = { { "9000000101", "123456" }};
        return loginData;
    }
}
