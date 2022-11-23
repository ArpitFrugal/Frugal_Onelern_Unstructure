package TimeTable;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Attendance;
import pageObjects.LoginPage;
import pageObjects.TimeTable;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class TimetablePaginationCheck extends Base {
    List<String> months = List.of("JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
            "NOVEMBER", "DECEMBER", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY");


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
    private void ValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1 +" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }
    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the student can navigate to next pages through pagination.")
    @Story("TIMFS_02")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void studentPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        tim.StudentImageClick().click();
        Thread.sleep(2000);
        tim.studentTimeTableToggle().click();
        Thread.sleep(2000);

        String CurrMonthDisplayed = tim.DisplayedMonth().getText();
        int monthIndex = 0, i = 0;

        for(String st:months){
            if(CurrMonthDisplayed.contains(st)){
                monthIndex = i;
                break;
            }
            i+=1;
        }
        System.out.println(monthIndex);
        boolean flag1, flag2, flag3;
        tim.leftNavigationBtn().click();
        flag1= ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-1));

        tim.leftNavigationBtn().click();
        flag2= ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-2));

        tim.rightNavigationBtn().click();
        flag3 = ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-1));

        ValidateTest(flag1, flag2, flag3);
    }



    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the teacher can navigate to next pages through pagination.")
    @Story("TIMFT_02")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
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

        String CurrMonthDisplayed = tim.DisplayedMonth().getText();
        int monthIndex = 0, i = 0;

        for(String st:months){
            if(CurrMonthDisplayed.contains(st)){
                monthIndex = i;
                break;
            }
            i+=1;
        }
        System.out.println(monthIndex);
        boolean flag1, flag2, flag3;
        tim.leftNavigationBtn().click();
        flag1= ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-1));

        tim.leftNavigationBtn().click();
        flag2= ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-2));

        tim.rightNavigationBtn().click();
        flag3 = ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-1));

        ValidateTest(flag1, flag2, flag3);
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
