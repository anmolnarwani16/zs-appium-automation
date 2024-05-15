package test;

import baseTest.MobileBaseTest;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.SortByPage;
import utiles.MobileLoginUtility;

import java.util.Map;

public class ContactUsTest extends MobileBaseTest {

    @Test(description = "performing contact us test")
    public void contactUsTest(Map<String, String> data) {
        HomePage homePage = new HomePage();
        ContactUsPage contactUsPage = new ContactUsPage();
        homePage.clickOnAllowLocationAccess(Constant.CONTACT_US).clickOnAccountButton(Constant.CONTACT_US);
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"), Constant.CONTACT_US);
        homePage.clickOnAccountButton(Constant.MY_ACCOUNT);
        contactUsPage.clickOnContactUs(Constant.CONTACT_US);
        contactUsPage.validateCallOption(Constant.PHONE_NO,Constant.CONTACT_US);


    }
}
