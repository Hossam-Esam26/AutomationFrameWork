package Pages;

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
}
