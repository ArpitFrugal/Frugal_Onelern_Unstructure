package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

import java.util.List;

public class Assessment extends Base {
    public WebDriver driver;

    By StudentAccount = By.id("student");
    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By AssessmentToggle = By.id("assessments");
    By GetHeader = By.xpath("//header/div/div[1]/span");
    By MyAssessmentsPage = By.xpath("//a[@href='assessments']");
    By CreateNew = By.xpath("//*[@class='add-btn']");
    By NameOfAssessmentInput = By.xpath("//input[@placeholder='Name of Assessment']");
    By AssessmentDetails = By.xpath("//select[contains(@class,'form-select')]");
    By AssessmentFormat = By.xpath("//*[contains(@class,'selectContainer')]/input");
    By AssessmentFormatOnline = By.xpath("//*[contains(@class,'listContainer')]/div[1]/div");
    By AssessmentFormatPenPaper = By.xpath("//*[contains(@class,'listContainer')]/div[2]/div");
    By SubmitBtn = By.xpath("//*[contains(@class,'modal-footer')]/div/div/button[2]");
    By SectionBtn = By.xpath("//*[contains(@class,'section-btn')]");
    By SectionName = By.id("section");
    By SectionInstructions = By.xpath("//*[contains(@class,'fr-element')]");
    By QuestionBtn = By.xpath("//*[contains(@class,'question-btn')]");
    By TrueFalseOption = By.xpath("//*[contains(@class,'question-selection')]/div[text()='True or False']");
    By ShortAsnwerOption = By.xpath("//*[contains(@class,'question-selection')]/div[text()='Short Answer']");
    By ModalOverlay = By.xpath("//*[contains(@class,'modal-overlay')]");
    By QuestionInputBoxes = By.xpath("//*[contains(@class,'fr-element')]");
    By TrueOption = By.xpath("//*[contains(@class,'radio-item')]");
    By QuestionsMetadata = By.xpath("//*[contains(@class,'form-select')]");
    By AddThisQuestionBtn = By.xpath("//*[contains(@class,'bottom-fix')]//button[contains(@class,'custome-btn')]");
    By MarksInputBox = By.xpath("//*[contains(@class,'modal-header-two')]/div/div/input");
    By PassMarks = By.id("passmarks");
    By AssignStudentsBtn = By.xpath("//*[contains(@class,'assign-students-btn')]");
    By SelectStudentsBtn = By.xpath("//*[text()='Select Students']");
    By SelectAllStudents = By.xpath("//*[contains(@class,'modal-body')]/div/div/div[@class='']");
    By AddStudents = By.xpath("//*[contains(@class,'modal-footer')]//div/div/button[2]");
    By ScheduleBtn = By.xpath("//*[@class='bottom-fix']/div/button[2]");
    By DateInput = By.xpath("//input[@type='date']");
    By TimeInput = By.xpath("//input[@type='time']");
    By DurationInput = By.xpath("//input[@placeholder='Duration']");
    By ShowScoresAfter = By.xpath("//*[contains(@class,'form-select')]");
    By passwordInputTeacher = By.xpath("//input[@placeholder='password']");
    By instructionsInput = By.xpath("//*[contains(@class,'form-box')]//textarea");
    By HintShowOption = By.xpath("//*[contains(@class,'hint-txt')]/div/div/div");
    By PublishAssessmentBtn = By.xpath("//*[@class='bottom-fix']/div/button[2]");
    By FirstAssessmentDisplayedTeacher = By.xpath("//*[contains(@class,'d-flex')]//h1");
    By AssessmentsSearch = By.xpath("//input[@aria-label='Search']");
    By FirstAssessmentDisplayedStudent = By.xpath("//button[contains(@class,'assessment-btn')]");
    By StartAssessmentBtn = By.xpath("//div[contains(@class,'footer')]//button");
    By PasswordInputStudent = By.id("password");
    By PasswordSubmitBtnStudent = By.xpath("//div[contains(@class,'modal-footer')]//button");
    By NextQuestionBtn = By.xpath("//*[contains(@class,'btn-next')]");
    By TrueOptionAnswer = By.xpath("//*[contains(@class,'exam-section')]//label");
    By AssessmentSubmitBtn = By.xpath("//*[contains(@class,'submit-btn')]");
    By FinalSubmitAssessment = By.id("submitAssessment");
    By ModuleHeading = By.xpath("//*[contains(@class,'top-div')]//h1");
    By ViewAnswersKey = By.xpath("//*[contains(@class,'report-section')]/div/div/button");
    By PrintReportBtn = By.xpath("//button[contains(@class,'print-btn')]");
    By PrintPreviewBtn = By.xpath("//div[@class='controls']/cr-button");

