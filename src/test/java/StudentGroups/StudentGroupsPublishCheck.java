package StudentGroups;

import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import java.util.List;

public class StudentGroupsPublishCheck extends Base {
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

    public void ValidateTest(String GroupName){
        System.out.println(GroupName);
        if (GroupName.contains("New Group")) {
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Student Groups module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully Search the added group.")
    @Story("SGFT-06")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void PublishStudentGroupsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        sg.rightswipemodules().click();
        sg.StudentGroupsToggle().click();
        Thread.sleep(10000);

        sg.AddGroupBtn().click();
        Thread.sleep(1000);

        sg.GroupNameInput().click();
        sg.GroupNameInput().sendKeys("New Group");

        sg.AddStudentsBtn().click();
        Thread.sleep(3000);
        sg.SelectAllStudents().click();

        sg.SelectAllStudentsSubmit().click();
        sg.SaveGroup().click();

        // -----------------------------------------
        driver.navigate().to(prop.getProperty("website")+"teacher");
        sg.PublishToggle().click();

        Thread.sleep(5000);
        sg.PublishNewContentBtn().click();
        Thread.sleep(5000);

        List<WebElement> ContentOptions = sg.ContentOptions();
        int i=0;
        for(WebElement webElement:ContentOptions){
            if(i==0 || i==3 || i==4){
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            else{
                webElement.sendKeys(Keys.ENTER);
            }
            i+=1;
            Thread.sleep(2000);
        }

        Thread.sleep(3000);

        sg.PublishContentDescriptionTextArea().click();
        sg.PublishContentDescriptionTextArea().sendKeys("Description");
        Thread.sleep(3000);
        sg.NextStepBtn().click();
        Thread.sleep(3000);

        sg.PublishToGroup().click();
        Select grades = new Select(sg.GroupDropDown());

        grades.selectByValue("New Group");
        Thread.sleep(3000);
        String groupName = grades.getFirstSelectedOption().getText();
        Thread.sleep(1000);
        ValidateTest(groupName);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above-mentioned data receiver
    // functions.
    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = {{"9000000101", "123456"}, {"9000000105", "123456"}, {"9000000109", "123456"},
                {"9000000113", "123456"}, {"9000000117", "123456"}};
//        Object loginData[][] = {{"9000000101", "123456"}};
        return loginData;
    }
}
