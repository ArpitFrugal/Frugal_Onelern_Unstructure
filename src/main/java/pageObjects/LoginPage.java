package pageObjects;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

public class LoginPage extends Base {
    public WebDriver driver;
    By studentSignIn = By.id("student");
    By teacherSignIn = By.id("teacher");
    By othersSignIn = By.id("others");
    By password = By.id("user-password");
    By submitButton = By.id("user-submit");
    By PasswordSubmit = By.id("password-submit");
    By loginWithPassword = By.xpath("/html/body/div[4]/div/div/div[2]/button[2]");
    By okText = By.id("ok-btn");
    By UserName = By.id("mobile-number");

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    // constructor
    public LoginPage(WebDriver driver2) {
        // TODO Auto-generated constructor stub
        this.driver = driver2;
    }
    // Get Student login page access
    @Step("Selected log in as Student...")
    public WebElement getStudentSignIn() {
        screenshot();
        return driver.findElement(studentSignIn);
    }
    // Get Teacher login page access
    @Step("Selected log in as Teacher...")
    public WebElement getTeacherSignIn() {
        screenshot();
        return driver.findElement(teacherSignIn);
    }
    // Get Student Others page access
    public WebElement getOthersSignIn() {
        return driver.findElement(othersSignIn);
    }
    // Get username block access
    @Step("Mobile number is entered...")
    public WebElement getUserName() {
        screenshot();
        return driver.findElement(UserName);
    }
    // Get password block access
    @Step("password is entered...")
    public WebElement getPassword() {
        screenshot();
        return driver.findElement(password);
    }
    // Get Submit button
    @Step("Mobile number is submitted...")
    public WebElement getSubmitButton() {
        screenshot();
        return driver.findElement(submitButton);
    }
    //Get Password Submit Button
    @Step("Password is submitted...")
    public WebElement getPasswordButton() {
        screenshot();
        return driver.findElement(PasswordSubmit);
    }
    // Get login with password text
    public WebElement getloginWithPassword() {
        return driver.findElement(loginWithPassword);
    }
    // Get ok text
    public WebElement okText() {
        return driver.findElement(okText);
    }
}