package Pages;

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
}
