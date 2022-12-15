package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

import java.util.List;

public class LessonDelivery extends Base {
    public WebDriver driver;
    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");

    By LessonDeliveryToggle = By.id("lesson_delivery");
    By GetHeader = By.xpath("//header/div[1]/h2");

    // Grade check
    By EnglishGradeTextGrade1 = By.xpath("//div[@id='616064e79e1fe601b5ee7677']//span");
    By EnglishGradeTextGrade2 = By.xpath("//div[@id='61606c609e1fe601b5ee7690']//span");
    By EnglishGradeTextGrade3 = By.xpath("//div[@id='61606e699e1fe601b5ee7697']//span");
    By EnglishGradeTextGrade4 = By.xpath("//div[@id='616070b99e1fe601b5ee769f']//span");
    By EnglishGradeTextGrade5 = By.xpath("//div[@id='6160748b9e1fe601b5ee76a7']//span");

    // Workbook Name
    By EnvironmentalcoursebookGrade1 = By.xpath("//*[@id='61606a629e1fe601b5ee768c']/img");
    By EnglishCoursebookGrade2 = By.xpath("//*[@id='61606c609e1fe601b5ee7690']/img");
    By MathematicsCoursebookGrade3 = By.xpath("//*[@id='61606ea59e1fe601b5ee7698']/img");
    By EnglishCoursebookGrade4 = By.xpath("//*[@id='616070b99e1fe601b5ee769f']/img");
    By MathematicsCoursebookGrade5 = By.xpath("//*[@id='616074c09e1fe601b5ee76a8']/img");
    By WorkbookHeading = By.id("book_title");


    By FirstLesson = By.xpath("//*[@id='item_1']/div/div[2]");
    By SecondLesson = By.xpath("//*[@id='item_2']/div/div[2]");
    By ThirdLesson = By.xpath("//*[@id='item_3']/div/div[2]");
    By DisplayedLessonName = By.xpath("//*[contains(@class, 'lesson-info')]//h2");

    By FirstLearningPlan = By.xpath("//*[contains(@class, 'all-sessions')]/div[contains(@class,'session')][1]");
    By BackButton = By.xpath("//*[contains(@class,'back-btn')]");
    By LessonPlanOverviewBtn = By.xpath("//*[contains(@class,'lesson-plan-box')]/button");
    By LessonPlanOverviewModalHeader = By.xpath("//*[contains(@class,'modal-header')]//*[contains(@class,'modal-title')]");
    By ModalDialogBox = By.xpath("//*[contains(@class,'modal-dialog')]");

    By TeachComponent = By.xpath("//*[contains(@class,'accordion')]//*[contains(@class,'accordion-item')][1]//button");
    By ApplyComponent = By.xpath("//*[contains(@class,'accordion')]//*[contains(@class,'accordion-item')][2]//button");
    By AssessComponent = By.xpath("//*[contains(@class,'accordion')]//*[contains(@class,'accordion-item')][3]//button");
    By ReviewComponent = By.xpath("//*[contains(@class,'accordion')]//*[contains(@class,'accordion-item')][4]//button");

    By LearningPlanStatus = By.xpath("//*[contains(@class,'footer-bottom')]//*[contains(@class,'ms-auto')]");
    By LessonPlanMode = By.xpath("//*[contains(@class,'navbar')]//*[contains(@class, 'ms-auto')]//button");
    By CreateLearningPlanBtn = By.xpath("//*[contains(@class,'create-lp-btn')]");
    By LearningPlanInputs = By.xpath("//*[contains(@class,'form-control')]");
    By LearningPlanSubmitBtn = By.xpath("//*[contains(@class,'bottom-bar')]//div//button[2]");
    By CustomLearningPlans = By.xpath("//*[contains(@class,'all-sessions')]//*[contains(@class,'session ')]");
    By LearningPlans = By.xpath("//*[contains(@class, 'all-sessions')]//*[contains(@class, 'session ')]");
    By EditBtn = By.xpath("//*[contains(@class, 'edit-btn')]");
    By ConfirmDeleteBtn = By.xpath("//*[contains(@class, 'modal-footer')]//button[2]");
    By FileSelectionOptions = By.xpath("//*[contains(@class, 'file-select-btn')]/span");
    By LinkInputBox = By.xpath("//*[contains(@class, 'link-modal-body')]/input");
    By AddLinkBtn = By.xpath("//*[contains(@class, 'link-modal-footer')]/button[2]");
    By previewLink = By.xpath("//*[contains(@class, 'preview-link')]");
    By ImageFileSelectionOption = By.id("image-type");
    By PDFFileSelectionOption = By.id("pdf-type");
    By AudioFileSelectionOption = By.id("audio-type");
    By VideoFileSelectionOption = By.id("video-type");
    By FilePreview = By.xpath("//div[contains(@class, 'file-preview')]");
    By DisplayedFileFormat = By.xpath("//h6[contains(@class, 'file-preview')]");
    By LessonInfo = By.xpath("//*[contains(@class,'lesson-info')]");
    By LessonInfoKeyPoints = By.xpath("//*[contains(@class,'key-points')]");


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    public LessonDelivery(WebDriver driver2) {
        this.driver = driver2;
    }
    @Step("Student account is selected...")
    public WebElement StudentImageClick() {
        screenshot();
        return driver.findElement(StudentImageClick);
    }
    // landing page
    @Step("Fetching heading...")
    public String GetHeader(){
        screenshot();
        return driver.findElement(GetHeader).getText();
    }

    @Step("Lesson delivery Module is opened...")
    public WebElement LessonDeliveryToggle() {
        screenshot();
        return driver.findElement(LessonDeliveryToggle);
    }

