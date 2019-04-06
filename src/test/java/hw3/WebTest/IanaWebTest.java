package hw3.WebTest;

import hw3.Hooks;
import hw3.pageobject.web.pages.HomePage;
import hw3.setup.HttpResponseCode;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw3.setup.DriverSetup.SUT;
import static org.testng.AssertJUnit.assertEquals;

public class IanaWebTest extends Hooks {
    private HomePage homepage;

    @BeforeMethod(description = "Initialisation of page")
    public void setUp(){
        homepage = new HomePage(driver);
    }

    @Test(groups = "web", description = "Open website")
    public void webTest() {
        int statusCode;
        statusCode = new HttpResponseCode().httpResponseCodeViaGet("https://www.iana.org/");
        assertEquals(200, statusCode);

        homepage.open();
        wait.until(ExpectedConditions.urlToBe(SUT));
        homepage.checkPageTitle();
        System.out.println("Site opening done");
    }

}
