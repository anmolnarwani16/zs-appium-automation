package test;

import baseTest.MobileBaseTest;
import driver.MobileDriver;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.HomePage;
import reports.MobileTestLog;
import utiles.MobileLoginUtility;

import java.util.Map;

public final class SignInTest extends MobileBaseTest {
    private SignInTest(){}
    /**
     * Test to perform Sign in.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author:-Anmol Narwani
     */

    @Test(description = "performing logIn and logOut test", groups = {"smoke","regression"})
    public void signInTest(Map<String, String> data) throws InterruptedException {
        MobileDriver.initialize(data.get("platformName"), data.get("udid"), data.get("platformVersion"));
        //new HomePage().clickOnAllowLocationAccess(Constant.SIGNINSIGNOUT_TEST).clickOnAccountButton(Constant.SIGNINSIGNOUT_TEST);
        new HomePage().clickOnAllowLocationAccessMap(Constant.SIGNINSIGNOUT_TEST).clickOnAccountButton(Constant.SIGNINSIGNOUT_TEST);
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"), Constant.SIGNINSIGNOUT_TEST);
        //MobileDriverManager.getDriver().navigate().back();
        // Save test steps to Excel file
        MobileTestLog.saveExcelFile();

    }
}
