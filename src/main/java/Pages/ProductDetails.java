package Pages;

import Data.DataClass;
import Utilities.Action;
import Utilities.Driver;
import Utilities.ScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetails extends Driver {
    public ProductDetails(WebDriver driver) {
        super(driver);
    }

    private final By productInformationDiv = By.xpath("//div [@class = 'product-information']");
    private final By productQuantityInput = By.xpath("//input[@id='quantity']");
    private final By addToCartButton = By.xpath("//div[@class = 'product-information']/span/button");


    public ProductDetails checkTheVisibilityOfDiv()
    {
        try {
            Action.elementIsDisplayed(productInformationDiv);
        }catch (Exception e)
        {
            Allure.step(e.getMessage());
            throw e;
        }
        return this;
    }

    public ProductDetails takeScreenshotFromTheProductDetailsPage() {
        ScreenShot.takeScreenShot("ProductInformation");
        return this;
    }

    public ProductDetails enterProductQuantity()
    {
        Action.sendText(productQuantityInput , DataClass.productQuantity);
        return this;
    }

    public ProductDetails clickOnAddToCart()
    {
        Action.clicker(addToCartButton);
        return this;
    }


    public void checkTheVisibilityOfElement()
    {
        checkTheVisibilityOfDiv();
        takeScreenshotFromTheProductDetailsPage();
    }
}
