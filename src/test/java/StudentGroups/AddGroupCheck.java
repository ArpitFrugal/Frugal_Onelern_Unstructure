package StudentGroups;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.StudentGroups;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AddGroupCheck extends Base {
    public StudentGroups sg;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        sg = new StudentGroups(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(String actual_header){
        System.out.println(actual_header);
        if (actual_header.contains("New Group")) {
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Student Groups module of the onelern_school project.")
    @Description("Examine whether or noti the teacher can successfully add a group of many students.")
    @Story("SGFT-03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void TeacherAddGroupCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        sg.rightswipemodules().click();
        sg.StudentGroupsToggle().click();
        Thread.sleep(2000);
        sg.AddGroupBtn().click();
        Thread.sleep(1000);

        sg.GroupNameInput().click();
        sg.GroupNameInput().sendKeys("New Group");

        sg.AddStudentsBtn().click();
        Thread.sleep(3000);
        sg.SelectAllStudents().click();

        sg.SelectAllStudentsSubmit().click();
        sg.SaveGroup().click();

        String CreatedGroup = sg.GroupCards().get(0).getText();
        ValidateTest(CreatedGroup);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
