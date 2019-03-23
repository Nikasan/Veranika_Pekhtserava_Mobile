package hw3.pageobject.app;

import hw3.pageobject.app.pages.AddContactPage;
import hw3.pageobject.app.pages.HomePage;
import io.appium.java_client.AppiumDriver;

public class ContactManagerApp {

    public static AddContactPage addContactPage;
    public static HomePage homePage;

    public static void init(AppiumDriver driver) {
        addContactPage = new AddContactPage(driver);
        homePage = new HomePage(driver);
    }
}
