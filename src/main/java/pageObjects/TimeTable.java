package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Base;

import java.util.List;

public class TimeTable extends Base {
    public WebDriver driver;

    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By rightSwipeModules = By.xpath("//*[contains(@class,'card-swiper')]//button[contains(@class,'btn-right-arrow')]");

    By studentTimeTableToggle = By.id("Timetable");
    By teacherTimeTableToggle = By.id("Planner");
    By GetHeader = By.xpath("//*[contains(@class, 'template-header')]/span[2]");

    // pagination
    By leftNavigationBtn = By.xpath("//*[contains(@class, 'navigation-controls')]/span[1]");
    By rightNavigationBtn = By.xpath("//*[contains(@class, 'navigation-controls')]/span[2]");
    By DisplayedMonth = By.xpath("//*[contains(@class, 'month')]");
    By ViewAllBtns = By.xpath("//*[contains(@class, 'upcoming-events')]//a");
    By TemplateHeader = By.xpath("//*[contains(@class, 'template-header')]");
    By EventsTab = By.id("Events");
    By HolidaysTab = By.id("Holidays");
    By adminTimetableToggle = By.xpath("//*[text()='Timetable']");
    By adminTimetableModuleHeading = By.xpath("//*[contains(@class, 'timetable')]/span");
    By TemplatesBtn = By.xpath("//*[contains(@class, 'btn-templates')]");
    By AddBtn = By.xpath("//*[contains(@class, 'add-btn')]");
    By templateName = By.id("templateName");
    By startDate = By.id("startDate");
    By endDate = By.id("endDate");
    By startTime = By.id("startTime");
    By endTime = By.id("endTime");
    By SelectWeekHoliday = By.xpath("//*[contains(@placeholder, 'Select')]");
    By Weekday = By.xpath("//*[contains(@class, 'listContainer')]/*[contains(@class, 'listItem')]");
    By NextButton = By.xpath("//*[contains(text(), 'Next')]");

    // sessions
    By Session1Name = By.xpath("//*[contains(@class, 'session-entries')]//*[contains(@class, 'row')][1]//*[contains(@class, 'form-group')][1]//input");
    By Session2Name = By.xpath("//*[contains(@class, 'session-entries')]//*[contains(@class, 'row')][2]//*[contains(@class, 'form-group')][1]//input");

    By Session1sessiontype = By.xpath("//*[contains(@class, 'session-entries')]//*[contains(@class, 'row')][1]//*[contains(@class, 'form-group')][2]//select");
    By Session2sessiontype = By.xpath("//*[contains(@class, 'session-entries')]//*[contains(@class, 'row')][2]//*[contains(@class, 'form-group')][2]//select");

    By Session1endTime = By.xpath("//*[contains(@class, 'session-entries')]//*[contains(@class, 'row')][1]//*[contains(@class, 'form-group')][4]//input");
    By Session2endTime = By.xpath("//*[contains(@class, 'session-entries')]//*[contains(@class, 'row')][2]//*[contains(@class, 'form-group')][4]//input");

    By AddMoreSessionsBtn = By.xpath("//*[contains(@class, 'add-more')]");
    By CreateTemplateSubmitBtn = By.xpath("//button[contains(@class, 'create-template')]");
    By backBtn = By.xpath("//*[contains(@class, 'arrow-container')]");
    By TemplateCards = By.xpath("//*[contains(@class, 'template-card')]");
    By DeleteBtn = By.id("drop-down-button");
    By ConfirmDelete = By.xpath("//*[contains(@class, 'btn-delete')]");
    By timetableGrades = By.xpath("//*[contains(@class, 'grades-under-timetable')]/div/div");
    By ViewOrAddTimetableBtn = By.xpath("//*[contains(@class, 'card-body')]//button");
    By TimetableSectionName = By.xpath("//*[contains(@class, 'title-block')]");
    By CurrentPagePath = By.xpath("//*[contains(@class, 'bredcrumb')]");
    By CreateTemplatePageHeader = By.xpath("//*[contains(@class, 'create-template-label')]");
    By EventName = By.id("eventName");
    By CreateTemplateBtn = By.xpath("//*[contains(@class, 'btn-create-template')]");
    By CreateHolidayBtn = By.xpath("//*[contains(@class, 'btn-create-holiday')]");
    By AllEventsName = By.xpath("//*[contains(@class, 'events-table')]//tr//td[1]");
    By EventsEditBtn = By.xpath("//*[contains(@class, 'dropdown')]//ul//li[1]//button");
    By HolidaysEditBtn = By.xpath("//*[contains(@class, 'dropdown-menu')]//li[1]//button");
    By HolidaysDeleteBtn = By.xpath("//*[contains(@class, 'dropdown-menu')]//li[2]//button");
    By EventsDeleteBtn = By.xpath("//*[contains(@class, 'dropdown')]//ul//li[2]//button");
    By HolidayName = By.id("holiday");
    By Holidaydesc = By.id("about_holiday");
    By HolidaySearchBox = By.xpath("//*[@type='search']");



    public TimeTable(WebDriver driver2) {
        this.driver = driver2;
    }

    @Step("Student account is selected...")
    public WebElement StudentImageClick() {
        return driver.findElement(StudentImageClick);
    }

    @Step("Analytics Module is opened...")
    public WebElement studentTimeTableToggle() {
        return driver.findElement(studentTimeTableToggle);
    }
    @Step("Analytics Module is opened...")
    public WebElement teacherTimeTableToggle() {
        return driver.findElement(teacherTimeTableToggle);
    }

