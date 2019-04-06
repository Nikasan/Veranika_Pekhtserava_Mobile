package hw2.NativeTest;

import hw2.Hooks;
import hw2.pageobject.app.ContactManagerApp;
import hw2.pageobject.app.entities.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ContactManagerTest extends Hooks {

    @BeforeMethod(description = "Initialisation of app")
    public void setUp() {
        ContactManagerApp.init(driver);
    }

    @Test(groups = "native",description = "test to click button")
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
}
