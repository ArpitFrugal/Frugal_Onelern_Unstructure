package Parent;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import pageObjects.Parent;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class StudentViewProfileCheck extends Base {
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
    @Story("PAR_01")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData")
    public void ParentStudentViewProfileCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);

        par.ParentImageClick().click();
        Thread.sleep(5000);

        String StudentName = par.DisplayedAccountName().getText();

        par.ViewProfileButton().click();

        String StudentNameInside = par.DisplayedAccountName().getText();

        ValidateTest(StudentName, StudentNameInside);
    }

    private void ValidateTest(String studentName, String studentNameInside) {
        if(studentName.contains(studentNameInside)){
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
