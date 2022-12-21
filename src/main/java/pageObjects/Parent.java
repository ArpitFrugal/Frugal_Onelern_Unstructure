package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Base;

public class Parent extends Base {
    public WebDriver driver;

    public Parent(WebDriver driver2) {
        this.driver = driver2;
    }


    By DisplayedAccountName = By.xpath("//h3");
    By ViewProfileButton = By.xpath("//*[contains(@class,'view-profile')]");
    By ParentImageClick = By.xpath("//*[contains(@class,'select-pic')]");
    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By AttendanceToggle = By.id("attendance");
    By AttendancePercentage = By.xpath("//*[contains(@class,'at-cal-percentage')]");
    By BackBtn = By.xpath("//*[contains(@class, 'menu-btn')]");
    By SwitchParent = By.xpath("//*[contains(@class, 'select-pic')]");
    By ParentPercentageDisplayed = By.xpath("//*[contains(@class, 'parent-cards-section')]//h1");


    @Step("Fetching Displayed account name...")
    public WebElement DisplayedAccountName(){return driver.findElement(DisplayedAccountName);}
    @Step("View Profile button is selected...")
    public WebElement ViewProfileButton(){return driver.findElement(ViewProfileButton);}
    @Step("Parent account is selected...")
    public WebElement ParentImageClick(){return driver.findElement(ParentImageClick);}

    @Step("Student account is selected...")
    public WebElement StudentImageClick() {return driver.findElement(StudentImageClick);}
    @Step("Doubts Module is opened...")
    public WebElement AttendanceToggle() { return driver.findElement(AttendanceToggle);}
    @Step("Fetching the attendance percentage displayed...")
    public WebElement AttendancePercentage(){return driver.findElement(AttendancePercentage);}

    @Step("Clicking and navigating back...")
    public WebElement BackBtn(){return driver.findElement(BackBtn);}
    @Step("Opening Quick Menu...")
    public WebElement HomepageMenuBtn(){return driver.findElement(BackBtn);}
    @Step("Switching to parent...")
    public WebElement SwitchParent(){ return driver.findElement(SwitchParent);}
    @Step("Fetching attendance percentage displayed...")
    public WebElement ParentPercentageDisplayed(){return driver.findElement(ParentPercentageDisplayed);}


}
