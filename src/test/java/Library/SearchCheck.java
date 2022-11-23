package Library;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Library;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class SearchCheck extends Base {
    public Library lib;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        lib = new Library(driver);
        log = new LoginPage(driver);
    }

    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void ThreadSleep3000() throws InterruptedException {
        Thread.sleep(3000);
    }


    public void ValidateTest(int expected_count, int countInSearchBox, int search_elements_size){
        System.out.println(expected_count +" "+ countInSearchBox+ " "+search_elements_size);
        if(countInSearchBox == expected_count && search_elements_size == expected_count ){
            System.out.println("PASSED");
        }
        else {
            Assert.fail();
        }
    }
    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Searched content should be displayed on screen.")
    @Story("LIBFS_08")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void StudentSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        lib.StudentImageClick().click();

        ThreadSleep3000();
        lib.LibraryToggle().click();
        ThreadSleep3000();

        if (mob >= 9000000001l && mob <= 9000000020l){ // Environmental Studies Coursebook - Part A
            String search_text= "good";
            int expected_count=4;

            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep3000();
            //click third lesson
            lib.ThirdLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.SearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            ValidateTest(expected_count, countInSearchBox, search_elements_size);

        }
        else if (mob >= 9000000021l && mob <= 9000000040l){ // English Coursebook - Part A
            String search_text= "read";
            int expected_count= 3;

            lib.EnglishCoursebookGrade2().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.SearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            ValidateTest(expected_count, countInSearchBox, search_elements_size);

        }
        else if (mob >= 9000000041l && mob <= 9000000060l){ // Mathematics Coursebook - Part A
            String search_text= "digit";
            int expected_count= 3;

            lib.MathematicsCoursebookGrade3().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.SearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            ValidateTest(expected_count, countInSearchBox, search_elements_size);

        }
        else if (mob >= 9000000061l && mob <= 9000000080l){ // English Coursebook - Part A
            String search_text= "read";
            int expected_count= 3;

            lib.EnglishCoursebookGrade4().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.SearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            ValidateTest(expected_count, countInSearchBox, search_elements_size);

        }
        else if (mob >= 9000000081l && mob <= 9000000100l){ // English Coursebook - Part A
            String search_text= "learn";
            int expected_count= 2;

            lib.EnglishCoursebookGrade5().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.SearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            ValidateTest(expected_count, countInSearchBox, search_elements_size);

        }

    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Searched content should be displayed on screen.")
    @Story("LIBFT-08")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void TeacherSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(5000);
        lib.LibraryToggle().click();
        ThreadSleep5000();

        if (mob >= 9000000101l && mob <= 9000000104l){ // Environmental Studies Coursebook - Part A
            String search_text= "good";
            int expected_count=4;

            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep3000();
            //click third lesson
            lib.ThirdLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.TeacherSearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            ValidateTest(expected_count, countInSearchBox, search_elements_size);

        }
        else if (mob >= 9000000105l && mob <= 9000000108l){ // English Coursebook - Part A
            String search_text= "read";
            int expected_count= 3;

            lib.EnglishCoursebookGrade2().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.TeacherSearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            ValidateTest(expected_count, countInSearchBox, search_elements_size);

        }
        else if (mob >= 9000000109l && mob <= 9000000112l){ // Mathematics Coursebook - Part A
            String search_text= "digit";
            int expected_count= 3;

            lib.MathematicsCoursebookGrade3().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.TeacherSearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            ValidateTest(expected_count, countInSearchBox, search_elements_size);

        }
        else if (mob >= 9000000113l && mob <= 9000000116l){ // English Coursebook - Part A
            String search_text= "read";
            int expected_count= 3;

            lib.EnglishCoursebookGrade4().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.TeacherSearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            ValidateTest(expected_count, countInSearchBox, search_elements_size);

        }
        else if (mob >= 9000000117l && mob <= 9000000120l){ // English Coursebook - Part A
            String search_text= "learn";
            int expected_count= 2;

            lib.EnglishCoursebookGrade5().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.TeacherSearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            ValidateTest(expected_count, countInSearchBox, search_elements_size);

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

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }


}
