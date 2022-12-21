package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Base;

import java.util.List;

public class Notifications extends Base {
    public WebDriver driver;
    By AssessmentToggle = By.id("assessments");
    By MyAssessmentsPage = By.xpath("//a[@href='assessments']");
    By CreateNew = By.xpath("//*[@class='add-btn']");
    By NameOfAssessmentInput = By.xpath("//input[@placeholder='Name of Assessment']");
    By AssessmentDetails = By.xpath("//select[contains(@class,'form-select')]");
    By AssessmentFormat = By.xpath("//*[contains(@class,'selectContainer')]/input");
    By AssessmentFormatOnline = By.xpath("//*[contains(@class,'listContainer')]/div[1]/div");
    By SubmitBtn = By.xpath("//*[contains(@class,'modal-footer')]/div/div/button[2]");
    By SectionBtn = By.xpath("//*[contains(@class,'section-btn')]");
    By SectionName = By.id("section");
    By SectionInstructions = By.xpath("//*[contains(@class,'fr-element')]");
    By QuestionBtn = By.xpath("//*[contains(@class,'question-btn')]");
    By MCQOption = By.xpath("//*[contains(@class,'question-selection')]/div[text()='Multiple Choice Question']");
    By FillBlanksOption = By.xpath("//*[contains(@class,'question-selection')]/div[text()='Fill in the Blanks']");
    By TrueFalseOption = By.xpath("//*[contains(@class,'question-selection')]/div[text()='True or False']");
    By MRQOption = By.xpath("//*[contains(@class,'question-selection')]/div[text()='Multiple Response Question']");
    By ShortAsnwerOption = By.xpath("//*[contains(@class,'question-selection')]/div[text()='Short Answer']");
    By ModalOverlay = By.xpath("//*[contains(@class,'modal-overlay')]");
    By QuestionInputBoxes = By.xpath("//*[contains(@class,'fr-element')]");
    By TrueOption = By.xpath("//*[contains(@class,'radio-item')]");
    By QuestionsMetadata = By.xpath("//*[contains(@class,'form-select')]");
    By AddThisQuestionBtn = By.xpath("//*[contains(@class,'single-answer')]//*[contains(@class,'bottom-fix')]//button[contains(@class,'custome-btn')]");
    By MarksInputBox = By.xpath("//*[contains(@class,'modal-header-two')]/div/div/input");
    By PassMarks = By.id("passmarks");
    By AssessmentAssignStudentsBtn = By.xpath("//*[contains(@class,'assign-students-btn')]");
    By AssessmentSelectStudentsBtn = By.xpath("//*[text()='Select Students']");
    By SelectAllStudents = By.xpath("//*[contains(@class,'modal-body')]/div/div/div[@class='']");
    By AddStudents = By.xpath("//*[contains(@class,'modal-footer')]//div/div/button[2]");
    By ScheduleBtn = By.xpath("//*[@class='bottom-fix']/div/button[2]");
    By DateInput = By.xpath("//input[@type='date']");
    By TimeInput = By.xpath("//input[@type='time']");
    By DurationInput = By.xpath("//input[@placeholder='Duration']");
    By ShowScoresAfter = By.xpath("//*[contains(@class,'form-select')]");
    By passwordInputTeacher = By.xpath("//input[@placeholder='password']");
    By instructionsInput = By.xpath("//*[contains(@id,'instruction')]/div/div");
    By HintShowOption = By.xpath("//*[contains(@class,'hint-txt')]/div/div/div");
    By PublishAssessmentBtn = By.xpath("//*[@class='bottom-fix']/div/button[2]");
    By logoutBtn = By.id("logout-btn");
    By HomepageMenuBtn = By.id("menu-btn");
    By StudentAccount = By.id("student");
    By backBtnLoginPage = By.xpath("//button[contains(@class, 'back-btn')]");
    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By notificationsStudent = By.id("notifications-student");
    By notificationsTeacher = By.id("notifications");
    By RecentNotificationInfo = By.xpath("//*[contains(@class, 'notification-card')]//*[contains(@class,'notification-description')]");
    By rightSwipeModules = By.xpath("//*[contains(@class,'card-swiper')]//button[contains(@class,'btn-right-arrow')]");
    By AssignmentsToggle = By.id("assignments");
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
    By AssignmentAssignStudentsBtn = By.xpath("//*[contains(@class,'bottom-fix')]//button[2]");
    By AssignmentSelectStudentsBtn = By.xpath("//*[contains(@class,'select-students-block')]//button");
    By SelectAllOption = By.xpath("//*[contains(@class,'modal-body')]/div[2]/div[3]/div");
    By StartEndDateInputs = By.xpath("//input");
    By FileSizeLimit = By.id("file-size-limit");
    By AttendanceToggle = By.id("attendance");

