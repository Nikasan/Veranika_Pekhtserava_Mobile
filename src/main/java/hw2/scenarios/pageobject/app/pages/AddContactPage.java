package hw2.scenarios.pageobject.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import hw2.scenarios.pageobject.app.entities.Contact;
import hw2.scenarios.pageobject.common.BasePage;

public class AddContactPage extends BasePage {
    @FindBy(id = "contactNameEditText")
    public WebElement contactNameEditText;

    @FindBy(id = "contactPhoneEditText")
    public WebElement contactPhoneEditText;

    @FindBy(id = "contactEmailEditText")
    public WebElement contactEmailEditText;

    @FindBy(id = "contactSaveButton")
    public WebElement contactSaveButton;


    public void addContact(Contact contact) {
        contactNameEditText.sendKeys(contact.getName());
        contactPhoneEditText.sendKeys(contact.getPhone());
        contactEmailEditText.sendKeys(contact.getEmail());

        contactSaveButton.click();
    }

    public AddContactPage(WebDriver driver) {
        super(driver);
    }
}
