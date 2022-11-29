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
    By EnterCurriculum = By.xpath("//div[@class='multiselect form-select svelte-1oi6uf5']//input");
    By EnterLiveClassURL = By.id("live-class-url");
    By EnterAddress = By.id("address");
    By EnterPhoneNumber = By.id("number");
    By EnterZipCode = By.id("zipcode");
    By EnterCity = By.id("city");
    By EnterState = By.id("state");
    By EnterCountry = By.id("country");
    By EnterEmail = By.id("email");
    By EnterWebsite = By.id("website");
    By CreateSchoolBtn = By.xpath("//*[contains(@class, 'btn btn-primary')]");
    By SearchSchool = By.xpath("//input[@type='search']");
    By SelectSchool = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[4]/div/div");
    By AddGradeBtnClick = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/button");
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


    /////
    @Step("Institute is selected from left Navigation bar...")
    public WebElement InstituteClick() {
        return this.driver.findElement(this.InstituteClick);
    }

    @Step("Create Institute button is clicked")
    public WebElement NewInstituteBtnClick() {
        return this.driver.findElement(this.NewInstituteBtnClick);
    }

    @Step("Enter Institute Name")
    public WebElement EnterInstituteName() {
        return this.driver.findElement(this.EnterInstituteName);
    }

    @Step("Enter Institute Code")
    public WebElement EnterInstituteCode() {
        return this.driver.findElement(this.EnterInstituteCode);
    }

    @Step("Select Curriculum from dropdown")
    public WebElement SelectCurriculum() {
        return this.driver.findElement(this.SelectCurriculum);
    }

    @Step("Click on Create Institute button ")
    public WebElement CreateInstituteBtnClick() {
        return this.driver.findElement(this.CreateInstituteBtnClick);
    }

    @Step("Search Institute from list ")
    public WebElement SearchInstitute() {
        return this.driver.findElement(this.SearchInstitute);
    }

    @Step("Click on Institute card from the list ")
    public WebElement SelectInstitute() {
        return this.driver.findElement(this.SelectInstitute);
    }

    @Step("Click on Add school button")
    public WebElement AddSchoolBtnClick() {
        return this.driver.findElement(this.AddSchoolBtnClick);
    }

    @Step("Enter School Name ")
    public WebElement EnterSchoolName() {
        return this.driver.findElement(this.EnterSchoolName);
    }

    @Step("Enter School Code ")
    public WebElement EnterSchoolCode() {
        return this.driver.findElement(this.EnterSchoolCode);
    }

    @Step("Enter Curriculum ")
    public WebElement EnterCurriculum() {
        return this.driver.findElement(this.EnterCurriculum);
    }

    @Step("Enter Live URl ")
    public WebElement EnterLiveClassURL() {
        return this.driver.findElement(this.EnterLiveClassURL);
    }

    @Step("Enter Address ")
    public WebElement EnterAddress() {
        return this.driver.findElement(this.EnterAddress);
    }

    @Step("Enter PhoneNumber ")
    public WebElement EnterPhoneNumber() {
        return this.driver.findElement(this.EnterPhoneNumber);
    }

    @Step("Enter Zipcode ")
    public WebElement EnterZipCode() {
        return this.driver.findElement(this.EnterZipCode);
    }

    @Step("Enter City ")
    public WebElement EnterCity() {
        return this.driver.findElement(this.EnterCity);
    }

    @Step("Enter State")
    public WebElement EnterState() {
        return this.driver.findElement(this.EnterState);
    }

    @Step("Enter Country ")
    public WebElement EnterCountry() {
        return this.driver.findElement(this.EnterCountry);
    }

    @Step("Enter Email ")
    public WebElement EnterEmail() {
        return this.driver.findElement(this.EnterEmail);
    }

    @Step("Enter Website ")
    public WebElement EnterWebsite() {
        return this.driver.findElement(this.EnterWebsite);
    }

    @Step("Click Create school button ")
    public WebElement CreateSchoolBtn() {
        return this.driver.findElement(this.CreateSchoolBtn);
    }

    @Step("Search for Schoolname ")
    public WebElement SearchSchool() {
        return this.driver.findElement(this.SearchSchool);
    }

    @Step("Select school from list")
    public WebElement SelectSchool() {
        return this.driver.findElement(this.SelectSchool);
    }

    @Step("Click Add Grade button ")
    public WebElement AddGradeBtnClick() {
        return this.driver.findElement(this.AddGradeBtnClick);
    }

    @Step("Select Grade1 Checkbox")
    public WebElement Grade1Check() {
        return this.driver.findElement(this.Grade1Check);
    }

    @Step("Select Grade2 Checkbox")
    public WebElement Grade2Check() {
        return this.driver.findElement(this.Grade2Check);
    }

    @Step("Select Grade3 Checkbox")
    public WebElement Grade3Check() {
        return this.driver.findElement(this.Grade3Check);
    }

    @Step("Select Grade4 Checkbox")
    public WebElement Grade4Check() {
        return this.driver.findElement(this.Grade4Check);
    }

    @Step("Select Grade5 Checkbox")
    public WebElement Grade5Check() {
        return this.driver.findElement(this.Grade5Check);
    }

    @Step("Click save button ")
    public WebElement SaveBtn() {
        return this.driver.findElement(this.SaveBtn);
    }

    @Step("Selecting Grades from list")
    public List<WebElement> GradesDisplay() {
        return this.driver.findElements(this.GradesDisplay);
    }

    @Step("Click Add sections button to add Add name of sections ")
    public WebElement AddsectionsBtn() {
        return this.driver.findElement(this.AddsectionsBtn);
    }

    @Step("Add Section name ")
    public WebElement InputSectionName() {
        return this.driver.findElement(this.InputSectionName);
    }

    @Step("Click on Add section button to save ")
    public WebElement AddSectionBtn() {
        return this.driver.findElement(this.AddSectionBtn);
    }

    public WebElement StudentFirstName(){return driver.findElement(StudentFirstName);}
    public WebElement StudentLastName(){return driver.findElement(StudentLastName);}
    public WebElement StudentDOB(){return driver.findElement(StudentDOB);}
    public WebElement StudentGender(){return driver.findElement(StudentGender);}
    public WebElement StudentEmail(){return driver.findElement(StudentEmail);}
    public WebElement StudentNationality(){return driver.findElement(StudentNationality);}
    public WebElement StudentRollNumber(){return driver.findElement(StudentRollNumber);}
    public WebElement ParentEmail(){return driver.findElement(ParentEmail);}
    public WebElement ParentName(){return driver.findElement(ParentName);}
    public WebElement ParentMobileNumber(){return driver.findElement(ParentMobileNumber);}
    public WebElement ParentOccupation(){return driver.findElement(ParentOccupation);}
    public WebElement CurrentAddress(){return driver.findElement(CurrentAddress);}
    public WebElement NextStep(){return driver.findElement(NextStep);}
    public WebElement StudentUsername(){return driver.findElement(StudentUsername);}
    public WebElement AddStudent(){return driver.findElement(AddStudent);}
    public List<WebElement> StudentsDisplayed(){return driver.findElements(StudentsDisplayed);}
    public WebElement StudentsPaginationText(){return driver.findElement(StudentsPaginationText);}
    public WebElement PaginationPrev(){return driver.findElement(PaginationPrev);}
    public WebElement PaginationNext(){return driver.findElement(PaginationNext);}


}
