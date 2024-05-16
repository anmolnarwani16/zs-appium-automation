package test;

import baseTest.MobileBaseTest;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SortByPage;
import reports.MobileTestLog;

import java.util.Map;

public class SortByTest extends MobileBaseTest {
    /**
     * Test to verify sorting category item based on Oldest,Newest and Popularity
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     * Author:-Ashif Alam
     */

    @Test(description = "performing sort by test",groups = {"regresssion"})
    public void sortByTest(Map<String, String> data) {
        HomePage homePage = new HomePage();
        SortByPage sortByPage = new SortByPage();
        homePage.clickOnFruit(Constant.SORT_BY);
        sortByPage.performClickOnSortBy(Constant.SORT_BY);
        sortByPage.performClickOnNewest(Constant.SORT_BY);
        sortByPage.performClickOnOldest(Constant.SORT_BY);
        sortByPage.performClickOnPopularity(Constant.SORT_BY);
        homePage.clickOnHomeIcon(Constant.SORT_BY);
        MobileTestLog.saveExcelFile();

    }
}
