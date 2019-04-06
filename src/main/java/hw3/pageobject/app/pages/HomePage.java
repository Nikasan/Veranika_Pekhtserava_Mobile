package hw3.pageobject.app.pages;

import hw3.pageobject.app.entities.Contact;
import hw3.pageobject.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class HomePage extends BasePage {

    @FindBy(id = "addContactButton")
    public WebElement addContactButton;

     @FindBy (id = "contactEntryText")
     public List<WebElement> contacts;

    @FindBy(id = "showInvisible")
    public  WebElement checkBox;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public Set<String> getAllContacts()  {
        Set<String> contactNames = new HashSet<>();

            for(WebElement contact : contacts){
             contactNames.add(contact.getText());
           }
       return contactNames;
    }

    public void setAddContactButtonClick(){
        addContactButton.click();
    }

    public void checkContact(Contact contact) {
        Assert.assertTrue(getAllContacts().contains(contact.getName().trim()));
    }

    public void openAddContactForm() {
       new TouchAction(driver).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)));
     //  checkBox.click();
        addContactButton.click();
    }

}
