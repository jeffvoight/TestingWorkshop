package com.afs.tas.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

public class Screenshot {
    Logger log = Logger.getLogger(Screenshot.class);

    private Screenshot(){
        log.error("Don't call me.");
    }

    public static void embedScreenshot(Scenario scenario, WebDriver driver, String screenshotName){
        byte[] bytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(bytes, "image/png", screenshotName);
    }

}
