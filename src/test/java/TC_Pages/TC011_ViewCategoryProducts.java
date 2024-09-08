package TC_Pages;

import Pages.HomePage;
import TC_Base.TC_Driver;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Home Page")
public class TC011_ViewCategoryProducts extends TC_Driver {

    HomePage homePage;

    @Description("User will choose one category and navigate to it")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://automationexercise.com/")
    @Owner("Hossam Esam")
    @Test
    public void ViewCategoryProducts()
    {
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getCategoryText().toLowerCase(),"Category".toLowerCase() , "Category at home page");
        homePage.clickOnWomenCategory()
                .clickOnWomenCategory_Dress();
        Assert.assertEquals(homePage.getCategoryPageText().toLowerCase() , "Women - Dress Products".toLowerCase());
    }
}
