package TC_Pages;

import Pages.HomePage;
import Pages.Products;
import TC_Base.TC_Driver;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Products Page")
public class TC05_SearchProduct extends TC_Driver {

    HomePage homePage;
    Products products;

    @BeforeMethod
    public void setObjects()
    {
        homePage = new HomePage(driver);
        products = new Products(driver);
    }
    @Description("User will navigate to the products page and he will search for product")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.automationexercise.com/products")
    @Owner("Hossam Esam")
    @Test
    public void searchForProduct()
    {
        homePage.clickOnProductsButton();
        Assert.assertEquals(products.getTextFromProductsPage().toLowerCase(),"All Products".toLowerCase() ,
                "All Products Text");
        products.getAllProductsAndCheckItIsVisible()
                .enterProductNameAtSearchField()
                .clickOnSubmitSearchButton();
        Assert.assertEquals(products.getSearchedProductText().toLowerCase(),"Searched Products".toLowerCase()
                , "SEARCHED PRODUCTS text");
        products.getAllProductsAndCheckItIsVisible();
    }
}
