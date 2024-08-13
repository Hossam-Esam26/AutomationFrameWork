package TC_Pages;

import Pages.ContactUs;
import Pages.HomePage;
import TC_Base.TC_Driver;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.nio.file.Paths;

@Feature("Contact Us Page")
public class TC3_ContactUs extends TC_Driver {

    HomePage homePage;
    ContactUs contactUs;
    SoftAssert softAssert;
    String uploadPhoto = Paths.get("ScreenShots/test.png").toAbsolutePath().toString();

    @BeforeMethod
    public void setObject()
    {
        homePage = new HomePage(driver);
        contactUs = new ContactUs(driver);
        softAssert =new SoftAssert();
    }

    @Description("User will navigate to the contact us page to sent request to the owner")
    @Severity(SeverityLevel.MINOR)
    @Owner("Hossam Esam")
    @Link("https://www.automationexercise.com/contact_us")
    @Test
    public void userWillOpenContactUsPageToSubmitRequest()
    {
        homePage.clickOnContactusButton();
        softAssert.assertEquals(contactUs.textAtContactusPage(),"GET IN TOUCH" ,
                "get in touch message");
        contactUs.userWillContactUs(uploadPhoto);
        softAssert.assertEquals(contactUs.successSubmittedMessage(),"Success! Your details have been submitted successfully." ,
                "successSubmittedMessage");
        contactUs.clickOnHomeButton();
        softAssert.assertAll();
    }

}
