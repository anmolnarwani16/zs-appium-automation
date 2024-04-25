package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "com.zopsmart.stg.scarlet:id/account")
    private WebElement profileIcon;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/notification")
    private WebElement notificationIcon;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/search_icon")
    private WebElement serachIcon;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/home")
    private WebElement homeIcon;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Cart']/android.widget.FrameLayout[2]")
    private WebElement cartIcon;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private WebElement hamburgerIcon;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowNotificationButton;

    public HomePage() {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    public SignInPage clickOnProfileIcon() {
        MobileExplicitWaitFactories.click(profileIcon, WaitStrategy.CLICKABLE, " user clciked on the profile icon");
        return new SignInPage();
    }

    public DynamicElementByXPath clickOnAllowNotificationButton() {
        MobileExplicitWaitFactories.click(allowNotificationButton, WaitStrategy.CLICKABLE, " user clciked on the allowNotificationButton ");
        return new DynamicElementByXPath();

    }

    public HomePage clickOnNotificationIcon(String locatorName) {
        String ele = String.format("com.zopsmart.stg.scarlet:id/%s", locatorName);
        WebElement webEle = profileIcon.findElement(By.id(ele));
        MobileExplicitWaitFactories.click(webEle, WaitStrategy.CLICKABLE, " user clicked on the");
        return this;

    }
    public DynamicXpathOfLeftHAndNavigation clickOnHamburgerIcon() {
        MobileExplicitWaitFactories.click(hamburgerIcon, WaitStrategy.CLICKABLE, " user clciked on the hamburgerIcon ");
        return new DynamicXpathOfLeftHAndNavigation();

    }
}

   /*public WebElement clickOnCartIcon() {
        return cartIcon;
    }

    public WebElement clickOnHomeIcon() {
        return homeIcon;
    }



    public WebElement clickOnSerachIcon() {
        return serachIcon;
    }*/

