package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

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
    public ChangePasswordPage performClickOnChangePasswordButton(String testname) {
        MobileExplicitWaitFactories.click( changePassword, WaitStrategy.CLICKABLE,"user clicked on change password button");
        MobileTestLog.logTestStep(testname, "Perform Click On Change Password Button", "User clicked on change password");
        return new ChangePasswordPage();
    }
    public ChangePasswordPage enterCurrentPassword(String currPassword,String testname){
        MobileExplicitWaitFactories.sendKeys(enterCurrentPassword,currPassword,WaitStrategy.VISIBLE,"currentPassword");
        MobileTestLog.logTestStep(testname, "Enter Current Password", "User enter current password");
        return this;
    }
    public ChangePasswordPage enterNewPassword(String newPassword,String testname){
        MobileExplicitWaitFactories.sendKeys(enterNewPassword,newPassword,WaitStrategy.VISIBLE,"newPassword");
        MobileTestLog.logTestStep(testname, "Enter New Password", "User enter new password");
        return this;
    }
    public ChangePasswordPage ReEnterNewPassword(String reEnterNewPassword,String testname){
        MobileExplicitWaitFactories.sendKeys(ReEnterNewPassword,reEnterNewPassword,WaitStrategy.VISIBLE,"ReEntered newPassword");
        MobileTestLog.logTestStep(testname, "Enter New Password", "User  re enter new password");
        return this;
    }

    public void performClickOnSavePassword(String testname){
        MobileExplicitWaitFactories.click(SavePassword, WaitStrategy.CLICKABLE,"user clicked on save password");
        MobileTestLog.logTestStep(testname, "Perform Click On Save Password", "User clicked on save password");
    }
    public String getPasswordChangeText(String text,String testname) {

        MobileTestLog.logTestStep(testname, "Get Password Change Text", "Change Password Successfully");
        return MobileExplicitWaitFactories.getText(ChangePasswordSuccessfully,text, WaitStrategy.ELEMENT_TO_HAVE_TEXT,"ChangePasswordSuccessfully");
    }
    public void performClickOnOkButton(String testname){
        MobileTestLog.logTestStep(testname, "Perform Click On Ok Button", "User clicked on OK button");
        MobileExplicitWaitFactories.click(ok, WaitStrategy.CLICKABLE,"User clicked on ok button");
    }





}
