package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public class LeftHandNavigationPage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/tv_sign_in")
    private WebElement signedInUser;

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
}
