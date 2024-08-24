package TC_Pages;

import Data.DataClass;
import Pages.HomePage;
import Pages.Login;
import TC_Base.TC_Driver;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

@Feature("Login Page")
public class TC02_Login extends TC_Driver {
    HomePage homePage;
    Login login;

    @BeforeMethod
    public void setObject()
    {
        homePage = new HomePage(driver);
        login = new Login(driver);
    }

    @Description("User will tries to login with valid data")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Hossam Esam")
    @Link("https://www.automationexercise.com/login")
    @Test
    public void userWillLogInWithValidData()
    {
        homePage.clickOnSignupAndLoginButton();
        Assert.assertEquals(login.loginText(),"Login to your account");
        login.userWillLogInToHisAccount(DataClass.email);
        homePage.clickOnLogoutButton();
    }

    @Description("User will tries to login with invalid data")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Hossam Esam")
    @Link("https://www.automationexercise.com/login")
    @Test(dependsOnMethods = "userWillLogInWithValidData")
    public void userWillLogInWithInValidData()
    {
        login.userWillLogInToHisAccount(DataClass.inValidEmail);
        Assert.assertEquals(login.errorMessageWithIncorrectEmail(),"Your email or password is incorrect!");
    }



}
