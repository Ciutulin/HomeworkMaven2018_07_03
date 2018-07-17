package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;

import static HomeworkMaven2018_07_03GI.Utils.clickOnElement;
import static HomeworkMaven2018_07_03GI.Utils.enterText;

public class VirtualGiftCardPage {
    private By _emailToAFriendButton = By.xpath("//div[8]/div[3]/input");

    public void clickOnEmailToAFriendButton(){

        clickOnElement(_emailToAFriendButton);//click on "Email to a friend" button

    }
}