    By editAttendanceBtn = By.xpath("//*[contains(@class,'edit-attendance-button')]");
    By notMarkedTeacher = By.xpath("//*[contains(@class,'active')]//button[contains(@class,'not-marked')]");
    By totalCountTeacher = By.xpath("//*[contains(@class,'total-students')]");
    By presentCountTeacher = By.xpath("//*[contains(@class,'present-students')]");
    By absentCountTeacher = By.xpath("//*[contains(@class,'absent-students')]");
    By leaveCountTeacher = By.xpath("//*[contains(@class,'leave-students')]");
    By attendancemarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[contains(@class,'active')]/button[contains(@class,'present')]");
    By presentmarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[2]/button[contains(@class,'present')]");
    By absentmarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[2]/button[contains(@class,'absent')]");
    By leavemarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[2]/button[contains(@class,'leave')]");
    By AttendancesaveBtn = By.xpath("//button[@name='saveButton']");


    By adminTimetableToggle = By.xpath("//*[text()='Timetable']");
    By HolidaysTab = By.id("Holidays");
    By AddBtn = By.xpath("//*[contains(@class, 'add-btn')]");
    By HolidayName = By.id("holiday");
    By startDate = By.id("startDate");
    By endDate = By.id("endDate");
    By CreateHolidayBtn = By.xpath("//*[contains(@class, 'btn-create-holiday')]");
    By AllEventsName = By.xpath("//*[contains(@class, 'events-table')]//tr//td[1]");



    By EventsTab = By.id("Events");
    By EventName = By.id("eventName");
    By startTime = By.id("startTime");
    By endTime = By.id("endTime");
    By CreateEventBtn = By.xpath("//*[contains(@class, 'btn-create-template')]");



    By PublishToggle = By.id("publish");
    By PublishNewContentBtn = By.xpath("/html/body/div/button");
    By ContentOptions = By.xpath("//select[contains(@class, 'form-select')]");
    By PublishContentDescriptionTextArea = By.xpath("//*[@placeholder='Description']");
    By NextStepBtn = By.xpath("//footer/div[2]/button[2]");
    By PublishGradeSectionInput = By.xpath("//select[contains(@class,'form-select')]");
    By FinalPublishBtn = By.xpath("/html/body/footer/div[2]/button[2]");
    By DoubtsToggle = By.id("doubts");
    By AskDoubtBtn = By.xpath("//a[@href='create-doubt']");
    By QuestionTextBox = By.xpath("//*[contains(@class,'fr-wrapper')]/div");




    public Notifications(WebDriver driver2) { this.driver = driver2;}
    @Step("Assessment Module is opened...")
    public WebElement AssessmentToggle() { return driver.findElement(AssessmentToggle);}

    @Step("Clicking on My Assessments...")
    public WebElement MyAssessmentsPage(){ return driver.findElement(MyAssessmentsPage);}

