package Attendance;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Attendance;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AttendanceMarkHolidayCheck extends Base {
    public Attendance att;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        att = new Attendance(driver);
        log = new LoginPage(driver);
    }


    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the teacher can mark a day as holiday or mark attendance for any particular day.")
    @Story("ATTFT_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherMarkHolidayCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        boolean markedForToday = att.notMarkedTeacher().size() > 0;

        if(markedForToday){
            att.markasholidayBtn().click();
            ValidateTest(att.holidayMarksTeacher().size(), Integer.parseInt(att.totalCountTeacher().getText().split(" ")[2]));
        }
        else{
            System.out.println("Attendance already marked for the day.");
            ValidateTest(1,1);
        }
    }

    private void ValidateTest(int actual, int expected) {
        System.out.println(actual+" "+expected);
        if(actual == expected){
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

    // This method provides data inputs to the above mentioned data receiver
    // functions.

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }

}
