package testcase;
import com.vetaar.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginPageTest {
    private AppiumDriver<MobileElement> driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "RZCW10VQAMP");
        //caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Test\\Vetaar\\application\\vetaar.apk");
       // caps.setCapability("appPackage", "com.anchor.anchorsmarthomes");
        caps.setCapability("appPackage", "com.theporter.android.customerapp");
       // caps.setCapability("appActivity", "MainActivity");
        caps.setCapability("appActivity", ".RootActivity");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(appiumServerURL, caps);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        loginPage.login("valid_username", "valid_password");
        // Add assertion to verify successful login
        Assert.assertTrue(loginPage.isLoggedIn(), "Login unsuccessful");
    }

    @Test
    public void invalidLoginTest() {
        loginPage.login("invalid_username", "invalid_password");
        // Add assertion to verify unsuccessful login
        Assert.assertFalse(loginPage.isLoggedIn(),
                "Login successful with invalid credentials");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



