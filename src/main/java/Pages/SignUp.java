package Pages;

import Utilities.Driver;
import Utilities.Actions;
import Data.Data;
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
        Actions.sendText(nameField , name);
        return this;
    }

    public SignUp enterYourEmailAddress(String email)
    {
        Actions.sendText(emailAddressField , email);
        return this;
    }

    public SignUp clickOnSignupButton()
    {
        Actions.clicker( signupButton);
        return this;
    }

    public SignUp clickOnGender()
    {
        Actions.clicker( titleIcon);
        return this;
    }

    public SignUp enterPassword(String password)
    {
        Actions.sendText(passwordField , password);
        return this;
    }

    public SignUp selectDateOfBirth_Days(String days)
    {
        Actions.select(daysDropdown , days);
        return this;
    }

    public SignUp selectDateOfBirth_Months(String months)
    {
        Actions.select(monthsDropdown , months);
        return this;
    }

    public SignUp selectDateOfBirth_Years(String years)
    {
        Actions.select(yearsDropdown , years);
        return this;
    }

    public SignUp enterYourFirstName(String firstName)
    {
        Actions.sendText(fNameField , firstName);
        return this;
    }

    public SignUp enterYourLastName(String lastName)
    {
        Actions.sendText(lNameField , lastName);
        return this;
    }

    public SignUp enterYourAddress(String address)
    {
        Actions.sendText(addressField , address);
        return this;
    }

    public SignUp selectYourCountry(String  country)
    {
        Actions.select(countryDropdown , country);
        return this;
    }

    public SignUp enterYourState(String state)
    {
        Actions.sendText(stateField , state);
        return this;
    }

    public SignUp enterYourCity(String city)
    {
        Actions.sendText(cityField , city);
        return this;
    }

    public SignUp enterYourZipcode(String zipcode)
    {
        Actions.scrollToElement(zipcodeField);
        Actions.sendText(zipcodeField , zipcode);
        return this;
    }

    public SignUp enterYourMobileNumber(String mobileNumber)
    {
        Actions.scrollToElement(mobileNumberField);
        Actions.sendText(mobileNumberField , mobileNumber);
        return this;
    }

    public SignUp clickOnCreateAccountButton()
    {
        Actions.scrollToElement(createAccountButton);
        Actions.clicker(createAccountButton);
        return this;
    }

    public SignUp clickOnContinueButton()
    {
        Actions.clicker(continueButton);
        return this;
    }

    public String  validationMessageAccountCreated()
    {
        return driver.findElement(accountCreatedMessage).getText();
    }

    public String validationMessageForExistingEmail()
    {
        return driver.findElement(emailExistValidationMessage).getText();
    }
    public void theUserSignInSuccessfully()
    {
        enterYourNameField(Data.dataClass("Name"));
        enterYourEmailAddress(Data.randomEmail);
        clickOnSignupButton();
        clickOnGender();
        enterPassword(Data.dataClass("Password"));
        selectDateOfBirth_Days(Data.dataClass("Day"));
        selectDateOfBirth_Months(Data.dataClass("Month"));
        selectDateOfBirth_Years(Data.dataClass("Year"));
        enterYourFirstName(Data.dataClass("FirstName"));
        enterYourLastName(Data.dataClass("LastName"));
        enterYourAddress(Data.dataClass("Address"));
        selectYourCountry(Data.dataClass("Country"));
        enterYourState(Data.dataClass("State"));
        enterYourCity(Data.dataClass("City"));
        enterYourZipcode(Data.dataClass("ZipCode"));
        enterYourMobileNumber(Data.dataClass("MobileNumber"));
        clickOnCreateAccountButton();
    }

    public void userWillRegisterWithTheSameEmail()
    {
        enterYourNameField(Data.dataClass("Name"));
        enterYourEmailAddress(Data.randomEmail);
        clickOnSignupButton();
    }

}
