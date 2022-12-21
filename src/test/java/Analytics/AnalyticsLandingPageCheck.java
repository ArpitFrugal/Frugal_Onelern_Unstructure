package Analytics;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Analytics;
import pageObjects.LessonDelivery;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AnalyticsLandingPageCheck extends Base {
    public Analytics ana;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ana = new Analytics(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(String actual_header){
        if (actual_header.equals("Analytics")) {
            System.out.println("Analytics Module is active");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or noti the teacher can successfully get inside the Analytics module.")
    @Story("ANAFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);

        String actual_header = ana.GetHeader();
        ValidateTest(actual_header);
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
