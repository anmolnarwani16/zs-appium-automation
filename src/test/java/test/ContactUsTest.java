package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import java.util.Map;

public class ContactUsTest extends MobileBaseTest {
    /**
     * Test to verify contactUs details
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     * Author:-Ashif Alam
     */

    @Test(description = "performing contact us test",groups = {"regression"})
    public void contactUsTest(Map<String, String> data) {
        HomePage homePage = new HomePage();
        ContactUsPage contactUsPage = new ContactUsPage();
        homePage.clickOnAccountButton(Constant.MY_ACCOUNT);
        contactUsPage.clickOnContactUs(Constant.CONTACT_US);
        contactUsPage.validateCallOption(Constant.PHONE_NO, Constant.CONTACT_US);
        contactUsPage.validateWriteToUs(Constant.USER_NAME, Constant.PHONE_NO, Constant.COMPLAIN_DESCRIPTION, Constant.SUBMIT, Constant.CONTACT_US);
        MobileDriverManager.getDriver().navigate().back();
        homePage.clickOnHomeIcon(Constant.CONTACT_US);


    }
}
