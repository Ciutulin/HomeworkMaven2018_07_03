package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;

public class WelcomePleaseSignInPage extends Utils {
    private By _checkoutAsAGuestButton = By.xpath("//div[1]/div[3]/input[1]");
    private By _shoppingCartLink = By.xpath("//div[1]//div[3]//input[2]");

    public void checkoutAsAGuest(){

        clickOnElement(_checkoutAsAGuestButton);//click on "Checkout as guest" button
    }

    public void clickOnShoppingCartList(){
        clickOnElement(_shoppingCartLink);//click on shopping cart right up corner
    }
}
