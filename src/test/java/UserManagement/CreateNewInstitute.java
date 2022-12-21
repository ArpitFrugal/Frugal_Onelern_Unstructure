package UserManagement;

import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

public class CreateNewInstitute extends Base {

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
    @Description("Examine whether or noti the admin can successfully create Institute or noti")
    @Story("UMFA_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminAddInstituteCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);
        usm.InstituteClick().click();
        Thread.sleep(2000);
        usm.NewInstituteBtnClick().click();
        Thread.sleep(2000);
        usm.SelectCurriculum().click();
        usm.SelectCurriculum().sendKeys("CBSE");
        usm.SelectCurriculum().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        usm.EnterInstituteName().sendKeys("Alphores_1");
        Thread.sleep(2000);
        usm.EnterInstituteCode().sendKeys("Alp_0001");
        Thread.sleep(2000);
        usm.CreateInstituteBtnClick().click();


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

