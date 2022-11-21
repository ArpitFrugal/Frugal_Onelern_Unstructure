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
    public WebElement leftNavigationBtn(){return driver.findElement(leftNavigationBtn);}
    public WebElement rightNavigationBtn(){return driver.findElement(rightNavigationBtn);}
    public WebElement DisplayedMonth(){return driver.findElement(DisplayedMonth);}
    public List<WebElement> ViewAllEventsHolidays(){return driver.findElements(ViewAllBtns);}
    public WebElement TemplateHeader(){return driver.findElement(TemplateHeader);}
    public WebElement EventsTab(){return driver.findElement(EventsTab);}
    public WebElement HolidaysTab(){return driver.findElement(HolidaysTab);}
    public WebElement adminTimetableToggle(){return driver.findElement(adminTimetableToggle);}
    public WebElement adminTimetableModuleHeading(){return driver.findElement(adminTimetableModuleHeading);}
    public WebElement TemplatesBtn(){return driver.findElement(TemplatesBtn);}
    public WebElement CreateTemplate(){return driver.findElement(AddBtn);}

    public WebElement templateName(){return driver.findElement(templateName);}
    public WebElement startDate(){return driver.findElement(startDate);}
    public WebElement endDate(){return driver.findElement(endDate);}
    public WebElement startTime(){return driver.findElement(startTime);}
    public WebElement endTime(){return driver.findElement(endTime);}
    public WebElement SelectWeekHoliday(){return driver.findElement(SelectWeekHoliday);}
    public WebElement Weekday(){return driver.findElement(Weekday);}
    public WebElement NextButton(){return driver.findElement(NextButton);}


    public WebElement Session1Name(){return driver.findElement(Session1Name);}
    public WebElement Session2Name(){return driver.findElement(Session2Name);}
    public WebElement Session1sessiontype(){return driver.findElement(Session1sessiontype);}
    public WebElement Session2sessiontype(){return driver.findElement(Session2sessiontype);}
    public WebElement Session1endTime(){return driver.findElement(Session1endTime);}
    public WebElement Session2endTime(){return driver.findElement(Session2endTime);}

    public WebElement AddMoreSessionsBtn(){return driver.findElement(AddMoreSessionsBtn);}
    public WebElement CreateTemplateSubmitBtn(){return driver.findElement(CreateTemplateSubmitBtn);}
    public WebElement backBtn(){return driver.findElement(backBtn);}
    public List<WebElement> TemplateCards(){return driver.findElements(TemplateCards);}
    public WebElement DeleteBtn(){return driver.findElement(DeleteBtn);}
    public WebElement ConfirmDelete(){return driver.findElement(ConfirmDelete);}
    public WebElement timetableGrades(){return driver.findElement(timetableGrades);}
    public WebElement ViewOrAddTimetableBtn(){return driver.findElement(ViewOrAddTimetableBtn);}
    public WebElement TimetableSectionName(){return driver.findElement(TimetableSectionName);}
    public WebElement CurrentPagePath(){return driver.findElement(CurrentPagePath);}
    public WebElement CreateTemplatePageHeader(){return driver.findElement(CreateTemplatePageHeader);}
    public WebElement CreateNewEvent(){return driver.findElement(AddBtn);}
    public WebElement CreateNewHoliday(){return driver.findElement(AddBtn);}
    public WebElement EventName(){return driver.findElement(EventName);}
    public WebElement CreateEventBtn(){return driver.findElement(CreateTemplateBtn);}
    public WebElement CreateHolidayBtn(){return driver.findElement(CreateHolidayBtn);}
    public List<WebElement> AllEventsName(){return driver.findElements(AllEventsName);}
    public WebElement EventsEditBtn(){return driver.findElement(EventsEditBtn);}
    public WebElement HolidaysEditBtn(){return driver.findElement(HolidaysEditBtn);}
    public WebElement EventsDeleteBtn(){return driver.findElement(EventsDeleteBtn);}
    public WebElement HolidaysDeleteBtn(){return driver.findElement(HolidaysDeleteBtn);}
    public WebElement HolidayName(){return driver.findElement(HolidayName);}
    public WebElement Holidaydesc(){return driver.findElement(Holidaydesc);}
    public List<WebElement> AllHolidaysName(){return driver.findElements(AllEventsName);}
    public WebElement HolidaySearchBox(){return driver.findElement(HolidaySearchBox);}



}
