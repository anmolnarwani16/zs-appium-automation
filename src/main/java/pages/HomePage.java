package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
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
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_forgot_password']")
    private WebElement resetPassword;

    public HomePage() {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    public HomePage clickOnAllowLocationAccess() {
        MobileExplicitWaitFactories.click(locationAccessButton, WaitStrategy.CLICKABLE, "user clicked on location access");
        return this;
    }

    public SignInPage clickOnAccountButton() {
        MobileExplicitWaitFactories.click(accountButton, WaitStrategy.CLICKABLE, "user clicked on account button");
        return new SignInPage();
    }

    public LeftHandNavigationPage clickOnHamburgerIcon() {
        MobileExplicitWaitFactories.click(hamburgerIcon, WaitStrategy.CLICKABLE, "user clicked on hamburgerIcon");
        return new LeftHandNavigationPage();
    }

    public FruitCategoryPage clickOnFruit(){
        MobileExplicitWaitFactories.click(fruitCategory,WaitStrategy.CLICKABLE,"user clicked on fruit and vegetable category");
        return new FruitCategoryPage();
    }

    public MyCartPage clickOnCartIcon(){
        MobileExplicitWaitFactories.click(cartIcon,WaitStrategy.CLICKABLE,"user clicked on cart icon");
        return new MyCartPage();
    }


    public ForgotPasswordPage performClickOnResetPasswordButton() {
        MobileExplicitWaitFactories.click(resetPassword, WaitStrategy.CLICKABLE,"user clicked on reset password button");
        return new ForgotPasswordPage();
    }
}
