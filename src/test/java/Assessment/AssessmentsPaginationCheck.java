package Assessment;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Assessment;
import pageObjects.Assignments;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class AssessmentsPaginationCheck extends Base {
    public Assessment ass;
    public LoginPage log;
    public WebDriver driver;

    List<String> list = List.of("1 - 10", "11 - 20", "21 - 30", "31 - 40", "41 - 50", "51 - 60", "61 - 70", "71 - 80", "81 - 90", "91 - 100", "101 - 120");

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ass = new Assessment(driver);
        log = new LoginPage(driver);
    }

    public boolean CheckEnabled(WebElement nextNavigate) {
        return !nextNavigate.getAttribute("class").contains("disabled");
    }

    public boolean ValidateTest(String Actual_Text, String Expected_Text) {
        System.out.println(Actual_Text + " "+ Expected_Text);
        return Actual_Text.contains(Expected_Text);
    }

    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or noti the student can navigate to other pages through pagination.")
    @Story("ASSFS_07")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        ass.StudentImageClick().click();
        ass.AssessmentToggle().click();

        boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;
        String CurrPaginationText;
        int i=0;
        // one click forward
        if(CheckEnabled(ass.NextNavigate())){
            ass.NextNavigate().click(); Thread.sleep(2000);
            i+=1;
            CurrPaginationText = ass.PaginationText().getText(); Thread.sleep(2000);
            flag1= ValidateTest(CurrPaginationText, list.get(i)); Thread.sleep(2000);
        }

        // two clicks forward
        if(CheckEnabled(ass.NextNavigate())) {
            ass.NextNavigate().click(); Thread.sleep(2000);
            i+=1;
            if(CheckEnabled(ass.NextNavigate())){
                ass.NextNavigate().click(); Thread.sleep(2000);
                i+=1;
            }
            CurrPaginationText = ass.PaginationText().getText(); Thread.sleep(2000);
            flag2= ValidateTest(CurrPaginationText, list.get(i)); Thread.sleep(2000);
        }



        // one click back
        if(CheckEnabled(ass.BackNavigate())){
            ass.BackNavigate().click(); Thread.sleep(2000);
            i-=1;
            CurrPaginationText = ass.PaginationText().getText();
            flag3= ValidateTest(CurrPaginationText, list.get(i));
        }

        // two click back
        if(CheckEnabled(ass.BackNavigate())){
            ass.BackNavigate().click(); Thread.sleep(2000);
            i-=1;
            if(CheckEnabled(ass.BackNavigate())){
                ass.BackNavigate().click(); Thread.sleep(2000);
                i-=1;
            }
            CurrPaginationText = ass.PaginationText().getText();
            flag4= ValidateTest(CurrPaginationText, list.get(i));
        }


        if(flag1 && flag2 && flag3 && flag4){
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

    // This method provides data inputs to the above mentioned data receiver
    // functions.

    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }
}
