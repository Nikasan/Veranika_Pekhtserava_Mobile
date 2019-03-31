package hw2.NativeTest;

import hw2.pageobject.app.ContactManagerApp;

import hw2.setup.DriverSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import hw2.pageobject.app.entities.Contact;


public class ContactManagerTest {

    @BeforeClass(description = "Initialisation of driver")
    public void setUp() throws Exception {
        ContactManagerApp.init(DriverSetup.instance().getNativeDriver());
    }

    @Test(description = "test to click button")
    public void tapButtonTest() {
        ContactManagerApp.homePage.openAddContactForm();
        ContactManagerApp.addContactPage.setName("Maxim Mescheryakov");
        ContactManagerApp.addContactPage.setPhone("123456789");
        ContactManagerApp.addContactPage.setEmail("max@mail.ru");
        ContactManagerApp.addContactPage.contactSaveButton.click();
        System.out.println("Contact added");
    }

    @Test(description = "Adding contact more complex test. Check that contact added")
    public void appTest() {
        ContactManagerApp.homePage.openAddContactForm();
        ContactManagerApp.addContactPage.addContact(Contact.getContact());
        ContactManagerApp.homePage.checkContact(Contact.getContact());
    }

    @AfterClass(description = "Quit driver after all test in this class")
    public void tearDown() throws Exception {
        DriverSetup.instance().getNativeDriver().quit();
    }
}
