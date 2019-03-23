package hw3.NativeTest;

import hw3.pageobject.app.ContactManagerApp;
import hw3.pageobject.app.entities.Contact;
import hw3.setup.DriverSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class ContactManagerTest {

    @BeforeClass(description = "Initialisation of driver")
    public void setUp() throws IOException {
        ContactManagerApp.init(DriverSetup.instance().getNativeDriver());
    }

    @Test(description = "test to click button")
    public void tapButtonTest(){
      ContactManagerApp.homePage.setAddContactButtonClick();
      ContactManagerApp.addContactPage.setName("Maxim Mescheryakov");
      ContactManagerApp.addContactPage.setPhone("133456789");
      ContactManagerApp.addContactPage.setEmail("max@mail.ru");
      ContactManagerApp.addContactPage.contactSaveButton.click();
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
