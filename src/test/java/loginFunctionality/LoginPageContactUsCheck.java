package loginFunctionality;

import executions.LoginMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resources.Base;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class LoginPageContactUsCheck extends Base {
    public LoginPage log;
    public WebDriver driver;
    public LoginMethods logmethods;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        this.log = new LoginPage(driver);
        logmethods = new LoginMethods();
    }


    @Epic("Login functionality of the onelern_school project.")
    @Description("Check whether anyone can click on contact us link and view the contact details.")
    @Story("LIB_01")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "testData")
    public void StudentSearchCheck(String stakeholder) throws IOException, InterruptedException {
        if(stakeholder.contains("Teacher")){
            log.getTeacherSignIn().click();
            log.getUserName().sendKeys("9000000001");
            log.getSubmitButton().click();
            Thread.sleep(3000);
            log.getloginWithPassword().click();

            log.ContactUsBtn().click();
            ValidateTest(log.ContactUsModalHeader().getText(), "Contact Us");

        }
        else{
            log.getStudentSignIn().click();
            log.getUserName().sendKeys("9000000101");
            log.getSubmitButton().click();
            Thread.sleep(3000);
            log.getloginWithPassword().click();

            log.ContactUsBtn().click();
            ValidateTest(log.ContactUsModalHeader().getText(), "Contact Us");
        }
    }

    private void ValidateTest(String contactUsModalHeader, String contact_us) {
        if(contactUsModalHeader.contains(contact_us)){
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "testData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = {{"Teacher"}, {"Student"}};
        return loginData;
    }

}
