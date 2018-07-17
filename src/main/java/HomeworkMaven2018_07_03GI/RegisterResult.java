package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterResult extends Utils{
    private By _result = By.className("result");
    private By _continueButton = By.xpath("//input[@class='button-1 register-continue-button']");//continue button

    public void clickOnContinueButton(){
        clickOnElement(_continueButton);//click on continue button

    }
    public void assertRegisterResult(){
        Assert.assertEquals(getTextFromElement(_result),"Your registration completed");//display "Your registration completed" message

    }
}
