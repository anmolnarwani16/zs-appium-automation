package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public class MyAccountPage {
    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='com.zopsmart.stg.scarlet:id/account_item'])[12]")
    private WebElement logoutButton;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/itemImage'])[8]")
    private WebElement languageButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='Change Password']")
    private WebElement changePassword;

    public MyAccountPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }

    public HomePage clickOnLogoutButton(String testname){
        MobileExplicitWaitFactories.click(logoutButton, WaitStrategy.CLICKABLE,"User clicked on LogoutButton");
        MobileTestLog.logTestStep(testname,"Click on Logout Button","User clicked on LogoutButton");
        return new HomePage();
    }
    public HomePage clickOnLanguage(String testname){
        MobileExplicitWaitFactories.click(languageButton, WaitStrategy.CLICKABLE,"User clicked on LogoutButton");
        MobileTestLog.logTestStep(testname,"Click on Language Tab ","User clicked on Language Tab");
        return new HomePage();
    }
    public WebElement getChangePasswordElement(String testname)
    {
        MobileTestLog.logTestStep(testname,"Change Password Visibility","Verifying the change password");
        return changePassword;
    }
}
