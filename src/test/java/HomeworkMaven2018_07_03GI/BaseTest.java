package HomeworkMaven2018_07_03GI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest extends Utils {

    BrowserSetUp browserSetUp = new BrowserSetUp();

    @BeforeMethod
    public void openBrowser(){

        browserSetUp.selectBrowser();
        //System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.nopcommerce.com/");

    }

    @AfterMethod

    //screenshout method

  /* public void onFailure(ITestResult result)//ITestResult is an interface
    {
        if(ITestResult.FAILURE==result.getStatus())//compares if the result is failed with the itest result
        {
            takeScreenShot(result.getName());//uses the screenshot method from utils class
        }
        closeBrowser();
}*/
  public void screenShot(ITestResult result){

      //here will compare if test is failing, only than it will enter into if condition
      if (ITestResult.FAILURE==result.getStatus());
      try{
          //create reference of TakeScreenshot
          TakesScreenshot ts = (TakesScreenshot) driver;

          //call method to capture screenshot
          File source = ts.getScreenshotAs(OutputType.FILE);

          // Copy files to specific location here it will save all screenshot in our project home directory and
          // result.getName() will return name of test case so that screenshot name will be same


          // now copy the  screenshot to desired location using copyFile //method
          // System.currentTimeMillis() for taking multiple screenshots. If you dont use it, it will re write old image
          // so if you dont use that you will be able to take only one image at a time.

          FileUtils.copyFile(source, new File("src\\test\\Resources\\ScreenShots" + System.currentTimeMillis()+".png"));
          System.out.println("Screenshot taken");
      } catch (IOException e){
          System.out.println(e.getMessage());
      }

    }





    public void closeBrowser(){
        driver.quit();
    }
}
