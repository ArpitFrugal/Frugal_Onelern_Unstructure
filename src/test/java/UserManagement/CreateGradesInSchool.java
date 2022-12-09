package UserManagement;

import io.qameta.allure.*;
import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    public void AdminCreateGradeCheck(String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        usm.InstituteClick().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Automation");
        Thread.sleep(2000);
        usm.SelectInstitute().click();
        Thread.sleep(2000);
        usm.SearchSchool().click();
        usm.SearchSchool().sendKeys("School");
        usm.SelectSchool().click();
        Thread.sleep(2000);

        int gradesDisplayed = driver.findElements(By.xpath("//label[contains(@for,'form')]/input")).size();
        usm.AddGradeBtnClick().click();
        Thread.sleep(5000);

        if(usm.Grades().size()>0){
            usm.Grade1Check().click();
            Thread.sleep(2000);
            usm.SaveBtn().click();
            Thread.sleep(2000);

            System.out.println(driver.findElements(By.xpath("//label[contains(@for,'form')]/input")).size());
            flag = driver.findElements(By.xpath("//label[contains(@for,'form')]/input")).size() == gradesDisplayed+1;
        }
        else{
            flag=true;
        }

        ValidateTest(flag);

    }

    private void ValidateTest(boolean flag) {
        if(flag){
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