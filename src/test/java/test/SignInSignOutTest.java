package test;

import baseTest.MobileBaseTest;
import frameConstatnt.testConstant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LeftHandNavigationPage;
import pages.SignInPage;
import reports.MobileTestLog;
import utiles.MobileLoginUtility;
import utiles.MobileLogoutUtility;

import java.util.Map;

public class SignInSignOutTest extends MobileBaseTest {

    @Test(description = "performing logIn and logOut test")
    public void signinSignoutTest(Map<String,String> data){
        new HomePage().clickOnAllowLocationAccess(Constant.SIGNINSIGNOUT_TEST).clickOnAccountButton(Constant.SIGNINSIGNOUT_TEST);
        MobileLoginUtility.login(data.get("UserName"),data.get("Password"),Constant.SIGNINSIGNOUT_TEST);
        String loggedInUser = new HomePage().clickOnHamburgerIcon(Constant.SIGNINSIGNOUT_TEST).getUserName(Constant.SIGNINSIGNOUT_TEST,Constant.SIGNIN_USERNAME);
        Assert.assertNotEquals(loggedInUser,"Sign In / Sign Up");
        new LeftHandNavigationPage().clickOnUserName(Constant.SIGNINSIGNOUT_TEST);
        MobileLogoutUtility.logout(Constant.SIGNINSIGNOUT_TEST);
        new HomePage().clickOnAccountButton(Constant.SIGNINSIGNOUT_TEST);
        String signUpHeading = new SignInPage().getHeading(Constant.SIGNINSIGNOUT_TEST,Constant.SIGNIN_HEADING);
        Assert.assertEquals(signUpHeading,"Signup / Login");
        // Save test steps to Excel file
        MobileTestLog.saveExcelFile();

    }
}
