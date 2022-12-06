package Analytics;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Analytics;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsEoSQLessonsTopicCheck extends Base {
    public Analytics ana;
    public LoginPage log;
    public WebDriver driver;
    //Creating a List
    List<String> grade = new ArrayList<>();

    String[] grades = {"Grade 1", "Grade 2", "Grade 3", "Grade 4", "Grade 5"};

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ana = new Analytics(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(boolean flag){
        if(flag){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to view the lessons and can open them to view detailed scores.")
    @Story("ANAFT_10")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void EoSQLessonTopicsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();

        ana.ViewWEoSQ().click();

        int i=0, j=0;
        boolean flag = true;
        for(i=0;i<ana.LessonTopics().size();i++){
            List<WebElement> LessonTopics = ana.LessonTopics();
            Thread.sleep(2000);
            int percentage = (int)Math.ceil(Double.parseDouble(List.of(ana.TopicsPercentage().get(i).getText().split(" ")).get(0)));
            if(percentage == 0){
                String classname =  LessonTopics.get(i).getAttribute("class");
                String tobepresent = "pointer-events-none";
                flag = classname.contains(tobepresent);
            }
            if(percentage != 0){
//                System.out.println(1);
                String prevUrl = driver.getCurrentUrl();
                LessonTopics.get(i).click();
                Thread.sleep(2000);
                String currUrl = driver.getCurrentUrl();
                flag = !ValCompare(prevUrl, currUrl);
                Thread.sleep(2000);
                ana.backBtn().click();
            }
        }
        ValidateTest(flag);
    }

    public boolean ValCompare(String prevUrl, String currUrl) {
        return prevUrl.equals(currUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // This method provides data inputs to the above mentioned data receiver
    // functions.

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
