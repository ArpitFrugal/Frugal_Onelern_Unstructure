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
import java.util.List;

public class LessonDeliveryInsertPDFCheck extends Base {
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
    @Description("Teacher should be able to insert PDF while creating learning plan successfully.")
    @Story("LDFT_16")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherInsertPDFCheck(String mobNumber, String password) throws IOException, InterruptedException {
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

        ld.CreateLearningPlanBtn().click();
        Thread.sleep(2000);

        ld.LearningPlanInputs().get(1).click();
        ld.LearningPlanInputs().get(1).sendKeys("Description");

        ld.LearningPlanInputs().get(2).click();
        ld.LearningPlanInputs().get(2).sendKeys("Content");

        ld.PDFFileSelectionOption().sendKeys(System.getProperty("user.dir")+"/SampleFiles/pdf.pdf");

        Thread.sleep(3000);
        ld.LearningPlanSubmitBtn().click();
        Thread.sleep(2000);

        ld.LearningPlans().get(ld.LearningPlans().size() -1).click();
        WebElement insertedImage = ld.FilePreview();
        List<String> DisplayedFile = List.of(ld.DisplayedFileFormat().getText().split("\\."));
        String DisplayedFileFormat = DisplayedFile.get(DisplayedFile.size() -1);
        ValidateTest(insertedImage, DisplayedFileFormat);
    }

    public void ValidateTest(WebElement insertedImage, String DisplayedFileFormat) {
        if(insertedImage.isDisplayed() && DisplayedFileFormat.contains("pdf")){
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
