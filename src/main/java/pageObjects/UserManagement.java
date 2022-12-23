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

    ////////////
    By InstituteClick = By.id("Institute");
    By NewInstituteBtnClick = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]");
    By EnterInstituteName = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/input[1]");
    By EnterInstituteCode = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[2]/input[1]");
    By SelectCurriculum = By.xpath("//*[contains(@class, 'multiselect')]//input");
    By CreateInstituteBtnClick = By.xpath("//*[contains(@class, 'modal-curriculum-footer')]/button[2]");
    By SearchInstitute = By.xpath("//input[@type='search']");
    By SelectInstitute = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div");
    By AddSchoolBtnClick = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/button");
    By EnterSchoolName = By.id("school-name");
    By EnterSchoolCode = By.id("school-code");
    By EnterCurriculum = By.xpath("//*[@id='curriculum']//select");
    By EnterLiveClassURL = By.id("live-class-url");
    By EnterAddress = By.id("address");
    By EnterPhoneNumber = By.xpath("//input[@type='number' and contains(@onkeypress, 'length')]");
//    By EnterPhoneNumber = By.id("number");
    By EnterZipCode = By.id("schoolzipcode");
    By EnterCity = By.id("city");
    By EnterState = By.id("state");
    By EnterCountry = By.id("country");
    By EnterEmail = By.id("email");
    By EnterWebsite = By.id("website");
    By CreateSchoolBtn = By.xpath("//*[contains(@class, 'btn btn-primary')]");
    By SearchSchool = By.xpath("//input[@type='search']");
    By SelectSchool = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[4]/div/div");
    By AddGradeBtnClick = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/button");
    By Grades = By.xpath("//label[contains(@for,'form')]/input");
    By Sections = By.xpath("//*[contains(@class,'grade-card')]");
    By Grade1Check = By.xpath("//label[@for='form_0']/input");
    By Grade2Check = By.xpath("//label[@for='form_1']/input");
    By Grade3Check = By.xpath("//label[@for='form_2']/input");
    By Grade4Check = By.xpath("//label[@for='form_3']/input");
    By Grade5Check = By.xpath("//label[@for='form_4']/input");
    By SaveBtn = By.xpath("//*[contains(@class, 'modal-curriculum-footer')]/button[2]");
    By GradesDisplay = By.xpath("//*[contains(@class, 'grade-card')]/div/div");
    By AddsectionsBtn = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/button");
    By InputSectionName = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/input");
    By AddSectionBtn = By.xpath("/html/body/div[2]/div[2]/div/div[3]/button[2]");

    By StudentFirstName = By.id("firstName");
    By StudentLastName = By.id("lastName");
    By StudentDOB = By.id("birthdate");
    By StudentGender = By.id("male");
    By StudentEmail = By.id("studentEmail");
    By StudentNationality = By.id("Nationality");
    By StudentRollNumber = By.id("rollNumber");
    By ParentEmail = By.id("parentEmail");
    By ParentName = By.id("parentName");
    By ParentMobileNumber = By.id("parentmobileNumber");
    By ParentOccupation = By.id("parentOccupation");
    By CurrentAddress = By.id("currentAddress");
    By NextStep = By.id("nextStep");
    By StudentUsername = By.id("studentUsername");
    By AddStudent = By.id("addStudent");
    By StudentsDisplayed = By.xpath("//*[contains(@class, 'list-of-students')]//*[contains(@class,'student-card')]");

    By StudentsPaginationText = By.xpath("//*[contains(@class, 'pagination')]//span");
    By PaginationPrev = By.xpath("//*[contains(@class, 'pagination')]//button[1]");
    By PaginationNext = By.xpath("//*[contains(@class, 'pagination')]//button[2]");




    public UserManagement(WebDriver driver2) {
        this.driver = driver2;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Student account is selected...")
    public WebElement StudentImageClick() { return driver.findElement(StudentImageClick); }
    @Step("Fetching header...")
    public WebElement GetHeader(){return driver.findElement(GetHeader);}
    @Step("Opening collections module...")
    public WebElement CollectionsModule(){return driver.findElement(CollectionsModule);}
    @Step("Opening Institutes module...")
    public WebElement InstitutesModule(){return driver.findElement(InstitutesModule);}
    @Step("Adding collections...")
    public WebElement AddCollectionsBtn(){return driver.findElement(AddCollectionsBtn);}
    @Step("Entering collections name...")
    public WebElement CollectionNameInput(){return driver.findElement(CollectionNameInput);}
    @Step("Entering collections description...")
    public WebElement CollectionDescriptionInput(){return driver.findElement(CollectionDescriptionInput);}
    public WebElement bottomDiv(){return driver.findElement(bottomDiv);}
    @Step("Adding packages...")
    public WebElement AddPackagesBtn(){return driver.findElement(AddPackagesBtn);}
    @Step("Adding collections...")
    public WebElement AddCollectionBtn(){return driver.findElement(AddCollectionBtn);}
    public WebElement FirstPackage(){return driver.findElement(FirstPackage);}
    public WebElement FirstCollection(){return driver.findElement(FirstPackage);}
    @Step("Confirming packages...")
    public WebElement ConfirmPackages(){return driver.findElement(ConfirmPackages);}
    @Step("Confirming collections...")
    public WebElement ConfirmCollections(){return driver.findElement(ConfirmPackages);}
    @Step("Confirming collections...")
    public WebElement ConfirmCollection(){return driver.findElement(ConfirmCollection);}
    public WebElement FirstCollectionDisplayed(){return driver.findElement(FirstCollectionDisplayed);}
    public WebElement FirstLicenseDisplayed(){return driver.findElement(FirstCollectionDisplayed);}
    @Step("Paginating to previous page...")
    public WebElement prevNavigateBtn(){return driver.findElement(prevNavigateBtn);}
    @Step("Paginating to next page...")
    public WebElement nextNavigateBtn(){return driver.findElement(nextNavigateBtn);}
    @Step("Fetching pagination text...")
    public WebElement paginationText(){return driver.findElement(paginationText);}
    @Step("Searching...")
    public WebElement SearchInputBox(){return driver.findElement(SearchInputBox);}
    public List<WebElement> CollectionsDisplayed(){return driver.findElements(CollectionsDisplayed);}
    @Step("Opening User Management module...")
    public WebElement UserManagementModule(){return driver.findElement(UserManagementModule);}
    @Step("Opening License module...")
    public WebElement LicensesModule(){return driver.findElement(LicensesModule);}
    @Step("Adding license...")
    public WebElement AddLicenseBtn(){return driver.findElement(AddCollectionsBtn);}
    @Step("Entering license name...")
    public WebElement LicenseName(){return driver.findElement(LicenseName);}
    @Step("Selecting institute...")
    public WebElement LicenseInstituteSelect(){return driver.findElement(LicenseInstituteSelect);}
    @Step("Fetching total allocated licenses...")
    public WebElement TotalAllocatedLicenses(){return driver.findElement(TotalAllocatedLicenses);}
    @Step("Entering Start date...")
    public WebElement StartDateInputBox(){return driver.findElement(StartDateInputBox);}
    @Step("Entering end date...")
    public WebElement EndDateInputBox(){return driver.findElement(EndDateInputBox);}
    @Step("Creating License...")
    public WebElement CreateLicenseBtn(){return driver.findElement(CreateLicenseBtn);}
    @Step("Fetching institutes displayed...")
    public List<WebElement> InstitutesDisplayed(){return driver.findElements(InstitutesDisplayed);}
    @Step("Fetching schools displayed...")
    public List<WebElement> SchoolsDisplayed(){return driver.findElements(InstitutesDisplayed);}
    @Step("Fetching grades displayed...")
    public List<WebElement> GradesDisplayed(){return driver.findElements(GradesDisplayed);}
    @Step("Fetching sections displayed...")
    public List<WebElement> SectionsDisplayed(){return driver.findElements(GradesDisplayed);}
    @Step("Adding students...")
    public WebElement AddStudentBtn(){return driver.findElement(AddCollectionsBtn);}


    /////
    @Step("Institute is selected from left Navigation bar...")
    public WebElement InstituteClick() {
        return driver.findElement(InstituteClick);
    }

    @Step("Create Institute button is clicked")
    public WebElement NewInstituteBtnClick() {
        return driver.findElement(NewInstituteBtnClick);
    }

    @Step("Enter Institute Name")
    public WebElement EnterInstituteName() {
        return driver.findElement(EnterInstituteName);
    }

    @Step("Enter Institute Code")
    public WebElement EnterInstituteCode() {
        return driver.findElement(EnterInstituteCode);
    }

    @Step("Select Curriculum from dropdown")
    public WebElement SelectCurriculum() {
        return driver.findElement(SelectCurriculum);
    }

    @Step("Click on Create Institute button ")
    public WebElement CreateInstituteBtnClick() {
        return driver.findElement(CreateInstituteBtnClick);
    }

    @Step("Search Institute from list ")
    public WebElement SearchInstitute() {
        return driver.findElement(SearchInstitute);
    }

    @Step("Click on Institute card from the list ")
    public WebElement SelectInstitute() {
        return driver.findElement(SelectInstitute);
    }

    @Step("Click on Add school button")
    public WebElement AddSchoolBtnClick() {
        return driver.findElement(AddSchoolBtnClick);
    }

    @Step("Enter School Name ")
    public WebElement EnterSchoolName() {
        return driver.findElement(EnterSchoolName);
    }

    @Step("Enter School Code ")
    public WebElement EnterSchoolCode() { return driver.findElement(EnterSchoolCode); }

    @Step("Enter Curriculum ")
    public WebElement EnterCurriculum() { return driver.findElement(EnterCurriculum); }

    @Step("Enter Live URl ")
    public WebElement EnterLiveClassURL() {
        return driver.findElement(EnterLiveClassURL);
    }

    @Step("Enter Address ")
    public WebElement EnterAddress() {
        return driver.findElement(EnterAddress);
    }

    @Step("Enter PhoneNumber ")
    public WebElement EnterPhoneNumber() { return driver.findElement(EnterPhoneNumber);}

    @Step("Enter Zipcode ")
    public WebElement EnterZipCode() { return driver.findElement(EnterZipCode);}

    @Step("Enter City ")
    public WebElement EnterCity() {
        return driver.findElement(EnterCity);
    }

    @Step("Enter State")
    public WebElement EnterState() {
        return driver.findElement(EnterState);
    }

    @Step("Enter Country ")
    public WebElement EnterCountry() {
        return driver.findElement(EnterCountry);
    }

    @Step("Enter Email ")
    public WebElement EnterEmail() {
        return driver.findElement(EnterEmail);
    }

    @Step("Enter Website ")
    public WebElement EnterWebsite() {
        return driver.findElement(EnterWebsite);
    }

    @Step("Click Create school button ")
    public WebElement CreateSchoolBtn() { return driver.findElement(CreateSchoolBtn);}

    @Step("Search for Schoolname ")
    public WebElement SearchSchool() { return driver.findElement(SearchSchool); }

    @Step("Select school from list")
    public WebElement SelectSchool() {
        return driver.findElement(SelectSchool);
    }

    @Step("Click Add Grade button ")
    public WebElement AddGradeBtnClick() {
        return driver.findElement(AddGradeBtnClick);
    }

    @Step("fetching grades...")
    public List<WebElement> Grades(){
        return driver.findElements(Grades);
    }

    @Step("Select Grade1 Checkbox")
    public WebElement Grade1Check() {
        return driver.findElement(Grade1Check);
    }

    @Step("Select Grade2 Checkbox")
    public WebElement Grade2Check() {
        return driver.findElement(Grade2Check);
    }

    @Step("Select Grade3 Checkbox")
    public WebElement Grade3Check() {
        return driver.findElement(Grade3Check);
    }

    @Step("Select Grade4 Checkbox")
    public WebElement Grade4Check() {
        return driver.findElement(Grade4Check);
    }

    @Step("Select Grade5 Checkbox")
    public WebElement Grade5Check() {
        return driver.findElement(Grade5Check);
    }

    @Step("Click save button ")
    public WebElement SaveBtn() {
        return driver.findElement(SaveBtn);
    }

    @Step("Selecting Grades from list")
    public List<WebElement> GradesDisplay() {
        return driver.findElements(GradesDisplay);
    }

    @Step("Click Add sections button to add Add name of sections ")
    public WebElement AddsectionsBtn() {
        return driver.findElement(AddsectionsBtn);
    }

    @Step("Add Section name ")
    public WebElement InputSectionName() {
        return driver.findElement(InputSectionName);
    }

    @Step("Click on Add section button to save ")
    public WebElement AddSectionBtn() {
        return driver.findElement(AddSectionBtn);
    }

    @Step("Entering Student first name...")
    public WebElement StudentFirstName(){return driver.findElement(StudentFirstName);}
    @Step("Entering Student last name...")
    public WebElement StudentLastName(){return driver.findElement(StudentLastName);}
    @Step("Entering Student DOB...")
    public WebElement StudentDOB(){return driver.findElement(StudentDOB);}
    @Step("Entering Student gender...")
    public WebElement StudentGender(){return driver.findElement(StudentGender);}
    @Step("Entering Student email...")
    public WebElement StudentEmail(){return driver.findElement(StudentEmail);}
    @Step("Entering Studnet nationality...")
    public WebElement StudentNationality(){return driver.findElement(StudentNationality);}
    @Step("Entering Student roll number...")
    public WebElement StudentRollNumber(){return driver.findElement(StudentRollNumber);}
    @Step("Entering parent email...")
    public WebElement ParentEmail(){return driver.findElement(ParentEmail);}
    @Step("Entering parent name...")
    public WebElement ParentName(){return driver.findElement(ParentName);}
    @Step("Entering parent mobile number...")
    public WebElement ParentMobileNumber(){return driver.findElement(ParentMobileNumber);}
    @Step("Entering parent occupation...")
    public WebElement ParentOccupation(){return driver.findElement(ParentOccupation);}
    @Step("Entering current address...")
    public WebElement CurrentAddress(){return driver.findElement(CurrentAddress);}
    @Step("Clicking on next step...")
    public WebElement NextStep(){return driver.findElement(NextStep);}
    @Step("Entering Student user name...")
    public WebElement StudentUsername(){return driver.findElement(StudentUsername);}
    @Step("Adding Student...")
    public WebElement AddStudent(){return driver.findElement(AddStudent);}
    @Step("Fetching all the Students displayed...")
    public List<WebElement> StudentsDisplayed(){return driver.findElements(StudentsDisplayed);}
    @Step("Fetching Pagination text...")
    public WebElement StudentsPaginationText(){return driver.findElement(StudentsPaginationText);}
    @Step("Paginating to previous page...")
    public WebElement PaginationPrev(){return driver.findElement(PaginationPrev);}
    @Step("Paginating to next page...")
    public WebElement PaginationNext(){return driver.findElement(PaginationNext);}

}
