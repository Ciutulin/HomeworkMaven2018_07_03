package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;

public class CheckoutPage extends Utils {

    private By _firstNameField = By.id("BillingNewAddress_FirstName");
    private By _lastNameFIeld = By.id("BillingNewAddress_LastName");
    private By _emailAddressField = By.id("BillingNewAddress_Email");
    private By _countryField = By.id("BillingNewAddress_CountryId");
    private By _stateField = By.id("BillingNewAddress_StateProvinceId");
    private By _cityField = By.id("BillingNewAddress_City");
    private By _address1Field = By.id("BillingNewAddress_Address1");
    private By _postCodeField = By.id("BillingNewAddress_ZipPostalCode");
    private By _telephoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    private By _continueButton = By.xpath("//input[@class='button-1 new-address-next-step-button']");
    private By _nextDayAirButton = By.id("shippingoption_1");
    private By _shippingMethodContinueButton = By.xpath("//form/div[2]/input");
    private By _creditCardButton = By.id("paymentmethod_1");
    private By _creditCardContinueButton = By.xpath("//li[4]/div[2]/div[1]/input");
    private By _creditCardType = By.id("CreditCardType");
    private By _cardHolderNameField = By.id("CardholderName");
    private By _cardNumber = By.id("CardNumber");
    private By _expireMonth = By.id("ExpireMonth");
    private By _expireYear = By.id("ExpireYear");
    private By _cardCode = By.id("CardCode");
    private By _paymentInformationContinueButton = By.xpath("//li[5]/div[2]/div[1]/input");
    private By _confirmOrderButton = By.xpath("//li[6]/div[2]/div[2]/input");
    //private By _

    public void enterDetailsForGuestBillingAddress(){
        enterText(_firstNameField, "Dana");//fill in the first name field
        enterText(_lastNameFIeld, "Ciutulin");//fill in the last name field
        enterText(_emailAddressField, generateEmail());//generate an random email address
        selectFromDropDown(_countryField, "United States");//enter country
        selectFromDropDown(_stateField, "Alabama");//select State
        enterText(_cityField, "New York");//enter city
        enterText(_address1Field, "28 Main Road");//enter address
        enterText(_postCodeField, "NW1 2NW");//enter postCode
        enterText(_telephoneNumberField, "0123456789");//enter telephone number
        clickOnElement(_continueButton);//click on "CONTINUE" button
    }

    public void chooseShippingMethod(){
        clickOnElement(_nextDayAirButton);//click on "Next Day Air" radio button
        clickOnElement(_shippingMethodContinueButton);//click on "CONTINUE" button
    }

    public void choosePaymentMethod(){
        clickOnElement(_creditCardButton);//click on Credit Card radio button
        clickOnElement(_creditCardContinueButton);//click on "CONTINUE" button

    }

    public void enterPaymentInformation(){
        selectFromDropDown(_creditCardType, "Visa");//chose from drop down list Credit Card Visa
        enterText(_cardHolderNameField, "Daniel Harris");//enter Cardholder Name
        enterText(_cardNumber, "4940666023952776");//introduce credit Card number
        selectFromDropDown(_expireMonth, "11");//select expireMonth
        selectFromDropDown(_expireYear, "2020");//select expireYear
        enterText(_cardCode, "877");//enter CVV number
        clickOnElement(_paymentInformationContinueButton);//click on "CONTINUE" button
    }

    public void confirmOrder(){
        waitForElementToBeClickable(_confirmOrderButton, 10);//wait for 'CONFIRM' button to be clickable
        clickOnElement(_confirmOrderButton);//click on 'CONFIRM' button
    }

    public void enterDetailsForUserBillingAddress(){
        selectFromDropDown(_countryField, "United States");//enter country
        selectFromDropDown(_stateField, "Alabama");//select State
        enterText(_cityField, "New York");//enter city
        enterText(_address1Field, "28 Main Road");//enter address
        enterText(_postCodeField, "NW1 2NW");//enter postCode
        enterText(_telephoneNumberField, "0123456789");//enter telephone number
        clickOnElement(_continueButton);//click on "CONTINUE" button
    }




    //we are on Credit Card details page

}
