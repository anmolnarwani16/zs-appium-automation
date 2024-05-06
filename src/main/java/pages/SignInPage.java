package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public HomePage performClickOnLoginButton(){
        MobileExplicitWaitFactories.click(loginButton, WaitStrategy.CLICKABLE,"user clicked on login button");
        return new HomePage();
    }

    public SignInPage enterUserName(String userName){
        MobileExplicitWaitFactories.sendKeys(userNameField,userName,WaitStrategy.VISIBLE,"user entered userName");
        return this;
    }

    public SignInPage enterPassword(String password){
        MobileExplicitWaitFactories.sendKeys(passwordField,password,WaitStrategy.VISIBLE,"user entered password");
        return this;
    }

    public String getHeading(String actualText){
        String str = MobileExplicitWaitFactories.getText(signUpHeader,actualText, WaitStrategy.VISIBLE,"verfying Heading");
        return str;
    }

    public RegisterPage performClickOnRegisterNow(){
        MobileExplicitWaitFactories.click(registerNow, WaitStrategy.CLICKABLE,"user clicked on register button");
        return new RegisterPage();
    }
}
