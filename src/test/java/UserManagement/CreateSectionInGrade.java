package UserManagement;

import io.qameta.allure.*;
import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
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

public class CreateSectionInGrade extends Base {
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
    @Description("Examine whether or noti the admin can successfully create Section or noti")
    @Story("UMFA_05")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminCreateSection(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);
        usm.InstituteClick().click();
        Thread.sleep(2000);
        usm.SearchInstitute().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Automation");
        Thread.sleep(2000);
        usm.SelectInstitute().click();
        Thread.sleep(2000);
        usm.SearchSchool().click();
        usm.SearchSchool().sendKeys("School");
        Thread.sleep(2000);
        usm.SelectSchool().click();
        Thread.sleep(2000);
        List<WebElement> grades = usm.GradesDisplay();
        grades.get(0).click();
        Thread.sleep(2000);

        int sectionsDisplayed = driver.findElements(By.xpath("//*[contains(@class,'grade-card')]")).size();
        usm.AddsectionsBtn().click();
        Thread.sleep(2000);
        usm.InputSectionName().click();
        usm.InputSectionName().sendKeys("SectionA");
        Thread.sleep(2000);
        usm.AddSectionBtn().click();
        Thread.sleep(2000);
        int sectionsDisplayedAfterAdding = driver.findElements(By.xpath("//*[contains(@class,'grade-card')]")).size();

        ValidateTest(sectionsDisplayed, sectionsDisplayedAfterAdding);
    }

    private void ValidateTest(int sectionsDisplayed, int sectionsDisplayedAfterAdding) {
        if(sectionsDisplayed+1 == sectionsDisplayedAfterAdding){
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
