package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSetUp extends BasePage {


        //creating an object to call LoadProp class
        LoadProp loadProp = new LoadProp();

        //creating method for multi browser
        public void selectBrowser(){
        String browser = loadProp.getProperty("browser");

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
            driver =  new InternetExplorerDriver();
        }else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.Firefox.driver", "src\\test\\Resources\\BrowserDriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
         else {System.out.println("wrong browser name or empty :"+browser);
        }


    }
}