    By HomepageMenuBtn = By.id("menu-btn");
    By logoutBtn = By.id("logout-btn");
    By backBtnLoginPage = By.xpath("//button[contains(@class, 'back-btn')]");
    By questionPaperPreview = By.id("pdf_body");
    By CompletedTabPage = By.xpath("//a[text()='Completed']");
    By DraftsTabPage = By.xpath("//a[text()='Drafts']");
    By OngoingTabPage = By.xpath("//a[text()='Ongoing']");
    By EvaluateAssess = By.xpath("//a[text()='Evaluate']");
    By EvaluatePaper = By.xpath("//button[contains(@class,'evaluate-btn')]");
    By QuestionByQuestion = By.xpath("//*[contains(text(),'Question by Question')]");
    By AssessmentCards = By.xpath("//*[contains(@class,'assessment-card')]");
    By DraftPublishBtn = By.xpath("//*[contains(@class,'assessment-btn')]");
    By OutsideEditBtnDrafts = By.xpath("//a[text()='Edit']");
    By deleteDraft = By.xpath("//*[contains(text(),'Delete')]");
    By StatusTagOnAssessment = By.xpath("//*[contains(@class,'due-take-test')]//div/label");


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    public Assessment(WebDriver driver2) {
        this.driver = driver2;
    }
    @Step("Student account is selected...")
    public WebElement StudentImageClick() {
        screenshot();
        return driver.findElement(StudentImageClick);
    }
    @Step("Assessment Module is opened...")
    public WebElement AssessmentToggle() {
        screenshot();
        return driver.findElement(AssessmentToggle);
    }
    @Step("Fetching heading...")
    public WebElement GetHeader(){
        screenshot();
        return driver.findElement(GetHeader);
    }
    @Step("Clicking on My Assessments...")
    public WebElement MyAssessmentsPage(){
        screenshot();
        return driver.findElement(MyAssessmentsPage);
    }
    @Step("Create new button is clicked...")
    public WebElement CreateNew(){
        screenshot();
        return driver.findElement(CreateNew);
    }
    @Step("Giving input for name of assessment...")
    public WebElement NameOfAssessmentInput(){
        screenshot();
        return driver.findElement(NameOfAssessmentInput);
    }
    @Step("Selecting details for assessment...")
    public List<WebElement> AssessmentDetails(){
        screenshot();
        return driver.findElements(AssessmentDetails);
    }
    @Step("Choosing format for assessment...")
    public WebElement AssessmentFormat(){
        screenshot();
        return driver.findElement(AssessmentFormat);
    }
    @Step("Choosing Online mode of assessment...")
    public WebElement AssessmentFormatOnline(){
        screenshot();
        return driver.findElement(AssessmentFormatOnline);
    }
    @Step("Choosing Pen & Paper mode of assessment...")
    public WebElement AssessmentFormatPenPaper(){
        screenshot();
        return driver.findElement(AssessmentFormatPenPaper);
    }
    @Step("Submitting Assessment details...")
    public WebElement SubmitBtn(){
        screenshot();
        return driver.findElement(SubmitBtn);
    }
    @Step("Adding Section in assessment...")
    public WebElement SectionBtn(){
        screenshot();
        return driver.findElement(SectionBtn);
    }
    @Step("Entering Section name...")
    public WebElement SectionName(){
        screenshot();
        return driver.findElement(SectionName);
    }
    @Step("Entering Section instructions...")
    public WebElement SectionInstructions(){
        screenshot();
        return driver.findElement(SectionInstructions);
    }
    @Step("Add new question...")
    public WebElement QuestionBtn(){
        screenshot();
        return driver.findElement(QuestionBtn);
    }
    @Step("Choosing true or false option for question type...")
    public WebElement TrueFalseOption(){
        screenshot();
        return driver.findElement(TrueFalseOption);
    }
    @Step("Choosing Short answer option for question type...")
    public WebElement ShortAsnwerOption(){
        screenshot();
        return driver.findElement(ShortAsnwerOption);
    }

