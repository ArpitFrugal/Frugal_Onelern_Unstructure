package UserManagement;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.UserManagement;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class UserManagementStudentsPaginationCheck extends Base {
    public UserManagement usm;
    public LoginPage log;
    public WebDriver driver;

    List<String> paginationpage = List.of("1-", "16-", "31-", "46-", "61-");

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        usm = new UserManagement(driver);
        log = new LoginPage(driver);
    }

    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or noti the admin can successfully navigayte to all pages of students and view them.")
    @Story("UMFA_07")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminStudentPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        usm.InstitutesModule().click();
        Thread.sleep(2000);

        usm.SearchInstitute().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Frugal");
        Thread.sleep(2000);

        List<WebElement> institutesDisplayed = usm.InstitutesDisplayed();
        Thread.sleep(2000);
        institutesDisplayed.get(0).click();

        WebElement firstSchool = usm.SchoolsDisplayed().get(0);
        firstSchool.click();
        Thread.sleep(2000);
        WebElement firstGrade = usm.GradesDisplayed().get(3); // temp
        firstGrade.click();
        Thread.sleep(2000);
        WebElement firstSection = usm.SectionsDisplayed().get(0);
        firstSection.click();

        int i=0;
        boolean flag1, flag2, flag3;

        flag1 = ValCompare(usm.StudentsPaginationText().getText(), paginationpage.get(i));
        Thread.sleep(2000);
        usm.PaginationNext().click();
        i+=1;
//        usm.PaginationNext().click();
//        i+=1;

        flag2 = ValCompare(usm.StudentsPaginationText().getText(), paginationpage.get(i));
        Thread.sleep(2000);
        usm.PaginationPrev().click();
        i-=1;

        flag3 = ValCompare(usm.StudentsPaginationText().getText(), paginationpage.get(i));
        Thread.sleep(2000);
        ValidateTest(flag1, flag2, flag3);

    }

    private void ValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1+" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    private boolean ValCompare(String studentsPaginationText, String actual) {
        System.out.println(studentsPaginationText+" "+actual);
        return studentsPaginationText.contains(actual);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "adminData")
    public Object[][] getadminData() throws FileAlreadyExistsException {
        return getProjectAdminData();
    }


}
