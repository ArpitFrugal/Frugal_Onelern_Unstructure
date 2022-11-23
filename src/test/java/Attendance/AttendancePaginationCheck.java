package Attendance;

import io.qameta.allure.*;
import org.openqa.selenium.By;
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
import java.util.List;

public class AttendancePaginationCheck extends Base {
    List<String> months = List.of("June 2022", "July 2022", "August 2022", "September 2022", "October 2022",
            "November 2022", "December 2022", "January 2023", "February 2023", "March 2023", "April 2023", "May 2023");


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

    public boolean ValidateMonth(String actual_month, String expected_month){
        System.out.println(actual_month+" "+expected_month);
        if (actual_month.contains(expected_month)) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }
    private void ValidateTest(boolean flag) {
        if(flag){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }
    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the student can navigate to next pages through pagination.")
    @Story("ATTFS_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void studentPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        att.StudentImageClick().click();
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        String CurrMonthDisplayed = att.DisplayedMonthStudent().getText();
        int monthindex = months.indexOf(CurrMonthDisplayed);

        boolean flag1, flag2, flag3;
        att.PaginationLeftBtn().click();
        flag1= ValidateMonth(att.DisplayedMonthStudent().getText(), months.get(monthindex-1));

        att.PaginationLeftBtn().click();
        flag2= ValidateMonth(att.DisplayedMonthStudent().getText(), months.get(monthindex-2));

        att.PaginationRightBtn().click();
        flag3 = ValidateMonth(att.DisplayedMonthStudent().getText(), months.get(monthindex-1));

        ValidateTest(flag1 && flag2 && flag3);
    }



    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the teacher can navigate to next pages through pagination.")
    @Story("ATTFT_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        String CurrMonthDisplayed = att.DisplayedMonthTeacher().getAttribute("value");
        int monthindex = months.indexOf(CurrMonthDisplayed);
        boolean flag1, flag2, flag3;
        att.PaginationLeftBtn().click();
        flag1= ValidateMonth(att.DisplayedMonthTeacher().getAttribute("value"), months.get(monthindex-1));
        Thread.sleep(5000);
        att.PaginationLeftBtn().click();
        flag2= ValidateMonth(att.DisplayedMonthTeacher().getAttribute("value"), months.get(monthindex-2));
        Thread.sleep(5000);
        att.PaginationRightBtn().click();
        flag3 = ValidateMonth(att.DisplayedMonthTeacher().getAttribute("value"), months.get(monthindex-1));

        ValidateTest(flag1 && flag2 && flag3);
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
