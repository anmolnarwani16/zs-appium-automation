package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LeftHandNavigationPage;
import pages.RegisterPage;
import pages.SignInPage;
import utiles.MobileLoginUtility;
import utiles.MobileLogoutUtility;

import java.util.Map;

public class RegisterTest extends MobileBaseTest {


    @Test(description = "performing new user registration")
    public void newUserRegisterTest(Map<String, String> data) {
        new HomePage().clickOnAllowLocationAccess("User Registration").clickOnAccountButton("User Registration");
        new SignInPage().performClickOnRegisterNow();
//        new RegisterPage().enterFirstName(data.get("FirstName"))
//                .enterLastName(data.get("LastName"))
//                .enterDay(data.get("Day")).enterMonth(data.get("Month")).enterYear(data.get("Year"))
//                .clickMaleRadioButton().enterPhoneNo(data.get("PhoneNo")).enterPassword(data.get("Password"))
//                .clickAlertButton().enterOtp(data.get("OTP")).clickSubmitButton();

        new RegisterPage().enterFirstName("sam")
                .enterLastName("xyz")
                .enterDay("11").enterMonth("12").enterYear("1990")
                .clickMaleRadioButton().enterEmail("sample@gmail.com").enterPhoneNo("5555555136").enterPassword("123456az").clickValidateButton()
                .clickAlertButton().enterOtp("1234").clickSubmitButton(MobileDriverManager.getDriver());


    }
}
