package hw3.NativeTest;

import hw3.Hooks;
import hw3.pageobject.app.ContactManagerApp;
import hw3.pageobject.app.entities.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ContactManagerTest extends Hooks {

    @BeforeMethod(description = "Initialisation of app")
    public void setUp() {
        ContactManagerApp.init(driver);
    }

    @Test(groups = "native",description = "test to click button")
    public void tapButtonTest(){
      ContactManagerApp.homePage.setAddContactButtonClick();
      ContactManagerApp.addContactPage.setName("Maxim Mescheryakov");
      ContactManagerApp.addContactPage.setPhone("133456789");
      ContactManagerApp.addContactPage.setEmail("max@mail.ru");
      ContactManagerApp.addContactPage.contactSaveButton.click();
      System.out.println("addContactButton is taped");
    }

    @Test(groups = "native", description = "Adding contact via PageObject pattern.")
    public void appTest() {
        ContactManagerApp.homePage.openAddContactForm();
        ContactManagerApp.addContactPage.addContact(Contact.getContact());
        System.out.println(ContactManagerApp.homePage.getAllContacts());
        ContactManagerApp.homePage.checkContact(Contact.getContact());
    }
}
