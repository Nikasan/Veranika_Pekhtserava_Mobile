package hw2.WebTest;

import hw2.Hooks;
import hw2.pageobject.web.pages.HomePage;
import hw2.setup.HttpResponseCode;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw2.setup.DriverSetup.SUT;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class IanaWebTest extends Hooks {
    private HomePage homepage;

    @BeforeMethod(description = "Initialisation of page")
    public void setUp(){
        homepage = new HomePage(driver);
    }

    @Test(groups = "web", description = "Open website")
    public void webTest() throws Exception {
        int statusCode;
        statusCode = new HttpResponseCode().httpResponseCodeViaGet("https://www.iana.org/");
        assertEquals(200, statusCode);

        homepage.open();
        wait.until(ExpectedConditions.urlToBe(SUT));
        homepage.checkIsOpened();
        assertTrue(driver.getTitle().contains("Internet Assigned Numbers Authority"));
        System.out.println("Site opening done");
    }
}
