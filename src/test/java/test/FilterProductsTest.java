package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FilterProductPage;
import pages.HomePage;
import pages.SearchPage;
import reports.MobileTestLog;
import utiles.LoginChecker;
import utiles.MobileAssertionUtility;
import frameConstatnt.testConstant.Constant;

import java.util.Map;


public final class FilterProductsTest extends MobileBaseTest {
    private FilterProductsTest() {

    }

    /**
     * Test to verify the filtering of products based on brand.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author:-Satyajeet Kumar
     */
    @Test(description = "Filtering products based on brand", groups = {"regression"})
    public static void filterProducts(Map<String, String> data) throws InterruptedException {
        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(), Constant.FILTER_TEST);
        //new HomePage().clickOnSearchIcon(Constant.FILTER_TEST);
        new HomePage().clickOnSearchTextField(Constant.FILTER_TEST);
        new SearchPage().enterValueForSearchTab(Constant.FILTER_TEST, "Floral");
        new FilterProductPage().clickonFilterButton(Constant.FILTER_TEST);
        new FilterProductPage().clickonBrandButton(Constant.FILTER_TEST);
        String value = new FilterProductPage().getCountText(Constant.FILTER_TEST);
        String brandName = new FilterProductPage().getBrandText(Constant.FILTER_TEST);
        new FilterProductPage().clickonparticularBrand(Constant.FILTER_TEST);
        new FilterProductPage().clickonapplyButton(Constant.FILTER_TEST);
        WebElement brandvalue = new FilterProductPage().getBrandCountElement(Constant.FILTER_TEST);
        MobileAssertionUtility.assertElementContainsText(brandvalue, value);
        WebElement brandtext = new FilterProductPage().getBrandTextElement(Constant.FILTER_TEST);
        MobileAssertionUtility.assertElementTextEquals(brandtext, brandName);
        new HomePage().clickOnHomeIcon(Constant.FILTER_TEST);
        // Save test steps to Excel file
        MobileTestLog.saveExcelFile();
    }
}
