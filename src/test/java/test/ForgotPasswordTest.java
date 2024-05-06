package test;

import baseTest.MobileBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.ForgotPasswordPage;
import pages.HomePage;
import utiles.MobileLoginUtility;

import java.util.Map;

public class ForgotPasswordTest extends MobileBaseTest {
    @Test(description = "performing reset password test")
    public void forgotPasswordTest(Map<String,String> data) throws InterruptedException {
        HomePage homePage = new HomePage();
        ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage();
        homePage.clickOnAllowLocationAccess().clickOnAccountButton();
        homePage.performClickOnResetPasswordButton();
        forgotPasswordPage.enterPhoneNumber(data.get("UserName"),"OTP sent to your number");
        forgotPasswordPage.enterOtp(data.get("OTP"));
        forgotPasswordPage.enterNewPassword(data.get("NewPassword"));
        forgotPasswordPage.enterConfirmPassword(data.get("ReEnterCnfPassword"));
        forgotPasswordPage.performClickOnSubmit();
        forgotPasswordPage.getPasswordResetText("Password successfully reset.");
        forgotPasswordPage.performClickOnOkButton();

    }

}
