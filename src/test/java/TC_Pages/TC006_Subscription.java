package TC_Pages;

import Pages.HomePage;
import TC_Base.TC_Driver;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Home Page")
public class TC006_Subscription extends TC_Driver {

    HomePage homePage;


    @Description("User will navigate to footer at the home page to enter his name and subscribe")
    @Severity(SeverityLevel.MINOR)
    @Link("https://automationexercise.com/")
    @Owner("Hossam Esam")
    @Test
    public void subscriptionFeature()
    {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getSubscriptionLabel().equalsIgnoreCase("Subscription") ,
                "Subscription feature at the home page");
        homePage.enterYourEmailToSubscribe()
                .clickOnSubscribeButton();
        Assert.assertTrue(homePage.getSuccessSubscriptionMessage().equalsIgnoreCase("You have been successfully subscribed!"),
                "Successful subscription message");
        homePage.clickOnScrollUpButton();
        Assert.assertEquals(homePage.getCategoryText().toLowerCase(),"Category".toLowerCase() , "Category at home page");
    }
}