    @Step("Create new button is clicked...")
    public WebElement CreateNew(){ return driver.findElement(CreateNew);}
    @Step("Giving input for name of assessment...")
    public WebElement NameOfAssessmentInput(){ return driver.findElement(NameOfAssessmentInput);}
    @Step("Selecting details for assessment...")
    public List<WebElement> AssessmentDetails(){ return driver.findElements(AssessmentDetails);}
    @Step("Choosing format for assessment...")
    public WebElement AssessmentFormat(){ return driver.findElement(AssessmentFormat);}
    @Step("Choosing Online mode of assessment...")
    public WebElement AssessmentFormatOnline(){ return driver.findElement(AssessmentFormatOnline);}
    @Step("Submitting Assessment details...")
    public WebElement SubmitBtn(){ return driver.findElement(SubmitBtn);}
    @Step("Adding Section in assessment...")
    public WebElement SectionBtn(){ return driver.findElement(SectionBtn);}
    @Step("Entering Section name...")
    public WebElement SectionName(){ return driver.findElement(SectionName);}
    @Step("Entering Section instructions...")
    public WebElement SectionInstructions(){ return driver.findElement(SectionInstructions);}
    @Step("Add new question...")
    public WebElement QuestionBtn(){ return driver.findElement(QuestionBtn);}
    @Step("Choosing MCQ option for question type...")
    public WebElement MCQOption(){ return driver.findElement(MCQOption);}
    @Step("Choosing Fill in the blanks option for question type...")
    public WebElement FillBlanksOption(){ return driver.findElement(FillBlanksOption);}
    @Step("Choosing true or false option for question type...")
    public WebElement TrueFalseOption(){ return driver.findElement(TrueFalseOption);}
    @Step("Choosing Multiple Response option for question type...")
    public WebElement MRQOption(){ return driver.findElement(MRQOption);}
    @Step("Choosing Short answer option for question type...")
    public WebElement ShortAnswerOption(){ return driver.findElement(ShortAsnwerOption);}

