package StudentGroups;

import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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

public class EditGroupCheck extends Base {
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

    public void ValidateTest(int size, String actual_header){
        System.out.println(size+" "+actual_header);
        if (size>0 && actual_header.contains("Edit Group")) {
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Student Groups module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully edit the added group.")
    @Story("SGFT-04")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void TeacherEditGroupCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        sg.rightswipemodules().click();
        sg.StudentGroupsToggle().click();
        Thread.sleep(1000);

        Actions action = new Actions(driver);
        sg.SearchInputBox().click();
        sg.SearchInputBox().sendKeys("New Group");

        sg.MoreOptionsBtn().click();
        sg.EditOption().click();

        String Header = sg.GetHeader().getText();

        sg.GroupNameInput().click();
        action.sendKeys(Keys.CONTROL).clickAndHold().sendKeys("A").build().perform();

        sg.GroupNameInput().sendKeys("Edited Group");
        sg.UpdateGroupNameSubmit().click();

        sg.SearchInputBox().click();
        sg.SearchInputBox().sendKeys("Edited Group");

        ValidateTest(sg.GroupCards().size(), Header);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = {{"9000000101", "123456"}, {"9000000105", "123456"}, {"9000000109", "123456"},
                {"9000000113", "123456"}, {"9000000117", "123456"}};
//        Object loginData[][] = {{"9000000101", "123456"}};
        return loginData;
    }
}
