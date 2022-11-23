package Publish;

import io.qameta.allure.*;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
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

public class PublishPagination extends Base {
    public Publish pub;
    public LoginPage log;
    public WebDriver driver;
    List<String> list = List.of("1 - 10", "11 - 20", "21 - 30", "31 - 40", "41 - 50", "51 - 60", "61 - 70", "71 - 80", "81 - 90", "91 - 100", "101 - 120");


    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        pub = new Publish(driver);
        log = new LoginPage(driver);
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully navigate to next pages.")
    @Story("TPUBFS_04")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "studentData")
    public void studentPublishPagination(String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;
        String CurrPaginationText;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.StudentImageClick().click();
        Thread.sleep(2000);

        pub.PublishToggle().click();
        Thread.sleep(10000);

        int i=0;
        // one click forward
        if(CheckEnabled(pub.StudentNextNavigate())){
            pub.StudentNextNavigate().click(); Thread.sleep(2000);
            i+=1;
            CurrPaginationText = pub.PaginationText().getText(); Thread.sleep(2000);
            flag1= ValidateTest(CurrPaginationText, list.get(i)); Thread.sleep(2000);
        }

        // two clicks forward
        if(CheckEnabled(pub.StudentNextNavigate())) {
            pub.StudentNextNavigate().click(); Thread.sleep(2000);
            i+=1;
            if(CheckEnabled(pub.StudentNextNavigate())){
                pub.StudentNextNavigate().click();
                i+=1;
            }
            Thread.sleep(2000);
            CurrPaginationText = pub.PaginationText().getText(); Thread.sleep(2000);
            flag2= ValidateTest(CurrPaginationText, list.get(i)); Thread.sleep(2000);
        }



        // one click back
        if(CheckEnabled(pub.StudentBackNavigate())){
            pub.StudentBackNavigate().click(); Thread.sleep(2000);
            i-=1;
            CurrPaginationText = pub.PaginationText().getText();
            flag3= ValidateTest(CurrPaginationText, list.get(i));
        }

        // two click back
        if(CheckEnabled(pub.StudentBackNavigate())){
            pub.StudentBackNavigate().click(); Thread.sleep(2000);
            i-=1;
            if(CheckEnabled(pub.StudentBackNavigate())){
                pub.StudentBackNavigate().click(); Thread.sleep(2000);
                i-=1;
            }
            CurrPaginationText = pub.PaginationText().getText();
            flag4= ValidateTest(CurrPaginationText, list.get(i));
        }


        if(flag1 && flag2 && flag3 && flag4){
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully navigate to next pages.")
    @Story("PUBFT-04")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "teacherData")
    public void teacherPublishPagination(String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;
        String CurrPaginationText;

        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(10000);

        int i=0; 
        // one click forward
        if(CheckEnabled(pub.NextNavigate())){
            pub.NextNavigate().click(); Thread.sleep(2000);
            i+=1;
            CurrPaginationText = pub.PaginationText().getText(); Thread.sleep(2000);
            flag1= ValidateTest(CurrPaginationText, list.get(i)); Thread.sleep(2000);
        }

        // two clicks forward
        if(CheckEnabled(pub.NextNavigate())) {
            pub.NextNavigate().click(); Thread.sleep(2000);
            i+=1;
            if(CheckEnabled(pub.NextNavigate())){
                pub.NextNavigate().click(); Thread.sleep(2000);
                i+=1;
            }            
            CurrPaginationText = pub.PaginationText().getText(); Thread.sleep(2000);
            flag2= ValidateTest(CurrPaginationText, list.get(i)); Thread.sleep(2000);
        }
        
        

        // one click back
        if(CheckEnabled(pub.BackNavigate())){
            pub.BackNavigate().click(); Thread.sleep(2000);
            i-=1;
            CurrPaginationText = pub.PaginationText().getText();
            flag3= ValidateTest(CurrPaginationText, list.get(i));
        }
        
        // two click back
        if(CheckEnabled(pub.BackNavigate())){
            pub.BackNavigate().click(); Thread.sleep(2000);
            i-=1;
            if(CheckEnabled(pub.BackNavigate())){
                pub.BackNavigate().click(); Thread.sleep(2000);
                i-=1;
            }            
            CurrPaginationText = pub.PaginationText().getText();
            flag4= ValidateTest(CurrPaginationText, list.get(i));
        }
        

        if(flag1 && flag2 && flag3 && flag4){
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    public boolean CheckEnabled(WebElement nextNavigate) {
        return !nextNavigate.getAttribute("class").contains("disabled");
    }

    public boolean ValidateTest(String Actual_Text, String Expected_Text) {
        System.out.println(Actual_Text + " "+ Expected_Text);
        return Actual_Text.contains(Expected_Text);
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

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
