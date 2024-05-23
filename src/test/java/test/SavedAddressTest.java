package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SavedAddressPage;
import reports.MobileTestLog;
import utiles.LoginChecker;

import java.util.Map;

public final class SavedAddressTest extends MobileBaseTest {

    private SavedAddressTest() {
    }

    /**
     * Test to verify whether user are able to add new address
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     *             Author:-Ashif Alam
     */
    @Test(description = "performing saved address test", groups = {"regression"})
    public void savedAddressTest(Map<String, String> data) {

        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(),Constant.SAVED_ADDRESS);
        new HomePage().clickOnAccountButton(Constant.SAVED_ADDRESS);
        new SavedAddressPage().performClickOnSavedAddress(Constant.SAVED_ADDRESS);
        new SavedAddressPage().performClickOnAddNewAddress(Constant.SAVED_ADDRESS);
        new SavedAddressPage().addNewAddress(Constant.SEARCH_ADDRESS, Constant.HOUSE_NO, Constant.SAVED_ADDRESS);
        new SavedAddressPage().getAddressAddedText(Constant.ADDRESS_ADDED, Constant.SAVED_ADDRESS);
        new SavedAddressPage().performClickOnOkButton(Constant.SAVED_ADDRESS);
        new HomePage().clickOnHomeIcon(Constant.SAVED_ADDRESS);
        MobileTestLog.saveExcelFile();

    }
}
