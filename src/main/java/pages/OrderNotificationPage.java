package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class OrderNotificationPage {
    @FindBy(xpath="//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_display_message']")
    public WebElement ordertext;

    @FindBy(xpath="//android.widget.TextView[@resource-id='android:id/message']")
    public WebElement orderalert;

    @FindBy(xpath="(//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_title_text'])[1]")
    public WebElement orderNumber;

    @FindBy(xpath="//android.widget.Button[@resource-id='com.zopsmart.stg.scarlet:id/ok_button']")
    public WebElement okButton;

    public OrderNotificationPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }


    public String getOrderId(String testname, String text, WebDriver driver)  {
        String str = "";
        if (text.equalsIgnoreCase("orderText")) {
            str = MobileExplicitWaitFactories.getText(ordertext, WaitStrategy.CLICKABLE, "Fetching Order Number");
           }
         else{
            str = MobileExplicitWaitFactories.getText(orderNumber, WaitStrategy.CLICKABLE, "Fetching Order Number");
         }
        Pattern pattern = Pattern.compile("\\d{8}");
        Matcher matcher = pattern.matcher(str);

        // Check if matcher finds a match before accessing group
        if (matcher.find()) {
            return matcher.group(); // Return the matched order number
        } else {
            return ""; // Return empty string if no order number is found
        }
    }

}
