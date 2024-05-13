package test;

import baseTest.MobileBaseTest;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import reports.MobileTestLog;
import utiles.MobileAssertionUtility;
import utiles.MobileLoginUtility;

import java.util.Map;

public class MyAccountTest  extends MobileBaseTest {
    @Test(description = "performing my account text visibility test")
    public void myAccountTestForTextVisibility(Map<String, String> data) {

        HomePage homePage = new HomePage();
        MyAccountPage myAccount = new MyAccountPage();
        homePage.clickOnAllowLocationAccess(Constant.MY_ACCOUNT);
        homePage.clickOnAccountButton(Constant.MY_ACCOUNT);
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"), Constant.MY_ACCOUNT);
        homePage.clickOnAccountButton(Constant.MY_ACCOUNT);
        String welcomeText= myAccount.getElementTextForWelcome(Constant.WELCOME,Constant.MY_ACCOUNT);
        Assert.assertEquals(welcomeText, Constant.WELCOME);
        myAccount.verifyElementTexts(Constant.MY_ACCOUNT);
        MobileTestLog.saveExcelFile();

    }

    @Test(description = "performing my account test for each page")
    public void myAccountTestForPages(Map<String, String> data){

        HomePage homePage = new HomePage();
        MyAccountPage myAccount = new MyAccountPage();
        SavedAddressPage savedAddressPage = new SavedAddressPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        homePage.clickOnAllowLocationAccess(Constant.MY_ACCOUNT);
        homePage.clickOnAccountButton(Constant.MY_ACCOUNT);
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"), Constant.MY_ACCOUNT);
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
        MobileTestLog.saveExcelFile();

    }
}
