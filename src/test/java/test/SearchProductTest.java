package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import reports.MobileTestLog;
import utiles.LoginChecker;
import utiles.MobileAssertionUtility;
import frameConstatnt.testConstant.Constant;

import java.util.Map;


public final class SearchProductTest extends MobileBaseTest {
    private SearchProductTest() {

    }

    /**
     * Test to verify searching for a category.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author: Satyajeet Kumar
     */
    @Test(description = "login and searching for a category", groups = {"smoke", "regression"})
    public static void searchCategory(Map<String, String> data) {
        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(), Constant.SEARCH_TEST_NAME_1);
        new HomePage().clickOnSearchIcon(Constant.SEARCH_TEST_NAME_1);
        new SearchPage().enterValueForSearchTab(Constant.SEARCH_TEST_NAME_1, Constant.CATEGORY_NAME);
        WebElement categoryTitle = new SearchPage().getSearchedCategory(Constant.SEARCH_TEST_NAME_1);
        MobileAssertionUtility.assertElementIsDisplayed(categoryTitle);
        new HomePage().clickOnHomeIcon(Constant.SEARCH_TEST_NAME_1);
        // Save test steps to Excel file
        MobileTestLog.saveExcelFile();
    }

    /**
     * Test to verify searching for an item.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author: Satyajeet Kumar
     */
    @Test(description = "login and searching for an item", groups = {"smoke", "regression"})
    public static void searchItem(Map<String, String> data) {
        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(), Constant.SEARCH_TEST_NAME_2);
        new HomePage().clickOnSearchIcon(Constant.SEARCH_TEST_NAME_2);
        new SearchPage().enterValueForSearchTab(Constant.SEARCH_TEST_NAME_2, Constant.ITEM_NAME);
        new SearchPage().itemInfo();
        WebElement itemTitle = new SearchPage().getSearchedItem(Constant.SEARCH_TEST_NAME_2);
        MobileAssertionUtility.assertElementIsDisplayed(itemTitle);
        new HomePage().clickOnHomeIcon(Constant.SEARCH_TEST_NAME_2);
        // Save test steps to Excel file
        MobileTestLog.saveExcelFile();
    }
}
