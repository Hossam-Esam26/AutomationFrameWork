package TC_Pages;

import Pages.Cart;
import Pages.ProductDetails;
import Pages.Products;
import TC_Base.TC_Driver;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Cart")
public class TC008_VerifyProductQuantityInCart extends TC_Driver {

    Products products;
    ProductDetails  productDetails;
    Cart cart;

    @BeforeMethod
    public void setObject()
    {
        products = new Products(driver);
        productDetails = new ProductDetails(driver);
        cart = new Cart(driver);
    }

    @Description("The user will navigate to the product details and add more than one to the cart,and validate the quantity at the cart is right")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://automationexercise.com/view_cart")
    @Owner("Hossam Esam")
    @Test
    public void verifyProductQuantityInCart()
    {
        products.clickOnViewProductButton();
        productDetails.checkTheVisibilityOfDiv()
                .enterProductQuantity()
                .clickOnAddToCart();
        products.clickOnViewCartLink();
        Assert.assertEquals(cart.getProductQuantity().toLowerCase() , "4" , "Product Quantity");
    }
}
