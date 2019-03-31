package hw2.pageobject.app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import hw2.pageobject.app.entities.Contact;
import hw2.pageobject.common.BasePage;

public class AddContactPage extends BasePage {
    @FindBy(id = "contactNameEditText")
    public WebElement contactNameEditText;

    @FindBy(id = "contactPhoneEditText")
    public WebElement contactPhoneEditText;

    @FindBy(id = "contactEmailEditText")
    public WebElement contactEmailEditText;

    @FindBy(id = "contactSaveButton")
    public WebElement contactSaveButton;


    public AddContactPage(AppiumDriver driver) {
        super(driver);
    }

    public void addContact(Contact contact) {
        contactNameEditText.sendKeys(contact.getName());
        contactPhoneEditText.sendKeys(contact.getPhone());
        contactEmailEditText.sendKeys(contact.getEmail());
        contactSaveButton.click();
    }

    public void setName(String name) {
        contactNameEditText.sendKeys(name);
    }

    public void setPhone(String phone) {
        contactPhoneEditText.sendKeys(phone);
    }

    public void setEmail(String email) {
        contactEmailEditText.sendKeys(email);
    }
}
