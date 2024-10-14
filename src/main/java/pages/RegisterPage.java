package pages;

import com.google.common.collect.ImmutableMap;
import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;
import utiles.MobileScrollDownUtility;

import java.time.Duration;
import java.util.Collections;

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

    public RegisterPage() {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    public RegisterPage enterFirstName(String firstName, String testname) {
        MobileExplicitWaitFactories.sendKeys(firstNameField, firstName, WaitStrategy.VISIBLE, "user entered first name");
        MobileTestLog.logTestStep(testname, "Enter the first name", "User entered first name");
        return new RegisterPage();
    }

    public RegisterPage enterLastName(String lastName, String testname) {
        MobileExplicitWaitFactories.sendKeys(lastNameField, lastName, WaitStrategy.VISIBLE, "user entered last name");
        MobileTestLog.logTestStep(testname, "Enter the last name", "User entered last name");
        return new RegisterPage();
    }

    public RegisterPage enterDay(String day, String testname) {
        MobileExplicitWaitFactories.sendKeys(dateTextField, day, WaitStrategy.VISIBLE, "user entered day");
        MobileTestLog.logTestStep(testname, "Enter day", "User entered day");
        return new RegisterPage();
    }

    public RegisterPage enterMonth(String month, String testname) {
        MobileExplicitWaitFactories.sendKeys(monthTextField, month, WaitStrategy.VISIBLE, "user entered month");
        MobileTestLog.logTestStep(testname, "Enter month", "User entered month");
        return new RegisterPage();
    }

    public RegisterPage enterYear(String year, String testname) {
        MobileExplicitWaitFactories.sendKeys(yearTextField, year, WaitStrategy.VISIBLE, "user entered year");
        MobileTestLog.logTestStep(testname, "Enter year", "User entered year");
        return new RegisterPage();
    }

    public RegisterPage clickMaleRadioButton(String testname) {
        MobileExplicitWaitFactories.click(maleRadioButton, WaitStrategy.CLICKABLE, "user clicked on male radio button");
        MobileTestLog.logTestStep(testname, "Select gender", "User entered gender");
        return new RegisterPage();
    }

    public RegisterPage enterEmail(String email, String testname) {
        MobileExplicitWaitFactories.sendKeys(emailTextField, email, WaitStrategy.VISIBLE, "user entered email");
        MobileTestLog.logTestStep(testname, "Enter the email", "User entered the email");
        return new RegisterPage();
    }

    public RegisterPage enterPhoneNo(String phoneNo, String testname) {
        MobileExplicitWaitFactories.sendKeys(phoneNoTextField, phoneNo, WaitStrategy.VISIBLE, "user entered phoneNo");
        MobileTestLog.logTestStep(testname, "Enter the phone number", "User entered the phone number");
        return new RegisterPage();
    }

    public RegisterPage enterPassword(String password, String testname) {
        MobileExplicitWaitFactories.sendKeys(passwordTextField, password, WaitStrategy.VISIBLE, "user entered password");
        MobileTestLog.logTestStep(testname, "Enter the password", "User entered password");
        return new RegisterPage();
    }

    public RegisterPage clickSubmitButton(WebDriver driver, String testname) {
        MobileScrollDownUtility.scrollDown(driver);
        MobileExplicitWaitFactories.click(submitButton, WaitStrategy.CLICKABLE, "user clicked on submit button");
        MobileTestLog.logTestStep(testname, "Click on Submit Button", "User clicked on submit button");
        return new RegisterPage();
    }

    public RegisterPage clickValidateButton(String testname) {
        MobileExplicitWaitFactories.click(validateButton, WaitStrategy.CLICKABLE, "user clicked on validate button");
        MobileTestLog.logTestStep(testname, "Clicked on validate button", "User clicked on validate button");
        return new RegisterPage();
    }

    public RegisterPage clickAlertButton(String testname) {
        MobileExplicitWaitFactories.click(alertButton, WaitStrategy.CLICKABLE, "user clicked on OK button");
        MobileTestLog.logTestStep(testname, "Clicked on OK button", "User clicked on OK button");
        return new RegisterPage();
    }

    public RegisterPage enterOtp(String otp, String testname) {
        MobileExplicitWaitFactories.sendKeys(otpField, otp, WaitStrategy.VISIBLE, "user entered otp");
        MobileTestLog.logTestStep(testname, "Enter otp", "User entered otp");
        return new RegisterPage();
    }
}
