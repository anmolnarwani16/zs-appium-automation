package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
	private WebElement userNameTextField;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
	private WebElement passwordTextField;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
	private WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(MobileDriverManager.getDriver(), this);
	}

	public LoginPage getUserNameTextField(String userName) {

		MobileExplicitWaitFactories.sendKeys(userNameTextField, userName, WaitStrategy.PRESENCE,
				" User entred " + userName + " as usename in text field");
		return this;
	}

	public LoginPage getPasswordTextField(String password) {
		MobileExplicitWaitFactories.sendKeys(passwordTextField, password, WaitStrategy.PRESENCE,
				" User entred " + password + " as password in text field");
		return this;
	}

	public WebElement getLoginButton() {
		MobileExplicitWaitFactories.click(loginButton, WaitStrategy.CLICKABLE, " user clicked on login button");
		return loginButton;
	}

}
