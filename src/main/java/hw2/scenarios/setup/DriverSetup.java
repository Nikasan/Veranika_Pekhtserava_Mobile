package hw2.scenarios.setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import hw2.scenarios.setup.driver.NativeUtils;
import hw2.scenarios.setup.driver.WebUtils;

import java.io.IOException;

import static hw2.scenarios.setup.enums.capabilitiesEnums.*;


public class DriverSetup {
    private static DriverSetup _instance = null;
    private AndroidDriver _webDriver = null;
    private AndroidDriver _nativeDriver = null;

    protected DriverSetup() {
    }

    public static DriverSetup instance() {
        if (_instance == null) _instance = new DriverSetup();
        return _instance;
    }

    public AndroidDriver getNativeDriver() throws IOException {
        if (_nativeDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(PLATFORM.value, NativePropertyReader.instance().platfoplatformName);
            capabilities.setCapability(DEVICE.value, NativePropertyReader.instance().deviceName);
            capabilities.setCapability(APP.value, NativePropertyReader.instance().app);
            _nativeDriver = new AndroidDriver(NativeUtils.createUrl(), capabilities);
        }
        return _nativeDriver;
    }

    public AndroidDriver getWebDriver() throws IOException {
        if (_webDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(PLATFORM.value, WebPropertyReader.instance().platfoplatformName);
            capabilities.setCapability(DEVICE.value, WebPropertyReader.instance().deviceName);
            capabilities.setCapability(BROWSER.value, WebPropertyReader.instance().browserName);

            /**chromedriverExecutable capability for emulators only with Android 7.0 and Appium version 1.11.0
             * Should be commented for real devise
             */
            capabilities.setCapability(CHDREXECUTABLE.value, WebPropertyReader.instance().chromedriverExecutable);
            _webDriver = new AndroidDriver(WebUtils.createUrl(), capabilities);
        }
        return _webDriver;
    }

    public WebDriverWait getWait() throws IOException {
        return new WebDriverWait(getWebDriver(), 5);
    }
}