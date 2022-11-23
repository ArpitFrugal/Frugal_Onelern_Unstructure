package Assignments;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Assignments;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class StartAssignment extends Base {
    public Assignments asg;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        asg = new Assignments(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(boolean flag1, boolean flag2){
        System.out.println(flag1+" "+flag2);
        if (flag1 && flag2) {
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the assignments module.")
    @Story("ASGFS_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentStartAssignment(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        asg.StudentImageClick().click();
        asg.AssignmentsToggle().click();

        asg.FirstAssignment().click();

        asg.startAssignment().click();
        Thread.sleep(2000);
        asg.AttachFileInputBox().click();
        asg.AttachFileInputBox().sendKeys("www.sample.com");

        asg.AssignmentAnswerInputBox().click();
        Thread.sleep(2000);
        asg.AssignmentAnswerInputBox().sendKeys("Answer");
        Thread.sleep(2000);

        asg.submitAssignment().click();

        asg.GoToDashboardBtn().click();
        Thread.sleep(2000);

        asg.FirstAssignment().click();
        Thread.sleep(2000);
        String contentDisplayed = asg.mainContent().getText();

        System.out.println(contentDisplayed);
        boolean flag1 = contentDisplayed.contains("sample.com");
        boolean flag2 = contentDisplayed.contains("Answer");

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
}