    public WebElement ModalOverlay(){return driver.findElement(ModalOverlay);}
    public List<WebElement> QuestionInputBoxes(){return driver.findElements(QuestionInputBoxes);}
    public WebElement TrueOption(){return driver.findElement(TrueOption);}
    public List<WebElement> QuestionsMetadata(){return driver.findElements(QuestionsMetadata);}
    @Step("Created question...")
    public WebElement AddThisQuestionBtn(){ return driver.findElement(AddThisQuestionBtn);}
    @Step("Assigning marks to the question...")
    public WebElement MarksInputBox(){ return driver.findElement(MarksInputBox);}
    @Step("Fetching pass marks...")
    public WebElement PassMarks(){return driver.findElement(PassMarks);}
    @Step("Clicking on assign students btn...")
    public WebElement AssessmentAssignStudentsBtn(){return driver.findElement(AssessmentAssignStudentsBtn);}
    public WebElement AssessmentSelectStudentsBtn(){return driver.findElement(AssessmentSelectStudentsBtn);}
    public WebElement SelectAllStudents(){return driver.findElement(SelectAllStudents);}
    @Step("Confirming added students...")
    public WebElement AddStudents(){return driver.findElement(AddStudents);}
    @Step("Schedule button is clicked...")
    public WebElement ScheduleBtn(){return driver.findElement(ScheduleBtn);}
    @Step("Entering date...")
    public WebElement DateInput(){return driver.findElement(DateInput);}
    @Step("Entering time...")
    public WebElement TimeInput(){return driver.findElement(TimeInput);}
    @Step("Entering duration...")
    public WebElement DurationInput(){return driver.findElement(DurationInput);}
    public WebElement ShowScoresAfter(){return driver.findElement(ShowScoresAfter);}
    @Step("Entering password...")
    public WebElement passwordInputTeacher(){return driver.findElement(passwordInputTeacher);}
    @Step("Entering instructions...")
    public WebElement instructionsInput(){return driver.findElement(instructionsInput);}
    @Step("choosing hint to show or hide...")
    public WebElement HintShowOption(){return driver.findElement(HintShowOption);}
    @Step("Publish assessment button is clicked...")
    public WebElement PublishAssessmentBtn(){return driver.findElement(PublishAssessmentBtn);}
    @Step("Logging out...")
    public WebElement logoutBtn(){ return driver.findElement(logoutBtn);}
    @Step("Opening Menu...")
    public WebElement HomepageMenuBtn(){ return driver.findElement(HomepageMenuBtn);}
    @Step("Student account is selected...")
    public WebElement StudentAccount(){ return driver.findElement(StudentAccount);}
    @Step("Back button is clicked...")
    public WebElement backBtnLoginPage(){ return driver.findElement(backBtnLoginPage);}
    @Step("Student account is selected...")
    public WebElement StudentImageClick() { return driver.findElement(StudentImageClick);}
    @Step("Clicking on notifications button...")
    public WebElement notificationsStudent(){ return driver.findElement(notificationsStudent);}
    @Step("Clicking on notifications button...")
    public WebElement notificationsTeacher(){ return driver.findElement(notificationsTeacher);}
    @Step("Fetching notification title of most recent notification...")
    public WebElement RecentNotificationInfo(){ return driver.findElement(RecentNotificationInfo);}
    public WebElement rightswipemodules(){return driver.findElement(rightSwipeModules);}
    @Step("Opening assignments module...")
    public WebElement AssignmentsToggle() { return driver.findElement(AssignmentsToggle);}
    @Step("Creating new assignment...")
    public WebElement CreateNewBtn(){return driver.findElement(CreateNewBtn);}
    public WebElement AssignmentName(){return driver.findElement(AssignmentName);}
    public WebElement AssignmentSubject(){return driver.findElement(AssignmentSubject);}
    public WebElement AssignmentRewardType(){return driver.findElement(AssignmentRewardType);}
    public WebElement AssignmentType(){return driver.findElement(AssignmentType);}
    public WebElement AssignmentDetailsSubmitBtn(){return driver.findElement(AssignmentDetailsSubmitBtn);}
    public WebElement QuestionDescription(){return driver.findElement(QuestionDescription);}
    @Step("Attaching link...")
    public WebElement AttachLink(){return driver.findElement(AttachLink);}
    public WebElement LinkInputBox(){return driver.findElement(LinkInputBox);}
    @Step("Adding link...")
    public WebElement AddLinkSubmit(){return driver.findElement(AssignmentDetailsSubmitBtn);}
    public List<WebElement> FileTypes(){return driver.findElements(FileTypes);}
    @Step("Assigning students...")
    public WebElement AssignmentAssignStudentsBtn(){return driver.findElement(AssignmentAssignStudentsBtn);}
    @Step("Selecting students...")
    public WebElement AssignmentSelectStudentsBtn(){return driver.findElement(AssignmentSelectStudentsBtn);}
    public WebElement SelectAllOption(){return driver.findElement(SelectAllOption);}
    @Step("Adding students...")
    public WebElement AddStudentsBtn(){return driver.findElement(AssignmentDetailsSubmitBtn);}
    @Step("Scheduling assignment...")
//    public WebElement ScheduleBtn(){return driver.findElement(AssessmentAssignStudentsBtn);}
    public WebElement StartDateInputBox(){return driver.findElements(StartEndDateInputs).get(3);}
    public WebElement EndDateInputBox(){return driver.findElements(StartEndDateInputs).get(4);}
    @Step("Publishing the assignment...")
    public WebElement PublishBtn(){return driver.findElement(AssignmentAssignStudentsBtn);}
    public WebElement FileSizeLimit(){return driver.findElement(FileSizeLimit);}

    @Step("Doubts Module is opened...")
    public WebElement AttendanceToggle() { return driver.findElement(AttendanceToggle);}




