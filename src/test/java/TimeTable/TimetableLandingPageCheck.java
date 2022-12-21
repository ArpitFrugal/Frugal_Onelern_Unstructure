package TimeTable;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
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

public class TimetableLandingPageCheck extends Base {
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

    public void ValidateTest(String actual_header, String expected_header){
        if (actual_header.contains(expected_header)) {
            System.out.println("Time table Module is active");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or noti the student can successfully get inside the Time table module.")
    @Story("TIMFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        tim.StudentImageClick().click();
        Thread.sleep(2000);
        tim.studentTimeTableToggle().click();
        Thread.sleep(2000);

        String actual_header = tim.GetHeader();
        String expected_header = "Timetable";
        ValidateTest(actual_header, expected_header);
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or noti the teacher can successfully get inside the Time table module.")
    @Story("TIMFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
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

        String actual_header = tim.GetHeader();
        String expected_header = "Planner";
        ValidateTest(actual_header, expected_header);
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
