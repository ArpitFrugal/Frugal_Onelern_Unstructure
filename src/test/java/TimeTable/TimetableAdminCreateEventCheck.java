package TimeTable;

import io.qameta.allure.*;
import org.checkerframework.checker.units.qual.A;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimetableAdminCreateEventCheck extends Base {
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
    @Description("Examine whether or not the admin can create an event successfully.")
    @Story("TIMFA_05")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminCreateEventCheck(String usermail, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.EventsTab().click();
        tim.CreateNewEvent().click();

        tim.EventName().click();
        tim.EventName().sendKeys("New Event");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String CurrDate = formatter.format(date);
        Calendar cal1 = Calendar.getInstance();
        try{
            cal1.setTime(formatter.parse(CurrDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal2 = Calendar.getInstance();
        try{
            cal2.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal2.add(Calendar.YEAR, 1);
        String dateAfter = formatter.format(cal2.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        tim.startDate().click();
        tim.startDate().sendKeys(currdate);
        tim.startDate().sendKeys(currmonth);
        tim.startDate().sendKeys(curryear);

        tim.endDate().click();
        tim.endDate().sendKeys(enddate);
        tim.endDate().sendKeys(endmonth);
        tim.endDate().sendKeys(endyear);

        // time
        tim.startTime().click();
        tim.startTime().sendKeys("08");
        tim.startTime().sendKeys("00");
        tim.startTime().sendKeys("a");

        tim.endTime().click();
        tim.endTime().sendKeys("03");
        tim.endTime().sendKeys("00");
        tim.endTime().sendKeys("p");

        tim.CreateEventBtn().click();

        List<WebElement> AllEventsName = tim.AllEventsName();
        boolean flag = false;

        for(WebElement webElement: AllEventsName){
            if(webElement.getText().contains("New Event")){
                flag = true;
                break;
            }
        }

        ValidateTest(flag);

    }

    public void ValidateTest(boolean flag) {
        System.out.println(flag);
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
        return getSchoolAdminData();
    }
}
