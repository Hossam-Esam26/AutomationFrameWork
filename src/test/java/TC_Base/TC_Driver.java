package TC_Base;

import Utilities.Browser;
import io.qameta.allure.Epic;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
@Epic("Automation Exercise")
public class TC_Driver {
    public static WebDriver driver;

    @BeforeClass
    public void browser()
    {
        driver = Browser.setBrowser();
    }

    @AfterClass
    public void quit()
    {
        Browser.quit();
    }
}
