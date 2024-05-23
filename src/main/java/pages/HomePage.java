package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public final class HomePage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/account")
    private WebElement accountButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    private WebElement locationAccessButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowNotificationButton;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/notification")
    private WebElement notificationIcon;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Cart']/android.widget.FrameLayout[2]")
    private WebElement cartIcon;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/home")
    private WebElement homeIcon;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private WebElement hamburgerIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_category_title' and @text='FRUITS & VEGETABLES']")
    private WebElement fruitCategory;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/search_icon']")
    private WebElement searchIcon;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_forgot_password']")
    private WebElement resetPassword;
    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement ok;

    public HomePage() {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    public HomePage clickOnAllowLocationAccess(String testname) {
        MobileExplicitWaitFactories.click(locationAccessButton, WaitStrategy.CLICKABLE, "user clicked on location access");
        MobileTestLog.logTestStep(testname, "ClickOnAllowLocationAccess", "User clicked on location access");
        return this;
    }

    public SignInPage clickOnAccountButton(String testname) {
        MobileExplicitWaitFactories.click(accountButton, WaitStrategy.CLICKABLE, "user clicked on account button");
        MobileTestLog.logTestStep(testname, "ClickOnAccountButton", "User clicked on account button");
        return new SignInPage();
    }

    public LeftHandNavigationPage clickOnHamburgerIcon(String testname) {
        MobileExplicitWaitFactories.click(hamburgerIcon, WaitStrategy.CLICKABLE, "user clicked on hamburgerIcon");
        MobileTestLog.logTestStep(testname, "ClickOnHamburgerIcon", "User clicked on hamburger icon");
        return new LeftHandNavigationPage();
    }

    public FruitCategoryPage clickOnFruit(String testname) {
        MobileExplicitWaitFactories.click(fruitCategory, WaitStrategy.CLICKABLE, "user clicked on fruit and vegetable category");
        MobileTestLog.logTestStep(testname, "ClickOnFruit", "User clicked on fruit and vegetable category");
        return new FruitCategoryPage();
    }

    public MyCartPage clickOnCartIcon(String testname) {
        MobileExplicitWaitFactories.click(cartIcon, WaitStrategy.CLICKABLE, "user clicked on cart icon");
        MobileTestLog.logTestStep(testname, "ClickOnCartIcon", "User clicked on cart icon");
        return new MyCartPage();
    }

    public SearchPage clickOnSearchIcon(String testname) {
        MobileExplicitWaitFactories.click(searchIcon, WaitStrategy.CLICKABLE, "user clicked on search icon");
        MobileTestLog.logTestStep(testname, "ClickOnSearchIcon", "User clicked on search icon");
        return new SearchPage();
    }

    public ForgotPasswordPage performClickOnResetPasswordButton(String testname) {
        MobileExplicitWaitFactories.click(resetPassword, WaitStrategy.CLICKABLE, "user clicked on reset password button");
        MobileTestLog.logTestStep(testname, "perform Click On Reset Password Button", "user clicked on reset password button");
        return new ForgotPasswordPage();
    }

    public void clickOnHomeIcon(String testname) {
        MobileExplicitWaitFactories.click(homeIcon, WaitStrategy.CLICKABLE, "User clicked on Home Icon");
        MobileTestLog.logTestStep(testname, "Click On HomeIcon", "User clicked on Home Icon");

    }

    public void performClickOnOkButton(String testname) {
        MobileTestLog.logTestStep(testname, "Perform Click On Ok Button", "user clicked on ok button");
        MobileExplicitWaitFactories.click(ok, WaitStrategy.CLICKABLE, "user clicked on ok button");
    }

}
