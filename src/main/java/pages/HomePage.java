package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.MobileTestLog;

import java.time.Duration;
import java.util.List;

public final class HomePage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/account")
    private WebElement accountButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    private WebElement locationAccessButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    private List<WebElement> locationAccessButtonList;

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
    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/tv_search']")
    private WebElement searchTextField;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_forgot_password']")
    private WebElement resetPassword;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/logo']")
    private WebElement backToHome;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/iv_notification_image'])[1]")
    private WebElement notificationImage;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/iv_category'])[1]")
    private WebElement weeklyOffers;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/iv_category'])[2]")
    private WebElement exclusiveDeals;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_page_name']")
    private WebElement pageName;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_view_all']")
    private WebElement viewAllButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_subcategory_name' and @text='IMPORTED ✈']")
    private WebElement importedSubCategory;
    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement ok;

    String categoryXpath= "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_category_title' and @text='${text}']";

    WebDriverWait wait = new WebDriverWait(MobileDriverManager.getDriver(), Duration.ofSeconds(40));

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
        wait.until(ExpectedConditions.visibilityOf(hamburgerIcon));
        MobileExplicitWaitFactories.click(hamburgerIcon, WaitStrategy.CLICKABLE, "user clicked on hamburgerIcon");
        MobileTestLog.logTestStep(testname, "ClickOnHamburgerIcon", "User clicked on hamburger icon");
        return new LeftHandNavigationPage();
    }

    public FruitCategoryPage clickOnFruit(String testname) {
        try {
            MobileExplicitWaitFactories.click(fruitCategory, WaitStrategy.CLICKABLE, "user clicked on fruit and vegetable category");
            MobileTestLog.logTestStep(testname, "Click On Fruit", "User clicked on fruit and vegetable category");
            return new FruitCategoryPage();
        } catch (Exception e) {
            MobileExplicitWaitFactories.click(fruitCategory, WaitStrategy.CLICKABLE, "user clicked on fruit and vegetable category");
            MobileTestLog.logTestStep(testname, "Click On Fruit", "User clicked on fruit and vegetable category");
            return new FruitCategoryPage();
        }
    }
    public MyCartPage clickOnCartIcon(String testname) {
        MobileExplicitWaitFactories.click(cartIcon, WaitStrategy.CLICKABLE, "user clicked on cart icon");
        MobileTestLog.logTestStep(testname, "Click On CartIcon", "User clicked on cart icon");
        return new MyCartPage();
    }
    public SearchPage clickOnSearchIcon(String testname){
        MobileExplicitWaitFactories.click(searchIcon,WaitStrategy.CLICKABLE,"user clicked on search icon");
        MobileTestLog.logTestStep(testname, "ClickOnSearchIcon", "User clicked on search icon");
        return new SearchPage();
    }

    public SearchPage clickOnSearchTextField(String testname){
        MobileExplicitWaitFactories.click(searchTextField,WaitStrategy.CLICKABLE,"user clicked on search text field");
        MobileTestLog.logTestStep(testname, "clickOnSearchTextField", "User clicked on search text field");
        return new SearchPage();
    }

    public ForgotPasswordPage performClickOnResetPasswordButton(String testname) {
        MobileExplicitWaitFactories.click(resetPassword, WaitStrategy.CLICKABLE,"user clicked on reset password button");
        MobileTestLog.logTestStep(testname, "perform Click On Reset Password Button", "user clicked on reset password button");
        return new ForgotPasswordPage();
    }

    public void clickBackToHome(String testname) {
        MobileExplicitWaitFactories.click(backToHome, WaitStrategy.CLICKABLE, "User clicked on Back To Home Button");
        MobileTestLog.logTestStep(testname, "Click On Back To HomeButton", "User clicked on Back To Home Button");

    }

    public void clickOnNotificationIcon(String testname) {
        MobileExplicitWaitFactories.click(notificationIcon, WaitStrategy.CLICKABLE, "User clicked on Notification Icon");
        MobileTestLog.logTestStep(testname, "Click On NotificationIcon", "User clicked on Notification Icon");

    }

    public void clickOnHomeIcon(String testname) {
        MobileExplicitWaitFactories.click(homeIcon, WaitStrategy.CLICKABLE, "User clicked on Home Icon");
        MobileTestLog.logTestStep(testname, "Click On HomeIcon", "User clicked on Home Icon");

    }

    public WebElement getNotificationImageElement(String testname) {
        MobileTestLog.logTestStep(testname, "Notification Image Visibility", "Verifying the Notification Image");
        return notificationImage;
    }

    public WebElement getWeeklyOffersElement(String testname) {
        MobileTestLog.logTestStep(testname, "Weekly Offers Visibility", "Verifying the Weekly Offers Page Name ");
        return pageName;
    }

    public WebElement getExclusivedealsElement(String testname) {
        MobileTestLog.logTestStep(testname, "Exclusive Deals Visibility", "Verifying the Exclusive Deals Page Name");
        return pageName;
    }

    public void clickOnWeeklyOffers(String testname) {
        MobileExplicitWaitFactories.click(weeklyOffers, WaitStrategy.CLICKABLE, "User clicked on Weekly Offers Tab");
        MobileTestLog.logTestStep(testname, "Clicked on Weekly Offers", "User clicked on Weekly Offers Tab");
    }

    public void clickOnExclusiveDeals(String testname) {
        MobileExplicitWaitFactories.click(exclusiveDeals, WaitStrategy.CLICKABLE, "User clicked on Exclusive Deals Tab");
        MobileTestLog.logTestStep(testname, "Clicked on Exclusive Deals", "User clicked on Exclusive Deals Tab");
    }

    public void clickOnViewAllButton(String testname) {
        MobileExplicitWaitFactories.click(viewAllButton, WaitStrategy.CLICKABLE, "User clicked on View All Button");
        MobileTestLog.logTestStep(testname, "Clicked on View All Button", "User clicked on View All Button");
    }

    public WebElement getSubCategoryElement(String testname) {
        MobileTestLog.logTestStep(testname, "Sub-Category Visibility", "Verifying the Sub-Category");
        return importedSubCategory;
    }
    public void performClickOnOkButton(String testname) {
        MobileTestLog.logTestStep(testname, "Perform Click On Ok Button", "user clicked on ok button");
        MobileExplicitWaitFactories.click(ok, WaitStrategy.CLICKABLE, "user clicked on ok button");
    }

    public HomePage clickOnAllowLocationAccessMap(String testname) {
        if (MobileExplicitWaitFactories.getCount(locationAccessButtonList) > 0) {
            MobileExplicitWaitFactories.click(locationAccessButton, WaitStrategy.CLICKABLE, "user clicked on location access");
            MobileTestLog.logTestStep(testname, "ClickOnAllowLocationAccess", "User clicked on location access");

        }
        return this;
    }

    public FruitCategoryPage clickOnCategory(String testname, String categoryValue) {
        WebElement categoryXpathValue=MobileDriverManager.getDriver().findElement(By.xpath(categoryXpath.replace("${text}", categoryValue)));
        try {
            MobileExplicitWaitFactories.click(categoryXpathValue, WaitStrategy.CLICKABLE, "user clicked on category :"+categoryValue);
            MobileTestLog.logTestStep(testname, "Click On "+categoryValue, "User clicked on category:"+categoryValue);
        } catch (Exception e) {
            MobileTestLog.logTestStep(testname, "Click On "+categoryValue, "Unable to click on category:"+categoryValue);
        }
        return new FruitCategoryPage();
    }

}