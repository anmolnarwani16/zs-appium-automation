package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignInPage;
import java.util.Map;

public class RegisterTest extends MobileBaseTest {


    @Test(description = "performing new user registration")
    public void newUserRegisterTest(Map<String, String> data) {
        new HomePage().clickOnAllowLocationAccess().clickOnAccountButton();
        new SignInPage().performClickOnRegisterNow();
        new RegisterPage().enterFirstName(data.get("FirstName"))
                .enterLastName(data.get("LastName"))
                .enterDay(data.get("Day")).enterMonth(data.get("Month")).enterYear(data.get("Year"))
                .clickMaleRadioButton().enterEmail(data.get("Email")).enterPhoneNo(data.get("PhoneNo"))
                .enterPassword(data.get("RegisterPassword")).clickValidateButton()
                .clickAlertButton().enterOtp(data.get("OTP"))
                .clickSubmitButton(MobileDriverManager.getDriver());
        String loggedInUser = new HomePage().clickOnHamburgerIcon().getUserName();
        Assert.assertNotEquals(loggedInUser, "Sign In / Sign Up");
    }
}
