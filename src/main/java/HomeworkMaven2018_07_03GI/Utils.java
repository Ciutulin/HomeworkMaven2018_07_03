package HomeworkMaven2018_07_03GI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Utils extends BasePage {
    //click on element
    public static void clickOnElement(By by){

        driver.findElement(by).click();
    }
    //enter text
    public static void enterText(By by, String text){

        driver.findElement(by).sendKeys(text);
    }
    //get text from element(o folosesti la sfarsit cand verifici daca ti-a aparut textul pe care il vrei for assert)
    public static String getTextFromElement(By by){
        return driver.findElement(by).getText() ;

    }

    public static String generateEmail(){
        Calendar time =Calendar.getInstance();
        String curTime = String.format("%02d_%02d_%02d",time.get(Calendar.HOUR_OF_DAY),time.get(Calendar.MINUTE),time.get(Calendar.SECOND));
        String email = "DanaBen_" + curTime + "@yahoo.com";

        return email;
    }

    //for making dynamic email id - using TimeStamp
    public static String timeStamp()
    {
        DateFormat format = new SimpleDateFormat("DDMMYYHHMM");
        return format.format(new Date());
    }

    //select from Drop-down by Visible text
    public static void selectFromDropDown(By by, String choosedValue)//dropDown- date of birth (day, month,year)
                                                                               //choosedValue -what value do you select
    {

        Select droplist = new Select(driver.findElement(by));//create an object for dropdown
        droplist.selectByVisibleText(choosedValue);//select from dropdown
    }

    //select from Drop-down by Index
    public static void SelectFromDropDownByIndex (By element, int num)
    {
        new Select(driver.findElement(element)).selectByIndex(num);
    }

    //select from Drop-down by Value
    public static void SelectFromDropDownByValue (By element, String num)
    {
        new Select(driver.findElement(element)).selectByValue(num);
    }
    //wait for element to be clickable
    public static void waitForElementToBeClickable(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //wait for element to be visible
    public static void waitForElementToBeVisible(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //wait for element to be invisible
    public static void waitForElementToBeInvisible(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public static void waitVisibilityOfElementLocatede(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    //clear and enter text
    public static void clearAndEnterText(By by, String text){
        driver.findElement(by).clear();//il face sa se uite la un element(buton)
        driver.findElement(by).sendKeys(text);
    }
    //select from visible number
    public static void selectFromListByNumber(By element, int number){
        new Select(driver.findElement(element)).selectByVisibleText(String.valueOf(number));
    }
    //select from visible number
    public static void selectFromByIndex(By element, int number){
        new Select(driver.findElement(element)).deselectByIndex(number);
    }
    //select from value
    public static void selectFromListByValue(By element, String text){
        new Select(driver.findElement(element)).selectByValue(text);
    }


    public static void takeScreenShot(String name) {
        try {
            TakesScreenshot ts = ((TakesScreenshot) driver);//type casting. TakesScreenshot is an interface, so cannot create its object
            File source = ts.getScreenshotAs(OutputType.FILE);//saves the screen shot in buffer memory
            FileUtils.copyFile(source, new File(".\\ScreenShot\\" + name + ".jpg"));//copies files from buffer to our destination file
            //also name is parameterized, so user can give name to the file as per choice
            System.out.println("Screenshot taken.");
        } catch (IOException e) {
            System.out.print("The error we got when taking screenshot:");
            //in case if there is exception the below message is printed with the exception
            e.printStackTrace();
        }
    }
}
