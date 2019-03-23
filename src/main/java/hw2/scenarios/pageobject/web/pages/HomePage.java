package hw2.scenarios.pageobject.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import hw2.scenarios.pageobject.common.BasePage;
import hw2.scenarios.pageobject.web.enums.HomePageData;
import hw2.scenarios.setup.WebPropertyReader;

import java.io.IOException;

public class HomePage extends BasePage {
    @FindBy(id = "intro")
    public WebElement intro;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() throws IOException {
        driver.get(WebPropertyReader.instance().sut);
    }

    public void checkIsOpened() {
        Assert.assertEquals(intro.getText(), HomePageData.INTRO.toString());

    }
}
