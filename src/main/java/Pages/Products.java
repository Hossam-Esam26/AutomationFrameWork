package Pages;

import Utilities.Actions;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import java.util.Random;

public class Products extends Driver {
    public Products (WebDriver driver)
    {
        super(driver);
    }

    private final By productsPageText = By.xpath("//h2 [text() = 'All Products']");
    private final By allProducts = By.xpath("//div [@class = 'col-sm-4']");
    private final By viewProductButton = By.xpath("//a[text() = 'View Product']");


    public String getTextFromProductsPage()
    {
        return driver.findElement(productsPageText).getText();
    }
    public Products getAllProductsAndCheckItIsVisible()
    {
        List<WebElement> element = driver.findElements(allProducts);
        if (!(element.isEmpty()))
        {
            System.out.println("Products list visible successfully and products number is = " + element.size());
        }else
        {
            Assert.fail();
        }
        return this;
    }

    public Products clickOnViewProductButton()
    {
        List<WebElement> elements = driver.findElements(viewProductButton);
        if (!elements.isEmpty())
        {
            Random random = new Random();
            int randomIndex = random.nextInt(elements.size());
            Actions.clicker(elements.get(randomIndex));
        }
        return this;
    }

    public void userOpenProductsPage()
    {
        getAllProductsAndCheckItIsVisible();
        clickOnViewProductButton();
    }

}
