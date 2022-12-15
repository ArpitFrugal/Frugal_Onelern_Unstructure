package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	// Initialization of Webdriver through Properties.

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless", "--ignore-certificate-errors","--disable-extensions");
//			driver = new ChromeDriver(options);
		}

		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;

	}

	public void getScreenshot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports" + "\\reports" + testcasename + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}

	public Object[][] getStudentData() throws FileAlreadyExistsException {
		Object loginData[][] = {{"9000000001", "123456"}};
//		Object loginData[][] = { { "9000000001", "123456" }, { "9000000021", "123456" }, { "9000000041", "123456" },
//				{ "9000000061", "123456" }, { "9000000081", "123456" } };
		return loginData;
	}

	public Object[][] getTeacherData() throws FileAlreadyExistsException {
		Object loginData[][] = {{"9000000101", "123456"}};
//		Object loginData[][] = {{"9000000101", "123456"}, {"9000000106", "123456"}, {"9000000109", "123456"},
//				{"9000000113", "123456"}, {"9000000117", "123456"}};
		return loginData;
	}

	public Object[][] getSchoolAdminData() throws FileAlreadyExistsException{
		Object loginData[][] = {{"frugaltestschooladmin@onelern.com", "123456"}};
		return loginData;
	}

	public Object[][] getPrincipalAdminData() throws FileAlreadyExistsException{
		Object loginData[][] = {{"prakhar.test@onelern.school", "123456"}};
		return loginData;
	}

	public Object[][] getProjectAdminData() throws FileAlreadyExistsException{
		Object loginData[][] = {{"indianadmin@onelern.com", "IndianProject@098"}};
		return loginData;
	}

	public void getScreenshotAtEveryStep(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\stepscreenshots" + "\\"+ testcasename + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}

}
