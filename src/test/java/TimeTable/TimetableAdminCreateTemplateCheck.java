package TimeTable;

import io.qameta.allure.*;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.TimeTable;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimetableAdminCreateTemplateCheck extends Base {
    public TimeTable tim;
    public WebDriver driver;


    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("schooladminurl"));
        tim = new TimeTable(driver);
    }
    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or noti the admin can create an template successfully.")
    @Story("TIMFA_02")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminCreateTemplateCheck(String usermail, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.TemplatesBtn().click();

        tim.CreateTemplate().click();

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
        String CurrDate = formatter.format(date);
        String CurrDate1 = formatter1.format(date);

        tim.templateName().click();
        tim.templateName().sendKeys("New Template " + CurrDate1);

        Calendar cal1 = Calendar.getInstance();
        try{
            cal1.setTime(formatter.parse(CurrDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal2 = Calendar.getInstance();
        try{
            cal2.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal2.add(Calendar.YEAR, 1);
        String dateAfter = formatter.format(cal2.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        tim.startDate().click();
        tim.startDate().sendKeys(currdate);
        tim.startDate().sendKeys(currmonth);
        tim.startDate().sendKeys(curryear);

        tim.endDate().click();
        tim.endDate().sendKeys(enddate);
        tim.endDate().sendKeys(endmonth);
        tim.endDate().sendKeys(endyear);

        // time
        tim.startTime().click();
        tim.startTime().sendKeys("08");
        tim.startTime().sendKeys("00");
        tim.startTime().sendKeys("a");

        tim.endTime().click();
        tim.endTime().sendKeys("03");
        tim.endTime().sendKeys("00");
        tim.endTime().sendKeys("p");


        tim.SelectWeekHoliday().click();
        tim.Weekday().click();

        tim.NextButton().click();
        Thread.sleep(2000);
        tim.AddMoreSessionsBtn().click();

        tim.Session1Name().click();
        tim.Session1Name().sendKeys("Session1");

        tim.Session2Name().click();
        tim.Session2Name().sendKeys("Session2");
        Thread.sleep(2000);

        Select sessiontype1 = new Select(tim.Session1sessiontype());
        sessiontype1.selectByIndex(1);
        Thread.sleep(2000);
        Select sessiontype2 = new Select(tim.Session2sessiontype());
        sessiontype2.selectByIndex(1);

        Thread.sleep(2000);
        tim.Session1endTime().click();
        Thread.sleep(1000);
        tim.Session1endTime().sendKeys("09");
        Thread.sleep(1000);
        tim.Session1endTime().sendKeys("00");
        tim.Session1endTime().sendKeys("a");

        Thread.sleep(2000);
        tim.Session2endTime().click();
        Thread.sleep(1000);
        tim.Session2endTime().sendKeys("10");
        tim.Session2endTime().sendKeys("00");
        tim.Session2endTime().sendKeys("a");

        tim.CreateTemplateSubmitBtn().click();
        Thread.sleep(3000);
        tim.backBtn().click();

        boolean flag=false;
        for(WebElement webElement:tim.TemplateCards()){
            if(webElement.getText().contains("New Template")){
                flag = true;
                break;
            }
        }

        List<WebElement> TemplateCards = driver.findElements(By.xpath("//*[contains(@class, 'menu-icon')]"));

        TemplateCards.get(TemplateCards.size()-1).click();
        tim.DeleteBtn().click();
        tim.ConfirmDelete().click();

        ValidateTest(flag);
    }

    public void ValidateTest(boolean flag) {
        System.out.println(flag);
        if(flag){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @DataProvider(name = "adminData")
    public Object[][] getadminData() throws FileAlreadyExistsException {
        return getSchoolAdminData();
    }
}
