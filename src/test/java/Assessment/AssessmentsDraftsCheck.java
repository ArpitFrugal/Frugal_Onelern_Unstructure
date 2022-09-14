package Assessment;

import io.qameta.allure.*;
import org.openqa.selenium.By;
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

public class AssessmentsDraftsCheck extends Base {
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
    @Description("Examine whether or not the teacher can successfully draft assessment for the students.")
    @Story("ASSFT_03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherdata")
    public void teacherDraftAssessmentsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);


//        if(ass.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(2000);

        boolean flag1, flag2, flag3;

        ass.DraftsTabPage().click();

        int no_of_assessments =ass.AssessmentCards().size();
        if(no_of_assessments > 0){
            flag1= ValueCompare(no_of_assessments, ass.DraftPublishBtn().size());

            ass.OutsideEditBtnDrafts().click();
            Thread.sleep(1000);
            flag2 = TextCheck(driver.getPageSource());
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[contains(@class,'back-btn')]")).click();
            Thread.sleep(5000);
            ass.DraftsTabPage().click();
            Thread.sleep(1000);
            ass.deleteDraft().click();
            Thread.sleep(2000);
            ass.DraftsTabPage().click();
            Thread.sleep(1000);
            flag3 = ValueCompare(no_of_assessments -1, ass.AssessmentCards().size());

            ValidateTest(flag1, flag2, flag3);
        }
        else {
            String CurrUrl = driver.getCurrentUrl();
            boolean flag = CurrUrl.contains("drafts");
            if(flag)
                ValidateTest(flag, flag, flag);
            else
                ValidateTest(false, false, false);
        }
    }

    private void ValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1+" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3)
            System.out.println("PASSED");
        else
            Assert.fail();
    }

    private boolean TextCheck(String pageSource) {
        return pageSource.contains("Question Paper");
    }

    private boolean ValueCompare(int expected_count, int actual_count) {
        System.out.println(expected_count+" "+actual_count);
        return expected_count == actual_count;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = {{"9000000101", "123456"}, {"9000000105", "123456"}, {"9000000109", "123456"},
                {"9000000113", "123456"}, {"9000000117", "123456"}};
//        Object loginData[][] = {{"9000000105", "123456"}};
        return loginData;
    }

}