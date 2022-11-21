package Doubts;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Doubts;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class DoubtsFilterFunctionality extends Base {
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

    public boolean textCheck(String actual_text, String expected_text){
        if(expected_text.contains("Environmental")){
            return actual_text.contains("EVS") || actual_text.contains(expected_text);
        }
        return actual_text.contains(expected_text);
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully filter the content by applying specific filters.")
    @Story("DOUFS_06")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentdata")
    public void studentFilterFunctionalityCheck(String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1 = false, flag2 = false, flag3 = false;
        int no_of_doubts;
        String selectedFilterSubject;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        dou.StudentImageClick().click();
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);

//        dou.FilterSubjectSelectAll_Student().click();
        Thread.sleep(2000);

        dou.FilterSubjectFirstSubject_Student().click();
        Thread.sleep(2000);

        selectedFilterSubject = dou.FilterSubjectFirstSubject_Student().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag1 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag1){
                break;
            }
        }
        dou.FilterSubjectFirstSubject_Student().click();
        Thread.sleep(2000);

        dou.FilterSubjectSecondSubject_Student().click();
        Thread.sleep(2000);

        selectedFilterSubject = dou.FilterSubjectSecondSubject_Student().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag2 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag2){
                break;
            }
        }
        dou.FilterSubjectSecondSubject_Student().click();
        Thread.sleep(2000);

        dou.FilterSubjectThirdSubject_Student().click();
        Thread.sleep(2000);

        selectedFilterSubject = dou.FilterSubjectThirdSubject_Student().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            if(webElement.getText().contains("Environmental") || webElement.getText().contains("EVS")){
                flag3 = textCheck(webElement.getText(), selectedFilterSubject) || textCheck(webElement.getText(), "EVS");
                if(!flag3){
                    break;
                }
            }
            else{
                flag3 = textCheck(webElement.getText(), selectedFilterSubject);
                if(!flag3){
                    break;
                }
            }
        }
        dou.FilterSubjectThirdSubject_Student().click();
        Thread.sleep(2000);
        
        ValidateTest(flag1, flag2, flag3);
    }

    public void ValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1 +" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully filter the content by applying specific filters.")
    @Story("DOUFT-04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherdata")
    public void teacherFilterFunctionalityCheck(String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1 = false, flag2 = false, flag3 = false;
        int no_of_doubts;
        String selectedFilterSubject;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);


        dou.FilterSubjectFirstSubject_Teacher().click();
        Thread.sleep(1000);
        dou.FilterSubjectSecondSubject_Teacher().click();
        Thread.sleep(1000);
        dou.FilterSubjectThirdSubject_Teacher().click();
        Thread.sleep(1000);

        dou.FilterSubjectFirstSubject_Teacher().click();
        Thread.sleep(5000);

        selectedFilterSubject = dou.FilterSubjectFirstSubject_Teacher().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag1 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag1){
                break;
            }
        }

        dou.FilterSubjectSecondSubject_Teacher().click();
        Thread.sleep(2000);

        dou.FilterSubjectFirstSubject_Teacher().click();
        Thread.sleep(2000);


//        dou.FilterSubjectSecondSubject_Teacher().click();
//        Thread.sleep(5000);

        selectedFilterSubject = dou.FilterSubjectSecondSubject_Teacher().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag2 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag2){
                System.out.println(webElement.getText()+" "+selectedFilterSubject);
                break;
            }
        }

        dou.FilterSubjectThirdSubject_Teacher().click();
        Thread.sleep(2000);

        dou.FilterSubjectSecondSubject_Teacher().click();
        Thread.sleep(2000);


//        dou.FilterSubjectThirdSubject_Teacher().click();
//        Thread.sleep(5000);

        selectedFilterSubject = dou.FilterSubjectThirdSubject_Teacher().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag3 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag3){
                System.out.println(webElement.getText()+" "+selectedFilterSubject);
                break;
            }
        }

        dou.FilterSubjectThirdSubject_Teacher().click();
        Thread.sleep(2000);

        ValidateTest(flag1, flag2, flag3);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.
    @DataProvider(name = "studentdata")
    public Object[][] getstudentData() throws FileAlreadyExistsException {

        Object loginData[][] = {{"9000000001", "123456"}, {"9000000024", "123456"}, {"9000000046", "123456"},
                {"9000000069", "123456"}, {"9000000081", "123456"}};
//        Object loginData[][] = {{"9000000001", "123456"}};
        return loginData;
    }

    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = {{"9000000101", "123456"}, {"9000000105", "123456"}, {"9000000109", "123456"},
                {"9000000113", "123456"}, {"9000000117", "123456"}};
//        Object loginData[][] = {{"9000000101", "123456"}};
        return loginData;
    }
}
