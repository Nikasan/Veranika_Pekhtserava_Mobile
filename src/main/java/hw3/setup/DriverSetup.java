package hw3.setup;

import hw3.setup.driver.NativeUtils;
import hw3.setup.driver.WebUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static hw3.setup.enums.capabilitiesEnums.*;


public class DriverSetup {
    private static DriverSetup _instance = null;
    private AppiumDriver _webDriver = null;
    private AppiumDriver _nativeDriver = null;

    private DriverSetup() {
    }

    public static DriverSetup instance() {
        if (_instance == null) _instance = new DriverSetup();
        return _instance;
    }

    public AppiumDriver getNativeDriver() throws IOException {
        if (_nativeDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(PLATFORM_NAME.value, NativePropertyReader.instance().platformName);
            capabilities.setCapability(UDID.value, NativePropertyReader.instance().udid);
            capabilities.setCapability(APP_ACTIVITY.value, NativePropertyReader.instance().appActivity);
            capabilities.setCapability(APP_PACKAGE.value, NativePropertyReader.instance().appPackage);
//             capabilities.setCapability(APP_LAUNCH.value,NativePropertyReader.instance().autoLaunch);
//             capabilities.setCapability(APP.value,NativePropertyReader.instance().app);

            _nativeDriver = new AppiumDriver(NativeUtils.createUrl(), capabilities);
        }
        return _nativeDriver;
    }

    public AppiumDriver getWebDriver() throws IOException {
        if (_webDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(PLATFORM_NAME.value, WebPropertyReader.instance().platform);
            capabilities.setCapability(BROWSER_NAME.value, WebPropertyReader.instance().browser_name);
            capabilities.setCapability(UDID.value, WebPropertyReader.instance().udid);

            _webDriver = new AppiumDriver(
                    new URL(WebUtils.createUrl()), capabilities);


            _webDriver.manage().timeouts()
                    .pageLoadTimeout(2, TimeUnit.MINUTES)
                    .implicitlyWait(90, TimeUnit.SECONDS);
        }
        return _webDriver;
    }

    public WebDriverWait getWait() throws IOException {
        return new WebDriverWait(getWebDriver(), 5);
    }
}