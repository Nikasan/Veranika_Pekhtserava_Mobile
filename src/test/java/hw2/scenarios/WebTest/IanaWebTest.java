package hw2.scenarios.WebTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import hw2.scenarios.pageobject.web.pages.HomePage;
import hw2.scenarios.setup.DriverSetup;
import hw2.scenarios.setup.HttpResponseCode;
import hw2.scenarios.setup.WebPropertyReader;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class IanaWebTest {
    private HomePage homepage;

    @BeforeClass(description = "Initialisation of driver")
    public void setUp() throws Exception {
        homepage = new HomePage(DriverSetup.instance().getWebDriver());
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        int statusCode;
        statusCode = new HttpResponseCode().httpResponseCodeViaGet("https://www.iana.org/");
        assertEquals(200, statusCode);

        homepage.open();
        DriverSetup.instance().getWait().until(ExpectedConditions.urlToBe(WebPropertyReader.instance().sut));//"https://www.iana.org/"
        homepage.checkIsOpened();
        assertTrue(DriverSetup.instance().getWebDriver().getTitle().contains("Internet Assigned Numbers Authority"));
        System.out.println("Site opening done");
    }

    @AfterClass(description = "Quit driver after all test in this class")
    public void tearDown() throws Exception {
        DriverSetup.instance().getWebDriver().quit();
    }
}
