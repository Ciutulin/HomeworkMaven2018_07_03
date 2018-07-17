package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;

public class ElectronicsPage extends Utils {

    private By _cameraPhotoLink = By.linkText("Camera & photo");

    public void clickOnCameraPhotoLink(){
        clickOnElement(_cameraPhotoLink);//click on "Camera and photo"
    }
}
