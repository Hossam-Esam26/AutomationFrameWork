package Pages;

import Data.DataClass;
import Utilities.Actions;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Driver {

    public HomePage (WebDriver driver)
    {
        super(driver);
    }
    private final By signupAndLoginButton = By.xpath("//a[text() = ' Signup / Login']");
    private final By logoutButton = By.xpath("//a[text() = ' Logout']");
    private final By contactusButton = By.xpath("//a[text() = ' Contact us']");
    private final By productsButton = By.xpath("//a[text() = ' Products']");
    private final By subscriptionLabel = By.xpath("//h2[text() = 'Subscription']");
    private final By subscriptionField = By.xpath("//input[@id = 'susbscribe_email']");
    private final By subscribeButton = By.xpath("//button[@id = 'subscribe']");
    private final By successSubscriptionMessage = By.xpath("//div[@class = 'alert-success alert']");

    public HomePage clickOnSignupAndLoginButton()
    {
        Actions.clicker(signupAndLoginButton);
        return this;
    }

    public HomePage clickOnLogoutButton()
    {
        Actions.clicker(logoutButton);
        return this;
    }

    public HomePage clickOnContactusButton()
    {
        Actions.clicker(contactusButton);
        return this;
    }

    public HomePage clickOnProductsButton()
    {
        Actions.clicker(productsButton);
        return this;
    }

    public String getSubscriptionLabel()
    {
        Actions.scrollToElement(subscriptionLabel);
        return driver.findElement(subscriptionLabel).getText();
    }

    public HomePage enterYourEmailToSubscribe()
    {
        Actions.sendText(subscriptionField , DataClass.email);
        return this;
    }

    public HomePage clickOnSubscribeButton()
    {
        Actions.clicker(subscribeButton);
        return this;
    }

    public String getSuccessSubscriptionMessage()
    {
        return driver.findElement(successSubscriptionMessage).getText();
    }
}
