package UserManagement;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserManagementAddLicenseCheck extends Base {
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
    @Description("Examine whether or noti the admin can successfully able to add License.")
    @Story("UMFA_11")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminAddLicenseCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        usm.UserManagementModule().click();
        Thread.sleep(1000);

        usm.LicensesModule().click();

        usm.AddLicenseBtn().click();

        String LicenseName = "New License";
        usm.LicenseName().click();
        usm.LicenseName().sendKeys(LicenseName);

        Select InstituteOptions = new Select(usm.LicenseInstituteSelect());
        InstituteOptions.selectByVisibleText("Automation Test School");

        usm.TotalAllocatedLicenses().click();
        usm.TotalAllocatedLicenses().sendKeys("10");
//////////////////////////////////////////

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal.add(Calendar.DAY_OF_MONTH, 7);
        String dateAfter = formatter.format(cal.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        usm.StartDateInputBox().click();
        usm.StartDateInputBox().sendKeys(currdate);
        usm.StartDateInputBox().sendKeys(currmonth);
        usm.StartDateInputBox().sendKeys(curryear);

        usm.EndDateInputBox().click();
        usm.EndDateInputBox().sendKeys(enddate);
        usm.EndDateInputBox().sendKeys(endmonth);
        usm.EndDateInputBox().sendKeys(endyear);

        System.out.println(currdate+" "+enddate);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = usm.bottomDiv();
        js.executeScript("arguments[0].scrollIntoView();", element);

        Thread.sleep(2000);

        usm.AddCollectionBtn().click();
        usm.FirstCollection().click();

        usm.ConfirmCollections().click();

        usm.CreateLicenseBtn().click();
        Thread.sleep(2000);
        ValidateTest(usm.FirstCollectionDisplayed().getText(), LicenseName);

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
