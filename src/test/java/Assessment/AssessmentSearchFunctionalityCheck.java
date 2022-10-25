package Assessment;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Assessment;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.time.Duration;

public class AssessmentSearchFunctionalityCheck extends Base {
    public Assessment ass;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ass = new Assessment(driver);
        log = new LoginPage(driver);
    }



    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully search an assessment.")
    @Story("ASSFS_06")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentdata")
    public void studentSearchAssessmentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        ass.StudentImageClick().click();
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.AssessmentsSearch().click();
        ass.AssessmentsSearch().sendKeys("Assessment13579");

        int NoOfAssessmentsDisplayed = driver.findElements(By.xpath("//*[contains(@class,'assessment-box')]//h1[text()='Assessment13579']")).size();

        ValidateTest(NoOfAssessmentsDisplayed);

    }

    private void ValidateTest(int actual_result) {
        System.out.println(actual_result);
        if(actual_result >= 1)
            System.out.println("PASSED");
        else
            Assert.fail();
    }


    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully search an assessment.")
    @Story("ASSFT_08")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherdata")
    public void teacherSearchAssessmentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);

        ass.CompletedTabPage().click();

        ass.AssessmentsSearch().click();
        Thread.sleep(2000);
        ass.AssessmentsSearch().sendKeys("New Assessment");
        Thread.sleep(3000);
//        ass.AssessmentsSearch().sendKeys(Keys.ENTER);


        int NoOfAssessmentsDisplayed = driver.findElements(By.xpath("//*[contains(@class,'assessment-box')]//h1[text()='New Assessment']")).size();

        ValidateTest(NoOfAssessmentsDisplayed);

    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.

    @DataProvider(name = "studentdata")
    public Object[][] getstudentData() throws FileAlreadyExistsException {

        Object loginData[][] = {{"9000000001", "123456"}, {"9000000021", "123456"}, {"9000000041", "123456"},
                {"9000000061", "123456"}, {"9000000081", "123456"}};
//        Object loginData[][] = {{"9000000001", "123456"}};
        return loginData;
    }
    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = {{"9000000101", "123456"}, {"9000000105", "123456"}, {"9000000109", "123456"},
                {"9000000113", "123456"}, {"9000000117", "123456"}};
//        Object loginData[][] = {{"9000000101", "123456"}};
        return loginData;
    }
}
