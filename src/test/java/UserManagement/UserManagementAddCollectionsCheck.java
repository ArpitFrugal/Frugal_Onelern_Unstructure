package UserManagement;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
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

public class UserManagementAddCollectionsCheck extends Base {
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
    @Description("Examine whether or noti the admin can successfully able to add collections.")
    @Story("UMFA_08")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminAddCollectionsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        usm.CollectionsModule().click();
        usm.AddCollectionsBtn().click();

        String CollectionName = "New Collection";
        usm.CollectionNameInput().click();
        usm.CollectionNameInput().sendKeys(CollectionName);

        usm.CollectionDescriptionInput().click();
        usm.CollectionDescriptionInput().sendKeys("Description");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = usm.bottomDiv();
        js.executeScript("arguments[0].scrollIntoView();", element);

        Thread.sleep(2000);
        usm.AddPackagesBtn().click();
        usm.FirstPackage().click();

        usm.ConfirmPackages().click();

        usm.ConfirmCollection().click();
        Thread.sleep(2000);
        ValidateTest(usm.FirstCollectionDisplayed().getText(), CollectionName);

    }

    private void ValidateTest(String actualText, String expectedText) {
        System.out.println(actualText+" "+expectedText);
        if(actualText.contains(expectedText)){
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
