package Pages;

import Data.DataClass;
import Utilities.Driver;
import Utilities.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs extends Driver {

    public ContactUs(WebDriver driver) {
        super(driver);
    }
    private final By textAtContactusPage = By.xpath("//h2 [ text() = 'Get In Touch']");
    private final By nameField = By.xpath("//input[@data-qa= 'name']");
    private final By emailField = By.xpath("//input[@data-qa= 'email']");
    private final By subjectField = By.xpath("//input[@data-qa= 'subject']");
    private final By messageField = By.xpath("//textarea[@data-qa= 'message']");
    private final By uploadFile = By.xpath("//input[@name= 'upload_file']");
    private final By submitButton = By.xpath("//input[@name= 'submit']");
    private final By successSubmittedMessage = By.cssSelector("div.status.alert.alert-success");
    private final By homeButton = By.xpath("//span[text() = ' Home']");


    public ContactUs enterYourName(String  name)
    {
        Action.sendText(nameField , name);
        return this;
    }

    public ContactUs enterYourEmail(String  email)
    {
        Action.sendText(emailField , email);
        return this;
    }

    public ContactUs enterTheSubject(String  subject)
    {
        Action.sendText(subjectField , subject);
        return this;
    }

    public ContactUs enterTheMessage(String  message)
    {
        Action.sendText(messageField , message);
        return this;
    }

    public ContactUs uploadTheFile(String  filePath)
    {
        Action.scrollToElement(uploadFile);
        Action.sendText(uploadFile , filePath);
        return this;
    }

    public ContactUs clickOnSubmitButton()
    {
        Action.scrollToElement(submitButton);
        Action.clicker(submitButton);
        driver.switchTo().alert().accept();
        return this;
    }

    public ContactUs clickOnHomeButton()
    {
        Action.clicker(homeButton);
        return this;
    }

    public String  textAtContactusPage()
    {
        return driver.findElement(textAtContactusPage).getText();
    }

    public String successSubmittedMessage()
    {
        return driver.findElement(successSubmittedMessage).getText();
    }

    public void userWillContactUs(String filePath)
    {
        enterYourName(DataClass.userName);
        enterYourEmail(DataClass.email);
        enterTheSubject(DataClass.subject);
        enterTheMessage(DataClass.userMessage);
        uploadTheFile(filePath);
        clickOnSubmitButton();
    }

}
