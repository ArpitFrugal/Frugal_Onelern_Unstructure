package loginFunctionality;

import java.io.IOException;

import io.qameta.allure.*;
import resources.Base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import executions.LoginMethods;
import pageObjects.LoginPage;

public class LoginLandingPageCheck extends Base {

	public LoginPage log;
	public WebDriver driver;
	public LoginMethods logmethods;

	@BeforeMethod // Method will work before each method inside this class
	public void standardLogic() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		this.log = new LoginPage(driver);
		logmethods = new LoginMethods();
	}

	@Epic("Login functionality of the onelern_school project.")
	@Description("Examin Student Toggel check ")
	@Story("LOGFS_01")
	@Test(priority = 1)
	@Severity(SeverityLevel.BLOCKER)
	public void studentLandingPage() {
		Assert.assertTrue(logmethods.studentLandingPage(driver));
	}

	@Epic("Login functionality of the onelern_school project.")
	@Description("Examin Teacher toggle check")
	@Story("LOGFT_01")
	@Test(priority = 2)
	@Severity(SeverityLevel.BLOCKER)
	public void teacherLandingPage() throws IOException, InterruptedException {
		Assert.assertTrue(logmethods.teacherLandingPage(driver));
	}

	@AfterMethod // Method will work After each method inside this class
	public void tearDown() {
		driver.quit();
	}

}
