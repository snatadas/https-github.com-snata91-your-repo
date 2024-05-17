package com.vetaar.utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumUtils {
    private static final int DEFAULT_TIMEOUT = 10;

    private final AppiumDriver<MobileElement> driver;
    private final WebDriverWait wait;

    public AppiumUtils(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public void waitForVisibilityOfElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void tapElement(By locator) {
        waitForVisibilityOfElement(locator);
        driver.findElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        waitForVisibilityOfElement(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public void scrollToElement(By locator) {
        MobileElement element = driver.findElement(locator);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(0, 1000))
                .waitAction()
                .moveTo(PointOption.point(0, element.getLocation().getY()))
                .release()
                .perform();
    }

    public void acceptAlertIfPresent() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            if (alert != null) {
                alert.accept();
            }
        } catch (Exception e) {
            // Ignore if no alert is present
        }
    }
}



