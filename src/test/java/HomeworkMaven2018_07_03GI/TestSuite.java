package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
        clickOnElement(By.linkText("Register"));//click on register button
        clickOnElement(By.id("gender-female"));//click on gender radio button
        enterText(By.id("FirstName"),"Dana");//complete the first name
        enterText(By.id("LastName"),"Ciutulin");//complete the last name
        selectFromDropDown(By.name("DateOfBirthDay"),"29");//choose day of birth
        selectFromDropDown(By.name("DateOfBirthMonth"),"July");//choose month of birth
        selectFromDropDown(By.name("DateOfBirthYear"),"2000");//choose year of birth
        enterText(By.id("Email"),generateEmail()); //it is generate random email address
        enterText(By.id("Company"),"Unique");//complete the company name
        clickOnElement(By.id("Newsletter"));//untick radio button
        enterText(By.id("Password"),"123456789");//enter password
        enterText(By.id("ConfirmPassword"),"123456789");//confirm password
        clickOnElement(By.id("register-button"));//click on register button

        Assert.assertEquals(getTextFromElement(By.className("result")),"Your registration completed");//display "Your registration completed" message


    }

    @Test

    public void verifyCompareProducts() {

        clickOnElement(By.xpath("//div[1]/div[1]/div[2]/div[3]/div[2]/input[2]"));//click on Build your own computer add to compare button


        waitVisibilityOfElementLocatede(By.className("close"),10);//wait for the green bar to appear
        clickOnElement(By.className("close"));//click on X  from green line
        waitVisibilityOfElementLocatede(By.xpath("//div[4]/div/div[2]/div[3]/div[2]/input[2]"),10);//wait for Virtual Gift Card Add to compare button to be activated
        clickOnElement(By.xpath("//div[4]/div/div[2]/div[3]/div[2]/input[2]"));//click on Virtual Gift Card add to compare button

        clickOnElement(By.id("bar-notification"));//click on green bar notification
       // waitForElementToBeClickable(By.xpath("//div[5]/p/a"),10);//

        int attempts = 0;//declare and initialise a variable
        while(attempts < 2) {//loop which run twice
            try {
                clickOnElement(By.xpath("//div[5]/p/a"));//click on "product comparison link" from green bar
                break;//sa iasa daca a reusit sa functioneze din prima incercare
            } catch(StaleElementReferenceException e){
            }
            attempts++;
        }/*try incearca sa dea click pe link(product comparation) si daca da eroare il pune in catch
         si nu oprest executia programului, apoi mai incearca o data sa execute click-ul si se pp ca in pasul asta functioneza */

        /*waitForElementToBeClickable(By.xpath("//div[1]/div[2]/ul/li[5]/a"),10);//wait for "Compare product list" link to be clickable
        clickOnElement(By.xpath("//div[1]/div[2]/ul/li[5]/a"));//click on "Compare product list" link

        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='page-title']")),"Compare products");//display "Compare products" page title*/


    }
     @Test

     public void verifyIfUserShouldBeAbleToClearTheProductList(){
         clickOnElement(By.xpath("//div[1]/div[1]/div[2]/div[3]/div[2]/input[2]"));//click on Build your own computer add to compare button
         clickOnElement(By.linkText("product comparison"));//click on product comparison link from the top green line
         clickOnElement(By.className("clear-list"));//click on clear list button
         Assert.assertEquals(getTextFromElement(By.xpath("//*[@class='no-data']")), "You have no items to compare.");//display "You have no items to compare." message

        }
     @Test
     public void verifyUserCanSortAndDisplayProducts(){

        clickOnElement(By.linkText("Books"));//click on Books link
        selectFromDropDown(By.id("products-orderby"),"Price: Low to High");//select from "Sort by" Drop-down "Price: Low to High"
        selectFromDropDown(By.id("products-pagesize"),"3");//select from "Display" Drop-down "3" value


         String firstProductPriceText = getTextFromElement(By.xpath("//div[1]/div[1]/div[2]/div[3]/div[1]/span[2]"));//get full price(dollar sign and number) for Pride and Prejudice book
         String secondProductPriceText = getTextFromElement(By.xpath("//div[2]/div/div[2]/div[3]/div[1]/span[2]"));//get full price(dollar sign and number) for "Fahrenheit 451 by Ray Bradbury" book
         String thirdProductPriceText = getTextFromElement(By.xpath("//div[3]/div/div[2]/div[3]/div[1]/span[2]"));//get full price(dollar sign and number) for "First Prize Pies" book

         double firstProductPrice=Double.parseDouble(firstProductPriceText.replace("$",""));//from the full price string take just the value with floated point for Prejudice boo
         double secondProductPrice=Double.parseDouble(secondProductPriceText.replace("$",""));//from the full price string take just the value with floated point for "Fahrenheit 451 by Ray Bradbury" book
         double thirdProductPrice=Double.parseDouble(thirdProductPriceText.replace("$",""));//from the full price string take just the value with floated point "First Prize Pies" book


         Assert.assertTrue(firstProductPrice<secondProductPrice&&secondProductPrice<thirdProductPrice);//test to see if the sort is correct
     }







     @Test
    public void verifyUserCanAddAProductToShoppingCart(){

        clickOnElement(By.linkText("Electronics"));//click on "Electronics" menu
        clickOnElement(By.linkText("Camera & photo"));//click on "Camera and photo"
        clickOnElement(By.linkText("Apple iCam"));// click on "Apple iCam"
        clickOnElement(By.id("add-to-cart-button-17"));//click on "ADD TO CART" button
        clickOnElement(By.className("cart-label"));//click on Shopping Cart

        Assert.assertEquals(getTextFromElement(By.className("sku-number")),"APPLE_CAM");//display SKU:APPLE_CAM on Shopping Cart

     }

     @Test
    public void verifyUserCanBuyTwoProducts() {
         clickOnElement(By.xpath("//a[@href='/jewelry']"));//click on Jewelry button
         clickOnElement(By.xpath("//div[2]/div[1]/div[2]/div[3]/div[2]/input"));//click on "Flower Girl Bracelet", "ADD TO CART" button

         waitVisibilityOfElementLocatede(By.className("close"), 10);//wait for the green bar to appear
         clickOnElement(By.className("close"));//press on X(close) button on the green bar

         clickOnElement(By.xpath("//div[3]/div[1]/div[2]/div[3]/div[2]/input"));//click on "Vintage Style Engagement Ring", "ADD TO CART" button
         clickOnElement(By.xpath("//a[@href='/cart']"));//click on "Shopping Cart" link
         clickOnElement(By.id("checkout"));//click on "CHECKOUT" button

         Assert.assertEquals(getTextFromElement(By.xpath("//div[7]/div[2]/p")), "Please accept the terms of service before the next step.");//verify the message from alert
         clickOnElement(By.xpath("//div[7]/div[1]/button"));//click on X(close) button
         clickOnElement(By.id("termsofservice"));//tick "Terms and condition" box
         clickOnElement(By.id("checkout"));//click on "CHECKOUT" button
         clickOnElement(By.xpath("//div[1]/div[3]/input[1]"));//click on "Checkout as guest" button

         enterText(By.id("BillingNewAddress_FirstName"), "Dana");//fill in the first name field
         enterText(By.id("BillingNewAddress_LastName"), "Ciutulin");//fill in the last name field
         enterText(By.id("BillingNewAddress_Email"), generateEmail());//generate an random email address
         selectFromDropDown(By.id("BillingNewAddress_CountryId"), "United States");//enter country
         selectFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "Alabama");//select State
         enterText(By.id("BillingNewAddress_City"), "New York");//enter city
         enterText(By.id("BillingNewAddress_Address1"), "28 Main Road");//enter address
         enterText(By.id("BillingNewAddress_ZipPostalCode"), "NW1 2NW");//enter postCode
         enterText(By.id("BillingNewAddress_PhoneNumber"), "0123456789");//enter telephone number
         clickOnElement(By.xpath("//input[@class='button-1 new-address-next-step-button']"));//click on "CONTINUE" button

         //we are on check out page
         clickOnElement(By.id("shippingoption_1"));//click on "Next Day Air" radio button
         clickOnElement(By.xpath("//form/div[2]/input"));//click on "CONTINUE" button

         //we are on payment page
         clickOnElement(By.id("paymentmethod_1"));//click on Credit Card radio button
         clickOnElement(By.xpath("//li[4]/div[2]/div[1]/input"));//click on "CONTINUE" button

         //we are on Credit Card details page
         selectFromDropDown(By.id("CreditCardType"), "Visa");//chose from drop down list Credit Card Visa
         enterText(By.id("CardholderName"), "Daniel Harris");//enter Cardholder Name
         enterText(By.id("CardNumber"), "4940666023952776");//introduce credit Card number
         selectFromDropDown(By.id("ExpireMonth"), "11");//select expireMonth
         selectFromDropDown(By.id("ExpireYear"), "2020");//select expireYear
         enterText(By.id("CardCode"), "877");//enter CVV number
         clickOnElement(By.xpath("//li[5]/div[2]/div[1]/input"));//click on "CONTINUE" button

         waitForElementToBeClickable(By.xpath("//li[6]/div[2]/div[2]/input"), 10);//wait for element to be clickable
         clickOnElement(By.xpath("//li[6]/div[2]/div[2]/input"));//click on 'CONFIRM' button

         waitVisibilityOfElementLocatede(By.linkText("Click here for order details."), 10);//wait for element to be visible
         Assert.assertEquals(getTextFromElement(By.xpath("//div[2]/div[1]/div[1]/strong")), "Your order has been successfully processed!");//text assert


         String Actualtext = driver.getCurrentUrl(); //initialise a variable with Current URL
         Assert.assertEquals(Actualtext, "http://demo.nopcommerce.com/checkout/completed/");//assert for URL (here we have actual result and expected result)

         Assert.assertEquals(driver.findElement(By.xpath("//div[3]/input")).getAttribute("value"), "Continue");
        /*driver find element(se uita la un element), we are giving the Xpath to the element "Continue",
        get attribute take "the value" property from the element"Continue"(continue button),
        in expected result we are writing the atribute vallue = "Continue"*/
     }

     @Test
     public void verifyUserCanChangeCurrency(){

         selectFromDropDown(By.id("customerCurrency"),"Euro");//change currency from Dollars into Euro

         //I've changed the Currency from dollars to euro
        // Assert.assertEquals(getTextFromElement(By.xpath("//div[2]/div[1]/div[2]/div[3]/div[1]/span")),"€1710.00");//in expected result noi scriem rezultatul nu il generam din alta parte


         //I've compared the Euro symbol
         Assert.assertEquals(getTextFromElement(By.xpath("//div[2]/div[1]/div[2]/div[3]/div[1]/span")).charAt(0),'€');//in expected result noi scriem rezultatul nu il generam din alta parte

         //getTextFromElement(By.xpath("//div[2]/div[1]/div[2]/div[3]/div[1]/span")) = asta imi returneaza €1710.00
         //.charAt(0) imi ia primul caracter din stringul "€1710.00"
         /*in assert trebuie sa comparam doua variabile de acelasi tip, in cazul de fata char with char,
         a trebuit sa schimbam expected result in char pentru ca rezultatul sa fie pass*/

         //String Currency = "€1710.00";//variabila de tip string
        //char aChar = Currency.charAt(0);//variabila de tip char
         }

     @Test
          public void verifyUserShouldBeAbleToSendEmailToAFriend(){

         clickOnElement(By.linkText("$25 Virtual Gift Card"));//click on "Virtual Gift Card" button
         clickOnElement(By.xpath("//div[8]/div[3]/input"));//click on "Email to a friend" button
         enterText(By.id("FriendEmail"),"vladusnostradamus@yahoo.com");//complete the field with friend email address
         enterText(By.id("YourEmailAddress"),"danabunadimineata@yahoo.com");//complete the field with my email address
         enterText(By.id("PersonalMessage"),"hello");//complete the field with one message
         clickOnElement(By.xpath("//form/div[2]/input"));//click on "SEND EMAIL" button

         Assert.assertEquals(getTextFromElement(By.xpath("//form/div[1]/ul/li")),"Only registered customers can use email a friend feature");//display "Only registered customers can use email a friend feature" message



         clickOnElement(By.linkText("Register"));//click on register button
         clickOnElement(By.id("gender-female"));//click on gender radio button
         enterText(By.id("FirstName"),"Dana");//complete the first name
         enterText(By.id("LastName"),"Ciutulin");//complete the last name
         selectFromDropDown(By.name("DateOfBirthDay"),"29");//choose day of birth
         selectFromDropDown(By.name("DateOfBirthMonth"),"July");//choose month of birth
         selectFromDropDown(By.name("DateOfBirthYear"),"2000");//choose year of birth
         enterText(By.id("Email"),generateEmail()); // generate random email address
         enterText(By.id("Company"),"Unique");//complete the company name
         clickOnElement(By.id("Newsletter"));//untick radio button
         enterText(By.id("Password"),"123456789");//enter password
         enterText(By.id("ConfirmPassword"),"123456789");//confirm password
         clickOnElement(By.id("register-button"));//click on register button

         clickOnElement(By.xpath("//div[2]/input"));//click on "CONTINUE" button

         clickOnElement(By.linkText("$25 Virtual Gift Card"));//click on "Virtual Gift Card" button
         clickOnElement(By.xpath("//div[8]/div[3]/input"));//click on "Email to a friend" button

         enterText(By.id("FriendEmail"),"vladusnostradamus@yahoo.com");//complete the field with friend email address
         enterText(By.id("PersonalMessage"),"hello");//complete a message
        clickOnElement(By.xpath("//form/div[2]/input"));//click on "SEND EMAIL" button

        Assert.assertEquals(getTextFromElement(By.xpath("//div/div[1]/div[1]/div[1]/div[2]/div[2]")),"Your message has been sent.");//display "Your message has been sent." message


        }



}
