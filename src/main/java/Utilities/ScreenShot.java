package Utilities;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ScreenShot extends Driver{

    public ScreenShot(WebDriver driver)
    {
        super(driver);
    }

    public static void takeScreenShot(String photoPath) {
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = STR."ScreenShots/\{photoPath}.jpg";
        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Allure.addAttachment("ScreenShot" , new FileInputStream(screenshotFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
