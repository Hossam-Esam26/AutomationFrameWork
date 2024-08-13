package TC_Pages;

import Pages.ProductDetails;
import TC_Base.TC_Driver;
import Pages.HomePage;
import Pages.Products;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Products Page")
public class TC4_Products extends TC_Driver {
    HomePage homePage;
    Products products;
    ProductDetails productDetails;

    @BeforeMethod
    public void setObject()
    {
        homePage = new HomePage(driver);
        products = new Products(driver);
        productDetails = new ProductDetails(driver);
    }

    @Description("User will navigate to the products page and click on one product to see product information")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.automationexercise.com/products")
    @Owner("Hossam Esam")
    @Test
    public void userNavigateToTheProductsPageAndViewProductDetails()
    {
        homePage.clickOnProductsButton();
        Assert.assertEquals(products.getTextFromProductsPage(),"ALL PRODUCTS" , "All Products Text");
        products.userOpenProductsPage();
        productDetails.checkTheVisibilityOfElement();
    }
}
