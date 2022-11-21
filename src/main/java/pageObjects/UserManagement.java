package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

public class UserManagement extends Base {
    public WebDriver driver;

    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Student account is selected...")
    public WebElement StudentImageClick() { return driver.findElement(StudentImageClick); }


}
