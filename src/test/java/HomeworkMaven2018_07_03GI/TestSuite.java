package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSuite extends BaseTest {

    /*@Test // This is a test method
    public void verifyUserShouldBeOnHomePage ()
    {

        Assert.assertEquals(getTextFromElement(By.linkText("Register")),"Register");


    }*/
    @Test // This is a test method
    public void verifyUserShouldBeAbleToRegisterSuccessfully ()
    {

        clickOnElement(By.linkText("Register"));
        clickOnElement(By.id("gender-female"));
        enterText(By.name("FirstName"),"DanaBen");
        enterText(By.name("LastName"), "Patel");
        selectFromDropDown("DateOfBirthDay", "5");
        selectFromDropDown("DateOfBirthMonth","July");
        selectFromDropDown("DateOfBirthYear", "2015");
        enterText(By.id("Email"),generateEmail());
        enterText(By.id("Company"),"Unik");
        clickOnElement(By.name("Newsletter"));
        enterText(By.id("Password"),"123456789");
        enterText(By.id("ConfirmPassword"),"123456789");


        waitForElementToBeClickable(By.id("register-button"),2);
        clickOnElement(By.id("register-button"));


        Assert.assertEquals(getTextFromElement(By.xpath("//*[@class='result']")),"Your registration completed");


    }

    @Test

    public void verifyCompareProducts() {

        clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[2]/input[2]"));


        waitVisibilityOfElementLocatede(By.className("close"),10);
        clickOnElement(By.className("close"));
        waitVisibilityOfElementLocatede(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[4]/div/div[2]/div[3]/div[2]/input[2]"),10);
        clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[4]/div/div[2]/div[3]/div[2]/input[2]"));

        waitVisibilityOfElementLocatede(By.xpath("//*[@href='/compareproducts']"),10);
        clickOnElement(By.xpath("//*[@href='/compareproducts']"));

        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='page-title']")),"Compare products");

    }
     @Test

     public void verifyIfUserShouldBeAbleToClearTheProductList(){
         clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[2]/input[2]"));
         clickOnElement(By.linkText("product comparison"));
         clickOnElement(By.className("clear-list"));
         Assert.assertEquals(getTextFromElement(By.xpath("//*[@class='no-data']")), "You have no items to compare.");

        }
     @Test
     public void verifyUserCanShortAndDisplayProducts(){

        clickOnElement(By.linkText("Books"));
        selectFromDropDown("products-orderby","Price: Low to High");
        selectFromDropDown("products-pagesize","3");

         String firstProductPriceText = getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/span[2]"));
         String secondProductPriceText = getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[3]/div[1]/span[2]"));
         String thirdProductPriceText = getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[3]/div/div[2]/div[3]/div[1]/span[2]"));

         double firstProductPrice=Double.parseDouble(firstProductPriceText.replace("$",""));
         double secondProductPrice=Double.parseDouble(secondProductPriceText.replace("$",""));
         double thirdProductPrice=Double.parseDouble(thirdProductPriceText.replace("$",""));


         Assert.assertTrue(firstProductPrice<secondProductPrice&&secondProductPrice<thirdProductPrice);
     }







     @Test
    public void verifyUserCanAddAProductToShoppingCart(){

        clickOnElement(By.linkText("Electronics"));
        clickOnElement(By.linkText("Camera & photo"));
        clickOnElement(By.linkText("Apple iCam"));
        clickOnElement(By.id("add-to-cart-button-17"));
        clickOnElement(By.className("cart-label"));

        Assert.assertEquals(getTextFromElement(By.className("sku-number")),"APPLE_CAM");

     }




}
