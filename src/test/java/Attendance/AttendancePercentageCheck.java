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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendancePercentageCheck extends Base {
    Map<String, Integer> NonWorkingDays  = new HashMap<String, Integer>() {{
        put("June 2022", 4);
        put("July 2022", 5);
        put("August 2022", 4);
        put("September 2022", 4);
        put("October 2022", 5);
        put("November 2022", 4);
        put("December 2022", 4);
        put("January 2023", 5);
        put("February 2023", 4);
        put("March 2023", 4);
        put("April 2023", 5);
        put("May 2023", 4);
    }};

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
    @Description("Examine whether or not the student can successfully the attendance percentage calculated monthly.")
    @Story("ATTFS_03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void studentPercentageCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        att.StudentImageClick().click();
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        int attendancePercentage = Integer.parseInt(att.AttendancePercentage().getText().split(" ")[1].split("%")[0]);

        int totalClassesHeld = Integer.parseInt(List.of(att.heldCountStudent().getText().split(" ")).get(2));
        int numberOfPresentDays = att.presentMarksStudent().size();
        System.out.println(numberOfPresentDays+" "+totalClassesHeld);
        ValidateTest((int)(((float)numberOfPresentDays/totalClassesHeld)*100), attendancePercentage);
//        ValidateTest(Math.round((float)numberOfPresentDays/totalWorkingDays), attendancePercentage);
    }

    private void ValidateTest(int calculated, int displayed) {
        System.out.println(calculated +" "+displayed);
        if(calculated == displayed){
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
    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }


}
