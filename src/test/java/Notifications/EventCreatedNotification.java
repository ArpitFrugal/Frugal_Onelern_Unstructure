package Notifications;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notifications;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EventCreatedNotification extends Base {
    public Notifications noti;
    public LoginPage log;
    public WebDriver driver;

    String TeacherMob = "9000000101";
    String StudentMob = "9000000001";
    String password = "123456";

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        noti = new Notifications(driver);
        log = new LoginPage(driver);
    }

    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the student can successf  ully view the notification for new Holiday created.")
    @Story("NOTIFS_06")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void StudentNewEventNotificationCheck(String usermail, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        noti.adminTimetableToggle().click();

        noti.EventsTab().click();
        noti.CreateNewEvent().click();

        noti.EventName().click();
        noti.EventName().sendKeys("New Event");

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

        noti.startDate().click();
        noti.startDate().sendKeys(currdate);
        noti.startDate().sendKeys(currmonth);
        noti.startDate().sendKeys(curryear);

        noti.endDate().click();
        noti.endDate().sendKeys(enddate);
        noti.endDate().sendKeys(endmonth);
        noti.endDate().sendKeys(endyear);

        // time
        noti.startTime().click();
        noti.startTime().sendKeys("08");
        noti.startTime().sendKeys("00");
        noti.startTime().sendKeys("a");

        noti.endTime().click();
        noti.endTime().sendKeys("03");
        noti.endTime().sendKeys("00");
        noti.endTime().sendKeys("p");

        noti.CreateEventBtn().click();




        driver.navigate().to(prop.getProperty("website"));
        Thread.sleep(2000);
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();


        user.userLogin("student", StudentMob, password);
        Thread.sleep(2000);
        noti.StudentImageClick().click();
        Thread.sleep(2000);

        noti.notificationsStudent().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "EVENT";
        ValidateTest(RecentNotificationTitle, expectedText);

    }

    public void ValidateTest(String displayedNotificationTitle, String expectedText) {
        System.out.println(displayedNotificationTitle +" "+ expectedText);
        if(displayedNotificationTitle.contains(expectedText)){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the notification for new Holiday created.")
    @Story("NOTIFT_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void TeacherNewEventNotificationCheck(String usermail, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        noti.adminTimetableToggle().click();

        noti.EventsTab().click();
        noti.CreateNewEvent().click();

        noti.EventName().click();
        noti.EventName().sendKeys("New Event");

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

        noti.startDate().click();
        noti.startDate().sendKeys(currdate);
        noti.startDate().sendKeys(currmonth);
        noti.startDate().sendKeys(curryear);

        noti.endDate().click();
        noti.endDate().sendKeys(enddate);
        noti.endDate().sendKeys(endmonth);
        noti.endDate().sendKeys(endyear);

        // time
        noti.startTime().click();
        noti.startTime().sendKeys("08");
        noti.startTime().sendKeys("00");
        noti.startTime().sendKeys("a");

        noti.endTime().click();
        noti.endTime().sendKeys("03");
        noti.endTime().sendKeys("00");
        noti.endTime().sendKeys("p");

        noti.CreateEventBtn().click();



        driver.navigate().to(prop.getProperty("website"));
        Thread.sleep(2000);
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();


        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);

        noti.notificationsTeacher().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "EVENT";
        ValidateTest(RecentNotificationTitle, expectedText);

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
