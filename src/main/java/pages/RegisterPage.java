package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utiles.MobileActionClassUtils;

public class RegisterPage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_username")
    private WebElement firstNameField;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_last_name")
    private WebElement lastNameField;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/dayTextField")
    private WebElement dateTextField;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/monthTextField")
    private WebElement monthTextField;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/yearTextField")
    private WebElement yearTextField;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/maleRadioButton")
    private WebElement maleRadioButton;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/femaleRadioButton")
    private WebElement femaleRadioButton;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_email")
    private WebElement emailTextField;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_phone_no")
    private WebElement phoneNoTextField;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_password")
    private WebElement passwordTextField;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/btn_validate_phone")
    private WebElement validateButton;

    @FindBy(id = "android:id/button1")
    private WebElement alertButton;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/button3")
    private WebElement submitButton;

    @FindBy(id = "com.zopsmart.stg.scarlet:id/et_otp")
    private WebElement otpField;

    public RegisterPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }

    public RegisterPage enterFirstName(String firstName){
        MobileExplicitWaitFactories.sendKeys(firstNameField,firstName,WaitStrategy.VISIBLE,"user entered first name");
        return new RegisterPage();
    }

    public RegisterPage enterLastName(String lastName){
        MobileExplicitWaitFactories.sendKeys(lastNameField,lastName,WaitStrategy.VISIBLE,"user entered last name");
        return new RegisterPage();
    }

    public RegisterPage enterDay(String day){
        MobileExplicitWaitFactories.sendKeys(dateTextField,day,WaitStrategy.VISIBLE,"user entered day");
        return new RegisterPage();
    }

    public RegisterPage enterMonth(String month){
        MobileExplicitWaitFactories.sendKeys(monthTextField,month,WaitStrategy.VISIBLE,"user entered month");
        return new RegisterPage();
    }

    public RegisterPage enterYear(String year){
        MobileExplicitWaitFactories.sendKeys(yearTextField,year,WaitStrategy.VISIBLE,"user entered year");
        return new RegisterPage();
    }

    public RegisterPage clickMaleRadioButton(){
        MobileExplicitWaitFactories.click(maleRadioButton,WaitStrategy.CLICKABLE,"user clicked on male radio button");
        return new RegisterPage();
    }

    public RegisterPage enterEmail(String email){
        MobileExplicitWaitFactories.sendKeys(emailTextField,email,WaitStrategy.VISIBLE,"user entered email");
        return new RegisterPage();
    }

    public RegisterPage enterPhoneNo(String phoneNo){
        MobileExplicitWaitFactories.sendKeys(phoneNoTextField,phoneNo,WaitStrategy.VISIBLE,"user entered phoneNo");
        return new RegisterPage();
    }

    public RegisterPage enterPassword(String password){
        MobileExplicitWaitFactories.sendKeys(passwordTextField,password,WaitStrategy.VISIBLE,"user entered password");
        return new RegisterPage();
    }

    public RegisterPage clickSubmitButton(WebDriver driver){
        //MobileActionClassUtils.scrollDown(driver ,submitButton);
        scrollDown(driver);
        MobileExplicitWaitFactories.click(submitButton,WaitStrategy.CLICKABLE,"user clicked on submit button");
        return new RegisterPage();
    }
    private static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by a certain pixel value. Adjust the value as needed.
        js.executeScript("window.scrollBy(0, 500)");
    }

    public RegisterPage clickValidateButton(){
        MobileExplicitWaitFactories.click(validateButton,WaitStrategy.CLICKABLE,"user clicked on validate button");
        return new RegisterPage();
    }

    public RegisterPage clickAlertButton(){
        MobileExplicitWaitFactories.click(alertButton,WaitStrategy.CLICKABLE,"user clicked on OK button");
        return new RegisterPage();
    }

    public RegisterPage enterOtp(String otp){
        MobileExplicitWaitFactories.sendKeys(otpField,otp,WaitStrategy.VISIBLE,"user entered otp");
        return new RegisterPage();
    }
}
