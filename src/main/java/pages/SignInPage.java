package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {

	@FindBy(id="com.zopsmart.stg.scarlet:id/rlClickConsumer")
	private WebElement countryCodeDropdown;

	@FindBy(id="com.zopsmart.stg.scarlet:id/et_username")
	private WebElement userNameTxtField;

	@FindBy(id="com.zopsmart.stg.scarlet:id/et_password")
	private WebElement passwordTxtField;

	@FindBy(id="com.zopsmart.stg.scarlet:id/button3")
	private WebElement loginButton;

	public SignInPage(){
		PageFactory.initElements(MobileDriverManager.getDriver(),this);
	}

	public SignInPage getCountryCodeDropdown() {
		MobileExplicitWaitFactories.click(countryCodeDropdown,WaitStrategy.CLICKABLE ," user clicked on the country code dropdown");
		return this;
	}

	public SignInPage enterUserNameInTxtField(String enterMobileNo) {
		MobileExplicitWaitFactories.sendKeys(userNameTxtField,enterMobileNo,WaitStrategy.VISIBLE ," user entered mobile no in username text field");
		return this;
	}

	public SignInPage enterPasswordInTxtField(String enterPassword) {
		MobileExplicitWaitFactories.sendKeys(passwordTxtField,enterPassword,WaitStrategy.VISIBLE ," user entered enterPassword in password text field");

		return this;
	}

	public HomePage clickOnLoginButton() {
		MobileExplicitWaitFactories.click(loginButton,WaitStrategy.CLICKABLE," user clicke don the login button");
		return new HomePage();
	}
}

