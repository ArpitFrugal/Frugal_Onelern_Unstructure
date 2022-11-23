package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import resources.Base;

import java.util.List;

public class UserManagement extends Base {
    public WebDriver driver;

    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By GetHeader = By.xpath("//header//span[contains(@class,'module-name')]");
    By CollectionsModule = By.xpath("//a[contains(@href,'collections')]");
    By InstitutesModule = By.xpath("//*[contains(@href, 'institutes')]");
    By AddCollectionsBtn = By.xpath("//*[contains(@class,'add-btn')]");
    By CollectionNameInput = By.xpath("//input[contains(@class,'form-control')]");
    By CollectionDescriptionInput = By.xpath("//textarea[contains(@class,'form-control')]");
    By bottomDiv = By.xpath("//*[contains(@class, 'bottom')]");
    By AddPackagesBtn = By.xpath("//*[text()='Add Packages']");
    By AddCollectionBtn = By.xpath("//*[text()='Add Collection']");
    By FirstPackage = By.xpath("//*[contains(@class,'modal-content')]//input");
    By ConfirmPackages = By.xpath("//*[contains(@class,'modal-footer')]/button[2]");
    By ConfirmCollection = By.xpath("//*[contains(@class,'bottom')]//button[2]");
    By FirstCollectionDisplayed = By.xpath("//*[contains(@class,'package-table')]//tbody/tr[1]");

    By prevNavigateBtn = By.xpath("//*[contains(@class, 'pagination-nav')]/span[contains(@class,'prev')]");
    By nextNavigateBtn = By.xpath("//*[contains(@class, 'pagination-nav')]/span[contains(@class,'next')]");
    By paginationText = By.xpath("//*[contains(@class, 'pagination-main-block')]/p");
    By SearchInputBox = By.xpath("//input[@type='search']");
    By CollectionsDisplayed = By.xpath("//tbody/tr");
    By UserManagementModule = By.xpath("//*[contains(@class, 'left-side-nav')]/div[2]/div");
    By LicensesModule = By.xpath("//a[contains(@href,'licenses')]");
    By LicenseName = By.xpath("//*[contains(text(),'Name')] /following-sibling::input");
    By LicenseInstituteSelect = By.xpath("//*[contains(text(),'Institute')] /following-sibling::select");
    By TotalAllocatedLicenses = By.xpath("//*[contains(text(),'Total')] /following-sibling::div/input");
    By StartDateInputBox = By.xpath("//*[contains(text(),'Start Date')] /following-sibling::div/input");
    By EndDateInputBox = By.xpath("//*[contains(text(),'End Date')] /following-sibling::div/input");
    By CreateLicenseBtn = By.xpath("//*[contains(@class,'bottom')]/div/div/button[2]");

    By InstitutesDisplayed = By.xpath("//*[contains(@class, 'row')]//div[contains(@class,'card-md')]");
    By GradesDisplayed = By.xpath("//*[contains(@class, 'grade-card')]/div/div");




    public UserManagement(WebDriver driver2) {
        this.driver = driver2;
    }
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Student account is selected...")
    public WebElement StudentImageClick() { return driver.findElement(StudentImageClick); }

    public WebElement GetHeader(){return driver.findElement(GetHeader);}
    public WebElement CollectionsModule(){return driver.findElement(CollectionsModule);}
    public WebElement InstitutesModule(){return driver.findElement(InstitutesModule);}
    public WebElement AddCollectionsBtn(){return driver.findElement(AddCollectionsBtn);}
    public WebElement CollectionNameInput(){return driver.findElement(CollectionNameInput);}
    public WebElement CollectionDescriptionInput(){return driver.findElement(CollectionDescriptionInput);}
    public WebElement bottomDiv(){return driver.findElement(bottomDiv);}
    public WebElement AddPackagesBtn(){return driver.findElement(AddPackagesBtn);}
    public WebElement AddCollectionBtn(){return driver.findElement(AddCollectionBtn);}
    public WebElement FirstPackage(){return driver.findElement(FirstPackage);}
    public WebElement FirstCollection(){return driver.findElement(FirstPackage);}
    public WebElement ConfirmPackages(){return driver.findElement(ConfirmPackages);}
    public WebElement ConfirmCollections(){return driver.findElement(ConfirmPackages);}
    public WebElement ConfirmCollection(){return driver.findElement(ConfirmCollection);}
    public WebElement FirstCollectionDisplayed(){return driver.findElement(FirstCollectionDisplayed);}
    public WebElement FirstLicenseDisplayed(){return driver.findElement(FirstCollectionDisplayed);}
    public WebElement prevNavigateBtn(){return driver.findElement(prevNavigateBtn);}
    public WebElement nextNavigateBtn(){return driver.findElement(nextNavigateBtn);}
    public WebElement paginationText(){return driver.findElement(paginationText);}
    public WebElement SearchInputBox(){return driver.findElement(SearchInputBox);}
    public List<WebElement> CollectionsDisplayed(){return driver.findElements(CollectionsDisplayed);}
    public WebElement UserManagementModule(){return driver.findElement(UserManagementModule);}
    public WebElement LicensesModule(){return driver.findElement(LicensesModule);}

    public WebElement AddLicenseBtn(){return driver.findElement(AddCollectionsBtn);}
    public WebElement LicenseName(){return driver.findElement(LicenseName);}
    public WebElement LicenseInstituteSelect(){return driver.findElement(LicenseInstituteSelect);}
    public WebElement TotalAllocatedLicenses(){return driver.findElement(TotalAllocatedLicenses);}
    public WebElement StartDateInputBox(){return driver.findElement(StartDateInputBox);}
    public WebElement EndDateInputBox(){return driver.findElement(EndDateInputBox);}
    public WebElement CreateLicenseBtn(){return driver.findElement(CreateLicenseBtn);}
    public List<WebElement> InstitutesDisplayed(){return driver.findElements(InstitutesDisplayed);}
    public List<WebElement> SchoolsDisplayed(){return driver.findElements(InstitutesDisplayed);}
    public List<WebElement> GradesDisplayed(){return driver.findElements(GradesDisplayed);}
    public List<WebElement> SectionsDisplayed(){return driver.findElements(GradesDisplayed);}
    public WebElement AddStudentBtn(){return driver.findElement(AddCollectionsBtn);}







}
