package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.util.Calendar;

public class Utils extends BasePage {
    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }
    public static void entertext(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by){
        return driver.findElement(by).getText() ;

    }
    public static String generateEmail(){
        //Timestamp time = new Timestamp(System.currentTimeMillis());
        Calendar time =Calendar.getInstance();
        String curTime = String.format("%02d_%02d_%02d",time.get(Calendar.HOUR_OF_DAY),time.get(Calendar.MINUTE),time.get(Calendar.SECOND));
        String email = "DanaBen_" + curTime + "@yahoo.com";
        //String email = "DanaBen" + time.get(Calendar.HOUR_OF_DAY)+"_"+time.get(Calendar.MINUTE)+"_"+ time.get(Calendar.SECOND)+"_" + "@yahoo.com";

        return email;
    }

    public static void selectFromDropDown(String dropDown, String choosedValue)//dropDown- date of birth (day, month,year)
                                                                               //choosedValue -what value do you select
    {

        Select droplist = new Select(driver.findElement(By.name(dropDown)));//create an object for dropdown
        droplist.selectByVisibleText(choosedValue);//select from dropdown
    }

    public static void waitForElementToBeClickable(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void waitVisibilityOfElementLocatede(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
