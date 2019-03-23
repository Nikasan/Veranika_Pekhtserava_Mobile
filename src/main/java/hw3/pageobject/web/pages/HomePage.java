package hw3.pageobject.web.pages;

import hw3.setup.WebPropertyReader;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class HomePage  {
    private AppiumDriver driver;
    private WebDriverWait driverWait;
    private String pageTitle = "Internet Assigned Numbers Authority";


    public HomePage(AppiumDriver appiumDriver,WebDriverWait driverWait) {
        this.driver = appiumDriver;
        this.driverWait = driverWait;
    }

    public void open() throws IOException {
        driver.get(WebPropertyReader.instance().sut);
        driverWait.until(ExpectedConditions.urlToBe(WebPropertyReader.instance().sut));
    }

    // Assert Title
    public void checkPageTitle() {
        assertEquals(driver.getTitle(), pageTitle);
    }
}
