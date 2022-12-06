package UserManagement;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.UserManagement;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class CreateSchoolInInstitute extends Base {
    public UserManagement usm;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        usm = new UserManagement(driver);
        log = new LoginPage(driver);
    }

    @Epic("This story represents the User management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully create School or not")
    @Story("UMFA_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminCreateSchoolCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);
        usm.InstituteClick().click();
        Thread.sleep(2000);
        usm.SearchInstitute().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Alphores");
        Thread.sleep(2000);
        usm.SelectInstitute().click();
        Thread.sleep(2000);
        usm.AddSchoolBtnClick().click();
        Thread.sleep(2000);

        usm.EnterCurriculum().click();
        Thread.sleep(1000);
        usm.EnterCurriculum().sendKeys("CBSE");
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);

        usm.EnterSchoolName().sendKeys("Trinity");
        Thread.sleep(2000);
        usm.EnterSchoolCode().sendKeys("Tri_001");
        Thread.sleep(2000);
//        usm.EnterCurriculum().click();
//        Thread.sleep(1000);
//        usm.EnterCurriculum().sendKeys("CBSE");
//        Thread.sleep(2000);
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.CONTROL).clickAndHold().sendKeys(Keys.ENTER).build().perform();
//        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", usm.EnterPhoneNumber());
        usm.EnterLiveClassURL().sendKeys("https://meet.google.com/");
        usm.EnterAddress().sendKeys("Park Street");
        usm.EnterPhoneNumber().sendKeys("9876543210");
        js.executeScript("arguments[0].scrollIntoView();", usm.EnterState());
        usm.EnterZipCode().sendKeys("500080");
        usm.EnterCity().sendKeys("Hyderabad");
        usm.EnterState().sendKeys("Telangana");
        js.executeScript("arguments[0].scrollIntoView();", usm.CreateSchoolBtn());
        usm.EnterCountry().sendKeys("India");
        usm.EnterEmail().sendKeys("abc@test.com");
        usm.EnterWebsite().sendKeys("Website");
        usm.CreateSchoolBtn().click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "adminData")
    public Object[][] getadminData() throws FileAlreadyExistsException {
        return getProjectAdminData();
    }
}
