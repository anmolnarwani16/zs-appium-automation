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

import java.util.Arrays;
import java.util.List;

public final class MyAccountPage {
    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='com.zopsmart.stg.scarlet:id/account_item'])[12]")
    private WebElement logoutButton;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/itemImage'])[8]")
    private WebElement languageButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='Change Password']")
    private WebElement changePassword;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/welcome']")
    private WebElement welcome;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='Themari']")
    private WebElement themari;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='My Orders']")
    private WebElement myOrders;
    //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/itemTextView" and @text="My Wallet"]
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='My Wallet']")
    private WebElement myWallet;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='Saved Cards']")
    private WebElement savedCards;
    @FindBy(xpath = "  //android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='Saved Address']")
    private WebElement savedAddress;

    //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/itemTextView" and @text="اللغة"]
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='اللغة']")
    private WebElement languageText;

    @FindBy(xpath = " //android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='Contact us']")
    private WebElement contactUs;

    @FindBy(xpath = " //android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_select_store']")
    private WebElement textOfSavedAddress;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/ic_cross']")
    private WebElement crossButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.zopsmart.stg.scarlet:id/btn_save_password']")
    private WebElement changePasswordButton;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/navigation_icon']")
    private WebElement navigateButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/debit_card']")
    private WebElement checkSaveCard;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_header']")
    private WebElement availableBalance;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_delivery_mode']")
    private WebElement deliverTo;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='My Products']")
    private WebElement myProducts;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_english']")
    private WebElement languagePreference;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/item_name' and @text='Company Information']")
    private WebElement contactUsText;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_add_new_card']")
    private WebElement addNewCardLnk;
    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement addConfirmationOkBtn;
    @FindBy(id = "android:id/tv_name_on_card_debit")
    private WebElement cardName;

    private List<WebElement> elements;

    public MyAccountPage() {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
        elements = Arrays.asList(
                themari,
                myOrders,
                myProducts,
                myWallet,
                savedCards,
                savedAddress,
                changePassword,
                languageText,
                contactUs
        );
    }

    public HomePage clickOnLogoutButton(String testname) {
        MobileExplicitWaitFactories.click(logoutButton, WaitStrategy.CLICKABLE, "User clicked on LogoutButton");
        MobileTestLog.logTestStep(testname, "Click on Logout Button", "User clicked on LogoutButton");
        return new HomePage();
    }

    public HomePage clickOnLanguage(String testname) {
        MobileExplicitWaitFactories.click(languageButton, WaitStrategy.CLICKABLE, "User clicked on LogoutButton");
        MobileTestLog.logTestStep(testname, "Click on Language Tab ", "User clicked on Language Tab");
        return new HomePage();
    }
    public WebElement getChangePasswordElement(String testname)
    {
        MobileTestLog.logTestStep(testname,"Change Password Visibility","Verifying the change password");
        return changePassword;
    }

    public String getElementTextForWelcome(String text, String testname) {
        MobileTestLog.logTestStep(testname, "Get Welcome Text", "Get Welcome Text");
        return MobileExplicitWaitFactories.getText(welcome, text, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Get Welcome Text");

    }

    public void validateSavedAddress(String text, String testname) {
        MobileTestLog.logTestStep(testname, "Get Saved Address Text", "Get Saved Address Text");
        String savedAddress = MobileExplicitWaitFactories.getText(textOfSavedAddress, text, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Get Saved Address Text");
        Assert.assertEquals(savedAddress, Constant.SAVED_ADDRESS_TEXT);
        MobileExplicitWaitFactories.click(crossButton, WaitStrategy.CLICKABLE, "user clicked on back button");

    }

    public void validateChangePassword(String text, String testname) {
        MobileTestLog.logTestStep(testname, "Get Change Password Text", "Get Change Password Text");
        String changePassword = MobileExplicitWaitFactories.getText(changePasswordButton, text, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Get Change Password Text");
        Assert.assertEquals(changePassword, Constant.SAVE_PASSWORD);
        MobileExplicitWaitFactories.click(navigateButton, WaitStrategy.CLICKABLE, "user clicked on back button");

    }

    public void validateSavedCard(String text, String testname) {
        MobileExplicitWaitFactories.click(savedCards, WaitStrategy.CLICKABLE, "user clicked on saved cards");
        MobileTestLog.logTestStep(testname, "User clicked on saved cards ", "user clicked on saved cards");
        String checkCard = MobileExplicitWaitFactories.getText(checkSaveCard, text, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Check Card");
        Assert.assertEquals(checkCard, Constant.CHECK_CARD);
        MobileExplicitWaitFactories.click(navigateButton, WaitStrategy.CLICKABLE, "user clicked on back button");

    }

    public void validateMyWallet(String text, String testname) {
        MobileExplicitWaitFactories.click(myWallet, WaitStrategy.CLICKABLE, "user clicked on my walllet");
        MobileTestLog.logTestStep(testname, "User clicked on my walllet ", "user clicked on my walllet");
        String checkBalance = MobileExplicitWaitFactories.getText(availableBalance, text, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Available Balance");
        Assert.assertEquals(checkBalance, Constant.BALANCE);
        MobileDriverManager.getDriver().navigate().back();

    }

    public void myProducts(String text, String testname) {
        MobileExplicitWaitFactories.click(myProducts, WaitStrategy.CLICKABLE, "user clicked on my products");
        MobileTestLog.logTestStep(testname, "User clicked on my products ", "user clicked on my products");
        String checkBalance = MobileExplicitWaitFactories.getText(deliverTo, text, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Check my products");
        Assert.assertEquals(checkBalance, Constant.DELIVERING);
        MobileDriverManager.getDriver().navigate().back();

    }

    public void myOrders(String testname) {
        MobileExplicitWaitFactories.click(myOrders, WaitStrategy.CLICKABLE, "user clicked on my orders");
        MobileTestLog.logTestStep(testname, "User clicked on my orders ", "user clicked on my orders");
        MobileDriverManager.getDriver().navigate().back();

    }

    public void changeLanguage(String text, String testname) {
        MobileExplicitWaitFactories.click(languageText, WaitStrategy.CLICKABLE, "user clicked on change language preference");
        MobileTestLog.logTestStep(testname, "User clicked on change language preference", "user clicked on my orders");
        String changeLanguage = MobileExplicitWaitFactories.getText(languagePreference, text, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Check my language preferences");
        Assert.assertEquals(changeLanguage, Constant.LANGUAGE_PREFERENCE);
        MobileDriverManager.getDriver().navigate().back();

    }

    public void contactUs(String text, String testname) {
        MobileExplicitWaitFactories.click(contactUs, WaitStrategy.CLICKABLE, "user clicked on contact Us");
        MobileTestLog.logTestStep(testname, "User clicked on contact Us", "user clicked on contact Us");
        String contactUs = MobileExplicitWaitFactories.getText(contactUsText, text, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "User check contact us text");
        Assert.assertEquals(contactUs, Constant.CONTACT_TEXT);
        MobileDriverManager.getDriver().navigate().back();

    }


    List<String> expectedTexts = Arrays.asList(
            "Themari",
            "My Orders",
            "My Products",
            "My Wallet",
            "Saved Cards",
            "Saved Address",
            "Change Password",
            "اللغة",
            "Contact us"
    );

    public void verifyElementTexts(String testName) {
        for (int i = 0; i < elements.size(); i++) {
            String actualText = MobileExplicitWaitFactories.getText(elements.get(i), expectedTexts.get(i), WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Get " + expectedTexts.get(i) + " Text");
            Assert.assertEquals(actualText, expectedTexts.get(i));
            MobileTestLog.logTestStep(testName, "Verified " + expectedTexts.get(i) + " Text", "Verified " + expectedTexts.get(i) + " Text");
        }
    }
}
