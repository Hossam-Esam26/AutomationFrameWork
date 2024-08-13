package Utilities;

import Utilities.Enums.WaitCases;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Actions extends Driver{

    public Actions(WebDriver driver) {
        super(driver);
    }

    public static void clicker(By locator)
    {
        Wait.wait(WaitCases.ELEMENT_CLICKABLE , locator);
        driver.findElement(locator).click();
    }

    public static void clicker(WebElement element)
    {
            Wait.wait(WaitCases.ELEMENT_CLICKABLE ,element);
            element.click();
    }

    public static void sendText(By locator , String value)
    {
        Wait.wait(WaitCases.ELEMENT_ENABLED , locator);
        driver.findElement(locator).sendKeys(value);

    }

    public static void elementIsDisplayed(By locator)
    {
        Wait.wait(WaitCases.ELEMENT_DISPLAYED , locator);
        driver.findElement(locator).isDisplayed();
    }

    public static void select (By locator , String value)
    {
        Wait.wait(WaitCases.ELEMENT_ENABLED , locator);
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void scrollToElement(By locator)
    {
        Wait.wait(WaitCases.ELEMENT_ENABLED , locator);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToElement(WebElement element)
    {
        Wait.wait(WaitCases.ELEMENT_ENABLED , element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
