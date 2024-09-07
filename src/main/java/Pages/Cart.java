package Pages;

import Utilities.Action;
import Utilities.Driver;
import Utilities.ScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Cart extends Driver {
    public Cart(WebDriver driver) {
        super(driver);
    }

    private final By getProductsAtCart = By.xpath("//tbody/tr");
    private final By productQuantity = By.xpath("//td[@class = 'cart_quantity']/button");
    private final By productQuantityField = By.xpath("//tbody/tr[1]/td[@class = 'cart_quantity']/button");
    private final By cartInfoContainer = By.xpath("//div[@id = 'cart_info']");
    private final By proceedToCheckoutButton = By.xpath("//a[text() = 'Proceed To Checkout']");
    private final By registerAndLoginButton = By.xpath("//u[text() = 'Register / Login']");
    private final By deleteProductButton = By.xpath("//a[@class = 'cart_quantity_delete']");
    private final By cartEmptyText = By.xpath("//b[text() = 'Cart is empty!']");

    public Cart verifyCardProducts()
    {
        List<WebElement> elements = driver.findElements(getProductsAtCart);
        if (!elements.isEmpty()){
            Allure.step("Products added in the cart successfully");
            ScreenShot.takeScreenShot("Cart");
        }else {
            Assert.fail();
        }
        return this;
    }

    public Cart quantityTextButton()
    {
        List<WebElement> quantityText = driver.findElements(productQuantity);
        for (WebElement quantity : quantityText)
        {
            String getQuantity = quantity.getText();
            if (!getQuantity.equals("1"))
            {
                Assert.fail();
            }
        }
        return this;
    }

    public String getProductQuantity()
    {
        return Action.getText(productQuantityField);
    }

    public Cart verifyThatTheCartPageIsDisplayed()
    {
        try {
            Action.elementIsDisplayed(cartInfoContainer);
        }catch (Exception e)
        {
            Allure.step(String.valueOf(e));
            throw e;
        }
        return this;
    }

    public Cart clickOnProceedToCheckoutButton()
    {
        Action.clicker(proceedToCheckoutButton);
        return this;
    }

    public Cart clickOnRegisterAndLoginButton()
    {
        Action.clicker(registerAndLoginButton);
        return this;
    }

    public Cart ClickOnDeleteProductButton()
    {
        List<WebElement> deleteButton = driver.findElements(deleteProductButton);
        for (WebElement button : deleteButton)
        {
            Action.clicker(button);
        }
        return this;
    }

    public String getCartEmptyText()
    {
        return Action.getText(cartEmptyText);
    }
}
