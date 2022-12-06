package Publish;

import io.qameta.allure.*;
import org.openqa.selenium.By;
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
import java.util.List;

public class PublishSubjectLessonCategoryFilters_Teacher extends Base {
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

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully filter the content according to book.")
    @Story("PUBFT-05")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherBookFilter(String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1= true, flag2 = true, flag3 = true;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(5000);

        List<WebElement> FilterOptions = pub.TeacherFilterOptions();
        int j=0;
        for(WebElement webElement:FilterOptions){
            if(j==0 || j==3 || j==4){
                Thread.sleep(3000);
                webElement.click();
                Thread.sleep(3000);
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            else{
                Thread.sleep(5000);
                webElement.click();
                Thread.sleep(5000);
                webElement.sendKeys(Keys.ENTER);
            }
            j+=1;
        }
        String SelectedSubject = List.of(FilterOptions.get(1).getText().split("\n")).get(1);
        String SelectedLesson = List.of(FilterOptions.get(3).getText().split("\n")).get(1);
        String SelectedCategory = List.of(FilterOptions.get(4).getText().split("\n")).get(1);

        List<WebElement> PublishedContentList = pub.ContentList();
        int contentssize = PublishedContentList.size()-1;
        Thread.sleep(5000);
        //Subject
        for(int i=0;i<contentssize;i++){
            flag1= Validate(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr["+(i+1)+"]/td[1]")).getText(), SelectedSubject);
            Thread.sleep(2000);
            if(!flag1){break;}
        }
        // Lesson name
        for(int i=0;i<contentssize;i++){
            flag2= Validate(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr["+(i+1)+"]/td[2]")).getText(), SelectedLesson);
            Thread.sleep(2000);
            if(!flag2){break;}
        }
        // category
        for(int i=0;i<contentssize;i++){
            flag3= Validate(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr["+(i+1)+"]/td[3]")).getText(), SelectedCategory);
            Thread.sleep(2000);
            if(!flag3){break;}
        }

        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    public boolean Validate(String element, String selectedSubject) {
        return element.contains(selectedSubject);
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
