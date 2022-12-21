package Assessment;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class EvaluateAssessment extends Base {
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
    @Description("Examine whether or noti the teacher can successfully create Online assessment for the students.")
    @Story("ASSFT_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherCreateAssessment_Online(String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));

        ass.CompletedTabPage().click();

        ass.AssessmentsSearch().click();
        ass.AssessmentsSearch().sendKeys("PP Assessment");
        Thread.sleep(1000);

        ass.EvaluateAssess().click();
        Thread.sleep(1000);
        ass.EvaluatePaper().click();

        ass.QuestionByQuestion().click();




    }
    public void ValidateTest(String displayedAssessmentName, String assessmentName) {
        if(displayedAssessmentName.contains(assessmentName)){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}

