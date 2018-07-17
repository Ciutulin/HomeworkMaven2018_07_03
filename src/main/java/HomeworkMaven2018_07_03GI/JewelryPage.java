package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;

import static HomeworkMaven2018_07_03GI.Utils.clickOnElement;
import static HomeworkMaven2018_07_03GI.Utils.waitVisibilityOfElementLocatede;

public class JewelryPage {

    private By _flowerGirlBraceletAddToCartButton = By.xpath("//div[2]/div[1]/div[2]/div[3]/div[2]/input");
    private By _waitForGreenNotificationBarToAppear = By.className("close");
    private By _vintageStileEngagementRingButton = By.xpath("//div[3]/div[1]/div[2]/div[3]/div[2]/input");
    private By _shoppingCartLink = By.xpath("//a[@href='/cart']");

    public void addTwoProductsInShoppingCart(){

        clickOnElement(_flowerGirlBraceletAddToCartButton);//click on "Flower Girl Bracelet", "ADD TO CART" button

        waitVisibilityOfElementLocatede(_waitForGreenNotificationBarToAppear, 10);//wait for the green bar to appear
        clickOnElement(_waitForGreenNotificationBarToAppear);//press on X(close) button on the green bar

        clickOnElement(_vintageStileEngagementRingButton);//click on "Vintage Style Engagement Ring", "ADD TO CART" button
        clickOnElement(_shoppingCartLink);//click on "Shopping Cart" link
    }

    public void addOneProductInShoppingCart(){

        clickOnElement(_flowerGirlBraceletAddToCartButton);//click on "Flower Girl Bracelet", "ADD TO CART" button
        clickOnElement(_shoppingCartLink);//click on "Shopping Cart" link

    }
}
