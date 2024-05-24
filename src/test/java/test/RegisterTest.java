package test;

import baseTest.MobileBaseTest;
import com.github.javafaker.Faker;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignInPage;
import reports.MobileTestLog;
import utiles.LoginChecker;
import utiles.MobileDataGenerator;

import java.util.Map;

public final class RegisterTest extends MobileBaseTest {

    private RegisterTest(){

    }
    /**
     * Test to verify Registering of New User.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author:-Anmol Narwani
     */
    @Test(description = "performing new user registration",groups = {"smoke","regression"})
    public void newUserRegisterTest(Map<String, String> data) {
        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(),Constant.REGISTER_USER);
        new HomePage().clickOnAllowLocationAccess(Constant.REGISTER_USER).clickOnAccountButton(Constant.REGISTER_USER);
        new SignInPage().performClickOnRegisterNow(Constant.REGISTER_USER);
        new RegisterPage().enterFirstName(data.get("FirstName"), Constant.REGISTER_USER)
                .enterLastName(data.get("LastName"), Constant.REGISTER_USER)
                .enterDay(data.get("Day"), Constant.REGISTER_USER).enterMonth(data.get("Month"), Constant.REGISTER_USER).enterYear(data.get("Year"), Constant.REGISTER_USER)
                .clickMaleRadioButton(Constant.REGISTER_USER).enterEmail(data.get("Email"), Constant.REGISTER_USER).enterPhoneNo(MobileDataGenerator.getPhoneNo(), Constant.REGISTER_USER)
                .enterPassword(data.get("RegisterPassword"), Constant.REGISTER_USER).clickValidateButton(Constant.REGISTER_USER)
                .clickAlertButton(Constant.REGISTER_USER).enterOtp(data.get("OTP"), Constant.REGISTER_USER)
                .clickSubmitButton(MobileDriverManager.getDriver(), Constant.REGISTER_USER);
        String loggedInUser = new HomePage().clickOnHamburgerIcon(Constant.REGISTER_USER).getUserName(Constant.REGISTER_USER,Constant.REGISTER_USERNAME);
        Assert.assertNotEquals(loggedInUser, "Sign In / Sign Up");
        MobileTestLog.saveExcelFile();
    }
}
