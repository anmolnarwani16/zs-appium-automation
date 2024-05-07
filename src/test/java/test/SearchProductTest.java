package test;

import baseTest.MobileBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import reports.TestLogger;
import utiles.MobileAssertionUtility;
import utiles.MobileLoginUtility;
import frameConstatnt.testConstant.Constant;

import java.util.Map;


public class SearchProductTest extends MobileBaseTest {

    @Test(description = "login d searching for a category")
    public void searchCategory(Map<String,String> data){
        new HomePage().clickOnAllowLocationAccess(Constant.TEST_NAME_1).clickOnAccountButton(Constant.TEST_NAME_1);
        MobileLoginUtility.login(data.get("UserName"),data.get("Password"));
        new HomePage().clickOnSearchIcon(Constant.TEST_NAME_1);
        new SearchPage().enterValueForSearchTab(Constant.TEST_NAME_1, Constant.CATEGORY_NAME);
        WebElement categoryTitle = new SearchPage().getSearchedCategory(Constant.TEST_NAME_1);
        MobileAssertionUtility.assertElementIsDisplayed(categoryTitle);
        // Save test steps to Excel file
        TestLogger.saveExcelFile();
    }

    @Test(description = "login and searching for an item")
    public void searchItem(Map<String,String> data){
        new HomePage().clickOnAllowLocationAccess(Constant.TEST_NAME_2).clickOnAccountButton(Constant.TEST_NAME_2);
        MobileLoginUtility.login(data.get("UserName"),data.get("Password"));
        new HomePage().clickOnSearchIcon(Constant.TEST_NAME_2);
        new SearchPage().enterValueForSearchTab(Constant.TEST_NAME_2, Constant.ITEM_NAME);
        new SearchPage().itemInfo();
        WebElement itemTitle = new SearchPage().getSearchedItem(Constant.TEST_NAME_2);
        MobileAssertionUtility.assertElementIsDisplayed(itemTitle);
        // Save test steps to Excel file
        TestLogger.saveExcelFile();
    }
}
