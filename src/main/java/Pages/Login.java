package Pages;

import Data.DataClass;
import Utilities.Driver;
import Utilities.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Login extends Driver {

    public Login (WebDriver driver)
    {
        super(driver);
    }

    private final By loginText = By.xpath("//div[@class = 'login-form']//h2");
    private final By emailAddressField = By.xpath("//input[@data-qa = 'login-email']");
    private final By passwordField = By.xpath("//input[@data-qa = 'login-password']");
    private final By loginButton = By.xpath("//button[@data-qa = 'login-button']");
    private final By errorMessageWithIncorrectMail = By.xpath("//p[text() = 'Your email or password is incorrect!']");


    public Login enterYourEmail(String email)
    {
        Action.sendText(emailAddressField , email);
        return this;
    }

    public Login enterYourPassword(String password)
    {
        Action.sendText(passwordField , password);
        return this;
    }

    public Login clickOnLoginButton()
    {
        Action.clicker(loginButton);
        return this;
    }

    public String loginText()
    {
        return Action.getText(loginText);
    }

    public String errorMessageWithIncorrectEmail()
    {
        return Action.getText(errorMessageWithIncorrectMail);
    }


    //-------------many actions at one method to call it at the test file------------

    public void userWillLogInToHisAccount(String Email)
    {
        enterYourEmail(Email);
        enterYourPassword(DataClass.password);
        clickOnLoginButton();
    }
}
