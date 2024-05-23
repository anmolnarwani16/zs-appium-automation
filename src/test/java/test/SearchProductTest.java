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
import utiles.MobileLoginUtility;
import frameConstatnt.testConstant.Constant;
import java.util.Map;


public class SearchProductTest extends MobileBaseTest {

    @Test(description = "login and searching for a category")
    public void searchCategory(Map<String,String> data){
        new HomePage().clickOnAllowLocationAccess(Constant.SEARCH_TEST_NAME_1).clickOnAccountButton(Constant.SEARCH_TEST_NAME_1);
        MobileLoginUtility.login(data.get("UserName"),data.get("Password"),Constant.SEARCH_TEST_NAME_1);
        new HomePage().clickOnSearchIcon(Constant.SEARCH_TEST_NAME_1);
        new SearchPage().enterValueForSearchTab(Constant.SEARCH_TEST_NAME_1, Constant.CATEGORY_NAME);
        WebElement categoryTitle = new SearchPage().getSearchedCategory(Constant.SEARCH_TEST_NAME_1);
        MobileAssertionUtility.assertElementIsDisplayed(categoryTitle);
        MobileTestLog.saveExcelFile();
    }

    @Test(description = "login and searching for an item")
    public void searchItem(Map<String,String> data){
        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(),Constant.SEARCH_TEST_NAME_2);
        new HomePage().clickOnAllowLocationAccess(Constant.SEARCH_TEST_NAME_2).clickOnAccountButton(Constant.SEARCH_TEST_NAME_2);
        MobileLoginUtility.login(data.get("UserName"),data.get("Password"),Constant.SEARCH_TEST_NAME_2);
        new HomePage().clickOnSearchIcon(Constant.SEARCH_TEST_NAME_2);
        new SearchPage().enterValueForSearchTab(Constant.SEARCH_TEST_NAME_2, Constant.ITEM_NAME);
        new SearchPage().itemInfo();
        WebElement itemTitle = new SearchPage().getSearchedItem(Constant.SEARCH_TEST_NAME_2);
        MobileAssertionUtility.assertElementIsDisplayed(itemTitle);
        MobileTestLog.saveExcelFile();
    }
}
