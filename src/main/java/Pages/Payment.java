package Pages;

import Data.CardData;
import Utilities.Action;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payment extends Driver {
    public Payment(WebDriver driver) {
        super(driver);
    }

    private final By nameOnCardField = By.xpath("//input[@name = 'name_on_card']");
    private final By cardNumberField = By.xpath("//input[@name = 'card_number']");
    private final By cvcField = By.xpath("//input[@name = 'cvc']");
    private final By expiry_MonthField = By.xpath("//input[@name = 'expiry_month']");
    private final By expiry_Year = By.xpath("//input[@name = 'expiry_year']");
    private final By submitButton = By.xpath("//button [ @id = 'submit']");
    private final By paymentDoneText = By.xpath("//p[contains(text() , 'Congratulations')]");

    public Payment enterCardData()
    {
        Action.sendText(nameOnCardField , CardData.CardName);
        Action.sendText(cardNumberField , CardData.CardNumber);
        Action.sendText(cvcField , CardData.CVC);
        Action.sendText(expiry_MonthField , CardData.Expiry_Month);
        Action.sendText(expiry_Year , CardData.Expiry_Year);
        return this;
    }

    public Payment clickOnSubmitButton()
    {
        Action.clicker(submitButton);
        return this;
    }

    public String getConfirmedOrderText()
    {
        return driver.findElement(paymentDoneText).getText();
    }
}
