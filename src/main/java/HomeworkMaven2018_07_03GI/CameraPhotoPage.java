package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;

public class CameraPhotoPage extends Utils {
    private By _appleICamLink = By.linkText("Apple iCam");

    public void clickOnAppleICamLink(){

        clickOnElement(_appleICamLink);// click on "Apple iCam"
    }
}
