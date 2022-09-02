package loginFunctionality;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import executions.LoginMethods;
import pageObjects.LoginPage;
import resources.Base;

public class UserSignInFunctionality extends Base {

	public LoginPage log;
	public WebDriver driver;
	public LoginMethods logmethods;
	public String student = "student";
	public String teacher = "student";

	@BeforeMethod // Method will work before each method inside this class
	public void standardLogic() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log = new LoginPage(driver); // Structured page object model function defined
		logmethods = new LoginMethods();
		System.out.println("Thread id is: " + Thread.currentThread().getId());

	}

	@Epic("Login functionality of the onelern_school project.")
	@Description("Examin Student Login with correct details")
	@Story("LOGFS_02")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider = "StudentLoginPageCorrectCredentials_Data", priority = 1)
	@Step("Logging in as student- mobile number: {0} and password: {1} for Login Check.")
	public void StudentLoginPageCorrectCredentials(String mobileNo, String pass) throws InterruptedException {
		Assert.assertEquals(logmethods.StudentLoginPageCorrectCredentials(driver, mobileNo, pass), true);
	}

	@Epic("Login functionality of the onelern_school project.")
	@Description("Examin Student Login with incorrect password details")
	@Story("LOGFS_03")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider = "StudentLoginPageIncorrectPassword_Data", priority = 2)
	@Step("Logging in as student- mobile number: {0} and password: {1} for Login Check.")
	public void StudentLoginPageIncorrectPassword(String mobileNo, String pass) throws InterruptedException {
		Assert.assertEquals(logmethods.StudentLoginPageIncorrectPassword(driver, mobileNo, pass), true);
	}

	@Epic("Login functionality of the onelern_school project.")
	@Description("Examin Student Login with incorrect mobile number")
	@Story("LOGFS_04")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider = "IncorrectuserMobileNoCheck_Data", priority = 3)
	@Step("Logging in as student- mobile number: {0} and password: {1} for Login Check.")
	public void IncorrectStudentMobileNoCheck(String mobileNo, String pass) throws InterruptedException {
		Assert.assertEquals(logmethods.IncorrectStudentMobileNoCheck(driver, mobileNo, pass), true);
	}

	@Epic("Login functionality of the onelern_school project.")
	@Description("Examin Teachers Login with correct details")
	@Story("LOGFT_02")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider = "TeacherLoginPageCorrectCredentials_Data", priority = 4)
	@Step("Logging in as teacher- mobile number: {0} and password: {1} for Login Check.")
	public void TeacherLoginPageCorrectCredentials(String mobileNo, String pass) throws InterruptedException {
		Assert.assertEquals(logmethods.TeacherLoginPageCorrectCredentials(driver, mobileNo, pass), true);
	}

	@Epic("Login functionality of the onelern_school project.")
	@Description("Examin Teacher Login with incorrect password details")
	@Story("LOGFT_03")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider = "TeacherLoginPageIncorrectPassword_Data", priority = 5)
	@Step("Logging in as teacher- mobile number: {0} and password: {1} for Login Check.")
	public void TeacherLoginPageIncorrectPassword(String mobileNo, String pass) throws InterruptedException {
		Assert.assertEquals(logmethods.TeacherLoginPageIncorrectPassword(driver, mobileNo, pass), true);
	}

	@Epic("Login functionality of the onelern_school project.")
	@Description("Examin Teacher Login with incorrect mobile number")
	@Story("LOGFT_04")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider = "IncorrectuserMobileNoCheck_Data", priority = 6)
	@Step("Logging in as teacher- mobile number: {0} and password:{1} for Login Check.")
	public void IncorrectTeacherMobileNoCheck(String mobileNo, String pass) throws InterruptedException {
		Assert.assertEquals(logmethods.IncorrectTeacherMobileNoCheck(driver, mobileNo, pass), true);
	}

	@AfterMethod // Method will work After each method inside this class
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "StudentLoginPageCorrectCredentials_Data")
	public Object[][] getDataSLPC() throws FileAlreadyExistsException {

		Object loginData[][] = { { "9000000010", "123456" }, { "9000000024", "123456" }, { "9000000056", "123456" },
				{ "9000000085", "123456" }, { "9000000091", "123456" } };
		return loginData;
	}

	@DataProvider(name = "StudentLoginPageIncorrectPassword_Data")
	public Object[][] getDataSLPIP() throws FileAlreadyExistsException {

		Object loginData[][] = { { "9000000010", "18" }, { "9000000024", "123456789" }, { "9000000056", " " },
				{ "9000000085", "12380761" }, { "9000000091", "1234987615" } };
		return loginData;
	}

	@DataProvider(name = "IncorrectuserMobileNoCheck_Data")
	public Object[][] getDataIUMNC() throws FileAlreadyExistsException {

		Object loginData[][] = { { "9007000010", "18" }, { "900", "123456789" }, { "8000000056687", "12345318" },
				{ "900000824185", "12380761" }, { "90000", "1234987615" } };
		return loginData;
	}

	@DataProvider(name = "TeacherLoginPageCorrectCredentials_Data")
	public Object[][] getDataTLPCC() throws FileAlreadyExistsException {

		Object loginData[][] = { { "9000000102", "123456" }, { "9000000105", "123456" }, { "9000000111", "123456" },
				{ "9000000115", "123456" }, { "9000000118", "123456" } };
		return loginData;
	}

	@DataProvider(name = "TeacherLoginPageIncorrectPassword_Data")
	public Object[][] getDataTLPIP() throws FileAlreadyExistsException {

		Object loginData[][] = { { "9000000102", "12" }, { "9000000105", "  " }, { "9000000111", "123456789" },
				{ "9000000115", "12345610" }, { "9000000118", "1234567894651" } };

		return loginData;
	}

}
