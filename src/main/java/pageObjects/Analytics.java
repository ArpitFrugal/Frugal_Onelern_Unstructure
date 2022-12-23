package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

import java.util.List;

public class Analytics extends Base {
    public WebDriver driver;

    By AnalyticsToggle = By.id("analytics");
    By PerformanceTab = By.xpath("//*[contains(@class, 'page-tabs')]//div[1]");
    By GetHeader = By.xpath("//header/div/div/h1");
    By LearningOutcomes = By.xpath("//div[contains(@class, 'lo-block')]//table//tbody/tr");
    By LearningOutcomesFilterDropdown = By.xpath("//div[contains(@class, 'lo-block')]//select");
    By LearningOutcomeOpenBtn = By.xpath("//div[contains(@class, 'lo-block')]//table//tbody/tr/td[4]/a");
    By NavigationPath = By.xpath("//nav/ol[contains(@class, 'breadcrumb')]");
    By AttemptedCount = By.xpath("//div[contains(@class, 'attempted-txt')]");
    By AttemptedStudents = By.xpath("//div[contains(@class, 'student-list-cards')]/a");
    By AttemptedSwitch = By.xpath("//div[contains(@class, 'list-of-students')]//select");
    By overallScore = By.xpath("//div[contains(@class, 'overall-score')]");
    By DisplayedStudentName = By.xpath("//div[contains(@class, 'list-of-students')]//a//h4");
    By StudentProfileName = By.xpath("//*[contains(@class, 'student-name')]");
    By topSection = By.xpath("//*[contains(@class, 'top-section')]");
    By ViewWEoSQ = By.id("view-link-eosq");
    By LessonTopics = By.xpath("//*[contains(@class, 'right-side')]//*[contains(@class, 'session')]");
    By TopicsPercentage = By.xpath("//*[contains(@class, 'session')]/a/div/div[2]/span");
    By backBtn = By.xpath("//*[contains(@class, 'back-btn')]");

    By EoSQLesson1 = By.id("item_1");
    By EoSQAttemptedTopic1 = By.xpath("//div[@class='session  svelte-jgwn9e']");
    By ViewEoLT = By.id("view-link");
    By LevelsStudents = By.xpath("//*[contains(@class,'recent-levels-list')]//span//span[not(contains(@class,'students-count'))]");
    By recentLevelsTotalStudents = By.xpath("//*[contains(@class,'recent-levels')]//small");




    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    public Analytics(WebDriver driver2) {
        this.driver = driver2;
    }

    @Step("Analytics Module is opened...")
    public WebElement AnalyticsToggle() {
        screenshot();
        return driver.findElement(AnalyticsToggle);
    }

    // landing page
    @Step("Fetching heading...")
    public String GetHeader(){
        screenshot();
        return driver.findElement(GetHeader).getText();
    }

    public List<WebElement> LearningOutcomes(){return driver.findElements(LearningOutcomes);}

    public WebElement LearningOutcomesFilterDropdown(){return driver.findElement(LearningOutcomesFilterDropdown);}
    @Step("Learning outcomes is opened...")
    public WebElement LearningOutcomeOpenBtn(){return driver.findElement(LearningOutcomeOpenBtn);}
    @Step("Fetching navigated path...")
    public WebElement NavigationPath(){return driver.findElement(NavigationPath);}
    @Step("Fetching attempted count...")
    public String AttemptedCount(){ return driver.findElement(AttemptedCount).getText();}
    @Step("Fetching attempted count...")
    public List<WebElement> AttemptedStudents(){return driver.findElements(AttemptedStudents);}
    public WebElement AttemptedSwitch(){return driver.findElement(AttemptedSwitch);}
    @Step("Fetching overall score...")
    public WebElement overallScore(){return driver.findElement(overallScore);}
    @Step("Fetching student name...")
    public WebElement DisplayedStudentName(){return driver.findElement(DisplayedStudentName);}
    public WebElement StudentProfileName(){return driver.findElement(StudentProfileName);}
    public WebElement topSection(){return driver.findElement(topSection);}
    @Step("EoSQ section is opened...")
    public WebElement ViewWEoSQ(){return driver.findElement(ViewWEoSQ);}
    @Step("Fetching all lesson topics...")
    public List<WebElement> LessonTopics(){return driver.findElements(LessonTopics);}
    @Step("Fetching topics percentage...")
    public List<WebElement> TopicsPercentage(){return driver.findElements(TopicsPercentage);}
    @Step("Clicking on back button")
    public WebElement backBtn(){return driver.findElement(backBtn);}
    public WebElement EoSQLesson1(){return driver.findElement(EoSQLesson1);}
    public WebElement EoSQAttemptedTopic1(){return driver.findElement(EoSQAttemptedTopic1);}
    @Step("EoLT section is opened...")
    public WebElement ViewEoLT(){return driver.findElement(ViewEoLT);}
    public List<WebElement> LevelsStudents(){return driver.findElements(LevelsStudents);}
    public int recentLevelsTotalStudents(){
        return Integer.parseInt(List.of(driver.findElement(recentLevelsTotalStudents).getText().split(" ")).get(2));
    }
    @Step("Switching to performance tab...")
    public WebElement PerformanceTab(){return driver.findElement(PerformanceTab);}



}
