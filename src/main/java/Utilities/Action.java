package Utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Action extends Driver{

    public Action(WebDriver driver) {
        super(driver);
    }

    public static void clicker(By locator)
    {
        Wait.fluent().until(d ->{
            driver.findElement(locator).click();
            return true;
        });
    }

    public static void clicker(WebElement element)
    {
        Wait.fluent().until(d ->{
            element.click();
            return true;
        });
    }

    public static void javaScriptClicker(By locator)
    {
        Wait.fluent().until(d -> {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            return true;
        });
    }

    public static void sendText(By locator , String value)
    {
        Wait.fluent().until(d ->{
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(value);
            return true;
        });
    }

    public static void elementIsDisplayed(By locator)
    {
        Wait.fluent().until(d ->{
            driver.findElement(locator).isDisplayed();
            return true;
        });
    }

    public static void select (By locator , String value)
    {
        Wait.fluent().until(d ->{
            WebElement element = driver.findElement(locator);
            Select select = new Select(element);
            select.selectByValue(value);
            return true;
        });
    }

    public static void scrollToElement(By locator)
    {
        Wait.fluent().until(d ->{
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            return true;
        });
    }

    public static void scrollToElement(WebElement element)
    {
        Wait.fluent().until(d ->{
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            return true;
        });
    }

    public static void moveToElement_Hover(By locator)
    {
        Wait.fluent().until(d ->{
            WebElement element = driver.findElement(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            return true;
        });

    }

    public static void moveToElement_Hover(WebElement element)
    {
        Wait.fluent().until(d ->{
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            return true;
        });
    }

    public static String getText(By locator) {
        return (String) Wait.fluent().until(d -> {
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed()) {
                return element.getText();
            } else {
                return null;
            }
        });
    }


}
