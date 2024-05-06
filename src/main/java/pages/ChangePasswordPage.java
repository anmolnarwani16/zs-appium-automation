package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='Change Password']")
    private WebElement changePassword;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_old_password")
    private WebElement enterCurrentPassword;
    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_new_password")
    private WebElement enterNewPassword;
    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_confirm_new_password")
    private WebElement ReEnterNewPassword;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/btn_save_password")
    private WebElement SavePassword;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    private WebElement ChangePasswordSuccessfully;
    @FindBy(id = "android:id/button1")
    private WebElement ok;




    public ChangePasswordPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }
    public ChangePasswordPage performClickOnChangePasswordButton() {
        MobileExplicitWaitFactories.click( changePassword, WaitStrategy.CLICKABLE,"user clicked on change password button");
        return new ChangePasswordPage();
    }
    public ChangePasswordPage enterCurrentPassword(String currPassword){
        MobileExplicitWaitFactories.sendKeys(enterCurrentPassword,currPassword,WaitStrategy.VISIBLE,"currentPassword");
        return this;
    }
    public ChangePasswordPage enterNewPassword(String newPassword){
        MobileExplicitWaitFactories.sendKeys(enterNewPassword,newPassword,WaitStrategy.VISIBLE,"newPassword");
        return this;
    }
    public ChangePasswordPage ReEnterNewPassword(String reEnterNewPassword){
        MobileExplicitWaitFactories.sendKeys(ReEnterNewPassword,reEnterNewPassword,WaitStrategy.VISIBLE,"ReEntered newPassword");
        return this;
    }

    public void performClickOnSavePassword(){
        MobileExplicitWaitFactories.click(SavePassword, WaitStrategy.CLICKABLE,"user clicked on save password");
    }
    public String getPasswordChangeText(String text) throws InterruptedException {


       return MobileExplicitWaitFactories.getText(ChangePasswordSuccessfully,text, WaitStrategy.ELEMENT_TO_HAVE_TEXT,"ChangePasswordSuccessfully");

    }
    public void performClickOnOkButton(){
        MobileExplicitWaitFactories.click(ok, WaitStrategy.CLICKABLE,"user clicked on OK button");
    }





}
