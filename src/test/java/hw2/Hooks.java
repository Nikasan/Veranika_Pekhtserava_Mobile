package hw2;

import hw2.setup.DriverSetup;
import hw2.setup.TestProperties;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static hw2.setup.DriverSetup.setProperties;


/**
 * Loads and reads properties to prepare driver for tests. Closes driver after test.
 */
//
@Test(groups = {"web", "native"})
public class Hooks {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    @Parameters("property path")
    @BeforeClass(description = "Initialisation of driver")
    public void setUpProp(String path) throws Exception {
        setProperties(new TestProperties(path).loadProperties());
        driver = DriverSetup.instance().getDriver();
        wait = DriverSetup.instance().getWait();
    }

    @AfterClass(description = "Quit driver after all test in this class")
    public void tearDown() throws Exception {
        // NOTE: Method quit() reboots the device (probably to release it from use so
        // it becomes available for others). To avoid reboot use method closeApp() instead.
        DriverSetup.instance().getDriver().quit();
    }

}