    @Step("Clicked on edit attendance button...")
    public WebElement editAttendanceBtn(){ return driver.findElement(editAttendanceBtn);}
    @Step("Fetching not marked students for selected day...")
    public List<WebElement> notMarkedTeacher(){ return driver.findElements(notMarkedTeacher);}
    @Step("Fetching total number of students in the class...")
    public WebElement totalCountTeacher(){ return driver.findElement(totalCountTeacher);}
    @Step("Fetching number of days present count...")
    public WebElement presentCountTeacher(){ return driver.findElement(presentCountTeacher);}
    @Step("Fetching number of days absent count...")
    public WebElement absentCountTeacher(){ return driver.findElement(absentCountTeacher);}
    @Step("Fetching number of days leave count...")
    public WebElement leaveCountTeacher(){ return driver.findElement(leaveCountTeacher);}
    @Step("Option for marking attendance is clicked...")
    public WebElement attendancemarkoption(){ return driver.findElement(attendancemarkoption);}
    @Step("Option for marking present is clicked...")
    public WebElement presentmarkoption(){ return driver.findElement(presentmarkoption);}
    @Step("Option for marking absent is clicked...")
    public WebElement absentmarkoption(){ return driver.findElement(absentmarkoption);}
    @Step("Option for marking leave is clicked...")
    public WebElement leavemarkoption(){ return driver.findElement(leavemarkoption);}
    @Step("Save button is clicked...")
    public WebElement AttendancesaveBtn(){ return driver.findElement(AttendancesaveBtn);}




    public WebElement adminTimetableToggle(){return driver.findElement(adminTimetableToggle);}
    @Step("Switching to holidays tab...")
    public WebElement HolidaysTab(){return driver.findElement(HolidaysTab);}
    @Step("Create new holiday...")
    public WebElement CreateNewHoliday(){return driver.findElement(AddBtn);}
    @Step("Entering holiday name...")
    public WebElement HolidayName(){return driver.findElement(HolidayName);}
    @Step("Entering Start date...")
    public WebElement startDate(){return driver.findElement(startDate);}
    @Step("Entering End date...")
    public WebElement endDate(){return driver.findElement(endDate);}
    @Step("submitting holiday...")
    public WebElement CreateHolidayBtn(){return driver.findElement(CreateHolidayBtn);}
    public List<WebElement> AllHolidaysName(){return driver.findElements(AllEventsName);}




    @Step("Switching to events tab...")
    public WebElement EventsTab(){return driver.findElement(EventsTab);}
    @Step("Creating new event...")
    public WebElement CreateNewEvent(){return driver.findElement(AddBtn);}
    @Step("Entering event name...")
    public WebElement EventName(){return driver.findElement(EventName);}
    @Step("Entering Start time...")
    public WebElement startTime(){return driver.findElement(startTime);}
    @Step("Entering End time...")
    public WebElement endTime(){return driver.findElement(endTime);}
    @Step("Submitting event...")
    public WebElement CreateEventBtn(){return driver.findElement(CreateEventBtn);}




    @Step("Publish Module is opened...")
    public WebElement PublishToggle() { return driver.findElement(PublishToggle);}
    @Step("Publish New content button is clicked...")
    public WebElement PublishNewContentBtn(){ return driver.findElement(PublishNewContentBtn);}
    public List<WebElement> ContentOptions(){return driver.findElements(ContentOptions);}
    @Step("Publish Content description is added...")
    public WebElement PublishContentDescriptionTextArea(){ return driver.findElement(PublishContentDescriptionTextArea);}
    @Step("Next Step button is clicked...")
    public WebElement NextStepBtn(){ return driver.findElement(NextStepBtn);}
    public List<WebElement> PublishGradeSectionInput(){return driver.findElements(PublishGradeSectionInput);}
    @Step("Final Publish button is clicked...")
    public WebElement FinalPublishBtn(){ return driver.findElement(FinalPublishBtn);}

    @Step("Doubts Module is opened...")
    public WebElement DoubtsToggle() { return driver.findElement(DoubtsToggle);}
    @Step("Ask a doubt button is clicked...")
    public WebElement AskDoubtBtn(){ return driver.findElement(AskDoubtBtn);}
    public WebElement QuestionTextBox(){return driver.findElement(QuestionTextBox);}

    By DoubtsSubmitBtn = By.xpath("//*[contains(@class, 'btn-section')]/button[2]");
    @Step("Submit button is clicked...")
    public WebElement DoubtsSubmitBtn(){ return driver.findElement(DoubtsSubmitBtn);}
}
