package TimeTable;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TimeTable;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class TimetableViewAllEventsCheck extends Base {
    public TimeTable tim;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        tim = new TimeTable(driver);
        log = new LoginPage(driver);
    }

    private void ValidateTest(boolean flag1, boolean flag2) {
        System.out.println(flag1 +" "+flag2);
        if(flag1 && flag2){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }
    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or noti the student can view all the events successfully by clicking on view all button.")
    @Story("TIMFS_03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void studentViewEventsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        tim.StudentImageClick().click();
        Thread.sleep(2000);
        tim.studentTimeTableToggle().click();
        Thread.sleep(2000);

        List<WebElement> ViewEventsHolidaysBtns = tim.ViewAllEventsHolidays();
        WebElement ViewAllEvents = ViewEventsHolidaysBtns.get(0);

        ViewAllEvents.click();

        boolean flag1, flag2;

        flag1 = tim.TemplateHeader().getText().contains("Events");

        flag2 = tim.EventsTab().getAttribute("class").contains("active");

        ValidateTest(flag1, flag2);

    }



    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or noti the teacher can view all the events successfully by clicking on view all button.")
    @Story("TIMFT_03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherViewEventsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);

        tim.rightswipemodules().click();
        Thread.sleep(1000);
        tim.rightswipemodules().click();
        Thread.sleep(1000);
        tim.rightswipemodules().click();

        tim.teacherTimeTableToggle().click();
        Thread.sleep(2000);

        List<WebElement> ViewEventsHolidaysBtns = tim.ViewAllEventsHolidays();
        WebElement ViewAllEvents = ViewEventsHolidaysBtns.get(0);

        ViewAllEvents.click();

        boolean flag1, flag2;

        flag1 = tim.TemplateHeader().getText().contains("Events");

        flag2 = tim.EventsTab().getAttribute("class").contains("active");

        ValidateTest(flag1, flag2);

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
