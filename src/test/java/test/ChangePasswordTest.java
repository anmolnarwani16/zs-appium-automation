package test;

import baseTest.MobileBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.HomePage;
import reports.MobileTestLog;
import java.util.Map;
import frameConstatnt.testConstant.Constant;

public class ChangePasswordTest extends MobileBaseTest {


    /**
     * Test to verify whether users are able to change password
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     * Author:-Ashif Alam
     */

    @Test(description = "performing change password test",groups = {"regression"})
    public void changePasswordTest(Map<String, String> data) {
        HomePage homePage = new HomePage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        homePage.clickOnAccountButton(Constant.CHANGE_PASSWORD);
        changePasswordPage.performClickOnChangePasswordButton(Constant.CHANGE_PASSWORD);
        changePasswordPage.enterCurrentPassword(data.get("Password"), Constant.CHANGE_PASSWORD);
        changePasswordPage.enterNewPassword(data.get("NewPassword"), Constant.CHANGE_PASSWORD);
        changePasswordPage.ReEnterNewPassword(data.get("ReEnterCnfPassword"), Constant.CHANGE_PASSWORD);
        changePasswordPage.performClickOnSavePassword(Constant.CHANGE_PASSWORD);
        String passwordChangeText = changePasswordPage.getPasswordChangeText(Constant.PASSWORD_SUCCESSFULLY_CHANGE, Constant.CHANGE_PASSWORD);
        Assert.assertEquals(passwordChangeText, Constant.PASSWORD_SUCCESSFULLY_CHANGE);
        changePasswordPage.performClickOnOkButton(Constant.CHANGE_PASSWORD);
        homePage.clickOnHomeIcon(Constant.CHANGE_PASSWORD);
        MobileTestLog.saveExcelFile();
    }

}
