package Publish;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Publish;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class PublishLandingPage extends Base {
    public Publish pub;
    public LoginPage log;
    public WebDriver driver;


    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        pub = new Publish(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(String actual_header, String expected_header ){
        System.out.println(actual_header + " "+ expected_header);
        if (actual_header.equals(expected_header)) {
            System.out.println("Publish Module is active");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the publish module.")
    @Story("TPUBFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.StudentImageClick().click();
        Thread.sleep(2000);

        pub.PublishToggle().click();
        Thread.sleep(2000);

        String actual_header = pub.PublishGetHeader();
        String expected_header = "Teacher Published Content";
        ValidateTest(actual_header, expected_header);
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Publish module.")
    @Story("PUBFT-01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(2000);

        String actual_header = pub.PublishGetHeader();
        String expected_header = "Publish Content";
        ValidateTest(actual_header, expected_header);
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

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
