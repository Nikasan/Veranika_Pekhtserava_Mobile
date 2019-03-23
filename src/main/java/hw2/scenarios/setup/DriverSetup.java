package hw2.scenarios.setup;

import hw2.scenarios.setup.driver.NativeUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import hw2.scenarios.setup.driver.WebUtils;


import static hw2.scenarios.setup.enums.capabilitiesEnums.*;


public class DriverSetup {
    private static DriverSetup _instance = null;
    private AppiumDriver _webDriver = null;
    private AppiumDriver _nativeDriver = null;

    protected DriverSetup() {
    }

    public static DriverSetup instance() {
        if (_instance == null) _instance = new DriverSetup();
        return _instance;
    }

    public AppiumDriver getNativeDriver() throws Exception {
        if (_nativeDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(PLATFORM.value, NativePropertyReader.instance().platformName);
            capabilities.setCapability(DEVICE.value, NativePropertyReader.instance().deviceName);
            capabilities.setCapability(APP.value, NativePropertyReader.instance().app);

            switch (NativePropertyReader.instance().platformName) {
                case "Android":
                    _nativeDriver = new AndroidDriver(NativeUtils.createUrl(), capabilities);
                    break;
                case "iOS":
                    _nativeDriver = new IOSDriver(NativeUtils.createUrl(), capabilities);
                    break;
                default:
                    throw new Exception("Unknown platform");
            }
        }
        return _nativeDriver;
    }


    public AppiumDriver getWebDriver() throws Exception {
        if (_webDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(PLATFORM.value, WebPropertyReader.instance().platformName);
            capabilities.setCapability(DEVICE.value, WebPropertyReader.instance().deviceName);
            capabilities.setCapability(BROWSER.value, WebPropertyReader.instance().browserName);

            /**chromedriverExecutable capability for emulators only with Android 7.0 and Appium version 1.11.0
             * Should be commented for real devise
             */
            // capabilities.setCapability(CHDREXECUTABLE.value, WebPropertyReader.instance().chromedriverExecutable);

            switch (WebPropertyReader.instance().platformName) {
                case "Android":
                    _webDriver = new AndroidDriver(WebUtils.createUrl(), capabilities);
                    break;
                case "iOS":
                    _webDriver = new IOSDriver(WebUtils.createUrl(), capabilities);
                    break;
                default:
                    throw new Exception("Unknown platform");
            }
        }
        return _webDriver;
    }

    public WebDriverWait getWait() throws Exception {
        return new WebDriverWait(getWebDriver(), 5);
    }
}