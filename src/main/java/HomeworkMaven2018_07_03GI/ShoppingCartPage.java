package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPage extends Utils {

    private By _skuNumber = By.className("sku-number");
    private By _checkoutButton = By.id("checkout");
    private By _assertTermsOfService = By.xpath("//div[7]/div[2]/p");
    private By _termsOfServiceCloseButton = By.xpath("//div[7]/div[1]/button");
    private By _termsOfServiceBox = By.id("termsofservice");



    public void assertUserAddedAppleICamInShoppingCart(){

        Assert.assertEquals(getTextFromElement(_skuNumber),"APPLE_CAM");//display SKU:APPLE_CAM on Shopping Cart
    }
    public void clickOnCheckoutButtonAndTickTermsOfServiceBox(){

        clickOnElement(_checkoutButton);//click on "CHECKOUT" button
        Assert.assertEquals(getTextFromElement(_assertTermsOfService), "Please accept the terms of service before the next step.");//verify the message from alert
        clickOnElement(_termsOfServiceCloseButton);//click on X(close) button
        clickOnElement(_termsOfServiceBox);//tick "Terms and condition" box
        clickOnElement(_checkoutButton);//click on "CHECKOUT" button
    }

    public void clickOnTermsOfServiceAndCheckoutButton(){

        clickOnElement(_termsOfServiceBox);//tick "Terms and condition" box
        clickOnElement(_checkoutButton);//click on "CHECKOUT" button
    }
}
