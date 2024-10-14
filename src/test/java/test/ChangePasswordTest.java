package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.HomePage;
import reports.MobileTestLog;
import utiles.LoginChecker;

import java.util.Map;

public final class  ChangePasswordTest extends MobileBaseTest {

    private ChangePasswordTest(){}
    /**
     * Test to verify whether users are able to change password
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     * Author:-Ashif Alam
     */

    @Test(description = "performing change password test",groups = {"regression"})
    public void changePasswordTest(Map<String, String> data) {
        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(),Constant.CHANGE_PASSWORD);
        new HomePage().clickOnAccountButton(Constant.CHANGE_PASSWORD);
        new ChangePasswordPage().performClickOnChangePasswordButton(Constant.CHANGE_PASSWORD);
        new ChangePasswordPage().enterCurrentPassword(data.get("RegisterPassword"), Constant.CHANGE_PASSWORD);
        new ChangePasswordPage().enterNewPassword(data.get("NewPassword"), Constant.CHANGE_PASSWORD);
        new ChangePasswordPage().ReEnterNewPassword(data.get("ReEnterCnfPassword"), Constant.CHANGE_PASSWORD);
        new ChangePasswordPage().performClickOnSavePassword(Constant.CHANGE_PASSWORD);
        String passwordChangeText = new ChangePasswordPage().getPasswordChangeText(Constant.PASSWORD_SUCCESSFULLY_CHANGE, Constant.CHANGE_PASSWORD);
        Assert.assertEquals(passwordChangeText, Constant.PASSWORD_SUCCESSFULLY_CHANGE);
        new ChangePasswordPage().performClickOnOkButton(Constant.CHANGE_PASSWORD);
        new HomePage().clickOnHomeIcon(Constant.CHANGE_PASSWORD);
        MobileTestLog.saveExcelFile();
    }

}
