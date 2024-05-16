package test;

import baseTest.MobileBaseTest;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SavedAddressPage;
import reports.MobileTestLog;
import java.util.Map;

public class SavedAddressTest extends MobileBaseTest {

    /**
     *
     * Test to verify whether user are able to add new address
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     *  Author:-Ashif Alam
     */
    @Test(description = "performing saved address test",groups = {"regression"})
    public void savedAddressTest(Map<String, String> data){
        HomePage homePage = new HomePage();
        SavedAddressPage savedAddressPage = new SavedAddressPage();
        homePage.clickOnAccountButton(Constant.SAVED_ADDRESS);
        savedAddressPage.performClickOnSavedAddress(Constant.SAVED_ADDRESS);
        savedAddressPage.performClickOnAddNewAddress(Constant.SAVED_ADDRESS);
        savedAddressPage.addNewAddress(Constant.SEARCH_ADDRESS, Constant.HOUSE_NO, Constant.SAVED_ADDRESS);
        savedAddressPage.getAddressAddedText(Constant.ADDRESS_ADDED, Constant.SAVED_ADDRESS);
        savedAddressPage.performClickOnOkButton(Constant.SAVED_ADDRESS);
        homePage.clickOnHomeIcon(Constant.SAVED_ADDRESS);
        MobileTestLog.saveExcelFile();


    }
}
