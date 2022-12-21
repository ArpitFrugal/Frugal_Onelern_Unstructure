package Parent;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Parent;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class StudentAttendanceCheck extends Base {
    public Parent par;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        par = new Parent(driver);
        log = new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Epic("This story represents the parent module of the onelern_school project.")
    @Description("Parent can view Complete his/her 's student profile.")
    @Story("PAR_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData")
    public void ParentStudentAttendanceCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        par.StudentImageClick().click();
        Thread.sleep(2000);
        par.AttendanceToggle().click();
        Thread.sleep(2000);

        int attendancePercentage = Integer.parseInt(par.AttendancePercentage().getText().split(" ")[1].split("%")[0]);

        par.BackBtn().click();

        par.HomepageMenuBtn().click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement SwitchParent = par.SwitchParent();
        js.executeScript("arguments[0].scrollIntoView();", SwitchParent);
        Thread.sleep(2000);
        SwitchParent.click();

        System.out.println(par.ParentPercentageDisplayed().getText());
        int parentAttendancePercentage = Integer.parseInt(par.ParentPercentageDisplayed().getText().split(" ")[0].split("%")[0]);

        ValidateTest(attendancePercentage, parentAttendancePercentage);
    }

    private void ValidateTest(int attendancePercentage, int parentAttendancePercentage) {
        if(attendancePercentage == parentAttendancePercentage){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }
}
