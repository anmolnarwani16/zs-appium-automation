package test;
import baseTest.MobileBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.HomePage;
import utiles.MobileLoginUtility;
import java.util.Map;

public class ChangePasswordTest extends MobileBaseTest {

    @Test(description = "performing change password test")
    public void changePasswordTest(Map<String,String> data) throws InterruptedException {
        HomePage homePage = new HomePage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        homePage.clickOnAllowLocationAccess().clickOnAccountButton();
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"));
        homePage.clickOnAccountButton();
        changePasswordPage.performClickOnChangePasswordButton();
        changePasswordPage.enterCurrentPassword(data.get("Password"));
        changePasswordPage.enterNewPassword(data.get("NewPassword"));
        changePasswordPage.ReEnterNewPassword(data.get("ReEnterCnfPassword"));
        changePasswordPage.performClickOnSavePassword();
        String passwordChangeText = changePasswordPage.getPasswordChangeText("Password successfully changed.");
        Assert.assertEquals(passwordChangeText, "Password successfully changed.");
        changePasswordPage.performClickOnOkButton();
    }

}
