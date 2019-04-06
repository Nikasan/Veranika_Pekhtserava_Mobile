package hw3.setup;

import hw3.setup.enums.capabilitiesEnums;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;

import static java.lang.String.format;


public class DriverSetup {
    private static DriverSetup _instance = null;
    private static AppiumDriver driver = null;
    private static WebDriverWait wait = null;

    private static String PLATFORM;
    private static String UDID;
    private static String DRIVER;
    private static String BROWSER;
    private static String APP_TYPE;
    private static String APP_ACTIVITY;
    private static String APP_PACKAGE;
    public static String SUT;

    private DriverSetup() {
    }

    public static DriverSetup instance() {
        if (_instance == null) _instance = new DriverSetup();
        return _instance;
    }

    public static void setProperties(TestProperties properties) throws IOException {

        PLATFORM = properties.getPropertyValue(capabilitiesEnums.PLATFORM.value);
        UDID = properties.getPropertyValue(capabilitiesEnums.UDID.value);
        APP_ACTIVITY = properties.getPropertyValue(capabilitiesEnums.APP_ACTIVITY.value);
        APP_PACKAGE = properties.getPropertyValue(capabilitiesEnums.APP_PACKAGE.value);
        DRIVER = format("http://%s:%s@%s/wd/hub", "EPM-TSTF", properties.getPropertyValue(capabilitiesEnums.API_KEY.value), properties.getPropertyValue(capabilitiesEnums.APPIUM_HUB.value));
        BROWSER = properties.getPropertyValue(capabilitiesEnums.BROWSER.value);
        APP_TYPE = properties.getPropertyValue(capabilitiesEnums.APP_TYPE.value);
        SUT = properties.getPropertyValue(capabilitiesEnums.SUT.value);
    }

    public AppiumDriver getDriver() throws Exception{
        if(driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(capabilitiesEnums.PLATFORM.value, PLATFORM);
            capabilities.setCapability(capabilitiesEnums.UDID.value, UDID);

            // Setup type of application:
            switch (APP_TYPE) {
                case "native":
                    capabilities.setCapability(capabilitiesEnums.APP_ACTIVITY.value, APP_ACTIVITY);
                    capabilities.setCapability(capabilitiesEnums.APP_PACKAGE.value, APP_PACKAGE);
                    break;
                case "web":
                    capabilities.setCapability(capabilitiesEnums.BROWSER.value, BROWSER);
                    break;
                default:
                    throw new Exception("Unknown application type");
            }

            driver = new AppiumDriver(new URL(DRIVER),capabilities);
        }
        return driver;
    }

    public WebDriverWait getWait() throws Exception {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), 5);
        }
        return wait;
    }

}