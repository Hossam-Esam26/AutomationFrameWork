package TC_Pages;

import Pages.Cart;
import Pages.HomePage;
import Pages.Products;
import TC_Base.TC_Driver;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Cart")
public class TC007_AddProductInCart extends TC_Driver {

    HomePage homePage;
    Products products;
    Cart cart;

    @BeforeMethod
    public void setObjects()
    {
        homePage = new HomePage(driver);
        products = new Products(driver);
        cart = new Cart(driver);
    }

    @Description("User will navigate to products page and tries to add two product in the cart")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://automationexercise.com/view_cart")
    @Owner("Hossam Esam")
    @Test
    public void addProductInCart() throws InterruptedException {
        homePage.clickOnProductsButton();
        products.addProductInCartAndContinueShopping()
                .addProductInCartAndViewCart();
        cart.verifyCardProducts()
            .quantityTextButton()
            .ClickOnDeleteProductButton();
        Assert.assertEquals(cart.getCartEmptyText().toLowerCase() , "Cart is empty!".toLowerCase() , "Cart is empty text");
    }
}
