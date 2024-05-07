package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignInPage;
import reports.MobileTestLog;

import java.util.Map;

public class RegisterTest extends MobileBaseTest {

    @Test(description = "performing new user registration")
    public void newUserRegisterTest(Map<String, String> data) {
        new HomePage().clickOnAllowLocationAccess(Constant.REGISTER_USER).clickOnAccountButton(Constant.REGISTER_USER);
        new SignInPage().performClickOnRegisterNow(Constant.REGISTER_USER);
        new RegisterPage().enterFirstName(data.get("FirstName"), Constant.REGISTER_USER)
                .enterLastName(data.get("LastName"), Constant.REGISTER_USER)
                .enterDay(data.get("Day"), Constant.REGISTER_USER).enterMonth(data.get("Month"), Constant.REGISTER_USER).enterYear(data.get("Year"), Constant.REGISTER_USER)
                .clickMaleRadioButton(Constant.REGISTER_USER).enterEmail(data.get("Email"), Constant.REGISTER_USER).enterPhoneNo(data.get("PhoneNo"), Constant.REGISTER_USER)
                .enterPassword(data.get("RegisterPassword"), Constant.REGISTER_USER).clickValidateButton(Constant.REGISTER_USER)
                .clickAlertButton(Constant.REGISTER_USER).enterOtp(data.get("OTP"), Constant.REGISTER_USER)
                .clickSubmitButton(MobileDriverManager.getDriver(), Constant.REGISTER_USER);
        String loggedInUser = new HomePage().clickOnHamburgerIcon(Constant.REGISTER_USER).getUserName(Constant.REGISTER_USER);
        Assert.assertNotEquals(loggedInUser, "Sign In / Sign Up");
        MobileTestLog.saveExcelFile();
    }
}
