package Publish;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import pageObjects.Publish;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class PublishTeacherCategoryFilters_Student extends Base {
    public Publish pub;
    public LoginPage log;
    public WebDriver driver;
    JavascriptExecutor js;
    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        pub = new Publish(driver);
        log = new LoginPage(driver);
        js = (JavascriptExecutor) driver;
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully filter content according to Teacher.")
    @Story("TPUBFS_05")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentdata")
    public void studentPublishTeacherFilter(String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1 = true, flag2 = true;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.StudentImageClick().click();
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(10000);

        pub.TeacherNameInput().click();
        String TeacherName = pub.FirstTeacherInList().getText();
        pub.FirstTeacherInList().click();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//*[text()='Category']"));
        js.executeScript("arguments[0].scrollIntoView();", element);

        Thread.sleep(2000);
        pub.FirstCategoryFilterOption().click();
        Thread.sleep(2000);

        if (TotalContentCount() != 0){
            List<WebElement> DoubtCards = pub.DoubtCards();
            for(int i=0;i<DoubtCards.size();i++){
                System.out.println(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[" + (i + 2) + "]/a/div/div[1]/div[2]/h3")).getText());
                if(!TeacherName.equals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[" + (i + 2) + "]/a/div/div[1]/div[2]/h3")).getText())){
                    flag1 = false;
                }
            }
            for(int i=0;i<DoubtCards.size();i++){
                if(!pub.FirstCategoryFilterOption().getText().equals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[" + (i + 2) + "]/div[2]/div[2]/span")).getText())){
                    flag2 = false;
                }
            }
        }
        System.out.println(flag1+" "+flag2);
        if(flag1 && flag2){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    public int TotalContentCount(){
        List<String> pagination_text = List.of(pub.PaginationText().getText().split(" "));
        return Integer.parseInt(pagination_text.get(pagination_text.size() - 1));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "studentdata")
    public Object[][] getstudentData() throws FileAlreadyExistsException {

        Object loginData[][] = {{"9000000001", "123456"}, {"9000000024", "123456"}, {"9000000046", "123456"},
                {"9000000069", "123456"}, {"9000000081", "123456"}};
//        Object loginData[][] = {{"9000000001", "123456"}};
        return loginData;
    }

}
