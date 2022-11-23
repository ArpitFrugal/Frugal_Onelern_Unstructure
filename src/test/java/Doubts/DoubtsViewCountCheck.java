package Doubts;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Doubts;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class DoubtsViewCountCheck extends Base {
    public Doubts dou;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        dou = new Doubts(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(int actualresult, int expectedresult){
        System.out.println(actualresult+" "+expectedresult);
        if(actualresult == expectedresult){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the increase in view count when viewed.")
    @Story("DOUFS_03")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "studentData")
    public void studentViewCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        dou.StudentImageClick().click();
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);
        int numberOfDoubts = dou.DoubtsCards().size();
        if(numberOfDoubts > 0){
            int prevCount = Integer.parseInt(dou.ViewCount().getText());
            dou.FirstDoubt().click();
            Thread.sleep(2000);

            int currCount = Integer.parseInt(dou.ViewCount().getText());

            ValidateTest(currCount, prevCount+1);
        }
        else{
            ValidateTest(-1, -1);
        }

    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the increase in view count when viewed.")
    @Story("DOUFT-02")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "teacherData")
    public void teacherViewCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);
        int numberOfDoubts = dou.DoubtsCards().size();
        if(numberOfDoubts > 0){
            int prevCount = Integer.parseInt(dou.ViewCount().getText());
            dou.FirstDoubt().click();
            Thread.sleep(2000);

            int currCount = Integer.parseInt(dou.ViewCount().getText());

            ValidateTest(currCount, prevCount+1);
        }
        else{
            ValidateTest(-1, -1);
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
