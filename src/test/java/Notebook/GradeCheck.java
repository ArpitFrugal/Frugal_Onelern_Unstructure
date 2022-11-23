package Notebook;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class GradeCheck extends Base {
    public Notebook note;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        note = new Notebook(driver);
        log = new LoginPage(driver);
    }

    public void ValidateTest(String actual_grade, String expected_grade){
        System.out.println(actual_grade +" "+expected_grade);
        if (actual_grade.contains(expected_grade)) {
            System.out.println("PASSED");
        } else {
            Assert.fail();
        }
    }
    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a student in a specific grade has the correct grade book")
    @Story("NOTFS_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData")
    public void CheckStudentBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        note.StudentImageClick().click();
        Thread.sleep(2000);
        note.NotebookToggle().click();
        Thread.sleep(2000);
        if (mob >= 9000000001l && mob <= 9000000020l) {// English
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 1";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {// English
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 2";

            ValidateTest(actual_grade, expected_grade);

        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {// English
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 3";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 4";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 5";

            ValidateTest(actual_grade, expected_grade);
        }

    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a teacher of a specific grade has the correct grade book")
    @Story("NOTFT_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teachersData")
    public void CheckTeacherBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        note.NotebookToggle().click();
        if (mob >= 9000000101l && mob <= 9000000104l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 1";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 2";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 3";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 4";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 5";

            ValidateTest(actual_grade, expected_grade);
        }

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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
