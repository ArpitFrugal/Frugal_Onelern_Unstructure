package TimeTable;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import java.util.List;

public class TimetableAdminEditHolidayCheck extends Base {
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
    @Description("Examine whether or noti the admin can edit the holiday successfully.")
    @Story("TIMFA_09")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminEditHolidayCheck(String usermail, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.HolidaysTab().click();

        List<WebElement> AllHolidaysName = tim.AllHolidaysName();

        WebElement FirstHoliday = AllHolidaysName.get(0);
        String FirstHolidayName = FirstHoliday.getText();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@class, 'menu-icon')]")).click();
        tim.HolidaysEditBtn().click();
        Thread.sleep(1000);

        String displayedEventName = tim.HolidayName().getAttribute("value");

//System.out.println(displayedEventName);
        ValidateTest(FirstHolidayName, displayedEventName);
    }

    public void ValidateTest(String actualHeading, String expectedHeading) {
        System.out.println(actualHeading+" "+expectedHeading);
        if(actualHeading.contains(expectedHeading)){
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
