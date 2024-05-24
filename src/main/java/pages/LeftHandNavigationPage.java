package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public final class LeftHandNavigationPage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/tv_sign_in")
    public WebElement signedInUser;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Close navigation drawer']")
    private WebElement SignInLogo;


    public LeftHandNavigationPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }

    public String getUserName(String testname,String enterActualText){
        String str = MobileExplicitWaitFactories.getText(signedInUser,enterActualText, WaitStrategy.VISIBLE,"verfying userName");
        MobileTestLog.logTestStep(testname,"Verifying the User","Verifying the User");
        return str;
    }

    public MyAccountPage clickOnUserName(String testname){
        MobileExplicitWaitFactories.click(signedInUser,WaitStrategy.CLICKABLE,"user clicked on userName");
        MobileTestLog.logTestStep(testname,"Verifying the User","Verifying the User");
        return new MyAccountPage();
    }
    public WebElement getSignedInUser(String testname)
    {
        MobileTestLog.logTestStep(testname,"Verifying SignIn Logo","Verifying the Signed In Logo");
        return SignInLogo;
    }
}
