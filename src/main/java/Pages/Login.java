package Pages;

import Data.DataClass;
import Utilities.Driver;
import Utilities.Actions;
import Data.ReadFromJson;
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
        Actions.sendText(emailAddressField , email);
        return this;
    }

    public Login enterYourPassword(String password)
    {
        Actions.sendText(passwordField , password);
        return this;
    }

    public Login clickOnLoginButton()
    {
        Actions.clicker(loginButton);
        return this;
    }

    public String loginText()
    {
        return driver.findElement(loginText).getText();
    }

    public String errorMessageWithIncorrectEmail()
    {
        return driver.findElement(errorMessageWithIncorrectMail).getText();
    }

    public void userWillLogInToHisAccount(String Email)
    {
        enterYourEmail(Email);
        enterYourPassword(DataClass.password);
        clickOnLoginButton();
    }
}
