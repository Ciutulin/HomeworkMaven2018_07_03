package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.testng.Assert;

import static HomeworkMaven2018_07_03GI.Utils.clickOnElement;
import static HomeworkMaven2018_07_03GI.Utils.enterText;
import static HomeworkMaven2018_07_03GI.Utils.getTextFromElement;

public class EmailAFriendPage {

        private By _friendEmailField = By.id("FriendEmail");
        private By _yourEmailFied = By.id("YourEmailAddress");
        private By _personalMessage = By.id("PersonalMessage");
        private By _sendEmailButton = By.xpath("//form/div[2]/input");
        private By _onlyRegisterText = By.xpath("//form/div[1]/ul/li");
        private By _registerButton = By.linkText("Register");
        private By _messageHasBeenSentText = By.xpath("//div/div[1]/div[1]/div[1]/div[2]/div[2]");

    public void completeFormUnregisteredUser() {

        enterText(_yourEmailFied, "danabunadimineata@yahoo.com");//complete the field with my email address
        competedFriendEmailMessageUserAndClickButton();
        Assert.assertEquals(getTextFromElement(_onlyRegisterText), "Only registered customers can use email a friend feature");//display "Only registered customers can use email a friend feature" message
        clickOnElement(_registerButton);//click on register button
    }
    public void completeFormRegisteredUser(){

        competedFriendEmailMessageUserAndClickButton();
        Assert.assertEquals(getTextFromElement(_messageHasBeenSentText),"Your message has been sent.");//display "Your message has been sent." message
    }

    public void competedFriendEmailMessageUserAndClickButton(){
        enterText(_friendEmailField, "vladusnostradamus@yahoo.com");//complete the field with friend email address
        enterText(_personalMessage, "hello");//complete the field with one message
        clickOnElement(_sendEmailButton);//click on "SEND EMAIL" button
    }
}
