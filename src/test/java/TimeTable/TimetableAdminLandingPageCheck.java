package TimeTable;

import io.qameta.allure.*;
import org.apache.commons.lang3.Validate;
import org.openqa.selenium.WebDriver;
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

public class TimetableAdminLandingPageCheck extends Base {
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
    @Description("Examine whether or not the admin can enter into timetable module successfully.")
    @Story("TIMFA_01")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "admindata")
    public void adminLandingPageCheck(String usermail, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        String actualHeading = tim.adminTimetableModuleHeading().getText();
        String expectedHeading = "Timetable";

        ValidateTest(actualHeading, expectedHeading);
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


    @DataProvider(name = "admindata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = {{"frugaltestschooladmin@onelern.com", "123456"}};
        return loginData;
    }
}
