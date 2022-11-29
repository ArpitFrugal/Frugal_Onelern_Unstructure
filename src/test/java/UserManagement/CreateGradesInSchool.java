package UserManagement;

import io.qameta.allure.*;
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

public class CreateGradesInSchool extends Base {
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
    @Description("Examine whether or not the admin can successfully create Grade or not")
    @Story("UMFA_04")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        usm.InstituteClick().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Alphores");
        Thread.sleep(2000);
        usm.SelectInstitute().click();
        Thread.sleep(2000);
        usm.SearchSchool().click();
        usm.SearchSchool().sendKeys("Trinity");
        usm.SelectSchool().click();
        Thread.sleep(2000);
        usm.AddGradeBtnClick().click();
        Thread.sleep(5000);
        usm.Grade1Check().click();
        Thread.sleep(2000);
        usm.Grade2Check().click();
        Thread.sleep(2000);
        usm.Grade3Check().click();
        Thread.sleep(2000);
        usm.Grade4Check().click();
        Thread.sleep(2000);
        usm.Grade5Check().click();
        Thread.sleep(2000);
        usm.SaveBtn().click();
        Thread.sleep(2000);


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