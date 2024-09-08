package Pages;

import Data.DataClass;
import Utilities.Driver;
import Utilities.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp extends Driver {
    public SignUp(WebDriver driver) {
        super(driver);
    }

    private final By nameField = By.xpath("//input[@name='name']");
    private final By emailAddressField = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = By.xpath("//button[@data-qa = 'signup-button']");
    private final By titleIcon = By.id("id_gender1");
    private final By passwordField = By.id("password");
    private final By daysDropdown = By.id("days");
    private final By monthsDropdown = By.id("months");
    private final By yearsDropdown = By.id("years");
    private final By fNameField = By.id("first_name");
    private final By lNameField = By.id("last_name");
    private final By addressField = By.id("address1");
    private final By countryDropdown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button [@data-qa = 'create-account']");
    private final By continueButton = By.xpath("//a[@data-qa= 'continue-button']");
    private final By accountCreatedMessage = By.xpath("//b[text() = 'Account Created!']");
    private final By emailExistValidationMessage = By.xpath("//p [text() = 'Email Address already exist!']");


    public SignUp enterYourNameField(String name)
    {
        Action.sendText(nameField , name);
        return this;
    }

    public SignUp enterYourEmailAddress(String email)
    {
        Action.sendText(emailAddressField , email);
        return this;
    }

    public SignUp clickOnSignupButton()
    {
        Action.clicker( signupButton);
        return this;
    }

    public SignUp clickOnGender()
    {
        Action.clicker( titleIcon);
        return this;
    }

    public SignUp enterPassword(String password)
    {
        Action.sendText(passwordField , password);
        return this;
    }

    public SignUp selectDateOfBirth_Days(String days)
    {
        Action.select(daysDropdown , days);
        return this;
    }

    public SignUp selectDateOfBirth_Months(String months)
    {
        Action.select(monthsDropdown , months);
        return this;
    }

    public SignUp selectDateOfBirth_Years(String years)
    {
        Action.select(yearsDropdown , years);
        return this;
    }

    public SignUp enterYourFirstName(String firstName)
    {
        Action.sendText(fNameField , firstName);
        return this;
    }

    public SignUp enterYourLastName(String lastName)
    {
        Action.sendText(lNameField , lastName);
        return this;
    }

    public SignUp enterYourAddress(String address)
    {
        Action.sendText(addressField , address);
        return this;
    }

    public SignUp selectYourCountry(String  country)
    {
        Action.select(countryDropdown , country);
        return this;
    }

    public SignUp enterYourState(String state)
    {
        Action.sendText(stateField , state);
        return this;
    }

    public SignUp enterYourCity(String city)
    {
        Action.sendText(cityField , city);
        return this;
    }

    public SignUp enterYourZipcode(String zipcode)
    {
        Action.scrollToElement(zipcodeField);
        Action.sendText(zipcodeField , zipcode);
        return this;
    }

    public SignUp enterYourMobileNumber(String mobileNumber)
    {
        Action.scrollToElement(mobileNumberField);
        Action.sendText(mobileNumberField , mobileNumber);
        return this;
    }

    public SignUp clickOnCreateAccountButton()
    {
        Action.scrollToElement(createAccountButton);
        Action.clicker(createAccountButton);
        return this;
    }

    public SignUp clickOnContinueButton()
    {
        Action.clicker(continueButton);
        return this;
    }

    public String  validationMessageAccountCreated()
    {
        return Action.getText(accountCreatedMessage);
    }

    public String validationMessageForExistingEmail()
    {
        return Action.getText(emailExistValidationMessage);
    }


    //-------------many actions at one method to call it at the test file------------

    public SignUp theUserSignInSuccessfully(String Email)
    {
        enterYourNameField(DataClass.userName);
        enterYourEmailAddress(Email);
        clickOnSignupButton();
        clickOnGender();
        enterPassword(DataClass.password);
        selectDateOfBirth_Days(DataClass.day);
        selectDateOfBirth_Months(DataClass.month);
        selectDateOfBirth_Years(DataClass.year);
        enterYourFirstName(DataClass.firstName);
        enterYourLastName(DataClass.lastName);
        enterYourAddress(DataClass.address);
        selectYourCountry(DataClass.country);
        enterYourState(DataClass.state);
        enterYourCity(DataClass.city);
        enterYourZipcode(DataClass.zipCode);
        enterYourMobileNumber(DataClass.mobileNumber);
        clickOnCreateAccountButton();
        return this;
    }

    public void userWillRegisterWithTheSameEmail()
    {
        enterYourNameField(DataClass.userName);
        enterYourEmailAddress(DataClass.emailOne);
        clickOnSignupButton();
    }

}
