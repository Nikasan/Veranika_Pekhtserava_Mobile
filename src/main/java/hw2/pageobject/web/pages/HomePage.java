package hw2.pageobject.web.pages;

import hw2.pageobject.common.BasePage;
import hw2.setup.WebPropertyReader;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import hw2.pageobject.web.enums.HomePageData;

import java.io.IOException;

public class HomePage extends BasePage {
    @FindBy(id = "intro")
    public WebElement intro;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void open() throws IOException {
        driver.get(WebPropertyReader.instance().sut);
    }

    public void checkIsOpened() {
        Assert.assertEquals(intro.getText(), HomePageData.INTRO.toString());

    }
}
