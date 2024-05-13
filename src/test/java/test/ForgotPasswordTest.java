package test;

import baseTest.MobileBaseTest;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.HomePage;
import reports.MobileTestLog;
import frameConstatnt.testConstant.Constant;
import java.util.Map;

public class ForgotPasswordTest extends MobileBaseTest {
    @Test(description = "performing reset password test")
    public void forgotPasswordTest(Map<String,String> data){
        HomePage homePage = new HomePage();
        ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage();
        homePage.clickOnAllowLocationAccess(Constant.FORGOT_PASSWORD).clickOnAccountButton(Constant.FORGOT_PASSWORD);
        homePage.performClickOnResetPasswordButton(Constant.FORGOT_PASSWORD);
        forgotPasswordPage.enterPhoneNumber(data.get("UserName"),Constant.OTP_SENT,Constant.FORGOT_PASSWORD);
        forgotPasswordPage.enterOtp(data.get("OTP"),Constant.FORGOT_PASSWORD);
        forgotPasswordPage.enterNewPassword(data.get("NewPassword"),Constant.FORGOT_PASSWORD);
        forgotPasswordPage.enterConfirmPassword(data.get("ReEnterCnfPassword"),Constant.FORGOT_PASSWORD);
        forgotPasswordPage.performClickOnSubmit(Constant.FORGOT_PASSWORD);
        forgotPasswordPage.getPasswordResetText(Constant.PASSWORD_SUCCESSFULLY_RESET,Constant.FORGOT_PASSWORD);
        forgotPasswordPage.performClickOnOkButton(Constant.FORGOT_PASSWORD);
        MobileTestLog.saveExcelFile();

    }

}
