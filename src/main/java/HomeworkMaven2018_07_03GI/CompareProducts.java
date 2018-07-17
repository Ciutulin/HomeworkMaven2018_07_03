package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CompareProducts extends Utils {

    private By _pageTitle = By.xpath("//div[@class='page-title']");
    private By _clearListButton = By.className("clear-list");
    private By _clearListDisplayText = By.xpath("//*[@class='no-data']");

    public void assertCompareTwoProducts(){
        Assert.assertEquals(getTextFromElement(_pageTitle),"Compare products");//display "Compare products" page title

    }

    public void clearListOnCompareProductsPage(){

        clickOnElement(_clearListButton);//click on clear list button
        Assert.assertEquals(getTextFromElement(_clearListDisplayText),"You have no items to compare.");//display "You have no items to compare." message

    }


}
