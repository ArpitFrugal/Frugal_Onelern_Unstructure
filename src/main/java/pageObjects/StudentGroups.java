package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

import java.util.List;

public class StudentGroups extends Base {
    public WebDriver driver;

    By StudentAccount = By.id("student");
    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By StudentGroupsToggle = By.id("student_groups");
    By rightSwipeModules = By.xpath("//*[contains(@class,'card-swiper')]//button[contains(@class,'btn-right-arrow')]");
    By GetHeader = By.xpath("//h1");
    By AddGroupBtn = By.xpath("//*[contains(@class,'add-btn')]");
    By GroupNameInput = By.xpath("//*[contains(@class,'group-section')]/input");
    By AddStudentsBtn = By.xpath("//*[contains(@class,'bottom')]/button");
    By SelectAllStudents = By.xpath("//*[contains(@class,'select-student-top')]//input");
    By SelectAllStudentsSubmit = By.xpath("//*[contains(@class,'modal-footer')]//button[2]");
    By SaveGroup = By.xpath("//*[contains(@class,'bottom')]//button[2]");
    By UpdateGroupNameSubmit = By.xpath("//*[contains(@class,'bottom')]//button[2]");
    By GroupCards = By.xpath("//*[contains(@class,'group-card')]");
    By SearchInputBox = By.xpath("//*[contains(@placeholder,'Search')]");
    By MoreOptionsBtn = By.xpath("//*[contains(@class,'dropdown')]");
    By EditOption = By.xpath("//button[text()='Edit']");
    By DeleteOption = By.xpath("//button[text()='Delete']");
    By DeleteConfirmationBtn = By.xpath("//*[contains(@class,'modal-content')]//button[2]");

    By PublishToggle = By.id("publish");
    By ContentOptions = By.xpath("//select[contains(@class, 'form-select')]");
    By PublishNewContentBtn = By.xpath("/html/body/div/button");
    By PublishContentDescriptionTextArea = By.xpath("//*[@placeholder='Description']");
    By NextStepBtn = By.xpath("/html/body/footer/div[2]/button[2]");
    By PublishToGroup = By.xpath("//*[contains(@class,'radio-section')]//label[@for='group']");
    By GroupDropDown = By.xpath("//*[contains(@class,'form-select')]");
    By FinalPublishBtn = By.xpath("//button[contains(text(),'Publish')]");




    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    public StudentGroups(WebDriver driver2) {
        this.driver = driver2;
    }
    @Step("Student account is selected...")
    public WebElement StudentImageClick() {
        screenshot();
        return driver.findElement(StudentImageClick);
    }
    @Step("Fetching heading...")
    public WebElement GetHeader(){
        screenshot();
        return driver.findElement(GetHeader);
    }
    @Step("Student groups Module is opened...")
    public WebElement StudentGroupsToggle() {
        screenshot();
        return driver.findElement(StudentGroupsToggle);
    }
    @Step("Add Group button is clicked...")
    public WebElement AddGroupBtn() {
        screenshot();
        return driver.findElement(AddGroupBtn);
    }
    public WebElement rightswipemodules(){return driver.findElement(rightSwipeModules);}
    @Step("Inputting Student Group Name...")
    public WebElement GroupNameInput(){
        screenshot();
        return driver.findElement(GroupNameInput);
    }
    @Step("Adding Students...")
    public WebElement AddStudentsBtn(){
        screenshot();
        return driver.findElement(AddStudentsBtn);
    }
    @Step("Selecting all students...")
    public WebElement SelectAllStudents(){
        screenshot();
        return driver.findElement(SelectAllStudents);
    }
    public WebElement SelectAllStudentsSubmit(){return driver.findElement(SelectAllStudentsSubmit);}
    @Step("Saving Group...")
    public WebElement SaveGroup(){
        screenshot();
        return driver.findElement(SaveGroup);
    }
    @Step("Edited Group...")
    public WebElement UpdateGroupNameSubmit(){
        screenshot();
        return driver.findElement(UpdateGroupNameSubmit);
    }
    public List<WebElement> GroupCards(){return driver.findElements(GroupCards);}
    @Step("Searching for Student group...")
    public WebElement SearchInputBox(){
        screenshot();
        return driver.findElement(SearchInputBox);
    }
    public WebElement MoreOptionsBtn(){return driver.findElement(MoreOptionsBtn);}
    @Step("Edit Option is clicked...")
    public WebElement EditOption(){
        screenshot();
        return driver.findElement(EditOption);
    }
    @Step("Delete Option is clicked...")
    public WebElement DeleteOption(){
        screenshot();
        return driver.findElement(DeleteOption);
    }
    public WebElement DeleteConfirmationBtn(){return driver.findElement(DeleteConfirmationBtn);}
    @Step("Publish Module is opened...")
    public WebElement PublishToggle() {
        screenshot();
        return driver.findElement(PublishToggle);
    }
    public List<WebElement> ContentOptions(){return driver.findElements(ContentOptions);}
    @Step("Publish New content button is clicked...")
    public WebElement PublishNewContentBtn(){
        screenshot();
        return driver.findElement(PublishNewContentBtn);
    }
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
    @Step("Choosing group to publish...")
    public WebElement PublishToGroup(){return driver.findElement(PublishToGroup);}
    public WebElement GroupDropDown(){return driver.findElement(GroupDropDown);}
    public WebElement FinalPublishBtn(){return driver.findElement(FinalPublishBtn);}



}
