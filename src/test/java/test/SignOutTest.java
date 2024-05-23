package test;


import frameConstatnt.testConstant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;
import reports.MobileTestLog;
import utiles.MobileLogoutUtility;

import java.util.Map;

public final class SignOutTest {
    private SignOutTest(){

    }
    /**
     * Test to verify Logout Functionality.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author:-Anmol Narwani
     */
    @Test
    public void signOutTest(Map<String,String> data){
        new HomePage().clickOnAccountButton(Constant.SIGN_OUT);
        MobileLogoutUtility.logout(Constant.SIGN_OUT);
        new HomePage().clickOnAccountButton(Constant.SIGN_OUT);
        String signUpHeading = new SignInPage().getHeading(Constant.SIGN_OUT,Constant.SIGNIN_HEADING);
        Assert.assertEquals(signUpHeading,Constant.EXPECTED_SIGNOUT_HEADING);
        MobileTestLog.saveExcelFile();

    }
}
