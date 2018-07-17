package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePage extends Utils {

    private By _registerButton = By.linkText("Register");
    private By _BuildYourOwnComputerAddToCompareButton = By.xpath("//div[1]/div[1]/div[2]/div[3]/div[2]/input[2]");
    private By _closeButtonOnGreenLine = By.className("close");
    private By _virtualGiftCardAddToCompareButton = By.xpath("//div[4]/div/div[2]/div[3]/div[2]/input[2]");
    private By _greenBarNotification = By.id("bar-notification");
    private By _productComparationLink = By.xpath("//div[5]/p/a");
    private By _booksLink = By.linkText("Books");
    private By _electronicsLink = By.linkText("Electronics");
    private By _jewelryLink = By.xpath("//a[@href='/jewelry']");
    private By _currencyDropDown = By.id("customerCurrency");
    private By _actualPrice = By.xpath("//div[2]/div[1]/div[2]/div[3]/div[1]/span");
    private By _virtualGiftCardLink = By.linkText("$25 Virtual Gift Card");
    private By _itemBoxesfield = By.className("product-item");//the way to the product items
    private By _addcartButtonfield = By.cssSelector("[type='button'][value='Add to cart']");//the way to the add to cart buttons
    private By _productnamefield = By.cssSelector("h2.product-title > a");//the way to the name of the product(ca sa ne spun care din produse nu are add to cart button)



    public void clickOnRegister(){

        clickOnElement(_registerButton);
    }

    public void compareTwoProducts(){

        clickOnElement(_BuildYourOwnComputerAddToCompareButton);//click on Build your own computer add to compare button
        waitVisibilityOfElementLocatede(_closeButtonOnGreenLine,10);//wait for the green bar to appear
        clickOnElement(_closeButtonOnGreenLine);//click on X  from green line
        waitVisibilityOfElementLocatede(_virtualGiftCardAddToCompareButton,10);//wait for Virtual Gift Card Add to compare button to be activated
        clickOnElement(_virtualGiftCardAddToCompareButton);//click on Virtual Gift Card add to compare button
        clickOnElement(_greenBarNotification);//click on green bar notification


        int attempts = 0;//declare and initialise a variable
        while(attempts < 2) {//loop which run twice
            try {
                clickOnElement(_productComparationLink);//click on "product comparison link" from green bar
                break;//sa iasa daca a reusit sa functioneze din prima incercare
            } catch(StaleElementReferenceException e){
            }
            attempts++;
        }/*try incearca sa dea click pe link(product comparation) si daca da eroare il pune in catch
         si nu oprest executia programului, apoi mai incearca o data sa execute click-ul si se pp ca in pasul asta functioneza */
    }

    public void clickOnBuildYourOwnComputerAddToCartAndGreenBarNotification(){
        clickOnElement(_BuildYourOwnComputerAddToCompareButton);//click on Build your own computer add to compare button
        waitVisibilityOfElementLocatede(_closeButtonOnGreenLine,10);//wait for the green bar to appear
        clickOnElement(_greenBarNotification);//click on green bar notification

        int attempts = 0;//declare and initialise a variable
        while(attempts < 2) {//loop which run twice
            try {
                clickOnElement(_productComparationLink);//click on "product comparison link" from green bar
                break;//sa iasa daca a reusit sa functioneze din prima incercare
            } catch(StaleElementReferenceException e){
            }
            attempts++;
        }/*try incearca sa dea click pe link(product comparation) si daca da eroare il pune in catch
         si nu oprest executia programului, apoi mai incearca o data sa execute click-ul si se pp ca in pasul asta functioneza */
    }

    public void clickOnBooksLink(){
        clickOnElement(_booksLink);//click on Books link
    }

    public void clickOnElectronicsLink(){
        clickOnElement(_electronicsLink);//click on "Electronics" menu
    }

    public void ClickOnJewelryLink(){
        clickOnElement(_jewelryLink);//click on Jewelry link
    }

    public void changeCurrency(){
        selectFromDropDown(_currencyDropDown,"Euro");//change currency from Dollars into Euro
        //I've compared the Euro symbol
        Assert.assertEquals(getTextFromElement(_actualPrice).charAt(0),'€');//in expected result noi scriem rezultatul nu il generam din alta parte
    }

    public void countProductsWithAddToCartButton (){

        List<WebElement> webElementList = driver.findElements(_itemBoxesfield);//creaza o lista cu elementele din pagina de tip produs
        int count = 0, nobutton = 0;//initiate a variable to count how many products has buttons add to cart and how many doesn't have add to cart buttons
        for (WebElement element : webElementList) {//parcurge fiecare element din lista

            if (element.findElements(_addcartButtonfield).size() == 1) {// verify if the current element has 'add to cart' button
                count++;//if has add to cart button it is counted

            }
            else  {//daca nu are buton
                nobutton++;//count the products that doesn't have 'add to cart' button
                System.out.println(getTextFromElement(_productnamefield) + "   NO ADD TO CART BUTTON ");//print the name of the product that desn't have add to cart button

            }
        }
        System.out.println(count);//print how many elements has add to cart button
        assertEquals(webElementList.size(), count);//verify if all the products have add to cart button
    }

    public void clickOnVirtualGiftCardLink(){
        clickOnElement(_virtualGiftCardLink);//click on "Virtual Gift Card" button
    }
}