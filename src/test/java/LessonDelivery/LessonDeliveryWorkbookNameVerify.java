package LessonDelivery;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LessonDelivery;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class LessonDeliveryWorkbookNameVerify extends Base {

	public LessonDelivery ld;
	public LoginPage log;
	public WebDriver driver;

	@BeforeMethod
	public void standardLogic() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		ld = new LessonDelivery(driver);
		log = new LoginPage(driver);
	}
	
	public void ThreadSleep2000() throws InterruptedException {
		Thread.sleep(2000);
	}
	public void ThreadSleep5000() throws InterruptedException {
		Thread.sleep(5000);
	}
	public void ValidateTest(String expected_text, String actual_text){
		System.out.println(actual_text+" "+expected_text);
		if(actual_text.equals(expected_text)){
			System.out.println("PASSED");
		}
		else{
			Assert.fail();
		}
	}

	@Epic("This story represents the Lesson Delivery module of the onelern_school project.")
	@Description("To check if the teacher workbook name is the same as that mentioned in the Lesson Delivery image")
	@Story("LDFT_03")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider = "teacherData")
	public void TeacherWorkbookCheck(String mobNumber, String password) throws IOException, InterruptedException {
		Long mob = Long.parseLong(mobNumber);
		BaseLogin user = new BaseLogin(driver);
		user.userLogin("teacher", mobNumber, password);
		ThreadSleep5000();
		ld.LessonDeliveryToggle().click();
		ThreadSleep5000();

		// Scrolling page
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
			WebElement element = ld.EnvironmentalcoursebookGrade1();
			js.executeScript("arguments[0].scrollIntoView();", element);
			ThreadSleep5000();
			element.click();
			ThreadSleep5000();
			String text = ld.WorkbookHeading().getText();
			String workbookName = "Lesson Delivery";

			ValidateTest(workbookName, text);
		}

		else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
			WebElement element = ld.EnglishCoursebookGrade2();
			js.executeScript("arguments[0].scrollIntoView();", element);
			ThreadSleep5000();
			element.click();
			ThreadSleep5000();
			String text = ld.WorkbookHeading().getText();
			String workbookName = "Lesson Delivery";

			ValidateTest(workbookName, text);
		}

		else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics Coursebook - Part A
			WebElement element = ld.MathematicsCoursebookGrade3();
			js.executeScript("arguments[0].scrollIntoView();", element);
			ThreadSleep5000();
			element.click();
			ThreadSleep5000();
			String text = ld.WorkbookHeading().getText();
			String workbookName = "Lesson Delivery";

			ValidateTest(workbookName, text);
		}

		else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
			WebElement element = ld.EnglishCoursebookGrade4();
			js.executeScript("arguments[0].scrollIntoView();", element);
			ThreadSleep5000();
			element.click();
			ThreadSleep5000();
			String text = ld.WorkbookHeading().getText();
			String workbookName = "Lesson Delivery";

			ValidateTest(workbookName, text);
		}

		else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
			WebElement element = ld.MathematicsCoursebookGrade5();
			js.executeScript("arguments[0].scrollIntoView();", element);
			ThreadSleep5000();
			element.click();
			ThreadSleep5000();
			String text = ld.WorkbookHeading().getText();
			String workbookName = "Lesson Delivery";

			ValidateTest(workbookName, text);
		}
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
