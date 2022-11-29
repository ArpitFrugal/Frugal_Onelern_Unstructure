package UserManagement;

import io.qameta.allure.*;
import org.apache.poi.ss.formula.functions.T;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserManagementCreateNewStudentCheck extends Base {
    public UserManagement usm;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        usm = new UserManagement(driver);
        log = new LoginPage(driver);
    }


    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully create a student.")
    @Story("UMFA_06")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminCreateNewStudentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;


        usm.InstitutesModule().click();
        Thread.sleep(2000);

        usm.SearchInstitute().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Automation");

        List<WebElement> institutesDisplayed = usm.InstitutesDisplayed();
        institutesDisplayed.get(0).click();


        WebElement firstSchool = usm.SchoolsDisplayed().get(0);
        firstSchool.click();
        Thread.sleep(2000);
        WebElement firstGrade = usm.GradesDisplayed().get(0);
        firstGrade.click();
        Thread.sleep(2000);
        WebElement firstSection = usm.SectionsDisplayed().get(0);
        firstSection.click();

        usm.AddStudentBtn().click();

        usm.StudentFirstName().click();
        usm.StudentFirstName().sendKeys("First Name");

        usm.StudentLastName().click();
        usm.StudentLastName().sendKeys("Last Name");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String CurrDate = formatter.format(date);
        Calendar cal1 = Calendar.getInstance();
        try{
            cal1.setTime(formatter.parse(CurrDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal1.add(Calendar.DAY_OF_MONTH, 5);
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        usm.StudentDOB().click();
        usm.StudentDOB().sendKeys(currdate);
        usm.StudentDOB().sendKeys(currmonth);
        usm.StudentDOB().sendKeys(curryear);

        usm.StudentGender().click();
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView();", usm.StudentEmail());
        Thread.sleep(2000);
        usm.ParentEmail().click();
        usm.ParentEmail().sendKeys("parentmail@gmail.com");

        usm.ParentName().click();
        usm.ParentName().sendKeys("Parent Name");

        usm.ParentMobileNumber().click();
        usm.ParentMobileNumber().sendKeys("9876543210");
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView();", usm.CurrentAddress());
        Thread.sleep(2000);
        usm.NextStep().click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-350)", "");
        Thread.sleep(1000);

        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String dateString = dateFormat.format(new Date(Calendar.getInstance().getTimeInMillis()));
        String currhour = dateString.split("\\.")[0];
        String currmin  = dateString.split("\\.")[1].split(" ")[0];
        String ampm = dateString.split("\\.")[1].split(" ")[1];


        usm.StudentUsername().click();
        usm.StudentUsername().sendKeys("username"+currhour+currmin);
        js.executeScript("arguments[0].scrollIntoView();", usm.AddStudent());
        Thread.sleep(1000);
        usm.AddStudent().click();
        Thread.sleep(2000);
        List<WebElement> StudentsDisplayed = usm.StudentsDisplayed();

        boolean flag = false;

        for(WebElement webElement:StudentsDisplayed){
            if(webElement.getText().contains("First")){
                flag = true;
                break;
            }
        }
        ValidateTest(flag);

    }


    private void ValidateTest(boolean flag) {
        System.out.println(flag);
        if(flag){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
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
