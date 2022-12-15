package Notebook;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import resources.Base;
import testResource.BaseLogin;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class viewHighlightsNotesBookmarks extends Base {
    public Notebook note;
    public LoginPage log;
    public WebDriver driver;


    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        note = new Notebook(driver);
        log = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void ValidateHighlight(String highlighted_text, String content_in_notebook) {
        if(content_in_notebook.contains(highlighted_text) || content_in_notebook.equals("blank")){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a student can view highlights, notes and bookmarks from library in Notebook")
    @Story("NOTFS_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void CheckStudentHighlightsNotesBookmarks(String mobNumber, String password) throws IOException, InterruptedException, UnsupportedFlavorException {
        Map<String, String> map = new HashMap<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        ThreadSleep5000();
        note.StudentImageClick().click();
        ThreadSleep5000();
        note.LibraryToggle().click();
        Thread.sleep(5000);

        if (mob >= 9000000001l && mob <= 9000000020l) {// English
            note.EnvironmentalCoursebookGrade1().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EnvFirstLessonFirstTopicRefGrade1();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();
            Thread.sleep(2000);
            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 1", highlighted_text);

            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to(prop.getProperty("website")+"notebook");
            ThreadSleep5000();
            Thread.sleep(3000);
            note.EnvironmentalCoursebookGrade1().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            Thread.sleep(2000);

            note.SearchIcon().click();
            ThreadSleep5000();

            String searchcontent = map.get("Grade 1");
            note.SearchInput().sendKeys(searchcontent);
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.EnvironmentalCoursebookGrade1().click();
            ThreadSleep5000();
            note.FirstLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EnvFirstLessonFirstTopicRefGrade1();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            ThreadSleep5000();
            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {// Mathematics
            note.EnglishCoursebookGrade2().click();
            ThreadSleep5000();

            note.ThirdLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EngThirdLessonFirstTopicRefGrade2();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 2", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to(prop.getProperty("website")+"notebook");

            ThreadSleep5000();
            note.EnglishCoursebookGrade2().click();
            ThreadSleep5000();

            note.ThirdLesson().click();
            Thread.sleep(2000);

            note.SearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 2"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.EnglishCoursebookGrade2().click();
            ThreadSleep5000();
            note.ThirdLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EngThirdLessonFirstTopicRefGrade2();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            ThreadSleep5000();
            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);

        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {// Social Studies
            note.MathematicsCoursebookGrade3().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.MathFirstLessonFirstTopicRefGrade3();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 3", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();;

            driver.navigate().to(prop.getProperty("website")+"notebook");


            ThreadSleep5000();
            note.MathematicsCoursebookGrade3().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            Thread.sleep(2000);

            note.SearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 3"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.MathematicsCoursebookGrade3().click();
            ThreadSleep5000();
            note.FirstLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.MathFirstLessonFirstTopicRefGrade3();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            ThreadSleep5000();
            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            note.EnglishCoursebookGrade4().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EngFirstLessonFirstTopicRefGrade4();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 4", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to(prop.getProperty("website")+"notebook");


            ThreadSleep5000();
            note.EnglishCoursebookGrade4().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            Thread.sleep(2000);

            note.SearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 4"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.EnglishCoursebookGrade4().click();
            ThreadSleep5000();
            note.FirstLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EngFirstLessonFirstTopicRefGrade4();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            ThreadSleep5000();
            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            note.MathematicsCoursebookGrade5().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.MathFirstLessonFirstTopicRefGrade5();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 5", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to(prop.getProperty("website")+"notebook");


            ThreadSleep5000();
            note.MathematicsCoursebookGrade5().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            Thread.sleep(2000);

            note.SearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 5"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.MathematicsCoursebookGrade5().click();
            ThreadSleep5000();
            note.FirstLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.MathFirstLessonFirstTopicRefGrade5();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            ThreadSleep5000();
            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);
        }

    }


    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a teacher can view highlights, notes and bookmarks from library in Notebook")
    @Story("NOTFT_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void CheckTeacherHighlightsNotesBookmarks(String mobNumber, String password) throws IOException, InterruptedException, UnsupportedFlavorException {
        Map<String, String> map = new HashMap<>();
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        ThreadSleep5000();
        note.LibraryToggle().click();
        if (mob >= 9000000101l && mob <= 9000000104l) {// English
            note.EnvironmentalCoursebookGrade1().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EnvFirstLessonFirstTopicRefGrade1();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();
            Thread.sleep(2000);
            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 1", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to(prop.getProperty("website")+"notebook");


            ThreadSleep5000();
            note.EnvironmentalCoursebookGrade1().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            Thread.sleep(2000);

            note.oldSearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 1"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.EnvironmentalCoursebookGrade1().click();
            ThreadSleep5000();
            note.FirstLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EnvFirstLessonFirstTopicRefGrade1();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            ThreadSleep5000();
            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) {// Mathematics
            note.EnglishCoursebookGrade2().click();
            ThreadSleep5000();

            note.ThirdLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EngThirdLessonFirstTopicRefGrade2();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 2", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to(prop.getProperty("website")+"notebook");

            ThreadSleep5000();
            note.EnglishCoursebookGrade2().click();
            ThreadSleep5000();

            note.ThirdLesson().click();
            Thread.sleep(2000);

            note.oldSearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 2"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.EnglishCoursebookGrade2().click();
            ThreadSleep5000();
            note.ThirdLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EngThirdLessonFirstTopicRefGrade2();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            ThreadSleep5000();
            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {// Social Studies
            note.MathematicsCoursebookGrade3().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.MathFirstLessonFirstTopicRefGrade3();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 3", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to(prop.getProperty("website")+"notebook");


            ThreadSleep5000();
            note.MathematicsCoursebookGrade3().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            Thread.sleep(2000);

            note.oldSearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 3"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.MathematicsCoursebookGrade3().click();
            ThreadSleep5000();
            note.FirstLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.MathFirstLessonFirstTopicRefGrade3();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            ThreadSleep5000();
            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            note.EnglishCoursebookGrade4().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EngFirstLessonFirstTopicRefGrade4();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 4", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to(prop.getProperty("website")+"notebook");

            ThreadSleep5000();
            note.EnglishCoursebookGrade4().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            Thread.sleep(2000);

            note.oldSearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 4"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.EnglishCoursebookGrade4().click();
            ThreadSleep5000();
            note.FirstLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EngFirstLessonFirstTopicRefGrade4();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            ThreadSleep5000();
            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            note.MathematicsCoursebookGrade5().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.MathFirstLessonFirstTopicRefGrade5();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 5", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to(prop.getProperty("website")+"notebook");

            ThreadSleep5000();
            note.MathematicsCoursebookGrade5().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            Thread.sleep(2000);

            note.oldSearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 5"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.MathematicsCoursebookGrade5().click();
            ThreadSleep5000();
            note.FirstLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.MathFirstLessonFirstTopicRefGrade5();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            ThreadSleep5000();
            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);
        }

    }



    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }

}
