package Pages;

import Data.DataClass;
import Utilities.Action;
import Utilities.Driver;
import Utilities.ScreenShot;
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
    private final By allProducts = By.xpath("//div[@class = 'features_items']/div [@class = 'col-sm-4']");
    private final By viewProductButton = By.xpath("//a[text() = 'View Product']");
    private final By searchField = By.xpath("//input[@id = 'search_product']");
    private final By submitSearchButton = By.xpath("//button[@id = 'submit_search']");
    private final By searchedProductText = By.xpath("//h2[text() = 'Searched Products']");
    private final By continueShoppingButton = By.xpath("//button[text() = 'Continue Shopping']");
    private final By viewCartLink = By.xpath("//u[text() = 'View Cart']");


    public String getTextFromProductsPage()
    {
        return Action.getText(productsPageText);
    }

    public Products getAllProductsAndCheckItIsVisible()
    {
        List<WebElement> elements = driver.findElements(allProducts);
        if (!(elements.isEmpty()))
        {
            System.out.println("Products list visible successfully and products number is = " + elements.size());
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
            Action.clicker(elements.get(randomIndex));
        }
        return this;
    }

    public Products enterProductNameAtSearchField()
    {
        Action.sendText(searchField , DataClass.productName);
        return this;
    }

    public Products clickOnSubmitSearchButton()
    {
        Action.clicker(submitSearchButton);
        return this;
    }

    public String getSearchedProductText()
    {
        Action.scrollToElement(searchedProductText);
        ScreenShot.takeScreenShot("searchedProduct");
        return Action.getText(searchedProductText);
    }

    public Products addInCart()
    {
        List<WebElement> elements = driver.findElements(allProducts);
        try {
            if (!elements.isEmpty())
            {
                Random random = new Random();
                int randomIndex = random.nextInt(elements.size());
                By productElement = By.xpath("//div[@class = 'features_items']/div["+randomIndex+"]/div[1]");
                By addProductElement = By.xpath("//div[@class = 'features_items']/div["+randomIndex+"]/div[1]/div[1]/div[2]/div[1]/a");
                Action.scrollToElement(productElement);
                Action.moveToElement_Hover(productElement);
                Action.javaScriptClicker(addProductElement);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
        return this;
    }


    public Products clickOnContinueShoppingButton()
    {
        Action.clicker(continueShoppingButton);
        return this;
    }

    public Products clickOnViewCartLink()
    {
        Action.clicker(viewCartLink);
        return this;
    }




    //-------------many actions at one method to call it at the test file------------
    public Products userOpenProductsPage()
    {
        getAllProductsAndCheckItIsVisible();
        clickOnViewProductButton();
        return this;
    }

    public Products addProductInCartAndContinueShopping()
    {
        addInCart();
        clickOnContinueShoppingButton();
        return this;
    }

    public Products addProductInCartAndViewCart()
    {
        addInCart();
        clickOnViewCartLink();
        return this;
    }

}
