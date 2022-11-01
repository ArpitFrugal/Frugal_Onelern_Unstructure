package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

import java.util.List;

public class Assignments extends Base {
    public WebDriver driver;

    By AssignmentsToggle = By.id("assignments");
    By StudentAccount = By.id("student");
    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By rightSwipeModules = By.xpath("//*[contains(@class,'card-swiper')]//button[contains(@class,'btn-right-arrow')]");
    By GetHeader = By.xpath("//header/div/div/h1");
    By CreateNewBtn = By.xpath("//*[@class='add-btn']");
    By AssignmentName = By.id("assignment-name");
    By AssignmentSubject = By.id("assignment-subject");
    By AssignmentRewardType = By.id("assignment-reward-type");
    By AssignmentType = By.id("assignment-type");
    By AssignmentDetailsSubmitBtn = By.xpath("//*[contains(@class,'modal-footer')]//button[2]");
    By QuestionDescription = By.id("description");
    By AttachLink = By.id("link");
    By LinkInputBox = By.xpath("//*[contains(@class, 'link-modal-body')]/input");
    By FileTypes = By.xpath("//*[contains(@class,'form-group')]");
    By AssignStudentsBtn = By.xpath("//*[contains(@class,'bottom-fix')]//button[2]");
    By SelectStudentsBtn = By.xpath("//*[contains(@class,'select-students-block')]//button");
    By SelectAllOption = By.xpath("//*[contains(@class,'modal-body')]/div[2]/div[3]/div");
    By StartEndDateInputs = By.xpath("//input");
    By OngoingTabPage = By.xpath("//a[contains(@href,'ongoing')]");
    By DraftsTabPage = By.xpath("//a[contains(@href,'drafts')]");
    By CompletedTabPage = By.xpath("//a[contains(@href,'completed')]");
    By CancelledTabPage = By.xpath("//a[contains(@href,'cancelled')]");
    By AssignmentStatus = By.id("assignment-status");
    By AssignmentNames = By.xpath("//*[contains(@class,'assessment-box')]//h1");

    //Pagination
    By NextNavigate = By.xpath("//*[contains(@class,'option next')]");
    By PaginationText = By.className("pagination-text");
    By BackNavigate = By.xpath("//*[contains(@class,'option prev')]");
    By SaveAsDraft  = By.xpath("//*[contains(@class,'save-text-btn')]");


    // student

    By startAssignment = By.xpath("//*[contains(@class,'bottom-fix')]//button");
    By AttachFileInputBox = By.xpath("//*[contains(@placeholder,'Paste')]");
    By AssignmentAnswerInputBox = By.id("description");
    By GoToDashboardBtn = By.xpath("//button[contains(text(),'Dashboard')]");
    By FirstAssignment = By.xpath("//*[contains(@class,'due-take-test')]//button");
    By mainContent = By.xpath("//*[contains(@class, 'main-content')]");




    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public Assignments(WebDriver driver2) {
        this.driver = driver2;
    }

    public WebElement StudentAccount(){ return driver.findElement(StudentAccount);}

    public WebElement StudentImageClick() { return driver.findElement(StudentImageClick);}
    public WebElement rightswipemodules(){return driver.findElement(rightSwipeModules);}

    public WebElement AssignmentsToggle() { return driver.findElement(AssignmentsToggle);}

    // landing page
    public String GetHeader(){ return driver.findElement(GetHeader).getText();}
    public WebElement CreateNewBtn(){return driver.findElement(CreateNewBtn);}
    public WebElement AssignmentName(){return driver.findElement(AssignmentName);}
    public WebElement AssignmentSubject(){return driver.findElement(AssignmentSubject);}
    public WebElement AssignmentRewardType(){return driver.findElement(AssignmentRewardType);}
    public WebElement AssignmentType(){return driver.findElement(AssignmentType);}
    public WebElement AssignmentDetailsSubmitBtn(){return driver.findElement(AssignmentDetailsSubmitBtn);}
    public WebElement QuestionDescription(){return driver.findElement(QuestionDescription);}
    public WebElement AttachLink(){return driver.findElement(AttachLink);}
    public WebElement LinkInputBox(){return driver.findElement(LinkInputBox);}
    public WebElement AddLinkSubmit(){return driver.findElement(AssignmentDetailsSubmitBtn);}
    public List<WebElement> FileTypes(){return driver.findElements(FileTypes);}
    public WebElement AssignStudentsBtn(){return driver.findElement(AssignStudentsBtn);}

    public WebElement SelectStudentsBtn(){return driver.findElement(SelectStudentsBtn);}
    public WebElement SelectAllOption(){return driver.findElement(SelectAllOption);}
    public WebElement AddStudentsBtn(){return driver.findElement(AssignmentDetailsSubmitBtn);}
    public WebElement ScheduleBtn(){return driver.findElement(AssignStudentsBtn);}
    public WebElement StartDateInputBox(){return driver.findElements(StartEndDateInputs).get(0);}
    public WebElement EndDateInputBox(){return driver.findElements(StartEndDateInputs).get(1);}
    public WebElement PublishBtn(){return driver.findElement(AssignStudentsBtn);}
    public WebElement OngoingTabPage(){return driver.findElement(OngoingTabPage);}
    public WebElement DraftsTabPage(){return driver.findElement(DraftsTabPage);}
    public WebElement CompletedTabPage(){return driver.findElement(CompletedTabPage);}
    public WebElement CancelledTabPage(){return driver.findElement(CancelledTabPage);}
    public List<WebElement> AssignmentStatus(){return driver.findElements(AssignmentStatus);}
    public List<WebElement> AssignmentNames(){return driver.findElements(AssignmentNames);}


    // Pagination

    public WebElement NextNavigate(){ return driver.findElement(NextNavigate); }
    public WebElement PaginationText(){return driver.findElement(PaginationText);}
    public WebElement BackNavigate(){ return driver.findElement(BackNavigate);}

    public WebElement SaveAsDraft(){return driver.findElement(SaveAsDraft);}
    public WebElement startAssignment(){return driver.findElement(startAssignment);}
    public WebElement submitAssignment(){return driver.findElement(startAssignment);}
    public WebElement AttachFileInputBox(){return driver.findElement(AttachFileInputBox);}
    public WebElement AssignmentAnswerInputBox(){return driver.findElement(AssignmentAnswerInputBox);}
    public WebElement GoToDashboardBtn(){return driver.findElement(GoToDashboardBtn);}
    public WebElement FirstAssignment(){return driver.findElement(FirstAssignment);}
    public WebElement mainContent(){return driver.findElement(mainContent);}




}
