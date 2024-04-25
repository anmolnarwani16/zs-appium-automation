package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DynamicElement {

    public WebElement getElementByResourceID(String resourceID) {
        return MobileDriverManager.getDriver().findElement(By.xpath("//android.widget.ImageView[contains(@resource-id, '" + resourceID + "')]"));
    }

    public void clickOnElementByResourceID(String resourceID, String elementName) {
        WebElement element = getElementByResourceID(resourceID);
        MobileExplicitWaitFactories.click(element, WaitStrategy.CLICKABLE, "User clicked on the " + elementName);
    }

    public SignInPage clickOnProfileIcon() {
        clickOnElementByResourceID("account", "profile icon");
        return new SignInPage();
    }

    public DynamicElement clickOnNotificationIcon() {
        clickOnElementByResourceID("notification", "notification icon");
        return this;
    }

    public DynamicElement clickOnSearchIcon() {
        clickOnElementByResourceID("search_icon", "search icon");
        return this;
    }

    public DynamicElement clickOnHomeIcon() {
        clickOnElementByResourceID("home", "home icon");
        return this;
    }

}
