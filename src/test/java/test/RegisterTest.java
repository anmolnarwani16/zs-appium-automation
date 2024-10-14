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

    public static String phoneNumber;

    private RegisterTest(){

    }
    /**
     * Test to verify Registering of New User.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author:-Anmol Narwani
     */
    @Test(description = "performing new user registration",groups = {"smoke","regression"})
    public void newUserRegisterTest(Map<String, String> data) throws InterruptedException {
        //new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(),Constant.REGISTER_USER);
        //new HomePage().clickOnAllowLocationAccess(Constant.REGISTER_USER).clickOnAccountButton(Constant.REGISTER_USER);
        phoneNumber = MobileDataGenerator.getPhoneNo();
        new HomePage().clickOnAllowLocationAccessMap(Constant.REGISTER_USER);
        new SignInPage().performClickOnRegisterNow(Constant.REGISTER_USER);
        new RegisterPage().enterFirstName(data.get("FirstName"), Constant.REGISTER_USER)
                .enterLastName(data.get("LastName"), Constant.REGISTER_USER)
                .enterDay(data.get("Day"), Constant.REGISTER_USER).enterMonth(data.get("Month"), Constant.REGISTER_USER).enterYear(data.get("Year"), Constant.REGISTER_USER)
                .clickMaleRadioButton(Constant.REGISTER_USER).enterEmail("sample"+MobileDataGenerator.getRandomNumber()+"@gmail.com", Constant.REGISTER_USER).enterPhoneNo(phoneNumber, Constant.REGISTER_USER)
                .enterPassword(data.get("RegisterPassword"), Constant.REGISTER_USER).clickValidateButton(Constant.REGISTER_USER)
                .clickAlertButton(Constant.REGISTER_USER).enterOtp(data.get("OTP"), Constant.REGISTER_USER);
        Thread.sleep(5000);
        new RegisterPage().clickSubmitButton(MobileDriverManager.getDriver(), Constant.REGISTER_USER);
        Thread.sleep(7000);
        String loggedInUser = new HomePage().clickOnHamburgerIcon(Constant.REGISTER_USER).getUserName(Constant.REGISTER_USER,Constant.REGISTER_USERNAME);
        Assert.assertNotEquals(loggedInUser, "Sign In / Sign Up");
        Thread.sleep(2000);
        MobileTestLog.saveExcelFile();
        new HomePage().clickBackToHome(Constant.REGISTER_USER);
        new HomePage().clickBackToHome(Constant.REGISTER_USER);

    }
}
