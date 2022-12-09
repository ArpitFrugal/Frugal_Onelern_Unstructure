package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

import java.util.List;

public class Doubts extends Base {
    public WebDriver driver;
    By StudentAccount = By.id("student");
    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By DoubtsToggle = By.id("doubts");
    By GetHeader = By.xpath("/html/body/div/span/span");
    By AskDoubtBtn = By.xpath("//a[@href='create-doubt']");
    By AskDoubtHeader = By.xpath("/html/body/div/span/span");
    By ViewCount = By.xpath("//span[contains(@class, 'view-count')]");
    By DoubtsCards = By.xpath("//*[contains(@class, 'doubts-card')]");
    By FirstDoubt = By.xpath("//*[contains(@class, 'doubts-card')]//div");
    By QuestionTextBox = By.xpath("//*[contains(@class,'fr-wrapper')]/div");
    By SubmitBtn = By.xpath("//*[contains(@class, 'btn-section')]/button[2]");
    By CreatedSubjectDetails = By.xpath("//div[contains(@class, 'subject-details')]");
    By CreatedQuestionDetails = By.xpath("//div[contains(@class, 'question-section')]");
    By InsertImageOption = By.id("insertImage-1");
    By ImageByUrl = By.id("imageByURL-1");
    By imageUrlInput = By.id("fr-image-by-url-layer-text-1");
    By InsertBtn = By.xpath("//button[@class='fr-command fr-submit']");
    By InsertVideoOption = By.id("insertVideo-1");
    By VideoUrlInput = By.id("fr-video-by-url-layer-text-1");
    By insertedImage = By.xpath("/html//div[1]/p/img");
    By insertedVideo = By.xpath("/html//div[1]/p/span");
    By UndoOption = By.id("undo-1");
    By RedoOption = By.id("redo-1");

    //    Filter Functionality
    By FilterSubjectFirstSubject_Student = By.xpath("//aside//li[1]//label[1]");
    By FilterSubjectSecondSubject_Student = By.xpath("//aside//li[1]//label[2]");
    By FilterSubjectThirdSubject_Student = By.xpath("//aside//li[1]//label[3]");
    //    By FilterSubjectThirdSubject_Student = By.xpath("//aside//li[1]//label[4]");
    By displayedDoubtSubjectDetails = By.xpath("//div[contains(@class, 'doubts-card')]//div[contains(@class, 'subject-details')]");

    //    By FilterSubjectSelectAll_Teacher = By.xpath("//aside//li[2]//label[1]");
    By FilterSubjectFirstSubject_Teacher = By.xpath("//aside//li[2]//label[1]");
    By FilterSubjectSecondSubject_Teacher = By.xpath("//aside//li[2]//label[2]");
    By FilterSubjectThirdSubject_Teacher = By.xpath("//aside//li[2]//label[3]");

    // replyCheck
    By HomepageMenuBtn = By.id("menu-btn");
    By logoutBtn = By.id("logout-btn");
    By backBtnLoginPage = By.xpath("//button[contains(@class, 'back-btn')]");
    By firstDoubt = By.xpath("//a[contains(@href, 'doubt-details')]");
    By ReplyInputBox = By.xpath("//input[@placeholder= 'Reply']");
    By ReplySubmitBtn = By.xpath("//button[contains(@class, 'reply-btn')]");
    By answered_count = By.xpath("//*[contains(@class, 'answered')]/div[2]");
    By markThisAnswerBtn = By.xpath("//*[contains(@class, 'answered-question')]//span");
    By greenCheckMark = By.xpath("//*[text()='check_circle']");
    By resolvedText = By.xpath("//*[contains(text(), 'Resolved')]");
    By bestAnswerText = By.xpath("//span[contains(@class, 'best-answer')]");
    By statusText = By.xpath("//*[contains(@class, 'status-text')]");


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }



    public Doubts(WebDriver driver2) {
        this.driver = driver2;
    }
    @Step("Student account is selected...")
    public WebElement StudentAccount(){
        screenshot();
        return driver.findElement(StudentAccount);
    }
    @Step("Student account is selected...")
    public WebElement StudentImageClick() {
        screenshot();
        return driver.findElement(StudentImageClick);
    }
    @Step("Doubts Module is opened...")
    public WebElement DoubtsToggle() {
        screenshot();
        return driver.findElement(DoubtsToggle);
    }
    @Step("Fetching heading...")
    public WebElement GetHeader(){
        screenshot();
        return driver.findElement(GetHeader);
    }
    @Step("Ask a doubt button is clicked...")
    public WebElement AskDoubtBtn(){
        screenshot();
        return driver.findElement(AskDoubtBtn);
    }
    public WebElement AskDoubtHeader(){return driver.findElement(AskDoubtHeader);}
    @Step("Fetching doubt views count...")
    public WebElement ViewCount(){
        screenshot();
        return driver.findElement(ViewCount);
    }
    public List<WebElement> DoubtsCards(){return driver.findElements(DoubtsCards);}
    public WebElement FirstDoubt(){return driver.findElement(FirstDoubt);}
    public WebElement QuestionTextBox(){return driver.findElement(QuestionTextBox);}
    @Step("Submit button is clicked...")
    public WebElement SubmitBtn(){
        screenshot();
        return driver.findElement(SubmitBtn);
    }
    @Step("Fetching subject details of doubt posted...")
    public WebElement CreatedSubjectDetails(){
        screenshot();
        return driver.findElement(CreatedSubjectDetails);
    }
    @Step("Fetching question details of doubt posted...")
    public WebElement CreatedQuestionDetails(){
        screenshot();
        return driver.findElement(CreatedQuestionDetails);
    }
    @Step("Image option is selected in question field...")
    public WebElement InsertImageOption(){
        screenshot();
        return driver.findElement(InsertImageOption);
    }
    @Step("Image url is entered...")
    public WebElement ImageByUrl(){
        screenshot();
        return driver.findElement(ImageByUrl);
    }
    public WebElement imageUrlInput(){return driver.findElement(imageUrlInput);}
    @Step("Insert button is clicked...")
    public WebElement InsertBtn(){
        screenshot();
        return driver.findElement(InsertBtn);
    }
    @Step("Video option is selected in question field...")
    public WebElement InsertVideoOption(){
        screenshot();
        return driver.findElement(InsertVideoOption);
    }
    public WebElement VideoUrlInput(){return driver.findElement(VideoUrlInput);}
    public WebElement insertedImage(){return driver.findElement(insertedImage);}
    public WebElement insertedVideo(){return driver.findElement(insertedVideo);}
    @Step("Undo option is selected in question field...")
    public WebElement UndoOption(){
        screenshot();
        return driver.findElement(UndoOption);
    }
    @Step("Redo option is selected in question field...")
    public WebElement RedoOption(){
        screenshot();
        return driver.findElement(RedoOption);
    }

    //    Filter Functionality
