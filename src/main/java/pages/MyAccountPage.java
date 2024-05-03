package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='com.zopsmart.stg.scarlet:id/account_item'])[12]")
    private WebElement logoutButton;

    public MyAccountPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }

    public HomePage clickOnLogoutButton(){
        MobileExplicitWaitFactories.click(logoutButton, WaitStrategy.CLICKABLE,"user clicked on LogoutButton");
        return new HomePage();
    }
}
