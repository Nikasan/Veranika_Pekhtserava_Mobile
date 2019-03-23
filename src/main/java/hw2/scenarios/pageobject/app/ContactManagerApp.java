package hw2.scenarios.pageobject.app;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import hw2.scenarios.pageobject.app.pages.AddContactPage;
import hw2.scenarios.pageobject.app.pages.HomePage;

public class ContactManagerApp {

    public static AddContactPage addContactPage;
    public static HomePage homePage;

    public static void init(AppiumDriver driver) {
        addContactPage = new AddContactPage(driver);
        homePage = new HomePage(driver);
    }
}
