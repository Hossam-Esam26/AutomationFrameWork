package Utilities;

import Data.BrowserLink;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser extends Driver{
    public Browser(WebDriver driver) {
        super(driver);
    }
    private static String url = BrowserLink.data.getProperty("URL");

    public static WebDriver setBrowser()
    {
        /*ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--headless=new");*/
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        return Browser.driver;
    }

    public static void quit()
    {
        driver.quit();
    }
}
