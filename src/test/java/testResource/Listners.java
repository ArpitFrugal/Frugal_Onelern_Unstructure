package testResource;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import resources.Base;

public class Listners extends Base implements ITestListener {

	public WebDriver driver;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String testMethodName = result.getMethod().getMethodName();
		System.out.println("Test on : " + testMethodName + " Started.");

	}

	public void onTestSuccess(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		System.out.println("Test on : " + testMethodName + " Succeed.");

	}

	public void onTestFailure(ITestResult result) {
		String TestMethodName = result.getMethod().getMethodName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		}
		catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			getScreenshot(TestMethodName, driver);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		saveScreenShotOnFailure(driver);
		saveLogs(result.getMethod().getConstructorOrMethod().getName());
		
	}

	
	
	@Attachment(value = "ScreenShot",type = "image/png")
	public byte[] saveScreenShotOnFailure(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	
	@Attachment(value= "{0}", type = "text/plain")
	public static String saveLogs(String message) {
		return message;
	}
}
