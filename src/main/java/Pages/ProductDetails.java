package Pages;

import Utilities.Action;
import Utilities.Driver;
import Utilities.ScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetails extends Driver {
    public ProductDetails(WebDriver driver) {
        super(driver);
    }

    By productInformationDiv = By.xpath("//div [@class = 'product-information']");


    public ProductDetails checkTheVisibilityOfDiv()
    {
        Action.elementIsDisplayed(productInformationDiv);
        return this;
    }

    public ProductDetails takeScreenshotFromTheProductDetailsPage() {
        ScreenShot.takeScreenShot("ProductInformation");
        return this;
    }


    public void checkTheVisibilityOfElement()
    {
        checkTheVisibilityOfDiv();
        takeScreenshotFromTheProductDetailsPage();
    }
}
