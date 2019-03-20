package scenarios.hw2.NativeTest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import scenarios.setup.DriverSetup;
import scenarios.pageobject.app.ContactManagerApp;
import scenarios.pageobject.app.entities.Contact;

import java.io.IOException;


public class ContactManagerTest {

    private static final String PACKAGE_NAME = "com.example.android.contactmanager:id/";

    @BeforeClass(description = "Initialisation of driver")
    public void setUp() throws IOException {
        ContactManagerApp.init(DriverSetup.instance().getNativeDriver());
    }

    @Test(description = "test to click button")
    public void tapButtonTest() throws IOException {
        DriverSetup.instance().getNativeDriver().findElement(By.id(PACKAGE_NAME + "addContactButton")).click();
        DriverSetup.instance().getNativeDriver().findElement(By.id("contactNameEditText")).sendKeys("Maxim Mescheryakov");
        DriverSetup.instance().getNativeDriver().findElement(By.id("contactSaveButton")).click();
        System.out.println("addContactButton is taped");
    }

    @Test(description = "Adding contact via PageObject pattern.")
    public void appTest() {
        ContactManagerApp.homePage.openAddContactForm();
        ContactManagerApp.addContactPage.addContact(Contact.getContact());
        ContactManagerApp.homePage.checkContact(Contact.getContact());
    }

    @AfterClass(description = "Quit driver after all test in this class")
    public void tearDown() throws IOException {
        DriverSetup.instance().getNativeDriver().quit();
    }
}
