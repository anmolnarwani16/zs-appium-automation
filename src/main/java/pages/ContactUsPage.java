package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import frameConstatnt.testConstant.Constant;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public class ContactUsPage {

    public ContactUsPage() {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    @FindBy(xpath = " //android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='Contact us']")
    private WebElement contactUs;


    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/item_name' and @text='Call']")
    private WebElement callOption;


    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_phone_no']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/item_name' and @text='Write to Us']")
    private WebElement writeToUs;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_name']")
    private WebElement name;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_number']")
    private WebElement phoneNo;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_description']")
    private WebElement description;
    public ContactUsPage clickOnContactUs(String testname) {
        MobileExplicitWaitFactories.click(contactUs, WaitStrategy.CLICKABLE, "user clicked on contact Us");
        MobileTestLog.logTestStep(testname, "User clicked on contact Us", "user clicked on contact Us");
        return this;

    }
    public ContactUsPage validateCallOption(String text,String testname) {
        MobileExplicitWaitFactories.click(callOption, WaitStrategy.CLICKABLE, "user clicked on call option");
        String phoneNo = MobileExplicitWaitFactories.getText(phoneNumber, text, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Check mobile number");
        Assert.assertEquals(phoneNo, Constant.CONTACT_TEXT);
        MobileTestLog.logTestStep(testname, "User clicked on call option", "user clicked on call option");
        return this;

    }
    public ContactUsPage validateWriteToUs(String text,String testname) {

        MobileExplicitWaitFactories.click(writeToUs, WaitStrategy.CLICKABLE, "user clicked on write to us");
        MobileTestLog.logTestStep(testname, "User clicked on write to us", "user clicked on write to us");
        return this;

    }
}
