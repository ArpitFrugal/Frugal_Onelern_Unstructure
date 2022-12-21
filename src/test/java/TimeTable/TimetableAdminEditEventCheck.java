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

public class TimetableAdminEditEventCheck extends Base {
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
    @Description("Examine whether or noti the admin can edit the event successfully.")
    @Story("TIMFA_06")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminEditEventCheck(String usermail, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.EventsTab().click();

        List<WebElement> AllEventsName = tim.AllEventsName();

        WebElement FirstEvent = AllEventsName.get(0);
        String FirstEventName = FirstEvent.getText();

        driver.findElement(By.xpath("//*[contains(@class, 'menu-icon')]")).click();
        tim.EventsEditBtn().click();
        Thread.sleep(1000);

        String displayedEventName = tim.EventName().getAttribute("value");

//System.out.println(displayedEventName);
        ValidateTest(FirstEventName, displayedEventName);
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
