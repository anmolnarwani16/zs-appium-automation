package test;

import baseTest.MobileBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LanguagePreferencePage;
import pages.MyAccountPage;
import reports.MobileTestLog;
import utiles.MobileAssertionUtility;
import utiles.MobileLoginUtility;
import frameConstatnt.testConstant.Constant;

import java.util.Map;


public class LanguagePreferenceTest extends MobileBaseTest {

    @Test(description = "login and Selecting the preferred language.")
    public void languagePreference(Map<String, String> data) {
        new HomePage().clickOnAllowLocationAccess(Constant.LANGUAGE_TEST).clickOnAccountButton(Constant.LANGUAGE_TEST);
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"), Constant.LANGUAGE_TEST);
        new HomePage().clickOnAccountButton(Constant.LANGUAGE_TEST);
        new MyAccountPage().clickOnLanguage(Constant.LANGUAGE_TEST);
        new LanguagePreferencePage().selectLanguage(Constant.LANGUAGE_TEST);
        WebElement LanguageTitle = new LanguagePreferencePage().getLanguage(Constant.LANGUAGE_TEST);
        MobileAssertionUtility.assertElementContainsText(LanguageTitle, Constant.ARABIC_TEXT);
        // Save test steps to Excel file
        MobileTestLog.saveExcelFile();
    }
}



