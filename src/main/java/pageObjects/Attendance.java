package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

import java.util.List;

public class Attendance extends Base {
    public WebDriver driver;
    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By AttendanceToggle = By.id("attendance");
    By GetHeader = By.xpath("//header/div/div[1]/span");
    By presentMarksStudent = By.xpath("//*[contains(@class,'present ')]");
    By absentMarksStudent = By.xpath("//*[contains(@class,'absent ')]");
    By leaveMarksStudent = By.xpath("//*[contains(@class,' leave ')]");
    By holidayMarksStudent = By.xpath("//*[contains(@class,'holiday ')]");
    By heldCountStudent = By.xpath("//*[contains(@class, 'held-tag')]//span[2]");
    By presentCountStudent = By.xpath("//*[contains(@class,'present-tag')]/span[2]");
    By absentCountStudent = By.xpath("//*[contains(@class,'absent-tag')]/span[2]");
    By leaveCountStudent = By.xpath("//*[contains(@class,'leave-tag')]/span[2]");
    By holidayCountStudent = By.xpath("//*[contains(@class,'holidays-tag')]/span[2]");
    By holidayMarksTeacher =  By.xpath("//*[contains(@class,'active')]//button[contains(@class,'holiday')]");
    By presentMarksTeacher =  By.xpath("//*[contains(@class,'active')]//button[contains(@class,'present')]");
    By absentMarksTeacher = By.xpath("//*[contains(@class,'active')]//button[contains(@class,'absent')]");
    By leaveMarksTeacher = By.xpath("//*[contains(@class,'active')]//button[contains(@class,'leave')]");
    By notMarkedTeacher = By.xpath("//*[contains(@class,'active')]//button[contains(@class,'not-marked')]");
    By totalCountTeacher = By.xpath("//*[contains(@class,'total-students')]");
    By presentCountTeacher = By.xpath("//*[contains(@class,'present-students')]");
    By absentCountTeacher = By.xpath("//*[contains(@class,'absent-students')]");
    By leaveCountTeacher = By.xpath("//*[contains(@class,'leave-students')]");
    By editAttendanceBtn = By.xpath("//*[contains(@class,'edit-attendance-button')]");
    By markasholidayBtn = By.xpath("//*[contains(@class,'mark-as-holiday-button')]");
    By saveBtn = By.xpath("//button[@name='saveButton']");
    By attendancemarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[contains(@class,'active')]/button[contains(@class,'present')]");
    By presentmarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[2]/button[contains(@class,'present')]");
    By absentmarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[2]/button[contains(@class,'absent')]");
    By leavemarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[2]/button[contains(@class,'leave')]");

    By AttendancePercentage = By.xpath("//*[contains(@class,'at-cal-percentage')]");
    By AllDaysList = By.xpath("//*[contains(@class,'calendar ')]//span[contains(@class,'day') and not(contains(@class,'day-disabled')) and not(contains(@class,'day-name'))]");
    By DisplayedMonthStudent = By.xpath("//*[contains(@class,'at-date-txt')]");


