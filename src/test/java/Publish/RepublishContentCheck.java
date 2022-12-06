package Publish;

import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepublishContentCheck extends Base {
    public Publish pub;
    public LoginPage log;
    public WebDriver driver;
    Map<String, String> map = new HashMap<>();


    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        pub = new Publish(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(String actual_text, String expected_text) {
        System.out.println(actual_text+" "+expected_text);
        if(actual_text.contains(expected_text)){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully republished the content.")
    @Story("PUBFT_05")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void RepublishContentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(2000);

        pub.FirstContentMoreOptions().click();
        pub.RepublishBtn().click();

        List<WebElement> GradeSectionInput = pub.PublishGradeSectionInput();
        for(WebElement webElement : GradeSectionInput){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
        }
        Thread.sleep(3000);
        pub.FinalPublishBtn().click();
        Thread.sleep(5000);
        pub.BackAfterPublish().click();

        String actual_time = pub.FirstContentTime().getText();
        String expected_time = "seconds";
        ValidateTest(actual_time, expected_time);

    }




    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
