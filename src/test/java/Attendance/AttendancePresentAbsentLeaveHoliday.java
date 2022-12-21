package Attendance;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import java.util.Arrays;

public class AttendancePresentAbsentLeaveHoliday extends Base {
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

    public void ValidateTest(boolean flag){
        if (flag) {
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }
    public boolean valCompare(int presentCount, int daysPresent) {
        System.out.println(presentCount+" "+daysPresent);
        return presentCount == daysPresent;
    }

    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or noti the student can view the count of present, absent, leave, and holiday correctly.")
    @Story("ATTFS_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData")
    public void studentPALHCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1, flag2, flag3, flag4;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        att.StudentImageClick().click();
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        String presentcounttext = att.presentCountStudent().getText();
        String absentcounttext = att.absentCountStudent().getText();;
        String leavecounttext = att.leaveCountStudent().getText();
        String holidaycounttext = att.holidayCountStudent().getText();

        int presentCount = Integer.parseInt(presentcounttext.split(" ")[1]);
        int absentCount = Integer.parseInt(absentcounttext.split(" ")[1]);
        int leaveCount = Integer.parseInt(leavecounttext.split(" ")[1]);
        int holidayCount = Integer.parseInt(holidaycounttext.split(" ")[1]);

        int dayspresent = att.presentMarksStudent().size();
        int daysabsent = att.absentMarksStudent().size();
        int daysleave = att.leaveMarksStudent().size();
        int daysholiday = att.holidayMarksStudent().size();

        flag1 = valCompare(presentCount, dayspresent);
        flag2 = valCompare(absentCount, daysabsent);
        flag3 = valCompare(leaveCount, daysleave);
        flag4 = valCompare(holidayCount, daysholiday);

        System.out.println(flag1+" "+flag2+" "+flag3+" "+flag4);

        ValidateTest(flag1 && flag2 && flag3 && flag4);
    }



    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or noti the teacher can view the count of present, absent, and leave correctly.")
    @Story("ATTFT_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void teacherPALCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(!att.editAttendanceBtn().isEnabled()){
            ValidateTest(true);
        }
        else {
            boolean markedForToday = att.notMarkedTeacher().size() >0;
            if(!markedForToday){
                driver.findElement(By.xpath("//*[contains(@class,'active')]")).click();
                Thread.sleep(2000);
                int totalcount = Integer.parseInt(att.totalCountTeacher().getText().split(" ")[2]);
                int presentcount = Integer.parseInt(att.presentCountTeacher().getText().split(" ")[1]);
                int absentcount = Integer.parseInt(att.absentCountTeacher().getText().split(" ")[1]);
                int leavecount = Integer.parseInt(att.leaveCountTeacher().getText().split(" ")[1]);

                System.out.println(totalcount +" "+presentcount+" "+absentcount+" "+leavecount);
                ValidateTest(totalcount == presentcount+absentcount+leavecount);

            }
            else{
                att.editAttendanceBtn().click();
                driver.findElement(By.xpath("//*[contains(@class,'present-mark-box')]")).click();
                WebElement element = att.attendancemarkoption();
                js.executeScript("arguments[0].scrollIntoView();", element);

                element.click();
                Thread.sleep(2000);
                att.absentmarkoption().click();
                Thread.sleep(2000);

                att.attendancemarkoption().click();
                Thread.sleep(2000);
                att.leavemarkoption().click();
                Thread.sleep(2000);

                att.saveBtn().click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[contains(@class,'active')]/*[contains(@class,'week-day')]")).click();
                Thread.sleep(2000);

                System.out.println(Arrays.toString(att.presentCountTeacher().getText().split(" ")));
                int totalcount = Integer.parseInt(att.totalCountTeacher().getText().split(" ")[2]);
                int presentcount = Integer.parseInt(att.presentCountTeacher().getText().split(" ")[1]);
                int absentcount = Integer.parseInt(att.absentCountTeacher().getText().split(" ")[1]);
                int leavecount = Integer.parseInt(att.leaveCountTeacher().getText().split(" ")[1]);

                System.out.println(totalcount+" "+presentcount+" "+absentcount+" "+leavecount);
                ValidateTest(totalcount == presentcount+absentcount+leavecount);
            }
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

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }

}
