package hw3.pageobject.web.pages;

import hw3.pageobject.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;

import java.time.Duration;

import static hw3.setup.DriverSetup.SUT;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage extends BasePage {

    private String pageTitle = "Internet Assigned Numbers Authority";

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(SUT);
        new TouchAction(driver).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)));
    }

    // Assert Title
    public void checkPageTitle() {
        assertEquals(driver.getTitle(), pageTitle);
    }


}
