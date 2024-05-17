package com.vetaar.base;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    public void setup() {
        // Code to initialize Appium driver
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getName());
        }
        driver.quit();
    }

    private void captureScreenshot(String testName) {
        try {
            // Convert driver to TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            // Capture screenshot as byte array
            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
            // Create directory if not exists
            File directory = new File("screenshots");
            if (!directory.exists()) {
                boolean mkdir = directory.mkdir();
            }
            // Save screenshot with timestamp and test name
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            Path screenshotPath = Paths.get("screenshots", testName + "_" + timeStamp + ".png");
            Files.write(screenshotPath, screenshotBytes);
            System.out.println("Screenshot saved: " + screenshotPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
