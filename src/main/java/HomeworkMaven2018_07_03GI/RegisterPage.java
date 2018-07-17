package HomeworkMaven2018_07_03GI;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage extends  Utils {

    LoadProp loadProp = new LoadProp();
    private By _registerPageTitleText = By.xpath("//div[@class=\"page-title\"]/h1");
    private By _genderFemale = By.id("gender-female");
    private By _firstNameField = By.id("FirstName");
    private By _lastNameField = By.id("LastName");
    private By _dayOfBirthField = By.name("DateOfBirthDay");
    private By _monthOfBirthField = By.name("DateOfBirthMonth");
    private By _yearOfBirthField = By.name("DateOfBirthYear");
    private By _emailField = By.id("Email");
    private By _companyField = By.id("Company");
    private By _newsLetter = By.id("Newsletter");
    private By _passwordField = By.id("Password");
    private By _confirmPasswordField = By.id("ConfirmPassword");
    private By _registerButton = By.id("register-button");

    public void verifyUserIsOnRegisterPage() {

        Assert.assertTrue(getTextFromElement(_registerPageTitleText).contains("Register"));
    }
    public void registerUser(boolean pass){
        clickOnElement(_genderFemale);//click on gender radio button
        enterText(_firstNameField,"Dana");//complete the first name
        enterText(_lastNameField,"Ciutulin");//complete the last name
        selectFromDropDown(_dayOfBirthField,"29");//choose day of birth
        selectFromDropDown(_monthOfBirthField,"July");//choose month of birth
        selectFromDropDown(_yearOfBirthField,"2000");//choose year of birth
        if (pass == true) {
            enterText(_emailField, generateEmail()); //it is generate random email address
        }
        else{
            enterText(_emailField,"cabs$yahoo.com"); //the email address is not right on purpose
        }
        enterText(_companyField,"Unique");//complete the company name
        clickOnElement(_newsLetter);//untick radio button
        enterText(_passwordField,"123456789");//enter password
        enterText(_confirmPasswordField,"123456789");//confirm password
        clickOnElement(_registerButton);//click on register button

    }
}
