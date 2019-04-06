package hw2.setup;

import hw2.setup.enums.capabilitiesEnums;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DriverSetup {
    private static DriverSetup _instance = null;
    private static AppiumDriver driver = null;
    private static WebDriverWait wait = null;

    private static String PLATFORM;
    private static String DEVICE;
    private static String APP;
    private static String DRIVER;
    private static String BROWSER;
    private static String APP_TYPE;
    private static String CHDREXECUTABLE;
    public static String SUT;

    //private constructor
    private DriverSetup() {
    }

    public static DriverSetup instance() {
        if (_instance == null) _instance = new DriverSetup();
        return _instance;
    }

    public static void setProperties(TestProperties properties) throws IOException {

        PLATFORM = properties.getPropertyValue(capabilitiesEnums.PLATFORM.value);
        DEVICE = properties.getPropertyValue(capabilitiesEnums.DEVICE.value);
        APP =  properties.getPropertyValue(capabilitiesEnums.APP.value);
        DRIVER = properties.getPropertyValue(capabilitiesEnums.DRIVER.value);
        BROWSER = properties.getPropertyValue(capabilitiesEnums.BROWSER.value);
        APP_TYPE = properties.getPropertyValue(capabilitiesEnums.APP_TYPE.value);
        CHDREXECUTABLE = properties.getPropertyValue(capabilitiesEnums.CHDREXECUTABLE.value);
        SUT = properties.getPropertyValue(capabilitiesEnums.SUT.value);
    }

    public AppiumDriver getDriver() throws Exception{
        if(driver == null){
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(capabilitiesEnums.PLATFORM.value, PLATFORM );
            capabilities.setCapability(capabilitiesEnums.DEVICE.value, DEVICE);

            // Setup type of application:
            switch (APP_TYPE) {
                case "native":
                    capabilities.setCapability(capabilitiesEnums.APP.value, new File(APP).getAbsolutePath() );
                    break;
                case "web":
                    capabilities.setCapability(capabilitiesEnums.BROWSER.value, BROWSER);

                    /**chromedriverExecutable capability for emulators only with Android 7.0 and Appium version 1.11.0
                     * Should be commented for real devise
                     */
                    // capabilities.setCapability(capabilitiesEnums.CHDREXECUTABLE.value, CHDREXECUTABLE);
                    break;
                default:
                    throw new Exception("Unknown application type");
            }

            switch (PLATFORM) {
                case "Android":
                    driver = new AndroidDriver(new URL(DRIVER), capabilities);
                    break;
                case "iOS":
                    driver = new IOSDriver(new URL(DRIVER), capabilities);
                    break;
                default:
                    throw new Exception("Unknown platform");
            }
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