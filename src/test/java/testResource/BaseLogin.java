package testResource;

import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.Base;
import pageObjects.Library;
import pageObjects.LoginPage;

public class BaseLogin extends Base {

	public LoginPage log;
	public WebDriver driver;

	public BaseLogin(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	public void userLogin(String user, String mobNumber, String pass) throws IOException, InterruptedException {
		log = new LoginPage(driver);

		if(user.equals("teacher")) {
			log.getTeacherSignIn().click();
			log.getUserName().sendKeys(mobNumber);
			log.getSubmitButton().click();
			Thread.sleep(5000);
			log.getloginWithPassword().click();
			log.getPassword().sendKeys(pass);
			Thread.sleep(5000);
			log.getPasswordButton().click();
			Thread.sleep(5000);
		}
		else {
			log.getStudentSignIn().click();
			log.getUserName().sendKeys(mobNumber);
			log.getSubmitButton().click();
			Thread.sleep(5000);
			log.getloginWithPassword().click();
			log.getPassword().sendKeys(pass);
			Thread.sleep(5000);
			log.getPasswordButton().click();
			Thread.sleep(5000);
		}

	}

}
