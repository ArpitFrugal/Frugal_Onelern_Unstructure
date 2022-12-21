package UserManagement;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
import java.util.List;

public class UserManagementLicenseSearchCheck extends Base {
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


    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or noti the admin can successfully search the collection.")
    @Story("UMFA_13")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminLicenseSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        usm.UserManagementModule().click();
        Thread.sleep(1000);

        usm.LicensesModule().click();

        usm.SearchInputBox().click();
        usm.SearchInputBox().sendKeys("New License");

        Thread.sleep(1000);
        ValidateTest(usm.CollectionsDisplayed());

    }

    private void ValidateTest(List<WebElement> collectionsDisplayed) {
        System.out.println(collectionsDisplayed.size());
        if(collectionsDisplayed.size() > 0){
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

    @DataProvider(name = "adminData")
    public Object[][] getadminData() throws FileAlreadyExistsException {
        return getProjectAdminData();
    }
}
