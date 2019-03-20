package scenarios.setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import scenarios.setup.driver.NativeUtils;
import scenarios.setup.driver.WebUtils;

import java.io.IOException;

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
            capabilities.setCapability("platformName", NativePropertyReader.instance().platform);
            //capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("deviceName", NativePropertyReader.instance().deviceName); //9887f744574b504850
            capabilities.setCapability("app", NativePropertyReader.instance().appPath);

            _nativeDriver = new AndroidDriver(NativeUtils.createUrl(), capabilities);
        }
        return _nativeDriver;
    }

    public AndroidDriver getWebDriver() throws IOException {
        if (_webDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", WebPropertyReader.instance().platform);
            capabilities.setCapability("deviceName", WebPropertyReader.instance().deviceName);
            capabilities.setCapability("browserName", WebPropertyReader.instance().browser);

            _webDriver = new AndroidDriver(WebUtils.createUrl(), capabilities);
        }

        return _webDriver;
    }

    public WebDriverWait getWait() throws IOException {
        return new WebDriverWait(getWebDriver(), 5);
    }
}