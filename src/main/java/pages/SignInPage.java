package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public class SignInPage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/tv_login_instr")
    private WebElement signUpHeader;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_username")
    private WebElement userNameField;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_password")
    private WebElement passwordField;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/button3")
    private WebElement loginButton;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/tv_register_now")
    private WebElement registerNow;

    public SignInPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }

    public HomePage performClickOnLoginButton(String testname){
        MobileExplicitWaitFactories.click(loginButton, WaitStrategy.CLICKABLE,"User clicked on login button");
        MobileTestLog.logTestStep(testname,"Login Button Clicked","User clicked on login button");
        return new HomePage();
    }

    public SignInPage enterUserName(String userName,String testname){
        MobileExplicitWaitFactories.sendKeys(userNameField,userName,WaitStrategy.VISIBLE,"User entered userName");
        MobileTestLog.logTestStep(testname,"Username Entered","User entered UserName");
        return this;
    }

    public SignInPage enterPassword(String password,String testname){
        MobileExplicitWaitFactories.sendKeys(passwordField,password,WaitStrategy.VISIBLE,"User entered password");
        MobileTestLog.logTestStep(testname,"Password Entered","User entered Password");
        return this;
    }

    public String getHeading(String testname,String actualText){
        String str = MobileExplicitWaitFactories.getText(signUpHeader,actualText, WaitStrategy.VISIBLE,"Verfying Heading");
        MobileTestLog.logTestStep(testname,"Verfying Heading","Verfying the SignIn/SignUp Heading");
        return str;
    }

    public RegisterPage performClickOnRegisterNow(String testname){
        MobileExplicitWaitFactories.click(registerNow, WaitStrategy.CLICKABLE,"User clicked on register button");
        MobileTestLog.logTestStep(testname,"Register Button Clicked","User clicked on register button");
        return new RegisterPage();
    }
}
