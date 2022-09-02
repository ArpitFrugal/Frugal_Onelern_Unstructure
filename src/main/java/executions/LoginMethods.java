package executions;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
public class LoginMethods {
    public LoginPage log;
    public void studentblock(WebDriver driver, String mobileNo, String pass) throws InterruptedException {
        this.log = new LoginPage(driver);
        log.getStudentSignIn().click();
        log.getUserName().sendKeys(mobileNo);
        log.getSubmitButton().click();
        Thread.sleep(2000);
        log.getloginWithPassword().click();
        log.getPassword().sendKeys(pass);
        Thread.sleep(5000);
        log.getPasswordButton().click();
//      log.getSubmitButton().click();
        Thread.sleep(5000);
    }
    public void teacherblock(WebDriver driver, String mobileNo, String pass) throws InterruptedException {
        this.log = new LoginPage(driver);
        log.getTeacherSignIn().click();
        log.getUserName().sendKeys(mobileNo);
        log.getSubmitButton().click();
        Thread.sleep(2000);
        log.getloginWithPassword().click();
        log.getPassword().sendKeys(pass);
        Thread.sleep(5000);
        log.getPasswordButton().click();
//      log.getSubmitButton().click();
        Thread.sleep(5000);
    }
    public boolean AlertHandling(WebDriver driver) {
        // Alert Handling
        boolean flag = false;
        String str = "Attention!";
        if (driver.getPageSource().contains(str)) {
            String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
            String subWindowHandler = null;
            Set<String> handles = driver.getWindowHandles(); // get all window handles
            Iterator<String> iterator = handles.iterator();
            while (iterator.hasNext()) {
                subWindowHandler = iterator.next();
            }
            driver.switchTo().window(subWindowHandler); // switch to popup window
            driver.switchTo().window(parentWindowHandler); // switch back to parent window
            String txt = log.okText().getText();
            if (txt != "Ok") {
                System.out.println("Popup handled");
                flag = true;
            }
        }
        return flag;
    }
    public boolean studentLandingPage(WebDriver driver) {
        this.log = new LoginPage(driver);
        log.getStudentSignIn().click();
        return driver.getPageSource().contains("Welcome to OneLern");
    }
    public boolean StudentLoginPageCorrectCredentials(WebDriver driver, String mobileNo, String pass)
            throws InterruptedException {
        studentblock(driver, mobileNo, pass);
        if (driver.getPageSource().contains("Frugal Test School")) {
            System.out.println("Login Successfull for student");
            return true;
        } else {
            System.out.println("Login Unsuccessful for student");
            return false;
        }
    }
    public boolean StudentLoginPageIncorrectPassword(WebDriver driver, String mobileNo, String pass)
            throws InterruptedException {
        this.log = new LoginPage(driver);
        log.getStudentSignIn().click();
        log.getUserName().sendKeys(mobileNo);
        log.getSubmitButton().click();
        log.getloginWithPassword().click();
        log.getPassword().sendKeys(pass);
        Thread.sleep(5000);
        if (log.getPasswordButton().isEnabled() == false) {
            System.out.println("Submit button is not enabled");
            return true;
        } else {
            boolean flag = false;
            log.getPasswordButton().click();
            Thread.sleep(1500);
            if (driver.getPageSource().contains("Incorrect password. Please try again")) {
                System.out.println("Invalid message displayed");
                flag = true;
            } else {
                System.out.println("Invalid message not displayed");
                flag = false;
            }
            return flag;
        }
    }
    public boolean IncorrectStudentMobileNoCheck(WebDriver driver, String mobileNo, String pass)
            throws InterruptedException {
        this.log = new LoginPage(driver);
        log.getStudentSignIn().click();
        log.getUserName().sendKeys(mobileNo);
        if (log.getSubmitButton().isEnabled() == false) {
            System.out.println("Submit button is not enabled");
            return true;
        } else {
            log.getSubmitButton().click();
            Thread.sleep(1000);
            return AlertHandling(driver);
        }
    }
    public boolean teacherLandingPage(WebDriver driver) {
        this.log = new LoginPage(driver);
        log.getTeacherSignIn().click();
        return driver.getPageSource().contains("Welcome to OneLern");
    }
    public boolean TeacherLoginPageCorrectCredentials(WebDriver driver, String mobileNo, String pass)
            throws InterruptedException {
        teacherblock(driver, mobileNo, pass);
        if (driver.getPageSource().contains("Quick Menu")) {
            System.out.println("Login Successfull for teacher");
            return true;
        } else {
            System.out.println("Login Unsuccessful for teacher");
            return false;
        }
    }
    public boolean TeacherLoginPageIncorrectPassword(WebDriver driver, String mobileNo, String pass)
            throws InterruptedException {
        this.log = new LoginPage(driver);
        log.getTeacherSignIn().click();
        log.getUserName().sendKeys(mobileNo);
        log.getSubmitButton().click();
        log.getloginWithPassword().click();
        log.getPassword().sendKeys(pass);
        Thread.sleep(5000);
        if (log.getPasswordButton().isEnabled() == false) {
            System.out.println("Submit button is not enabled");
            return true;
        } else {
            boolean flag = false;
            log.getPasswordButton().click();
            Thread.sleep(5000);
            if (driver.getPageSource().contains("Incorrect password. Please try again")) {
                System.out.println("Invalid message displayed");
                flag = true;
            } else {
                System.out.println("Invalid message not displayed");
                flag = false;
            }
            return flag;
        }
    }
    public boolean IncorrectTeacherMobileNoCheck(WebDriver driver, String mobileNo, String pass)
            throws InterruptedException {
        this.log = new LoginPage(driver);
        log.getTeacherSignIn().click();
        log.getUserName().sendKeys(mobileNo);
        if (log.getSubmitButton().isEnabled() == false) {
            System.out.println("Submit button is not enabled");
            return true;
        } else {
            log.getSubmitButton().click();
            Thread.sleep(1000);
            return AlertHandling(driver);
        }
    }
}