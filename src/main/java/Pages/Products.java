package Pages;

import Data.DataClass;
import Utilities.Actions;
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

    public Products enterProductNameAtSearchField()
    {
        Actions.sendText(searchField , DataClass.productName);
        return this;
    }

    public Products clickOnSubmitSearchButton()
    {
        Actions.clicker(submitSearchButton);
        return this;
    }

    public String getSearchedProductText()
    {
        Actions.scrollToElement(searchedProductText);
        ScreenShot.takeScreenShot("searchedProduct");
        return driver.findElement(searchedProductText).getText();
    }

    public void userOpenProductsPage()
    {
        getAllProductsAndCheckItIsVisible();
        clickOnViewProductButton();
    }



}
