package test;

import baseTest.MobileBaseTest;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SortByPage;
import reports.MobileTestLog;
import utiles.MobileLoginUtility;

import java.util.Map;

public class SortByTest extends MobileBaseTest {

    @Test(description = "performing sort by test")
    public void sortByTest(Map<String, String> data)
    {   HomePage homePage = new HomePage();
        SortByPage sortByPage=new SortByPage();
        homePage.clickOnAllowLocationAccess(Constant.SORT_BY).clickOnAccountButton(Constant.SORT_BY);
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"),Constant.SORT_BY);
        sortByPage.performClickOnCategory(Constant.SORT_BY);
        sortByPage.performClickOnSortBy(Constant.SORT_BY);
        sortByPage.performClickOnNewest(Constant.SORT_BY);
        sortByPage.performClickOnOldest(Constant.SORT_BY);
        sortByPage.performClickOnPopularity(Constant.SORT_BY);
        MobileTestLog.saveExcelFile();

    }
}
