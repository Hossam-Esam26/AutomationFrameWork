package TC_Pages;

import Pages.HomePage;
import Pages.SignUp;
import TC_Base.TC_Driver;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

@Feature("Register Page")
public class TC01_SignUp extends TC_Driver {

    HomePage homePage;
    SignUp signUp;

    @BeforeMethod
    public void setObject()
    {
        homePage = new HomePage(driver);
        signUp = new SignUp(driver);
    }

    @Description("The user will navigate to the sign up page and he will register with new data")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Hossam Esam")
    @Link("https://www.automationexercise.com/signup")
    @Test
    public void theUserWillRegisterSuccessfully()
    {
        homePage.clickOnSignupAndLoginButton();
        signUp.theUserSignInSuccessfully();
        Assert.assertEquals(signUp.validationMessageAccountCreated(),("ACCOUNT CREATED!") ,
                "validationMessageAccountCreated");
        signUp.clickOnContinueButton();
    }

    @Description("The user will navigate to the sign up page and he will register with existing data")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Hossam Esam")
    @Link("https://www.automationexercise.com/signup")
    @Test (dependsOnMethods = "theUserWillRegisterSuccessfully")
    public void userWillRegisterWithTheSameEmail()
    {
        homePage.clickOnLogoutButton();
        signUp.userWillRegisterWithTheSameEmail();
        Assert.assertEquals(signUp.validationMessageForExistingEmail() ,("Email Address already exist!") ,
                "validationMessageForExistingEmail");
    }

}
