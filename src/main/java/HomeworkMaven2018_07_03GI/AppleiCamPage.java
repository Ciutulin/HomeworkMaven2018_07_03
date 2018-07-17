package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;

public class AppleiCamPage extends Utils {

    private By _appleICamAddToCartButton = By.id("add-to-cart-button-17");
    private By _shoppingCartLink = By.className("cart-label");

    public void clickOnAddToCartButton() {
        waitForElementToBeClickable(_appleICamAddToCartButton,10);
        clickOnElement(_appleICamAddToCartButton);//click on "ADD TO CART" button
    }

    public void clickOnShoppingCart(){
        clickOnElement(_shoppingCartLink);//click on Shopping Cart
    }
}
