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
import java.util.Map;

public class MyAccountTest  extends MobileBaseTest {

    /**
     * Test to verify visibility of all the text in my account
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     *  Author:-Ashif Alam
     */
    @Test(description = "performing my account test for  text visibility",groups = {"regression"})
    public void myAccountTestForTextVisibility(Map<String, String> data) {

        HomePage homePage = new HomePage();
        MyAccountPage myAccount = new MyAccountPage();
        homePage.clickOnAccountButton(Constant.MY_ACCOUNT);
        String welcomeText= myAccount.getElementTextForWelcome(Constant.WELCOME,Constant.MY_ACCOUNT);
        Assert.assertEquals(welcomeText, Constant.WELCOME);
        myAccount.verifyElementTexts(Constant.MY_ACCOUNT);
        homePage.clickOnHomeIcon(Constant.MY_ACCOUNT);
        MobileTestLog.saveExcelFile();

    }
    /**
     * Test to verify each page in my account
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     *  Author:-Ashif Alam
     */

    @Test(description = "performing my account test for each page",groups = {"regression"})
    public void myAccountTestForPages(Map<String, String> data){

        HomePage homePage = new HomePage();
        MyAccountPage myAccount = new MyAccountPage();
        SavedAddressPage savedAddressPage = new SavedAddressPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        homePage.clickOnAccountButton(Constant.MY_ACCOUNT);
        savedAddressPage.performClickOnSavedAddress(Constant.SAVED_ADDRESS);
        savedAddressPage.performClickOnAddNewAddress(Constant.SAVED_ADDRESS);
        myAccount.validateSavedAddress(Constant.SAVED_ADDRESS_TEXT,Constant.MY_ACCOUNT);
        changePasswordPage.performClickOnChangePasswordButton(Constant.CHANGE_PASSWORD);
        myAccount.validateChangePassword(Constant.SAVE_PASSWORD,Constant.MY_ACCOUNT);
        myAccount.validateSavedCard(Constant.CHECK_CARD,Constant.MY_ACCOUNT);
        myAccount.validateMyWallet(Constant.BALANCE,Constant.MY_ACCOUNT);
        myAccount.myProducts(Constant.DELIVERING,Constant.MY_ACCOUNT);
        myAccount.myOrders(Constant.MY_ACCOUNT);
        myAccount.changeLanguage(Constant.LANGUAGE_PREFERENCE,Constant.MY_ACCOUNT);
        myAccount.contactUs(Constant.CONTACT_TEXT,Constant.MY_ACCOUNT);
        MobileDriverManager.getDriver().navigate().back();
        homePage.clickOnHomeIcon(Constant.MY_ACCOUNT);
        MobileTestLog.saveExcelFile();

    }
}
