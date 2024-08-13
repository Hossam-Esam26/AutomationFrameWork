package Utilities;

import Utilities.Enums.WaitCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait extends Driver{
    public Wait(WebDriver driver) {
        super(driver);
    }
    private static WebDriverWait wait ;
    public static void wait(WaitCases waitCondition , By locator)
    {

        if (waitCondition.equals(WaitCases.ELEMENT_CLICKABLE) || waitCondition.equals(WaitCases.ELEMENT_DISPLAYED))
        {
            wait = new WebDriverWait(driver , Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();
        }else if (waitCondition.equals(WaitCases.ELEMENT_ENABLED)) {
            wait = new WebDriverWait(driver , Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
    }
    }

    public static void wait(WaitCases waitCondition , WebElement element)
    {
        if (waitCondition.equals(WaitCases.ELEMENT_CLICKABLE) || waitCondition.equals(WaitCases.ELEMENT_DISPLAYED))
        {
            wait = new WebDriverWait(driver , Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
        }else if (waitCondition.equals(WaitCases.ELEMENT_ENABLED)) {
            wait = new WebDriverWait(driver , Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) element)).isEnabled();
        }
    }

    public static void wait(WaitCases waitCondition , WebElement element , int durationOfSeconds)
    {
        if (waitCondition.equals(WaitCases.ELEMENT_CLICKABLE) || waitCondition.equals(WaitCases.ELEMENT_DISPLAYED) || waitCondition.equals(WaitCases.ELEMENT_ENABLED))
        {
            wait = new WebDriverWait(driver , Duration.ofSeconds(durationOfSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
        }
    }

    public static FluentWait fluent(int sce)
    {
        FluentWait wait1 = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(sce))
                .pollingEvery(Duration.ofMillis(500));
        return wait1;
    }
}
