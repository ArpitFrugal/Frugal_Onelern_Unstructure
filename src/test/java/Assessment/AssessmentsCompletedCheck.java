package Assessment;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import java.util.List;
import java.util.Objects;

public class AssessmentsCompletedCheck extends Base {
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
    @Description("Examine whether or noti the teacher can successfully fetch completed assessments from ongoing tab.")
    @Story("ASSFT_07")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherCompletedAssessmentsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(2000);
        ass.CompletedTabPage().click();

        boolean flag = true;
        List<WebElement> assessmentsstatus = ass.StatusTagOnAssessment();
        for(WebElement webElement:assessmentsstatus){
            if(!Objects.equals(webElement.getText(), "SUBMITTED") && !Objects.equals(webElement.getText(), "COMPLETED")){
                flag = false;
                break;
            }
        }

        Validate(ass.StatusTagOnAssessment().size() > 0, flag);
    }

    private void Validate(boolean flag1, boolean flag2) {
        if(flag1 && flag2)
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
    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
