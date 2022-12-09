package Library;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import io.qameta.allure.*;
import resources.Base;
import testResource.BaseLogin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Library;
import pageObjects.LoginPage;

public class LibLandingPageCheck extends Base {
//	Logger logg = Logger.getLogger(LibLandingPageCheck.class);
	public Library lib;
	public LoginPage log;
	public WebDriver driver;
//	private static final Logger logger = (Logger) LogManager.getLogger(LibLandingPageCheck.class);

	@BeforeMethod
	public void standardLogic() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		lib = new Library(driver);
		log = new LoginPage(driver);
//		logger.info("End of BeforeMethod");
	}
	
	public void ThreadSleep5000() throws InterruptedException {
		Thread.sleep(5000);
	}

	@Epic("This story represents the Library module of the onelern_school project.")
	@Description("Examine whether or not the student can successfully get inside the library module.")
	@Story("LIBFS_01")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider = "studentData")
	public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
		BaseLogin user = new BaseLogin(driver);
		user.userLogin("student", mobNumber, password);
		ThreadSleep5000();
		lib.StudentImageClick().click();
		ThreadSleep5000();
		lib.LibraryToggle().click();
		ThreadSleep5000();
		String Headingtext_actual = lib.WorkbookHeading().getText();
		String Headingtext_expected = "Library";

		if (Headingtext_actual.equals(Headingtext_expected)) {
			System.out.println("Library Module is active");
		} else {
			Assert.fail();
		}

	}

	@Epic("This story represents the Library module of the onelern_school project.")
	@Description("Examine whether or not the teacher can successfully get inside the library module.")
	@Story("LIBFT_01")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider = "teacherData")
	public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
		BaseLogin user = new BaseLogin(driver);
		user.userLogin("teacher", mobNumber, password);
		ThreadSleep5000();
		lib.LibraryToggle().click();
		ThreadSleep5000();
		String Headingtext_actual = lib.WorkbookHeading().getText();
		String Headingtext_expected = "Library";
		if (Headingtext_actual.equals(Headingtext_expected)) {
			System.out.println("Library Module is active");
		} else {
			Assert.fail();
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
