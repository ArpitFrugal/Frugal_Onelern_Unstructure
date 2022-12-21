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

public class UserManagementCollectionPaginationCheck extends Base {
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
    @Description("Examine whether or noti the admin can successfully navigate to next and previous pages through navigation.")
    @Story("UMFA_12")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminLicensePaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        boolean flag1, flag2, flag3;

        usm.CollectionsModule().click();

        int i=0;

        Thread.sleep(2000);
        usm.nextNavigateBtn().click();
        usm.nextNavigateBtn().click();
        i+=2;
        Thread.sleep(1000);
        System.out.println(usm.paginationText().getText());
        flag1 = ValCompare(usm.paginationText().getText(), String.valueOf(i+1));

        Thread.sleep(1000);
        usm.prevNavigateBtn().click();
        i-=1;
        Thread.sleep(1000);
        System.out.println(usm.paginationText().getText());
        flag2 = ValCompare(usm.paginationText().getText(),String.valueOf(i+1));

        Thread.sleep(1000);
        usm.nextNavigateBtn().click();
        usm.nextNavigateBtn().click();
        i+=2;
        Thread.sleep(1000);
        System.out.println(usm.paginationText().getText());
        flag3 = ValCompare(usm.paginationText().getText(),String.valueOf(i+1));

        ValidateTest(flag1, flag2, flag3);
    }

    public boolean ValCompare(String actual, String expected){
        return actual.contains(expected);
    }

    private void ValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1 + " " + flag2 + " " +flag3);
        if(flag1 && flag2 && flag3){
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
