package pages;

import driver.MobileDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileExtentLogger;

import java.util.List;

public class DynamicXpath1 {

    @FindBy(xpath = "//android.widget.TextView")
    private List<WebElement> allTextViewElements;

    public DynamicXpath1(){
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    // Method to click on element with dynamic text
    public void clickOnElementWithText(String text) {
        for (WebElement textViewElement : allTextViewElements) {
            String elementText = textViewElement.getText();
            System.out.println("element text is"+"elementText");
            if (elementText.equals(text)) {

                textViewElement.click();
                MobileExtentLogger.info(" user clicked on "+text+" link and link is cliked succesfully");
                System.out.println("Clicked on element with text: " + text);
                return; // Exit the method after clicking the element
            }
        }
        System.out.println("Element with text '" + text + "' not found.");
    }
}
