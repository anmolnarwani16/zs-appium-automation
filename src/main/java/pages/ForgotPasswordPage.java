package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.TestLogger;

public class ForgotPasswordPage {
    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_phone_no']")
    private WebElement phoneNo;


    @FindBy(xpath = "//android.widget.Button[@resource-id='com.zopsmart.stg.scarlet:id/btn_validate_phone']")
    private WebElement validate;

    //android.widget.TextView[@resource-id="android:id/message"]
    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    private WebElement OtpSent;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_otp']")
    private WebElement enterOtp;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement ok;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_password']")
    private WebElement enterNewPassword;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_confirm_password']")
    private WebElement enterConfirmPassword;
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.zopsmart.stg.scarlet:id/button3']")
    private WebElement submitButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    private WebElement passwordReset;
    public ForgotPasswordPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }
    public ForgotPasswordPage enterPhoneNumber(String phoneNumber,String enterActualText,String testname){
        MobileExplicitWaitFactories.sendKeys(phoneNo,phoneNumber,WaitStrategy.VISIBLE,"PhoneNumber");
        MobileExplicitWaitFactories.click( validate, WaitStrategy.CLICKABLE,"user clicked on validate phone number");
        MobileExplicitWaitFactories.getText(OtpSent,enterActualText, WaitStrategy.ELEMENT_TO_HAVE_TEXT,"OTP sent to your number");
        MobileExplicitWaitFactories.click( ok, WaitStrategy.CLICKABLE,"user clicked on Ok button");
        TestLogger.logTestStep(testname, "Enter Phone Number", "User entered valid phone number");
        return this;
    }
    public ForgotPasswordPage enterOtp(String otp,String testname){
        MobileExplicitWaitFactories.sendKeys(enterOtp,otp,WaitStrategy.VISIBLE,"Otp");
        TestLogger.logTestStep(testname, "Enter Otp", "User entered otp");
        return this;
    }
    public ForgotPasswordPage enterNewPassword(String newPassword,String testname){
        MobileExplicitWaitFactories.sendKeys(enterNewPassword,newPassword,WaitStrategy.VISIBLE,"currentPassword");
        TestLogger.logTestStep(testname, "Enter New Password", "User entered new password");
        return this;
    }
    public ForgotPasswordPage enterConfirmPassword(String confirmPassword,String testname){
        MobileExplicitWaitFactories.sendKeys(enterConfirmPassword,confirmPassword,WaitStrategy.VISIBLE,"currentPassword");
        TestLogger.logTestStep(testname, "Enter Confirm Password", "User entered current password");
        return this;
    }
    public void performClickOnSubmit(String testname){
        MobileExplicitWaitFactories.click(submitButton, WaitStrategy.CLICKABLE,"user clicked on submit button");
        TestLogger.logTestStep(testname, "Perform Click On Submit", "User clicked on submit button");
    }
    public String getPasswordResetText(String enterActualText,String testname)  {
        TestLogger.logTestStep(testname, "Get Password Reset Text", "password reset successfully");
        return MobileExplicitWaitFactories.getText(passwordReset,enterActualText, WaitStrategy.ELEMENT_TO_HAVE_TEXT,"PasswordResetSuccessfully");

    }
    public void performClickOnOkButton(String testname){
        TestLogger.logTestStep(testname, "Perform Click On Ok Button", "user clicked on ok button");
        MobileExplicitWaitFactories.click(ok, WaitStrategy.CLICKABLE,"user clicked on ok button");
    }






}
