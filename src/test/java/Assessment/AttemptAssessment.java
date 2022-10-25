package Assessment;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
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

public class AttemptAssessment extends Base {
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
    @Description("Examine whether or not the student can successfully attempt the assessment created by his/her teacher.")
    @Story("ASSFS_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentdata")
    public void StudentAttemptAssessment(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        ass.StudentImageClick().click();
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.AssessmentsSearch().click();
        ass.AssessmentsSearch().sendKeys("New Assessment");
//        ass.AssessmentsSearch().sendKeys("New Assessment");

        ass.FirstAssessmentDisplayedStudent().click();
        Thread.sleep(1000);
        ass.StartAssessmentBtn().click();

        ass.PasswordInputStudent().click();
        ass.PasswordInputStudent().sendKeys("password");

        ass.PasswordSubmitBtnStudent().click();
        ass.NextQuestionBtn().click();

        Thread.sleep(3000);
        ass.AttemptAnswerOption().click();

//        ass.NextQuestionBtn().click();
//        ass.AttemptAnswerOption().click();
//        Thread.sleep(1000);
//        ass.AttemptAnswerOption().click();
//
//        ass.NextQuestionBtn().click();
//        ass.AttemptAnswerOption().click();
//
//        ass.NextQuestionBtn().click();


        ass.AssessmentSubmitBtn().click();

        ass.FinalSubmitAssessment().click();

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
}
