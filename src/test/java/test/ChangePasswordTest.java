package test;
import baseTest.MobileBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.HomePage;
import reports.MobileTestLog;
import utiles.MobileLoginUtility;
import java.util.Map;
import frameConstatnt.testConstant.Constant;

public class ChangePasswordTest extends MobileBaseTest {

    @Test(description = "performing change password test")
    public void changePasswordTest(Map<String,String> data){
        HomePage homePage = new HomePage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        homePage.clickOnAllowLocationAccess(Constant.CHANGE_PASSWORD).clickOnAccountButton(Constant.CHANGE_PASSWORD);
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"),Constant.CHANGE_PASSWORD);
        homePage.clickOnAccountButton(Constant.CHANGE_PASSWORD);
        changePasswordPage.performClickOnChangePasswordButton(Constant.CHANGE_PASSWORD);
        changePasswordPage.enterCurrentPassword(data.get("Password"),Constant.CHANGE_PASSWORD);
        changePasswordPage.enterNewPassword(data.get("NewPassword"),Constant.CHANGE_PASSWORD);
        changePasswordPage.ReEnterNewPassword(data.get("ReEnterCnfPassword"),Constant.CHANGE_PASSWORD);
        changePasswordPage.performClickOnSavePassword(Constant.CHANGE_PASSWORD);
        String passwordChangeText = changePasswordPage.getPasswordChangeText("Password successfully changed",Constant.CHANGE_PASSWORD);
        Assert.assertEquals(passwordChangeText, "Password successfully changed");
        changePasswordPage.performClickOnOkButton(Constant.CHANGE_PASSWORD);
        MobileTestLog.saveExcelFile();
    }

}
