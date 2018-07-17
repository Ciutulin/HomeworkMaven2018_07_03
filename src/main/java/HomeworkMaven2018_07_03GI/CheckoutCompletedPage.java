package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutCompletedPage extends Utils {

    private By _orderDetailsLink = By.linkText("Click here for order details.");
    private By _orderSuccessfullyProcessedText = By.xpath("//div[2]/div[1]/div[1]/strong");


    public void assertOrderCompleted(){
        waitVisibilityOfElementLocatede(_orderDetailsLink, 10);//wait for element to be visible
        Assert.assertEquals(getTextFromElement(_orderSuccessfullyProcessedText), "Your order has been successfully processed!");//text assert

    }
}
