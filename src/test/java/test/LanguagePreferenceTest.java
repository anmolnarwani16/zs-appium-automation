package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LanguagePreferencePage;
import pages.MyAccountPage;
import reports.MobileTestLog;
import utiles.LoginChecker;
import utiles.MobileAssertionUtility;

import java.util.Map;


public final class LanguagePreferenceTest extends MobileBaseTest {
    private LanguagePreferenceTest() {

    }

    /**
     * Test to verify the preferred language selection.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author:-Satyajeet Kumar
     */
    @Test(description = "login and Selecting the preferred language", groups = {"smoke", "regression"})
    public static void languagePreference(Map<String, String> data) {
        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(), Constant.LANGUAGE_TEST);
        new HomePage().clickOnAccountButton(Constant.LANGUAGE_TEST);
        new MyAccountPage().clickOnLanguage(Constant.LANGUAGE_TEST);
        new LanguagePreferencePage().selectLanguage(Constant.LANGUAGE_TEST, "Arabic");
        WebElement LanguageTitle = new LanguagePreferencePage().getLanguage(Constant.LANGUAGE_TEST);
        MobileAssertionUtility.assertElementContainsText(LanguageTitle, Constant.ARABIC_TEXT);
        new HomePage().clickOnAccountButton(Constant.LANGUAGE_TEST);
        new MyAccountPage().clickOnLanguage(Constant.LANGUAGE_TEST);
        new LanguagePreferencePage().selectLanguage(Constant.LANGUAGE_TEST, "English");
        new HomePage().clickOnHomeIcon(Constant.LANGUAGE_TEST);
        // Save test steps to Excel file
        MobileTestLog.saveExcelFile();
    }
}



