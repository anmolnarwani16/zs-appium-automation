package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import reports.MobileTestLog;


public final class SavedAddressPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='Saved Address']")
    private WebElement savedAddress;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/ic_add']")
    private WebElement addNewAddress;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_search']")
    private WebElement searchAddress;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_phone_no']")
    private WebElement searchNewAddress;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_house_building']")
    private WebElement enterHouseNo;
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.zopsmart.stg.scarlet:id/btn_submit']")
    private WebElement submitButton;
    @FindBy(xpath = " //android.widget.TextView[@resource-id='android:id/message']")
    private WebElement addedAddress;
    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement ok;

    public SavedAddressPage() {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    public SavedAddressPage performClickOnSavedAddress(String testname) {
        MobileExplicitWaitFactories.click(savedAddress, WaitStrategy.CLICKABLE, "user clicked on saved address");
        MobileTestLog.logTestStep(testname, "Perform Click on saved address", "User clicked on saved address");
        return new SavedAddressPage();
    }

    public SavedAddressPage performClickOnAddNewAddress(String testname) {
        MobileExplicitWaitFactories.click(addNewAddress, WaitStrategy.CLICKABLE, "user clicked on add new address");
        MobileTestLog.logTestStep(testname, "Perform Click On add new address button", "User clicked on add new address");
        return new SavedAddressPage();
    }

    public SavedAddressPage addNewAddress(String searchaddress, String houseNo, String testname) {

        MobileExplicitWaitFactories.click(searchAddress, WaitStrategy.CLICKABLE, "user clicked on search Address");
        MobileExplicitWaitFactories.sendKeys(searchAddress, searchaddress, WaitStrategy.VISIBLE, "search Address");
        MobileExplicitWaitFactories.click(searchNewAddress, WaitStrategy.CLICKABLE, "user clicked on add new address");
        //MobileDriverManager.getDriver().navigate().back();
        MobileExplicitWaitFactories.click(enterHouseNo, WaitStrategy.CLICKABLE, "user clicked on add house number ");
        MobileExplicitWaitFactories.sendKeys(enterHouseNo, houseNo, WaitStrategy.VISIBLE, " house  number");
//        MobileDriverManager.getDriver().navigate().back();
        MobileExplicitWaitFactories.click(submitButton, WaitStrategy.CLICKABLE, "user clicked on submit button");
        MobileTestLog.logTestStep(testname, "New Address Added", "User added new address");
        return this;
    }

    public void getAddressAddedText(String enterActualText, String testname) {
        MobileTestLog.logTestStep(testname, "Get Added address Text", "added address");
        String addedNewAddress = MobileExplicitWaitFactories.getText(addedAddress, enterActualText, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "New address set successfully");
        Assert.assertEquals(addedNewAddress, Constant.ADDRESS_ADDED);
    }

    public void performClickOnOkButton(String testname) {
        MobileTestLog.logTestStep(testname, "Perform Click On Ok Button", "user clicked on ok button");
        MobileExplicitWaitFactories.click(ok, WaitStrategy.CLICKABLE, "user clicked on ok button");
    }

}
