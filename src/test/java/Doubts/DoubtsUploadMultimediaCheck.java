package Doubts;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Doubts;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class DoubtsUploadMultimediaCheck extends Base {
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

    public void ValidateTest(WebElement webElement1, WebElement webElement2){
        if (webElement1.isDisplayed()) {
            System.out.println("Image is inserted successfully.");
        }
        else {
            System.out.println("Image is not inserted.");
        }
        if (webElement2.isDisplayed()) {
            System.out.println("Video is inserted successfully.");
        }
        else {
            System.out.println("Video is not inserted.");
        }

        if (webElement1.isDisplayed() && webElement2.isDisplayed()) {
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully upload multimedia content in his/her doubt.")
    @Story("DOUFS_05")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentdata")
    public void studentUploadMultimedia(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        dou.StudentImageClick().click();
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);

        dou.AskDoubtBtn().click();
        Thread.sleep(3000);

        dou.InsertImageOption().click();
        Thread.sleep(2000);

        dou.ImageByUrl().click();

        dou.imageUrlInput().click();
        dou.imageUrlInput().sendKeys("https://media.istockphoto.com/photos/sample-red-grunge-round-stamp-on-white-background-picture-id491520707");
        Thread.sleep(2000);

        dou.InsertBtn().click();
        Thread.sleep(5000);

        dou.UndoOption().click();
        dou.RedoOption().click();

        dou.InsertVideoOption().click();

        dou.VideoUrlInput().click();
        dou.VideoUrlInput().sendKeys("https://youtu.be/rUWxSEwctFU");
        Thread.sleep(5000);
        dou.InsertBtn().click();

        ValidateTest(dou.insertedImage(), dou.insertedVideo());

    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "studentdata")
    public Object[][] getstudentData() throws FileAlreadyExistsException {

        Object loginData[][] = {{"9000000001", "123456"}, {"9000000021", "123456"}, {"9000000041", "123456"},
                {"9000000061", "123456"}, {"9000000081", "123456"}};
//        Object loginData[][] = {{"9000000021", "123456"}};
        return loginData;
    }
}
