package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SavedAddressPage;
import reports.MobileTestLog;
import utiles.LoginChecker;

import java.util.Map;

public final class MyAccountTest extends MobileBaseTest {
    private MyAccountTest(){}

    /**
     * Test to verify visibility of all the text in my account
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     *             Author:-Ashif Alam
     */
    @Test(description = "performing my account test for  text visibility", groups = {"regression"})
    public void myAccountTestForTextVisibility(Map<String, String> data) {

        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver());
        new HomePage().clickOnAccountButton(Constant.MY_ACCOUNT);
        String welcomeText = new MyAccountPage().getElementTextForWelcome(Constant.WELCOME, Constant.MY_ACCOUNT);
        Assert.assertEquals(welcomeText, Constant.WELCOME);
        new MyAccountPage().verifyElementTexts(Constant.MY_ACCOUNT);
        new HomePage().clickOnHomeIcon(Constant.MY_ACCOUNT);
        MobileTestLog.saveExcelFile();

    }

    /**
     * Test to verify each page in my account
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     *             Author:-Ashif Alam
     */

    @Test(description = "performing my account test for each page", groups = {"regression"})
    public void myAccountTestForPages(Map<String, String> data) {

        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver());
        new HomePage().clickOnAccountButton(Constant.MY_ACCOUNT);
        new SavedAddressPage().performClickOnSavedAddress(Constant.SAVED_ADDRESS);
        new SavedAddressPage().performClickOnAddNewAddress(Constant.SAVED_ADDRESS);
        new MyAccountPage().validateSavedAddress(Constant.SAVED_ADDRESS_TEXT, Constant.MY_ACCOUNT);
        new ChangePasswordPage().performClickOnChangePasswordButton(Constant.CHANGE_PASSWORD);
        new MyAccountPage().validateChangePassword(Constant.SAVE_PASSWORD, Constant.MY_ACCOUNT);
        new MyAccountPage().validateSavedCard(Constant.CHECK_CARD, Constant.MY_ACCOUNT);
        new MyAccountPage().validateMyWallet(Constant.BALANCE, Constant.MY_ACCOUNT);
        new MyAccountPage().myProducts(Constant.DELIVERING, Constant.MY_ACCOUNT);
        new MyAccountPage().myOrders(Constant.MY_ACCOUNT);
        new MyAccountPage().changeLanguage(Constant.LANGUAGE_PREFERENCE, Constant.MY_ACCOUNT);
        new MyAccountPage().contactUs(Constant.CONTACT_TEXT, Constant.MY_ACCOUNT);
        MobileDriverManager.getDriver().navigate().back();
        new HomePage().clickOnHomeIcon(Constant.MY_ACCOUNT);
        MobileTestLog.saveExcelFile();

    }
}
