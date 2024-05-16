package test;

import baseTest.MobileBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FilterProductPage;
import pages.HomePage;
import reports.MobileTestLog;
import utiles.MobileAssertionUtility;
import frameConstatnt.testConstant.Constant;

import java.util.Map;


public class FilterProductsTest extends MobileBaseTest {

    /**
     * Test to verify the filtering of products based on brand.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author:-Satyajeet Kumar
     */
    @Test(description = "Filtering products based on brand", groups={"regression"})
    public void filterProducts(Map<String, String> data) throws InterruptedException {
        new HomePage().clickOnFruit(Constant.FILTER_TEST);
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
