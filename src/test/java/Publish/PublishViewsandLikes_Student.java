package Publish;

import io.qameta.allure.*;
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

public class PublishViewsandLikes_Student extends Base {
    public Publish pub;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        pub = new Publish(driver);
        log = new LoginPage(driver);
    }

    public boolean ValidateTest(int ActualValue, int ExpectedValue) {
        System.out.println(ActualValue + " " + ExpectedValue);
        if(ActualValue == ExpectedValue){
            return true;
        }
        else{
            return false;
        }
    }
    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view and like the published content.")
    @Story("TPUBFS_03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData", priority = 2)
    public void studentPublishViewsandLikes(String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1, flag2;
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.StudentImageClick().click();
        Thread.sleep(2000);

        pub.PublishToggle().click();
        Thread.sleep(2000);

        String PrevViewCount = pub.OutsideViewCount().getText();
        Thread.sleep(2000);
        pub.ContentMetaData().click();
        Thread.sleep(2000);
        String CurrViewCount = pub.InsideViewCount().getText();
        Thread.sleep(2000);
        String PrevLikeCount = pub.LikeCount().getText();
        Thread.sleep(2000);
        flag1 = ValidateTest(Integer.parseInt(CurrViewCount), Integer.parseInt(PrevViewCount) +1);
        Thread.sleep(2000);
        WebElement yesbtn = pub.LikeBtn();
        WebElement nobtn = pub.DisLikeBtn();

        System.out.println(yesbtn.getAttribute("class"));
        if(yesbtn.getAttribute("class").contains("likes")){
            nobtn.click();
            Thread.sleep(2000);
            String CurrLikeCount = pub.LikeCount().getText();
            Thread.sleep(2000);
            flag2 = ValidateTest(Integer.parseInt(CurrLikeCount), Integer.parseInt(PrevLikeCount)-1);
        }
        else{
            yesbtn.click();
            Thread.sleep(2000);
            String CurrLikeCount = pub.LikeCount().getText();
            Thread.sleep(2000);
            flag2 = ValidateTest(Integer.parseInt(CurrLikeCount), Integer.parseInt(PrevLikeCount)+1);
        }

        if (flag1 && flag2){
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
    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }


}
