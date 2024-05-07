package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.SavedAddressPage;
import reports.TestLogger;
import utiles.MobileLoginUtility;

import java.util.Map;

public class SavedAddressTest extends MobileBaseTest {
    @Test(description = "performing saved address test")
    public void savedAddressTest(Map<String, String> data){
        HomePage homePage = new HomePage();
        SavedAddressPage savedAddressPage = new SavedAddressPage();
        homePage.clickOnAllowLocationAccess(Constant.SAVED_ADDRESS);
        homePage.clickOnAccountButton(Constant.SAVED_ADDRESS);
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"));
        homePage.clickOnAccountButton(Constant.SAVED_ADDRESS);
        savedAddressPage.performClickOnSavedAddress(Constant.SAVED_ADDRESS);
        savedAddressPage.performClickOnAddNewAddress(Constant.SAVED_ADDRESS);
        savedAddressPage.addNewAddress(Constant.SEARCH_ADDRESS, Constant.HOUSE_NO, Constant.SAVED_ADDRESS);
        savedAddressPage.getAddressAddedText("Address added!", Constant.SAVED_ADDRESS);
        savedAddressPage.performClickOnOkButton(Constant.SAVED_ADDRESS);
        TestLogger.saveExcelFile();


    }
}
