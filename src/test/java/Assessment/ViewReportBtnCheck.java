package Assessment;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
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

public class ViewReportBtnCheck extends Base {
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
    @Description("Examine whether or noti the student can successfully open the report.")
    @Story("ASSFS_03")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData")
    public void StudentViewReportBtnCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        ass.StudentImageClick().click();
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.AssessmentsSearch().click();
        ass.AssessmentsSearch().sendKeys("New Assessment");

        ass.FirstAssessmentDisplayedStudent().click();

        String heading = ass.ModuleHeading().getText();
        ValidateTest(heading, "Student Report");
    }
    public void ValidateTest(String actual_text, String expected_text){
        if(actual_text.contains(expected_text))
            System.out.println("PASSED");
        else
            Assert.fail();
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }
}
