package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SortByPage;
import reports.MobileTestLog;
import utiles.LoginChecker;

import java.util.Map;

public final class SortByTest extends MobileBaseTest {
    private SortByTest(){}
    /**
     * Test to verify sorting category item based on Oldest,Newest and Popularity
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     *             Author:-Ashif Alam
     */

    @Test(description = "performing sort by test", groups = {"regression"})
    //regression
    public void sortByTest(Map<String, String> data) {
        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(),Constant.SORT_BY);
        new HomePage().clickOnFruit(Constant.SORT_BY);
        new SortByPage().performClickOnSortBy(Constant.SORT_BY);
        new SortByPage().performClickOnNewest(Constant.SORT_BY);
        new SortByPage().performClickOnOldest(Constant.SORT_BY);
        new SortByPage().performClickOnPopularity(Constant.SORT_BY);
        new HomePage().clickOnHomeIcon(Constant.SORT_BY);
        MobileTestLog.saveExcelFile();

    }
}
