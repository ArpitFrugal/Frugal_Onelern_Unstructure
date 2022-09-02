package Doubts;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Doubts;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class TeacherDoubtReplyCheck extends Base {
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

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully reply to the doubt posted by the student. And also to check whether student can view reply to the doubt")
    @Story("DOU-01")
    @Test
    public void DoubtreplyCheck() throws IOException, InterruptedException {
        boolean flag1, flag2, flag3, flag4, flag5, flag6;
        String Student_mobile_number = "9000000001";
        String Teacher_mobile_number = "9000000101";
        String password = "123456";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement logoutelement;
        
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", Student_mobile_number, password);
        Thread.sleep(2000);
        dou.StudentImageClick().click();
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);

        // ask doubt
        dou.AskDoubtBtn().click();
        Thread.sleep(2000);

        String selectedSubject = null, selectedLesson = null;
        List<WebElement> doubtoptions = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div/div[1]//select"));

        for(WebElement webElement:doubtoptions){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
        }
        int i=0;
        for(WebElement webElement:doubtoptions){
            Select select = new Select(webElement);
            if(i==0){
                selectedSubject = select.getFirstSelectedOption().getText();
            }
            else if(i==1){
                selectedLesson = select.getFirstSelectedOption().getText();
            }
            i++;
            Thread.sleep(3000);
        }
        dou.QuestionTextBox().click();
        dou.QuestionTextBox().sendKeys("ABCD TEST");
        dou.SubmitBtn().click();

        Thread.sleep(5000);

        // -------------------------

        driver.navigate().to(prop.getProperty("website"));
        dou.HomepageMenuBtn().click();
        logoutelement = dou.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        Thread.sleep(2000);
        logoutelement.click();
        driver.navigate().refresh();
        dou.StudentAccount().click();
        dou.backBtnLoginPage().click();

        user.userLogin("teacher", Teacher_mobile_number, password);
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);
        // reply to doubt
        dou.firstDoubt().click();
        Thread.sleep(2000);


        // reply doubt
        int prevAnsweredCount = Integer.parseInt(dou.answered_count().getText().strip());
        dou.ReplyInputBox().click();
        dou.ReplyInputBox().sendKeys("OK");
        Thread.sleep(2000);

        dou.ReplySubmitBtn().click();
        Thread.sleep(2000);

        int CurrAnsweredCount = Integer.parseInt(dou.answered_count().getText());
        // validate answered count- curr == prev+1
        flag1 = CompareVal(CurrAnsweredCount, prevAnsweredCount + 1);

        driver.navigate().to(prop.getProperty("website"));
        dou.HomepageMenuBtn().click();
        logoutelement = dou.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        logoutelement.click();
        driver.navigate().refresh();
        dou.StudentAccount().click();

        dou.backBtnLoginPage().click();

        user.userLogin("student", Student_mobile_number, password);
        Thread.sleep(2000);
        dou.StudentImageClick().click();
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);
        dou.firstDoubt().click();
        Thread.sleep(2000);

        int StudentCheckAnsweredCount = Integer.parseInt(dou.answered_count().getText());
        // validate answered count  -     == 1
        flag2 = CompareVal(StudentCheckAnsweredCount, 1);
        dou.markThisAnswerBtn().click();
        Thread.sleep(2000);

        int number_of_greenchecks = dou.greenCheckMark().size();
        // validate green check count        == 3
        flag3 = CompareVal(number_of_greenchecks, 3);

        String bestanswerelement = dou.bestAnswerText().getText();
//        validate Best Answer     == Best Answer
        flag4 = CompareText(bestanswerelement, "Best Answer");

        int ResolvedTextCount = dou.resolvedText().size();
        // validate resolved text count     == 2
        flag5 = CompareVal(ResolvedTextCount, 2);

        // checking resolved text in teacher account
        driver.navigate().to(prop.getProperty("website"));
        dou.HomepageMenuBtn().click();
        logoutelement = dou.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        logoutelement.click();
        driver.navigate().refresh();
        dou.StudentAccount().click();

        dou.backBtnLoginPage().click();

        user.userLogin("teacher", Teacher_mobile_number, password);
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);

        String statusText = dou.statusText().getText();
//        validate statustext    == Resolved

        flag6 = CompareText(statusText, "Resolved");

        ValidateTest(flag1 && flag2 && flag3 && flag4 && flag5 && flag6);
    }

    public void ValidateTest(boolean flag) {
        if(flag){
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }

    public boolean CompareText(String actual_result, String expected_result) {
        return Objects.equals(actual_result, expected_result);
    }

    public boolean CompareVal(int actual_result, int expected_result) {
        return actual_result == expected_result;
    }


    @AfterMethod
    public void tearDown() { driver.quit(); }

}
