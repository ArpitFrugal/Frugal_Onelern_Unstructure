package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

import java.util.List;

public class Publish extends Base {
    public WebDriver driver;

    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By PublishToggle = By.id("publish");
//    By GetHeader = By.xpath("/html/body/header/div[1]/h2");
    By PublishGetHeader = By.xpath("/html/body/nav/div[1]/span[2]");

    // publish new content btn
    By PublishNewContentBtn = By.xpath("/html/body/div/button");
    By PublishNewContentTabs = By.xpath("//*[contains(@class,'tab-btn')]");

    //Publish new content
    By ContentOptions = By.xpath("//select[contains(@class, 'form-select')]");

    By PublishContentDescriptionTextArea = By.xpath("//*[@placeholder='Description']");
    By NextStepBtn = By.xpath("//footer/div[2]/button[2]");
//    By IndividualOption = By.id("individual");
    By IndividualOption = By.xpath("//label[@for='individual']");
    By StudentNamesInput = By.id("lang");
    By FinalPublishBtn = By.xpath("/html/body/footer/div[2]/button[2]");
    By PublishGradeSectionInput = By.xpath("//select[contains(@class,'form-select')]");

    // student publish module
    By PublishContentOnTop = By.xpath("//*[contains(@class,'doubts-card')][1]/div[contains(@class,'question-section')]");
    By BackAfterPublish = By.xpath("/html/body/nav/div[1]/div/span[1]");
    By FirstContentTime = By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[6]");
    By OutsideViewCount = By.xpath("//span[contains(@class,'view-count')]");
    By ContentMetaData = By.xpath("//*[contains(@class,'doubts-card')]//div");
    By InsideViewCount = By.xpath("//div[contains(@class,'preview-footer')]//span");
    By LikeBtn = By.xpath("//button[text()='Yes']");
    By DisLikeBtn = By.xpath("//button[text()='No']");
    By LikeCount = By.xpath("/html/body/div/div[5]/div[1]/div[2]/span");

    // pagination
    By BackNavigate = By.xpath("//*[contains(@class,'nxt-prv')]//button[1]");
    By NextNavigate = By.xpath("//*[contains(@class,'nxt-prv')]//button[2]");
    By PaginationText = By.className("pagination-text");

    // Teacher filter
    By TeacherNameInput = By.xpath("//input[@placeholder='Search Teacher']");
    By FirstTeacherInList = By.xpath("//*[@class='listItem']");
    By DoubtCards = By.xpath("//*[contains(@class,'doubts-card')]");

    // Book filter
    By TeacherFilterOptions = By.xpath("//select[contains(@class,'form-select')]");
    By ContentList = By.xpath("//tr[@class= 'svelte-egeff7']");
    By FirstCategoryFilterOption = By.xpath("//*[@for='showing_0']");

    By FirstContentMoreOptions = By.xpath("//*[contains(@class, 'dropdown-toggle')]");
    By RepublishBtn = By.xpath("//*[contains(@class, 'dropdown-menu')]//li[1]");



    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public Publish(WebDriver driver2) { this.driver = driver2; }
    @Step("Publish Module is opened...")
    public WebElement PublishToggle() {
        screenshot();
        return driver.findElement(PublishToggle);
    }
    @Step("Student account is selected")
    public WebElement StudentImageClick() {
        screenshot();
        return driver.findElement(StudentImageClick);
    }
    @Step("Fetching Heading...")
    public String PublishGetHeader(){
        screenshot();
        return driver.findElement(PublishGetHeader).getText();
    }
    @Step("Publish New content button is clicked...")
    public WebElement PublishNewContentBtn(){
        screenshot();
        return driver.findElement(PublishNewContentBtn);
    }
    @Step("Fetching Content tabs...")
    public List<WebElement> PublishNewContentTabs(){
        screenshot();
        return driver.findElements(PublishNewContentTabs);
    }

    public List<WebElement> ContentOptions(){return driver.findElements(ContentOptions);}
    @Step("Publish Content description is added...")
    public WebElement PublishContentDescriptionTextArea(){
        screenshot();
        return driver.findElement(PublishContentDescriptionTextArea);
    }
    @Step("Next Step button is clicked...")
    public WebElement NextStepBtn(){
        screenshot();
        return driver.findElement(NextStepBtn);
    }
    public WebElement IndividualOption(){return driver.findElement(IndividualOption);}
    public List<WebElement> PublishGradeSectionInput(){return driver.findElements(PublishGradeSectionInput);}
    public WebElement StudentNamesInput(){return driver.findElement(StudentNamesInput);}
    @Step("Final Publish button is clicked...")
    public WebElement FinalPublishBtn(){
        screenshot();
        return driver.findElement(FinalPublishBtn);
    }
    @Step("First pushlished content is fetched...")
    public WebElement PublishContentOnTop(){
        screenshot();
        return driver.findElement(PublishContentOnTop);
    }
    @Step("Back button is clicked...")
    public WebElement BackAfterPublish(){
        screenshot();
        return driver.findElement(BackAfterPublish);
    }
    @Step("Fetching content published time...")
    public WebElement FirstContentTime(){
        screenshot();
        return driver.findElement(FirstContentTime);
    }
    @Step("Fetching View Count...")
    public WebElement OutsideViewCount(){
        screenshot();
        return driver.findElement(OutsideViewCount);
    }
    public WebElement ContentMetaData(){return driver.findElement(ContentMetaData);}
    @Step("Fetching View Count...")
    public WebElement InsideViewCount(){
        screenshot();
        return driver.findElement(InsideViewCount);
    }
    @Step("Liked the doubt...")
    public WebElement LikeBtn(){
        screenshot();
        return driver.findElement(LikeBtn);
    }
    @Step("Disliked the doubt...")
    public WebElement DisLikeBtn(){
        screenshot();
        return driver.findElement(DisLikeBtn);
    }
    @Step("Fetching Like Count...")
    public WebElement LikeCount(){
        screenshot();
        return driver.findElement(LikeCount);
    }

    // pagination

    @Step("Back button is clicked...")
    public WebElement StudentBackNavigate(){
        screenshot();
        return driver.findElement(BackNavigate);
    }
    @Step("Next button is clicked...")
    public WebElement StudentNextNavigate(){
        screenshot();
        return driver.findElement(NextNavigate);
    }
    @Step("Back button is clicked...")
    public WebElement BackNavigate(){
        screenshot();
        return driver.findElement(BackNavigate);
    }
    @Step("Next button is clicked...")
    public WebElement NextNavigate(){
        screenshot();
        return driver.findElement(NextNavigate);
    }
    public WebElement PaginationText(){return driver.findElement(PaginationText);}
    @Step("Typing Teacher name...")
    public WebElement TeacherNameInput(){
        screenshot();
        return driver.findElement(TeacherNameInput);
    }
    public WebElement FirstTeacherInList(){return driver.findElement(FirstTeacherInList);}
    public List<WebElement> DoubtCards(){return driver.findElements(DoubtCards);}


    // Book filter
    public List<WebElement> TeacherFilterOptions(){return driver.findElements(TeacherFilterOptions);}
    public List<WebElement> ContentList(){return driver.findElements(ContentList);}
    public WebElement FirstCategoryFilterOption(){return driver.findElement(FirstCategoryFilterOption);}
    public WebElement FirstContentMoreOptions(){return driver.findElement(FirstContentMoreOptions);}
    @Step("Republishing content...")
    public WebElement RepublishBtn(){return driver.findElement(RepublishBtn);}


}
