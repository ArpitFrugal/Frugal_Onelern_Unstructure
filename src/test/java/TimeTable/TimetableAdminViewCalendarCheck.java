package TimeTable;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.TimeTable;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class TimetableAdminViewCalendarCheck extends Base {
    public TimeTable tim;
    public WebDriver driver;


    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("schooladminurl"));
        tim = new TimeTable(driver);
    }
    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can view the calendar successfully.")
    @Story("TIMFA_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminViewCalendarCheck(String usermail, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.timetableGrades().click();
        String TimetableSectionName = tim.TimetableSectionName().getText();
        String BtnText = tim.ViewOrAddTimetableBtn().getText();

        if(BtnText.contains("View")){
            tim.ViewOrAddTimetableBtn().click();
            String NavigationPath = tim.CurrentPagePath().getText();
            ValidateTest(NavigationPath, TimetableSectionName);
        }
        else{
            tim.ViewOrAddTimetableBtn().click();
            String PageHeader = tim.CreateTemplatePageHeader().getText();
            ValidateTest(PageHeader, TimetableSectionName);
        }

    }

    public void ValidateTest(String actual, String expected) {
        System.out.println(actual+" "+expected);
        if(actual.contains(expected)){
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
        return getSchoolAdminData();
    }
}
