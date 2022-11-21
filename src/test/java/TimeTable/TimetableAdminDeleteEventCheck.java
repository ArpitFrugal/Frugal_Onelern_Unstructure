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

public class TimetableAdminDeleteEventCheck extends Base {
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
    @Description("Examine whether or not the admin can delete an event successfully.")
    @Story("TIMFA_07")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "admindata")
    public void adminDeleteEventCheck(String usermail, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.EventsTab().click();

        Thread.sleep(1000);
        List<WebElement> AllEventsName = tim.AllEventsName();

        Thread.sleep(1000);
        int beforeEventsCount = AllEventsName.size();
        driver.findElement(By.xpath("//*[contains(@class, 'menu-icon')]")).click();
        Thread.sleep(1000);
        tim.EventsDeleteBtn().click();
        tim.ConfirmDelete().click();
        Thread.sleep(1000);
        int afterEventsCount = tim.AllEventsName().size();

        ValidateTest(beforeEventsCount, afterEventsCount);

    }

    public void ValidateTest(int before, int after) {
        System.out.println(before+" "+after);
        if(before == after + 1){
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
