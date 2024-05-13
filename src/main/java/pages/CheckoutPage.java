package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;
import utiles.MobileScrollDownUtility;

public class CheckoutPage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_name")
    private WebElement commentSection;
    @FindBy(id = "com.zopsmart.stg.scarlet:id/radio_debit_card")
    private WebElement debitCardButton;
    @FindBy(xpath = "(//android.view.View[@resource-id='com.zopsmart.stg.scarlet:id/view_selection'])[3]")
    private WebElement savedDebitCard;
    @FindBy(id = "com.zopsmart.stg.scarlet:id/btn_place_order")
    private WebElement placeOrderButton;
    @FindBy(id = "com.zopsmart.stg.scarlet:id/order_placed_label")
    private WebElement orderPlacedTab;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_slot_time' and @text='Within 30 minutes']")
    private WebElement timeSlotButton;
    public CheckoutPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }
    public CheckoutPage enterComment(WebDriver driver,String testname){
        MobileScrollDownUtility.scrollDown(driver);
        MobileExplicitWaitFactories.sendKeys(commentSection,"sample text for place order text", WaitStrategy.VISIBLE,"user entered comment related to order");
        MobileTestLog.logTestStep(testname,"enter text in comment section","user entered comment related to order");
        return new CheckoutPage();
    }
    public CheckoutPage clickDebitCardButton(String testname){
        MobileExplicitWaitFactories.click(debitCardButton,WaitStrategy.CLICKABLE,"user clicked on debit card option");
        MobileTestLog.logTestStep(testname,"choose payment method","user clicked on debit card option");
        return new CheckoutPage();
    }
    public CheckoutPage clickOnSavedDebitCard(String testname){
        MobileExplicitWaitFactories.click(savedDebitCard,WaitStrategy.CLICKABLE,"user clicked on saved debit card");
        MobileTestLog.logTestStep(testname,"choose from saved cards","user clicked on saved debit card");
        return new CheckoutPage();
    }
    public CheckoutPage clickOnPlaceOrderButton(String testname){
        MobileExplicitWaitFactories.click(placeOrderButton,WaitStrategy.CLICKABLE,"user clicked on place order button");
        MobileTestLog.logTestStep(testname,"click place order button","user clicked on place order button");
        return new CheckoutPage();
    }
    public WebElement getOrderPlacedTab(String testname){
        MobileTestLog.logTestStep(testname,"validate presence of order placed tab","Verifying the visibility of Order placed tab");
        return orderPlacedTab;
    }
    public CheckoutPage clickOnTimeSlotButton(String testname){
        MobileExplicitWaitFactories.click(timeSlotButton,WaitStrategy.CLICKABLE,"user clicked on within 30 min time slot");
        MobileTestLog.logTestStep(testname,"click 30 min time slot","user clicked on within 30 min time slot");
        return new CheckoutPage();
    }
}
