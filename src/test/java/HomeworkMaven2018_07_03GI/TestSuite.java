package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestSuite extends BaseTest {

    HomePage homepage=new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegisterResult registerResult = new RegisterResult();
    CompareProducts compareProducts = new CompareProducts();
    BooksPage booksPage = new BooksPage();
    ElectronicsPage electronicsPage = new ElectronicsPage();
    CameraPhotoPage cameraPhotoPage = new CameraPhotoPage();
    AppleiCamPage appleiCamPage = new AppleiCamPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    JewelryPage jewelryPage = new JewelryPage();
    WelcomePleaseSignInPage welcomePleaseSignInPage = new WelcomePleaseSignInPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutCompletedPage checkoutCompletedPage = new CheckoutCompletedPage();
    VirtualGiftCardPage virtualGiftCardPage = new VirtualGiftCardPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();

    @Test
    public void verifyUserShouldBeOnRegisterPage ()
    {
        homepage.clickOnRegister();
        registerPage.verifyUserIsOnRegisterPage();
    }


    @Test
    public void verifyUserShouldBeAbleToRegisterSuccessfully ()
    {
     homepage.clickOnRegister();
     registerPage.registerUser(true);
     registerResult.assertRegisterResult();//display "Your registration completed" message
    }


    @Test
    public void verifyCompareProducts() {
        homepage.compareTwoProducts();
        compareProducts.assertCompareTwoProducts();
    }


    @Test
    public void verifyIfUserShouldBeAbleToClearTheProductList(){
        homepage.clickOnBuildYourOwnComputerAddToCartAndGreenBarNotification();
        compareProducts.clearListOnCompareProductsPage();
    }


    @Test
    public void verifyUserCanSortAndDisplayProducts() {
         homepage.clickOnBooksLink();
         booksPage.sortByAndDisplayBooks();
    }

    @Test
    public void verifyUserCanAddAProductToShoppingCart(){
        homepage.clickOnElectronicsLink();
        electronicsPage.clickOnCameraPhotoLink();
        cameraPhotoPage.clickOnAppleICamLink();
        appleiCamPage.clickOnAddToCartButton();
        appleiCamPage.clickOnShoppingCart();
        shoppingCartPage.assertUserAddedAppleICamInShoppingCart();
     }


    @Test
    public void verifyUserCanBuyTwoProductsAsAGuest() {
         homepage.ClickOnJewelryLink();
         jewelryPage.addTwoProductsInShoppingCart();
         shoppingCartPage.clickOnCheckoutButtonAndTickTermsOfServiceBox();
         welcomePleaseSignInPage.checkoutAsAGuest();
         checkoutPage.enterDetailsForGuestBillingAddress();
         checkoutPage.chooseShippingMethod();
         checkoutPage.choosePaymentMethod();
         checkoutPage.enterPaymentInformation();
         checkoutPage.confirmOrder();
         checkoutCompletedPage.assertOrderCompleted();


        /* String Actualtext = driver.getCurrentUrl(); //initialise a variable with Current URL
         Assert.assertEquals(Actualtext, "http://demo.nopcommerce.com/checkout/completed/");//assert for URL (here we have actual result and expected result)

         Assert.assertEquals(driver.findElement(By.xpath("//div[3]/input")).getAttribute("value"), "Continue");
        /*driver find element(se uita la un element), we are giving the Xpath to the element "Continue",
        get attribute take "the value" property from the element"Continue"(continue button),
        in expected result we are writing the atribute vallue = "Continue"*/
     }


    @Test
    public void verifyUserCanBuyOneProductAsARegister(){
         homepage.ClickOnJewelryLink();
         jewelryPage.addOneProductInShoppingCart();
         shoppingCartPage.clickOnTermsOfServiceAndCheckoutButton();
         welcomePleaseSignInPage.clickOnShoppingCartList();
         registerPage.registerUser(true);
         registerResult.assertRegisterResult();
         registerResult.clickOnContinueButton();
         shoppingCartPage.clickOnTermsOfServiceAndCheckoutButton();
         checkoutPage.enterDetailsForUserBillingAddress();
         checkoutPage.chooseShippingMethod();
         checkoutPage.choosePaymentMethod();
         checkoutPage.enterPaymentInformation();
         checkoutPage.confirmOrder();
         checkoutCompletedPage.assertOrderCompleted();
     }


    @Test
    public void verifyUserCanChangeCurrency(){
        homepage.changeCurrency();

         //I've changed the Currency from dollars to euro
        // Assert.assertEquals(getTextFromElement(By.xpath("//div[2]/div[1]/div[2]/div[3]/div[1]/span")),"€1710.00");//in expected result noi scriem rezultatul nu il generam din alta parte


         //getTextFromElement(By.xpath("//div[2]/div[1]/div[2]/div[3]/div[1]/span")) = asta imi returneaza €1710.00
         //.charAt(0) imi ia primul caracter din stringul "€1710.00"
         /*in assert trebuie sa comparam doua variabile de acelasi tip, in cazul de fata char with char,
         a trebuit sa schimbam expected result in char pentru ca rezultatul sa fie pass*/

         //String Currency = "€1710.00";//variabila de tip string
        //char aChar = Currency.charAt(0);//variabila de tip char*/
         }

    @Test
    public void verifyUserShouldBeAbleToSendEmailToAFriend(){
         homepage.clickOnVirtualGiftCardLink();
         virtualGiftCardPage.clickOnEmailToAFriendButton();
         emailAFriendPage.completeFormUnregisteredUser();
         registerPage.registerUser(true);
         registerResult.clickOnContinueButton();
         homepage.clickOnVirtualGiftCardLink();
         virtualGiftCardPage.clickOnEmailToAFriendButton();
         emailAFriendPage.completeFormRegisteredUser();
    }

    @Test
    public void verifyScreenShotIsTakenIfTheUserIsNotRegisterSuccessfully(){
         homepage.clickOnRegister();
         registerPage.registerUser(false);
         registerResult.assertRegisterResult();
    }


    @Test
    public void verifyAddCartButtonPresentInEachProduct(){
         homepage.countProductsWithAddToCartButton();
    }



}
