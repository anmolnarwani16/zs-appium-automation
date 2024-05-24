package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import reports.MobileTestLog;
import utiles.LoginChecker;
import java.util.Map;

public final class ContactUsTest extends MobileBaseTest {
    private ContactUsTest(){}
    /**
     * Test to verify contactUs details
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     * Author:-Ashif Alam
     */

    @Test(description = "performing contact us test",groups = {"regression"})
    public void contactUsTest(Map<String, String> data) {
        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(),Constant.CONTACT_US);
        new HomePage().clickOnAccountButton(Constant.MY_ACCOUNT);
        new ContactUsPage().clickOnContactUs(Constant.CONTACT_US);
        new ContactUsPage().validateCallOption(Constant.PHONE_NO, Constant.CONTACT_US);
        new ContactUsPage().validateWriteToUs(Constant.USER_NAME, Constant.PHONE_NO, Constant.COMPLAIN_DESCRIPTION, Constant.SUBMIT, Constant.CONTACT_US);
        MobileDriverManager.getDriver().navigate().back();
        new HomePage().clickOnHomeIcon(Constant.CONTACT_US);
        MobileTestLog.saveExcelFile();

    }
}
