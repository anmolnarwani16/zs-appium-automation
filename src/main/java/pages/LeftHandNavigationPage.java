package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftHandNavigationPage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/tv_sign_in")
    private WebElement signedInUser;

    public LeftHandNavigationPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }

    public String getUserName(String enterActualText){
        String str = MobileExplicitWaitFactories.getText(signedInUser, enterActualText,WaitStrategy.VISIBLE,"verfying userName");
        return str;
    }

    public MyAccountPage clickOnUserName(){
        MobileExplicitWaitFactories.click(signedInUser,WaitStrategy.CLICKABLE,"user clicked on userName");
        return new MyAccountPage();
    }
}
