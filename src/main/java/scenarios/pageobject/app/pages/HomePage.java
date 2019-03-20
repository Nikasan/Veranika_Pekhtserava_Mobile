package scenarios.pageobject.app.pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import scenarios.pageobject.app.entities.Contact;
import scenarios.pageobject.common.BasePage;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class HomePage extends BasePage {

    @FindBy(id = "addContactButton")
    public WebElement addContactButton;

    @FindBy(id = "showInvisible")
    public  WebElement checkBox;

     @FindBy (id = "contactEntryText")
     public List<WebElement> contacts;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Set<String> getAllContacts()  {
        Set<String> contactNames = new HashSet<>();

        for (int i = 0; i <=6; i++) {
            for(WebElement contact : contacts){
             contactNames.add(contact.getText());
           }
          scrollDown();
       }
       return contactNames;
    }

    public void checkContact(Contact contact) {
//        for(String element: getAllContacts()){
//            System.out.println(element);
//        }
        //System.out.println(getAllContacts());
       // System.out.println(contact.getName().trim());
        Assert.assertTrue(getAllContacts().contains(contact.getName().trim()));
    }

    public void openAddContactForm() {
        checkBox.click();
        addContactButton.click();
    }

    public void scrollDown(){
        Dimension dimension = driver.manage().window().getSize();

        Double scrollHeightStart = dimension.getHeight()*0.5;
        int scrollStart = scrollHeightStart.intValue();

        Double scrollHeightEnd = dimension.getHeight()*0.2;
        int scrollEnd = scrollHeightEnd.intValue();

        new TouchAction(driver).press(PointOption.point(0,scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(0,scrollEnd)).release().perform();

    }
}