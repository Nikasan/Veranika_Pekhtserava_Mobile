import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static java.util.Optional.ofNullable;

import static org.openqa.selenium.By.className;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AppiumDemo {
    private static final String PROJECT_NAME = "EPM-TSTF";

    private static final String API_KEY = "ae80f1d8-e81f-4dff-b180-58f42d394964";
    private static final String APPIUM_HUB = "epm-mstfmsq-ci.minsk.epam.com:8080";
    private static final String PLATFORM_NAME = "Android";
    private static final String PLATFORM_VERSION = "6.0.1";
    private static final String BROWSER_NAME = "chrome";
    private static final String DEVICE_NAME = "LGE Nexus 5";

    private final DesiredCapabilities capabilities;

    private AppiumDriver driver = null;

    public AppiumDemo() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("browserName", BROWSER_NAME);
        capabilities.setCapability("deviceName", DEVICE_NAME);
    }

    @BeforeClass
    public void before() throws MalformedURLException {
        driver = new AndroidDriver(
                new URL(format("http://%s:%s@%s/wd/hub", PROJECT_NAME, API_KEY, APPIUM_HUB)), capabilities);

        // For devices with low performance
        driver.manage().timeouts()
                .pageLoadTimeout(5, TimeUnit.MINUTES)
                .implicitlyWait(90, TimeUnit.SECONDS);
    }

    @Test
    public void demoTest() {
        final String epamUrl = "https://www.epam.com/";

        assertTrue(format("Focus is not on '%s'", BROWSER_NAME), driver.isBrowser());

        driver.get(epamUrl);

        new FluentWait<>(driver).withMessage("Page was not loaded")
                .pollingEvery(ofSeconds(1))
                .withTimeout(ofMinutes(1))
                .until(driver -> driver.findElements(className("header__logo")).size() > 0);

        assertEquals("Current url is incorrect", epamUrl, driver.getCurrentUrl());
        assertEquals("Page title is incorrect", "EPAM | Software Product Development Services", driver.getTitle());
    }

    @AfterClass
    public void after() {
        ofNullable(driver).ifPresent(RemoteWebDriver::quit);
    }
}
