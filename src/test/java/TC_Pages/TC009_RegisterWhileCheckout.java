package TC_Pages;

import Data.DataClass;
import Pages.*;
import TC_Base.TC_Driver;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Add product and pay")
public class TC009_RegisterWhileCheckout extends TC_Driver {

    HomePage homePage;
    Products products;
    Cart cart;
    SignUp signUp;
    Login login;
    Checkout checkout;
    Payment payment;

    @BeforeMethod
    public void setObject()
    {
        homePage = new HomePage(driver);
        products = new Products(driver);
        cart = new Cart(driver);
        signUp = new SignUp(driver);
        login = new Login(driver);
        checkout = new Checkout(driver);
        payment = new Payment(driver);
    }

    @Description("1. User add product to cart and checkout\n" +
            "2. Create new account\n" +
            "3. Complete The checkout and payment cycle ")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Hossam Esam")
    @Test
    public void addProductToCartAndRegister()
    {
        homePage.clickOnProductsButton();
        products.addProductInCartAndViewCart();
        cart.verifyThatTheCartPageIsDisplayed()
                .clickOnProceedToCheckoutButton()
                .clickOnRegisterAndLoginButton();
        signUp.theUserSignInSuccessfully(DataClass.emailTwo);
        Assert.assertEquals(signUp.validationMessageAccountCreated().toLowerCase(),("ACCOUNT CREATED!").toLowerCase() ,
                "validationMessageAccountCreated");
        signUp.clickOnContinueButton();
        homePage.clickOnLogoutButton();
        login.userWillLogInToHisAccount(DataClass.emailTwo);
        homePage.clickOnCartButton();
        cart.clickOnProceedToCheckoutButton();
        checkout.retrieveAddressDetails()
                .enterTextAtMessageTextarea()
                .clickOnPlaceOrderButton();
        payment.enterCardData()
                .clickOnSubmitButton();
        Assert.assertEquals(payment.getConfirmedOrderText().toLowerCase() ,
                "Congratulations! Your order has been confirmed!".toLowerCase()
        ,"Order done successfully message");
        homePage.clickOnDeleteAccountButton();
    }
}
