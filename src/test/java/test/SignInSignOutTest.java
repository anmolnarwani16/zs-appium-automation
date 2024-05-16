package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import reports.MobileTestLog;
import utiles.MobileLoginUtility;
import driver.MobileDriver;
import java.io.IOException;
import java.util.Map;

public class SignInSignOutTest extends MobileBaseTest {

    @Test(description = "performing logIn and logOut test")
    public void signinSignoutTest(Map<String,String> data) throws IOException {
        MobileDriver.initialize(data.get("platformName"),data.get("udid"),data.get("platformVersion"));
        new HomePage().clickOnAllowLocationAccess(Constant.SIGNINSIGNOUT_TEST).clickOnAccountButton(Constant.SIGNINSIGNOUT_TEST);
        MobileLoginUtility.login(data.get("UserName"),data.get("Password"),Constant.SIGNINSIGNOUT_TEST);
        String loggedInUser = new HomePage().clickOnHamburgerIcon(Constant.SIGNINSIGNOUT_TEST).getUserName(Constant.SIGNINSIGNOUT_TEST,Constant.SIGNIN_USERNAME);
        Assert.assertNotEquals(loggedInUser,"Sign In / Sign Up");
        MobileDriverManager.getDriver().navigate().back();
        MobileTestLog.saveExcelFile();

    }
}
