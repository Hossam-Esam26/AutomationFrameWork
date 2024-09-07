package Pages;

import Data.DataClass;
import Utilities.Action;
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
    private final By cartButton = By.xpath("//a[text() = ' Cart']");
    private final By deleteAccountButton = By.xpath("//a[text() = ' Delete Account']");
    private final By categoryText = By.xpath("//h2[text() = 'Category']");
    private final By womenCategory = By.xpath("//div[@id = 'accordian']/div[1]/div[1]/h4/a");
    private final By womenCategory_Dress = By.xpath("//div[@id = 'Women']//a[text() = 'Dress ']");
    private final By categoryPageText = By.xpath("//div[@class = 'features_items']/h2");
    private final By scrollUpButton = By.xpath("//a[@id = 'scrollUp']");

    public HomePage clickOnSignupAndLoginButton()
    {
        Action.clicker(signupAndLoginButton);
        return this;
    }

    public HomePage clickOnLogoutButton()
    {
        Action.clicker(logoutButton);
        return this;
    }

    public HomePage clickOnContactusButton()
    {
        Action.clicker(contactusButton);
        return this;
    }

    public HomePage clickOnProductsButton()
    {
        Action.clicker(productsButton);
        return this;
    }

    public String getSubscriptionLabel()
    {
        Action.scrollToElement(subscriptionLabel);
        return Action.getText(subscriptionLabel);
    }

    public HomePage enterYourEmailToSubscribe()
    {
        Action.sendText(subscriptionField , DataClass.emailOne);
        return this;
    }

    public HomePage clickOnSubscribeButton()
    {
        Action.clicker(subscribeButton);
        return this;
    }

    public HomePage clickOnCartButton()
    {
        Action.clicker(cartButton);
        return this;
    }

    public HomePage clickOnDeleteAccountButton()
    {
        Action.clicker(deleteAccountButton);
        return this;
    }

    public String getSuccessSubscriptionMessage()
    {
        return Action.getText(successSubscriptionMessage);
    }

    public String getCategoryText()
    {
        Action.scrollToElement(categoryText);
        return Action.getText(categoryText);
    }

    public HomePage clickOnWomenCategory()
    {
        Action.clicker(womenCategory);
        return this;
    }

    public HomePage clickOnWomenCategory_Dress()
    {
        Action.clicker(womenCategory_Dress);
        return this;
    }

    public String getCategoryPageText()
    {
        return Action.getText(categoryPageText);
    }

    public HomePage clickOnScrollUpButton()
    {
        Action.clicker(scrollUpButton);
        return this;
    }
}
