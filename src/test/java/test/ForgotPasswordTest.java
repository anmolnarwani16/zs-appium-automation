package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.HomePage;
import reports.MobileTestLog;
import frameConstatnt.testConstant.Constant;
import utiles.LoginChecker;
import java.util.Map;

public final class ForgotPasswordTest extends MobileBaseTest {
    private ForgotPasswordTest(){}

    /**
     * Test to verify forgot password
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     *  Author:-Ashif Alam
     */
    @Test(description = "performing reset password test",groups = {"regression"})
    public void forgotPasswordTest(Map<String,String> data){

        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver());
        new HomePage().clickOnAccountButton(Constant.FORGOT_PASSWORD);
        new HomePage().performClickOnResetPasswordButton(Constant.FORGOT_PASSWORD);
        new ForgotPasswordPage().enterPhoneNumber(data.get("UserName"),Constant.OTP_SENT,Constant.FORGOT_PASSWORD);
        new ForgotPasswordPage().enterOtp(data.get("OTP"),Constant.FORGOT_PASSWORD);
        new ForgotPasswordPage().enterNewPassword(data.get("NewPassword"),Constant.FORGOT_PASSWORD);
        new ForgotPasswordPage().enterConfirmPassword(data.get("ReEnterCnfPassword"),Constant.FORGOT_PASSWORD);
        new ForgotPasswordPage().performClickOnSubmit(Constant.FORGOT_PASSWORD);
        new ForgotPasswordPage().getPasswordResetText(Constant.PASSWORD_SUCCESSFULLY_RESET,Constant.FORGOT_PASSWORD);
        new ForgotPasswordPage().performClickOnOkButton(Constant.FORGOT_PASSWORD);
        MobileDriverManager.getDriver().navigate().back();
        MobileTestLog.saveExcelFile();

    }

}