    // Pagination
    By PaginationLeftBtn = By.xpath("//img[@alt='arrow-left']");
    By PaginationRightBtn = By.xpath("//img[@alt='arrow-right']");
    By DisplayedMonthTeacher = By.xpath("//*[contains(@class,'cal-box')]//input");


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    public Attendance(WebDriver driver2) {
        this.driver = driver2;
    }
    @Step("Student account is selected...")
    public WebElement StudentImageClick() {
        screenshot();
        return driver.findElement(StudentImageClick);
    }
    @Step("Doubts Module is opened...")
    public WebElement AttendanceToggle() {
        screenshot();
        return driver.findElement(AttendanceToggle);
    }
    @Step("Fetching heading...")
    public WebElement GetHeader(){
        screenshot();
        return driver.findElement(GetHeader);
    }
    @Step("Counting number of present marks on calendar...")
    public List<WebElement> presentMarksStudent(){
        screenshot();
        return driver.findElements(presentMarksStudent);
    }
    @Step("Counting number of absent marks on calendar...")
    public List<WebElement> absentMarksStudent(){
        screenshot();
        return driver.findElements(absentMarksStudent);
    }
    @Step("Counting number of leave marks on calendar...")
    public List<WebElement> leaveMarksStudent(){
        screenshot();
        return driver.findElements(leaveMarksStudent);
    }
    @Step("Counting number of holiday marks on calendar...")
    public List<WebElement> holidayMarksStudent(){
        screenshot();
        return driver.findElements(holidayMarksStudent);
    }
    @Step("Fetching not marked students for selected day...")
    public List<WebElement> notMarkedTeacher(){
        screenshot();
        return driver.findElements(notMarkedTeacher);
    }
    @Step("Fetching number of days held count...")
    public WebElement heldCountStudent(){
        screenshot();
        return driver.findElement(heldCountStudent);
    }
    @Step("Fetching number of days present count...")
    public WebElement presentCountStudent(){
        screenshot();
        return driver.findElement(presentCountStudent);
    }
    @Step("Fetching number of days absent count...")
    public WebElement absentCountStudent(){
        screenshot();
        return driver.findElement(absentCountStudent);
    }
    @Step("Fetching number of leave days count...")
    public WebElement leaveCountStudent(){
        screenshot();
        return driver.findElement(leaveCountStudent);
    }
    @Step("Fetching number of holidays count...")
    public WebElement holidayCountStudent(){
        screenshot();
        return driver.findElement(holidayCountStudent);
    }
    @Step("Counting number of holiday marks on calendar...")
    public List<WebElement> holidayMarksTeacher(){
        screenshot();
        return driver.findElements(holidayMarksTeacher);
    }
    @Step("Counting number of present marks on calendar...")
    public List<WebElement> presentMarksTeacher(){
        screenshot();
        return driver.findElements(presentMarksTeacher);
    }
    @Step("Counting number of absent marks on calendar...")
    public List<WebElement> absentMarksTeacher(){
        screenshot();
        return driver.findElements(absentMarksTeacher);
    }
    @Step("Counting number of leave marks on calendar...")
    public List<WebElement> leaveMarksTeacher(){
        screenshot();
        return driver.findElements(leaveMarksTeacher);
    }
    @Step("Fetching total number of students in the class...")
    public WebElement totalCountTeacher(){
        screenshot();
        return driver.findElement(totalCountTeacher);
    }
    @Step("Fetching number of days present count...")
    public WebElement presentCountTeacher(){
        screenshot();
        return driver.findElement(presentCountTeacher);
    }
    @Step("Fetching number of days absent count...")
    public WebElement absentCountTeacher(){
        screenshot();
        return driver.findElement(absentCountTeacher);
    }
    @Step("Fetching number of days leave count...")
    public WebElement leaveCountTeacher(){
        screenshot();
        return driver.findElement(leaveCountTeacher);
    }
    @Step("Clicked on edit attendance button...")
    public WebElement editAttendanceBtn(){
        screenshot();
        return driver.findElement(editAttendanceBtn);
    }
    @Step("Clicked on mark as holiday button...")
    public WebElement markasholidayBtn(){
        screenshot();
        return driver.findElement(markasholidayBtn);
    }
    @Step("Save button is clicked...")
    public WebElement saveBtn(){
        screenshot();
        return driver.findElement(saveBtn);
    }
    @Step("Option for marking attendance is clicked...")
    public WebElement attendancemarkoption(){
        screenshot();
        return driver.findElement(attendancemarkoption);
    }
    @Step("Option for marking present is clicked...")
    public WebElement presentmarkoption(){
        screenshot();
        return driver.findElement(presentmarkoption);
    }
    @Step("Option for marking absent is clicked...")
    public WebElement absentmarkoption(){
        screenshot();
        return driver.findElement(absentmarkoption);
    }
    @Step("Option for marking leave is clicked...")
    public WebElement leavemarkoption(){
        screenshot();
        return driver.findElement(leavemarkoption);
    }
    @Step("Fetching the attendance percentage displayed...")
    public WebElement AttendancePercentage(){
        screenshot();
        return driver.findElement(AttendancePercentage);
    }

    public List<WebElement> AllDaysList(){
        screenshot();
        return driver.findElements(AllDaysList);
    }
    @Step("Fetching the month displayed on calendar...")
    public WebElement DisplayedMonthStudent(){
        screenshot();
        return driver.findElement(DisplayedMonthStudent);
    }
    @Step("Fetching the month displayed on calendar...")
    public WebElement DisplayedMonthTeacher(){
        screenshot();
        return driver.findElement(DisplayedMonthTeacher);
    }
    @Step("Navigating to previous month...")
    public WebElement PaginationLeftBtn(){
        screenshot();
        return driver.findElement(PaginationLeftBtn);
    }
    @Step("Navigating to next month...")
    public WebElement PaginationRightBtn(){
        screenshot();
        return driver.findElement(PaginationRightBtn);
    }

}
