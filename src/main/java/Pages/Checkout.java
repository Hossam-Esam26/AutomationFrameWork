package Pages;

import Data.DataClass;
import Utilities.Action;
import Utilities.Driver;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Checkout extends Driver {
    public Checkout(WebDriver driver) {
        super(driver);
    }

    private final By addressDetails = By.xpath("//ul[@class = 'address item box']/li");
    private final By messageTextarea = By.xpath("//textarea[@name = 'message']");
    private final By placeOrderButton = By.xpath("//a[text() = 'Place Order']");

    public Checkout retrieveAddressDetails()
    {
        List<WebElement> details = driver.findElements(addressDetails);
        for (WebElement detail : details)
        {
            Allure.step("--->" + detail.getText());
        }
        return this;
    }

    public Checkout enterTextAtMessageTextarea()
    {
        Action.sendText(messageTextarea , DataClass.userMessage);
        return this;
    }

    public Checkout clickOnPlaceOrderButton()
    {
        Action.clicker(placeOrderButton);
        return this;
    }
}
