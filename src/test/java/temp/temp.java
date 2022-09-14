package temp;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import resources.Base;
import testResource.BaseLogin;
import testResource.Listners;
import testResource.ReadExcelFile;
import utility.ExcelUtils;

import java.io.File;
import java.io.IOException;

@Listeners(Listners.class)
public class temp extends Base {

    public Notebook note;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        note = new Notebook(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(String actual_header){
        if (actual_header.equals("Notebook")) {
            System.out.println("Notebook Module is active");
        }
        else {
            Assert.fail();
        }
    }
    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Test(dataProvider = "data")
    public void temp(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        note.StudentImageClick().click();
        Thread.sleep(2000);
        note.NotebookToggle().click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        note.EnvironmentalCoursebookGrade1().click();
        note.SecondLesson().click();
        Thread.sleep(10000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(10000);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "data")
    public Object[][] getData() throws Exception {
//        Object[][] loginData = ReadExcelFile.TestcasesCredentials("student");
//        Object[][] loginData = ExcelUtils.getTableArray(System.getProperty("user.dir") + "\\data\\UserSignInFunctionality.xlsx", "Student Credentials");
        Object[][] loginData ={{"9000000001","123456"}};
        return loginData;
    }
}
