package pages;

import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reports.MobileTestLog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderNotificationPage {
    @FindBy(xpath="//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_display_message']']")
    public WebElement ordertext;
    @FindBy(xpath="//android.widget.TextView[@resource-id='android:id/message']")
    public WebElement orderalert;
    @FindBy(xpath="//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/navigation_icon']")
    public WebElement backButton;
    @FindBy(xpath="(//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_title_text'])[1]")
    public WebElement orderNumber;
    public String getOrderId(String testname,String text)
    {   String str="";
        if(text.equals("ordertext")) {
            str = MobileExplicitWaitFactories.getText(ordertext, null, WaitStrategy.CLICKABLE, "Fetching Order Number");

        }
        else {
            str=MobileExplicitWaitFactories.getText(orderNumber, null, WaitStrategy.CLICKABLE, "Fetching Order Number");

        }
        Pattern pattern = Pattern.compile("\\d{8}");
        ;
        // Create a matcher object
        Matcher matcher = pattern.matcher(str);
        String orderNumber = matcher.group();
//        int value = Integer.parseInt(orderNumber);
        return orderNumber;
    }
    public void clickOnBack(String testname)
    {
        MobileExplicitWaitFactories.click(backButton,WaitStrategy.CLICKABLE,"User clicked on back button");
        MobileTestLog.logTestStep(testname,"Clicked BackButton","User clicked on back button");
    }
    public WebElement getOrderAlertElement(String testname)
    {
        return orderalert;
    }
}