    // Grade Check
    @Step("Fetching grade under Coursebooks...")
    public WebElement EnglishGradeTextGrade1(){
        screenshot();
        return driver.findElement(EnglishGradeTextGrade1);
    }
    @Step("Fetching grade under Coursebooks...")
    public WebElement EnglishGradeTextGrade2(){
        screenshot();
        return driver.findElement(EnglishGradeTextGrade2);
    }
    @Step("Fetching grade under Coursebooks...")
    public WebElement EnglishGradeTextGrade3(){
        screenshot();
        return driver.findElement(EnglishGradeTextGrade3);
    }
    @Step("Fetching grade under Coursebooks...")
    public WebElement EnglishGradeTextGrade4(){
        screenshot();
        return driver.findElement(EnglishGradeTextGrade4);
    }
    @Step("Fetching grade under Coursebooks...")
    public WebElement EnglishGradeTextGrade5(){
        screenshot();
        return driver.findElement(EnglishGradeTextGrade5);
    }

    // Workbook Name
    @Step("Opening Environmental coursebook...")
    public WebElement EnvironmentalcoursebookGrade1(){return driver.findElement(EnvironmentalcoursebookGrade1);}
    @Step("Opening English coursebook...")
    public WebElement EnglishCoursebookGrade2(){return driver.findElement(EnglishCoursebookGrade2);}
    @Step("Opening Mathematics coursebook...")
    public WebElement MathematicsCoursebookGrade3(){return driver.findElement(MathematicsCoursebookGrade3);}
    @Step("Opening English coursebook...")
    public WebElement EnglishCoursebookGrade4(){return driver.findElement(EnglishCoursebookGrade4);}
    @Step("Opening Mathematics coursebook...")
    public WebElement MathematicsCoursebookGrade5(){return driver.findElement(MathematicsCoursebookGrade5);}
    @Step("Fetching workbook heading...")
    public WebElement WorkbookHeading(){return driver.findElement(WorkbookHeading);}
    @Step("Opening first lesson...")
    public WebElement FirstLesson(){return driver.findElement(FirstLesson);}
    @Step("Opening second lesson...")
    public WebElement SecondLesson(){return driver.findElement(SecondLesson);}
    @Step("Opening third lesson...")
    public WebElement ThirdLesson(){return driver.findElement(ThirdLesson);}
    public WebElement DisplayedLessonName(){return driver.findElement(DisplayedLessonName);}
    public WebElement FirstLearningPlan(){return driver.findElement(FirstLearningPlan);}

    @Step("Back button is clicked...")
    public WebElement BackButton() {
        screenshot();
        return driver.findElement(BackButton);
    }
    @Step("Viewing lesson plan...")
    public WebElement LessonPlanOverviewBtn(){return driver.findElement(LessonPlanOverviewBtn);}

    public WebElement LessonPlanOverviewModalHeader(){return driver.findElement(LessonPlanOverviewModalHeader);}
    public WebElement ModalDialogBox(){return driver.findElement(ModalDialogBox);}

    public WebElement TeachComponent(){return driver.findElement(TeachComponent);}
    public WebElement ApplyComponent(){return driver.findElement(ApplyComponent);}
    public WebElement AssessComponent(){return driver.findElement(AssessComponent);}
    public WebElement ReviewComponent(){return driver.findElement(ReviewComponent);}
    @Step("Fetching learning plan status...")
    public WebElement LearningPlanStatus(){return driver.findElement(LearningPlanStatus);}
    public WebElement LessonPlanMode(){return driver.findElement(LessonPlanMode);}
    @Step("Creating learning plan...")
    public WebElement CreateLearningPlanBtn(){return driver.findElement(CreateLearningPlanBtn);}
    public List<WebElement> LearningPlanInputs(){return driver.findElements(LearningPlanInputs);}
    @Step("Submit learning plan...")
    public WebElement LearningPlanSubmitBtn(){return driver.findElement(LearningPlanSubmitBtn);}
    public List<WebElement> CustomLearningPlans(){return driver.findElements(CustomLearningPlans);}
    public List<WebElement> LearningPlans(){return driver.findElements(LearningPlans);}
    @Step("Editing learning plan...")
    public WebElement EditBtn(){return driver.findElement(EditBtn);}
    @Step("Deleting learning plan...")
    public WebElement DeleteBtn(){return driver.findElements(EditBtn).get(1);}
    @Step("confirm deleting learning plan...")
    public WebElement ConfirmDeleteBtn(){return driver.findElement(ConfirmDeleteBtn);}
    public List<WebElement> FileSelectionOptions(){return driver.findElements(FileSelectionOptions);}
    public WebElement LinkInputBox(){return driver.findElement(LinkInputBox);}
    @Step("Adding link...")
    public WebElement AddLinkBtn(){return driver.findElement(AddLinkBtn);}
    public WebElement previewLink(){return driver.findElement(previewLink);}
    @Step("Choosing image...")
    public WebElement ImageFileSelectionOption(){return driver.findElement(ImageFileSelectionOption);}
    @Step("Choosing PDF...")
    public WebElement PDFFileSelectionOption(){return driver.findElement(PDFFileSelectionOption);}
    @Step("Choosing Audio...")
    public WebElement AudioFileSelectionOption(){return driver.findElement(AudioFileSelectionOption);}
    @Step("Choosing video...")
    public WebElement VideoFileSelectionOption(){return driver.findElement(VideoFileSelectionOption);}
    @Step("Viewing file...")
    public WebElement FilePreview(){return driver.findElement(FilePreview);}
    public WebElement DisplayedFileFormat(){return driver.findElement(DisplayedFileFormat);}


    public WebElement LessonInfo(){return driver.findElement(LessonInfo);}
    public WebElement LessonInfoKeyPoints(){return driver.findElement(LessonInfoKeyPoints);}



}
