package Notebook;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class NotebookLandingPageCheck extends Base {
    public Notebook note;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        note = new Notebook(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(String actual_header){
        if (actual_header.equals("Notebook")) {
            System.out.println("Notebook Module is active");
        }
        else {
            Assert.fail();
        }
    }
    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("Examine whether or noti the student can successfully get inside the notebook module.")
    @Story("NOTFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        note.StudentImageClick().click();
        Thread.sleep(2000);
        note.NotebookToggle().click();
        Thread.sleep(2000);

        String actual_header = note.GetHeader();
        ValidateTest(actual_header);
    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("Examine whether or noti the teacher can successfully get inside the Notebook module.")
    @Story("NOTFT-01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        note.NotebookToggle().click();
        Thread.sleep(2000);

        String actual_header = note.GetHeader();
        ValidateTest(actual_header);
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