    public WebElement ModalOverlay(){return driver.findElement(ModalOverlay);}
    public List<WebElement> QuestionInputBoxes(){return driver.findElements(QuestionInputBoxes);}
    public WebElement TrueOption(){return driver.findElement(TrueOption);}
    public List<WebElement> QuestionsMetadata(){return driver.findElements(QuestionsMetadata);}
    @Step("Created question...")
    public WebElement AddThisQuestionBtn(){
        screenshot();
        return driver.findElement(AddThisQuestionBtn);
    }
    @Step("Assigning marks to the question...")
    public WebElement MarksInputBox(){
        screenshot();
        return driver.findElement(MarksInputBox);
    }
    public WebElement PassMarks(){return driver.findElement(PassMarks);}
    public WebElement AssignStudentsBtn(){return driver.findElement(AssignStudentsBtn);}
    public WebElement SelectStudentsBtn(){return driver.findElement(SelectStudentsBtn);}
    public WebElement SelectAllStudents(){return driver.findElement(SelectAllStudents);}
    public WebElement AddStudents(){return driver.findElement(AddStudents);}
    public WebElement ScheduleBtn(){return driver.findElement(ScheduleBtn);}
    public WebElement DateInput(){return driver.findElement(DateInput);}
    public WebElement TimeInput(){return driver.findElement(TimeInput);}
    public WebElement DurationInput(){return driver.findElement(DurationInput);}
    public WebElement ShowScoresAfter(){return driver.findElement(ShowScoresAfter);}
    public WebElement passwordInputTeacher(){return driver.findElement(passwordInputTeacher);}
    public WebElement instructionsInput(){return driver.findElement(instructionsInput);}
    public WebElement HintShowOption(){return driver.findElement(HintShowOption);}
    public WebElement PublishAssessmentBtn(){return driver.findElement(PublishAssessmentBtn);}
    public WebElement FirstAssessmentDisplayedTeacher(){return driver.findElements(FirstAssessmentDisplayedTeacher).get(1);}
    public WebElement AssessmentsSearch(){return driver.findElement(AssessmentsSearch);}
    public WebElement FirstAssessmentDisplayedStudent(){return driver.findElements(FirstAssessmentDisplayedStudent).get(0);}
    public WebElement StartAssessmentBtn(){return driver.findElement(StartAssessmentBtn);}
    public WebElement PasswordInputStudent(){return driver.findElement(PasswordInputStudent);}
    public WebElement PasswordSubmitBtnStudent(){return driver.findElement(PasswordSubmitBtnStudent);}
    public WebElement NextQuestionBtn(){return driver.findElement(NextQuestionBtn);}
    public WebElement TrueOptionAnswer(){return driver.findElement(TrueOptionAnswer);}
    public WebElement AssessmentSubmitBtn(){return driver.findElement(AssessmentSubmitBtn);}
    public WebElement FinalSubmitAssessment(){return driver.findElement(FinalSubmitAssessment);}
    public WebElement ModuleHeading(){return driver.findElement(ModuleHeading);}
    public WebElement ViewAnswersKey(){return driver.findElement(ViewAnswersKey);}
    public WebElement PrintReportBtn(){return driver.findElement(PrintReportBtn);}
    public WebElement PrintPreviewBtn(){return driver.findElement(PrintPreviewBtn);}
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
    @Step("Student account is selected...")
    public WebElement StudentAccount(){
        screenshot();
        return driver.findElement(StudentAccount);
    }
    public WebElement questionPaperPreview(){return driver.findElement(questionPaperPreview);}
    public WebElement CompletedTabPage(){return driver.findElement(CompletedTabPage);}
    public WebElement DraftsTabPage(){return driver.findElement(DraftsTabPage);}
    public WebElement OngoingTabPage(){return driver.findElement(OngoingTabPage);}
    public WebElement EvaluateAssess(){return driver.findElement(EvaluateAssess);}
    public WebElement EvaluatePaper(){return driver.findElement(EvaluatePaper);}
    public WebElement QuestionByQuestion(){return driver.findElement(QuestionByQuestion);}
    public List<WebElement> AssessmentCards(){return driver.findElements(AssessmentCards);}
    public List<WebElement> DraftPublishBtn(){return driver.findElements(DraftPublishBtn);}
    public WebElement OutsideEditBtnDrafts(){return driver.findElement(OutsideEditBtnDrafts);}
    public WebElement deleteDraft(){return driver.findElement(deleteDraft);}
    public List<WebElement> StatusTagOnAssessment(){return driver.findElements(StatusTagOnAssessment);}


}
