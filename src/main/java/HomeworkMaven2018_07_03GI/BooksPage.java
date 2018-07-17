package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.testng.Assert;

import static HomeworkMaven2018_07_03GI.Utils.getTextFromElement;
import static HomeworkMaven2018_07_03GI.Utils.selectFromDropDown;

public class BooksPage extends Utils {

    private By _sortByDropDown = By.id("products-orderby");
    private By _displayDropDown = By.id("products-pagesize");
    private By _priceForPrideAndPrejudiceBook = By.xpath("//div[1]/div[1]/div[2]/div[3]/div[1]/span[2]");
    private By _priceForFahrenheit451ByRayBradburyBook = By.xpath("//div[2]/div/div[2]/div[3]/div[1]/span[2]");
    private By _priceForFirstPrizePies = By.xpath("//div[3]/div/div[2]/div[3]/div[1]/span[2]");

    public void sortByAndDisplayBooks(){

        selectFromDropDown(_sortByDropDown,"Price: Low to High");//select from "Sort by" Drop-down "Price: Low to High"
        selectFromDropDown(_displayDropDown,"3");//select from "Display" Drop-down "3" value

        String firstProductPriceText = getTextFromElement(_priceForPrideAndPrejudiceBook);//get full price(dollar sign and number) for Pride and Prejudice book
        String secondProductPriceText = getTextFromElement(_priceForFahrenheit451ByRayBradburyBook);//get full price(dollar sign and number) for "Fahrenheit 451 by Ray Bradbury" book
        String thirdProductPriceText = getTextFromElement(_priceForFirstPrizePies);//get full price(dollar sign and number) for "First Prize Pies" book

        double firstProductPrice=Double.parseDouble(firstProductPriceText.replace("$",""));//from the full price string take just the value with floated point for Prejudice book
        double secondProductPrice=Double.parseDouble(secondProductPriceText.replace("$",""));//from the full price string take just the value with floated point for "Fahrenheit 451 by Ray Bradbury" book
        double thirdProductPrice=Double.parseDouble(thirdProductPriceText.replace("$",""));//from the full price string take just the value with floated point "First Prize Pies" book


        Assert.assertTrue(firstProductPrice<secondProductPrice&&secondProductPrice<thirdProductPrice);//test to see if the sort is correct
    }


}