//    @Step("Select all Under Subject filter option is clicked...")
//    public WebElement FilterSubjectSelectAll_Student(){return driver.findElement(FilterSubjectSelectAll_Student);}
    @Step("First subject under subject filter option is clicked...")
    public WebElement FilterSubjectFirstSubject_Student(){
        screenshot();
        return driver.findElement(FilterSubjectFirstSubject_Student);
    }
    @Step("Second subject under subject filter option is clicked...")
    public WebElement FilterSubjectSecondSubject_Student(){
        screenshot();
        return driver.findElement(FilterSubjectSecondSubject_Student);
    }
    @Step("Third subject under subject filter option is clicked...")
    public WebElement FilterSubjectThirdSubject_Student(){
        screenshot();
        return driver.findElement(FilterSubjectThirdSubject_Student);
    }
    @Step("Fetching subject details from all doubts displayed...")
    public List<WebElement> displayedDoubtSubjectDetails(){
        screenshot();
        return driver.findElements(displayedDoubtSubjectDetails);
    }

    //    @Step("Select all Under Subject filter option is clicked...")
//    public WebElement FilterSubjectSelectAll_Teacher(){return driver.findElement(FilterSubjectSelectAll_Teacher);}
    @Step("First subject under subject filter option is clicked...")
    public WebElement FilterSubjectFirstSubject_Teacher(){
        screenshot();
        return driver.findElement(FilterSubjectFirstSubject_Teacher);
    }
    @Step("Second subject under subject filter option is clicked...")
    public WebElement FilterSubjectSecondSubject_Teacher(){
        screenshot();
        return driver.findElement(FilterSubjectSecondSubject_Teacher);
    }
    @Step("Third subject under subject filter option is clicked...")
    public WebElement FilterSubjectThirdSubject_Teacher(){
        screenshot();
        return driver.findElement(FilterSubjectThirdSubject_Teacher);
    }


    // reply check
    @Step("Opening Menu...")
    public WebElement HomepageMenuBtn(){
        screenshot();
        return driver.findElement(HomepageMenuBtn);
    }
    @Step("Logging out...")
    public WebElement logoutBtn(){
        screenshot();
        return driver.findElement(logoutBtn);
    }
    @Step("Back button is clicked...")
    public WebElement backBtnLoginPage(){
        screenshot();
        return driver.findElement(backBtnLoginPage);
    }
    @Step("Fetching first doubt on top...")
    public WebElement firstDoubt(){
        screenshot();
        return driver.findElement(firstDoubt);
    }
    @Step("Giving input in reply box...")
    public WebElement ReplyInputBox(){
        screenshot();
        return driver.findElement(ReplyInputBox);
    }
    @Step("Submit button is clicked...")
    public WebElement ReplySubmitBtn(){
        screenshot();
        return driver.findElement(ReplySubmitBtn);
    }
    @Step("Fetching answered count for the doubt...")
    public WebElement answered_count(){
        screenshot();
        return driver.findElement(answered_count);
    }
    @Step("Marking this doubt as answer...")
    public WebElement markThisAnswerBtn(){
        screenshot();
        return driver.findElement(markThisAnswerBtn);
    }
    public List<WebElement> greenCheckMark(){return driver.findElements(greenCheckMark);}
    public List<WebElement> resolvedText(){return driver.findElements(resolvedText);}
    public WebElement bestAnswerText(){return driver.findElement(bestAnswerText);}
    public WebElement statusText(){return driver.findElement(statusText);}
}
