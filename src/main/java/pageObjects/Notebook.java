package pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import resources.Base;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Notebook extends Base {
    public WebDriver driver;

    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
//    By TeacherNotebookToggle = By.xpath("//img[@src='/images/notebook.svg']");
    By StudentNotebookToggle = By.xpath("//img[@src='/images/notebook-white.svg']");
//    By BackButton = By.xpath("//header/div[1]/div[1]/button[1]/img[1]");
    By NotebookToggle = By.id("notebook");
//    By BackButton = By.id("inner_header_back_btn");
    By BackButton = By.xpath("//*[contains(@class,'back-btn')]");

    //landing page
    By GetHeader = By.xpath("/html/body/header/div[1]/h2");


    // Grade check
    By CoursebooksGradeTextGrade = By.xpath("//*[contains(@class,'book ')]//div[contains(@class,'form-details')]");

    // lesson name verify
    By EnvironmentalCoursebookGrade1 = By.xpath("//*[@id='61606a629e1fe601b5ee768c']/img");
    By MathematicsCoursebookGrade2 = By.xpath("//*[@id='61606cd19e1fe601b5ee7691']/img");
    By SocialStudiesCoursebookGrade3 = By.xpath("//*[@id='616070109e1fe601b5ee769e']/img");
    By ScienceCoursebookGrade4 = By.xpath("//*[@id='616071349e1fe601b5ee76a1']/img");
    By SocialStudiesCoursebookGrade5 = By.xpath("//*[@id='616075449e1fe601b5ee76aa']/img");
    By EnglishCoursebookGrade2 = By.xpath("//*[@id='61606c609e1fe601b5ee7690']/img");
    By EnglishCoursebookGrade3 = By.xpath("//*[@id='61606e699e1fe601b5ee7697']/img");
    By MathematicsCoursebookGrade3 = By.xpath("//*[@id='61606ea59e1fe601b5ee7698']/img");
    By EnglishCoursebookGrade4 = By.xpath("//*[@id='616070b99e1fe601b5ee769f']/img");
    By MathematicsCoursebookGrade5 = By.xpath("//*[@id='616074c09e1fe601b5ee76a8']/img");

    By FirstLesson = By.id("item_1");
    By SecondLesson = By.id("item_2");
    By ThirdLesson = By.id("item_3");
    By FirstLessonText = By.xpath("//*[@id='item_1']/div/div[2]");
    By SecondLessonText = By.xpath("//*[@id='item_2']/div/div[2]");
    By ThirdLessonText = By.xpath("//*[@id='item_3']/div/div[2]");
    By LessonHeading = By.xpath("/html/body/div[3]/div/div[2]/div/h1");
//    By LessonHeading = By.id();
    // highlights
    By LibraryToggle = By.id("library");
    By FirstTopic = By.id("section_1");
    By SecondTopic = By.id("section_2");
    By ThirdTopic = By.id("section_3");
    By EnvFirstLessonFirstTopicRefGrade1 = By.xpath("//*[@id='6220ae6e92520323185f705b']/div/div/div/h2");
    By EngThirdLessonFirstTopicRefGrade2 = By.xpath("//*[@id='622ae4eb86c5d6273ab3c668']/div/div/div/h2");
    By MathFirstLessonFirstTopicRefGrade3 = By.xpath("//*[@id='6225f85049ef78a1df908273']/div/div/div/h2");
    By EngFirstLessonFirstTopicRefGrade4 = By.xpath("//*[@id='6228a6f9df9f3125a2007bd8']/div/div/div/h2");
    By MathFirstLessonFirstTopicRefGrade5 = By.xpath("//*[@id='6225ff0d50a3c5ff8177f83a']/div/div/div/h2");


    By greenBtn = By.xpath("//label[@for='green']");
    By notesBtn = By.xpath("//*[@class='radio-item notes']");
//    By notesBtn = By.className("radio-item notes");
    By notesTextarea = By.id("annotator-field-0");
    By saveNoteBtn = By.xpath("//a[@href='#save']");
    By bookmarkBtn = By.xpath("//*[@class='radio-item bookmark']");
//    By bookmarkBtn = By.className("radio-item bookmark");
    By deleteBtn = By.xpath("//div[contains(@class,'radio-item deleteannotation')]");
    By random_text_to_click = By.xpath("//p[contains(@class,'svelte')]");

    By oldSearchIcon = By.xpath("//img[@class='pointer']");
    By SearchIcon = By.id("search_icon");
    By SearchInput = By.id("search_box");
    By contents = By.xpath("//*[contains(@class,'bookmark student-state ')]");



    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public Notebook(WebDriver driver2) {
        this.driver = driver2;
    }

    // highlights
    @Step("Library module is opened...")
    public WebElement LibraryToggle(){
        screenshot();
        return driver.findElement(LibraryToggle);
    }
    @Step("Notebook Module is opened...")
    public WebElement NotebookToggle() throws IOException {
        screenshot();
        return driver.findElement(NotebookToggle);
    }

    public WebElement FirstTopic(){return driver.findElement(FirstTopic);}
    public WebElement SecondTopic(){return driver.findElement(SecondTopic);}

    public WebElement ThirdTopic(){return driver.findElement(ThirdTopic);}
    public WebElement EnvFirstLessonFirstTopicRefGrade1(){return driver.findElement(EnvFirstLessonFirstTopicRefGrade1);}
    public WebElement EngThirdLessonFirstTopicRefGrade2(){return driver.findElement(EngThirdLessonFirstTopicRefGrade2);}
    public WebElement MathFirstLessonFirstTopicRefGrade3(){return driver.findElement(MathFirstLessonFirstTopicRefGrade3);}
    public WebElement EngFirstLessonFirstTopicRefGrade4(){return driver.findElement(EngFirstLessonFirstTopicRefGrade4);}

    public WebElement MathFirstLessonFirstTopicRefGrade5(){return driver.findElement(MathFirstLessonFirstTopicRefGrade5);}
    @Step("Text is highlighted in green color...")
    public WebElement greenBtn(){
        screenshot();
        return driver.findElement(greenBtn);
    }
    public WebElement notesBtn(){return driver.findElement(notesBtn);}
    public WebElement notesTextarea(){return driver.findElement(notesTextarea);}
    public WebElement saveNoteBtn(){return driver.findElement(saveNoteBtn);}
    public WebElement bookmarkBtn(){return driver.findElement(bookmarkBtn);}
    @Step("removed highlight for highlighted text...")
    public WebElement deleteBtn(){
        screenshot();
        return driver.findElement(deleteBtn);
    }

    public WebElement random_text_to_click(){return driver.findElement(random_text_to_click);}

    public WebElement oldSearchIcon(){return driver.findElement(oldSearchIcon);}
    public WebElement SearchIcon(){return driver.findElement(SearchIcon);}
    @Step("Searching text...")
    public WebElement SearchInput(){
        screenshot();
        return driver.findElement(SearchInput);
    }

    public List<WebElement> contents(){return driver.findElements(contents);}



    @Step("Student account is selected...")
    public WebElement StudentImageClick() {
        screenshot();
        return driver.findElement(StudentImageClick);
    }
    //    public WebElement TeacherNotebookToggle() {
    //        return driver.findElement(TeacherNotebookToggle);
    //    }
    public WebElement StudentNotebookToggle() {return driver.findElement(StudentNotebookToggle);}
    @Step("Back button is clicked...")
    public WebElement BackButton() {
        screenshot();
        return driver.findElement(BackButton);
    }

    // landing page
    @Step("Fetching heading...")
    public String GetHeader(){
        screenshot();
        return driver.findElement(GetHeader).getText();
    }


    // Grade Check
    public WebElement CoursebooksGradeTextGrade(){return driver.findElement(CoursebooksGradeTextGrade);}

//    public WebElement EnglishGradeTextGrade1(){return driver.findElement(CoursebooksGradeTextGrade);}
//    public WebElement EnglishGradeTextGrade2(){return driver.findElement(EnglishGradeTextGrade2);}
//    public WebElement EnglishGradeTextGrade3(){return driver.findElement(EnglishGradeTextGrade3);}
//    public WebElement EnglishGradeTextGrade4(){return driver.findElement(EnglishGradeTextGrade4);}
//    public WebElement EnglishGradeTextGrade5(){return driver.findElement(EnglishGradeTextGrade5);}


    // lesson name verify
    @Step("Opening Environmental coursebook...")
    public WebElement EnvironmentalCoursebookGrade1(){return driver.findElement(EnvironmentalCoursebookGrade1);}
    @Step("Opening Mathematics coursebook...")
    public WebElement MathematicsCoursebookGrade2(){return driver.findElement(MathematicsCoursebookGrade2);}
    @Step("Opening Social Studies coursebook...")
    public WebElement SocialStudiesCoursebookGrade3(){return driver.findElement(SocialStudiesCoursebookGrade3);}
    @Step("Opening Science coursebook...")
    public WebElement ScienceCoursebookGrade4(){return driver.findElement(ScienceCoursebookGrade4);}
    @Step("Opening Social Studies coursebook...")
    public WebElement SocialStudiesCoursebookGrade5(){return driver.findElement(SocialStudiesCoursebookGrade5);}
    @Step("Opening English coursebook...")
    public WebElement EnglishCoursebookGrade2(){return driver.findElement(EnglishCoursebookGrade2);}
    @Step("Opening Mathematics coursebook...")
    public WebElement MathematicsCoursebookGrade3(){return driver.findElement(MathematicsCoursebookGrade3);}
    @Step("Opening English coursebook...")
    public WebElement EnglishCoursebookGrade4(){return driver.findElement(EnglishCoursebookGrade4);}
    @Step("Opening Mathematics coursebook...")
    public WebElement MathematicsCoursebookGrade5(){return driver.findElement(MathematicsCoursebookGrade5);}

    public WebElement FirstLesson(){return driver.findElement(FirstLesson);}
    public WebElement SecondLesson(){return driver.findElement(SecondLesson);}
    public WebElement ThirdLesson(){return driver.findElement(ThirdLesson);}
    public String FirstLessonText(){return driver.findElement(FirstLessonText).getText();}
    public String SecondLessonText(){return driver.findElement(SecondLessonText).getText();}
    public String ThirdLessonText(){return driver.findElement(ThirdLessonText).getText();}
    @Step("Fetching lesson heading...")
    public String LessonHeading(){
        screenshot();
        return driver.findElement(LessonHeading).getText().substring(2);
    }

}