    // landing page
    @Step("Fetching heading...")
    public String GetHeader(){
        return driver.findElement(GetHeader).getText();
    }

    public WebElement rightswipemodules(){return driver.findElement(rightSwipeModules);}
    @Step("Paginating to previous page...")
    public WebElement leftNavigationBtn(){return driver.findElement(leftNavigationBtn);}
    @Step("Paginating to next page...")
    public WebElement rightNavigationBtn(){return driver.findElement(rightNavigationBtn);}
    public WebElement DisplayedMonth(){return driver.findElement(DisplayedMonth);}
    @Step("Viewing all events and holidays...")
    public List<WebElement> ViewAllEventsHolidays(){return driver.findElements(ViewAllBtns);}
    public WebElement TemplateHeader(){return driver.findElement(TemplateHeader);}

    @Step("Switching to events tab...")
    public WebElement EventsTab(){return driver.findElement(EventsTab);}
    @Step("Switching to holidays tab...")
    public WebElement HolidaysTab(){return driver.findElement(HolidaysTab);}
    public WebElement adminTimetableToggle(){return driver.findElement(adminTimetableToggle);}
    public WebElement adminTimetableModuleHeading(){return driver.findElement(adminTimetableModuleHeading);}
    @Step("Opening templates section...")
    public WebElement TemplatesBtn(){return driver.findElement(TemplatesBtn);}
    @Step("Creating template...")
    public WebElement CreateTemplate(){return driver.findElement(AddBtn);}
    @Step("Entering template name...")
    public WebElement templateName(){return driver.findElement(templateName);}
    @Step("Entering Start date...")
    public WebElement startDate(){return driver.findElement(startDate);}
    @Step("Entering End date...")
    public WebElement endDate(){return driver.findElement(endDate);}
    @Step("Entering Start time...")
    public WebElement startTime(){return driver.findElement(startTime);}
    @Step("Entering End time...")
    public WebElement endTime(){return driver.findElement(endTime);}
    @Step("Selecting weekly holiday day...")
    public WebElement SelectWeekHoliday(){return driver.findElement(SelectWeekHoliday);}
    public WebElement Weekday(){return driver.findElement(Weekday);}
    @Step("Clicking next button...")
    public WebElement NextButton(){return driver.findElement(NextButton);}

    public WebElement Session1Name(){return driver.findElement(Session1Name);}
    public WebElement Session2Name(){return driver.findElement(Session2Name);}
    public WebElement Session1sessiontype(){return driver.findElement(Session1sessiontype);}
    public WebElement Session2sessiontype(){return driver.findElement(Session2sessiontype);}
    public WebElement Session1endTime(){return driver.findElement(Session1endTime);}
    public WebElement Session2endTime(){return driver.findElement(Session2endTime);}
    @Step("Clicking on add more sessions button...")
    public WebElement AddMoreSessionsBtn(){return driver.findElement(AddMoreSessionsBtn);}
    @Step("Clicking on create template submit button...")
    public WebElement CreateTemplateSubmitBtn(){return driver.findElement(CreateTemplateSubmitBtn);}
    @Step("Clicking on back button...")
    public WebElement backBtn(){return driver.findElement(backBtn);}
    public List<WebElement> TemplateCards(){return driver.findElements(TemplateCards);}
    @Step("Clicking on delete button...")
    public WebElement DeleteBtn(){return driver.findElement(DeleteBtn);}
    @Step("Confirming delete...")
    public WebElement ConfirmDelete(){return driver.findElement(ConfirmDelete);}
    public WebElement timetableGrades(){return driver.findElement(timetableGrades);}
    public WebElement ViewOrAddTimetableBtn(){return driver.findElement(ViewOrAddTimetableBtn);}
    public WebElement TimetableSectionName(){return driver.findElement(TimetableSectionName);}
    @Step("Fetching current page path...")
    public WebElement CurrentPagePath(){return driver.findElement(CurrentPagePath);}
    public WebElement CreateTemplatePageHeader(){return driver.findElement(CreateTemplatePageHeader);}
    @Step("Creating new event...")
    public WebElement CreateNewEvent(){return driver.findElement(AddBtn);}
    @Step("Create new holiday...")
    public WebElement CreateNewHoliday(){return driver.findElement(AddBtn);}
    @Step("Entering event name...")
    public WebElement EventName(){return driver.findElement(EventName);}
    @Step("Submitting event...")
    public WebElement CreateEventBtn(){return driver.findElement(CreateTemplateBtn);}
    @Step("submitting holiday...")
    public WebElement CreateHolidayBtn(){return driver.findElement(CreateHolidayBtn);}
    public List<WebElement> AllEventsName(){return driver.findElements(AllEventsName);}
    @Step("Editing events...")
    public WebElement EventsEditBtn(){return driver.findElement(EventsEditBtn);}
    @Step("Editing holidays...")
    public WebElement HolidaysEditBtn(){return driver.findElement(HolidaysEditBtn);}
    @Step("Deleting events...")
    public WebElement EventsDeleteBtn(){return driver.findElement(EventsDeleteBtn);}
    @Step("Deleting holidays...")
    public WebElement HolidaysDeleteBtn(){return driver.findElement(HolidaysDeleteBtn);}
    @Step("Entering holiday name...")
    public WebElement HolidayName(){return driver.findElement(HolidayName);}
    @Step("Entering holiday description...")
    public WebElement Holidaydesc(){return driver.findElement(Holidaydesc);}
    public List<WebElement> AllHolidaysName(){return driver.findElements(AllEventsName);}
    @Step("Searching holiday...")
    public WebElement HolidaySearchBox(){return driver.findElement(HolidaySearchBox);}


}
