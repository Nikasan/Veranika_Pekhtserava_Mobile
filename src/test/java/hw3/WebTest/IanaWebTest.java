package hw3.WebTest;

import hw3.pageobject.web.pages.HomePage;
import hw3.setup.DriverSetup;
import hw3.setup.HttpResponseCode;
import hw3.setup.WebPropertyReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class IanaWebTest {
    private HomePage homepage;

    @BeforeClass(description = "Initialisation of driver")
    public void setUp() throws IOException {
        homepage = new HomePage(DriverSetup.instance().getWebDriver(),DriverSetup.instance().getWait());
    }

    @Test(description = "Open website")
    public void webTest() throws IOException {
        int statusCode;
        statusCode = new HttpResponseCode().httpResponseCodeViaGet(WebPropertyReader.instance().sut);
        assertEquals(200, statusCode);

        homepage.open();
        homepage.checkPageTitle();
        System.out.println("Site opening done");
    }

    @AfterClass(description = "Quit driver after all test in this class")
    public void tearDown() throws IOException{
        DriverSetup.instance().getWebDriver().quit();
    }
}
