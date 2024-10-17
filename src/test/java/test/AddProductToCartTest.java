package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CommonUtility.AddItemToCartUtility;
import pages.FruitCategoryPage;
import pages.HomePage;
import pages.MyCartPage;
import pages.SearchPage;
import reports.MobileTestLog;
import utiles.LoginChecker;
import utiles.MobileAssertionUtility;

import java.util.ArrayList;
import java.util.Map;

public final class AddProductToCartTest extends MobileBaseTest {
    private AddProductToCartTest() {

    }

    ArrayList<String> itemPriceList = new ArrayList<>();

    /**
     * Test to verify adding a product to the cart.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author:-Anmol Narwani
     */
    @Test(description = "login and add item to the cart", groups = {"smoke", "regression"})
    public static void addProductToCart(Map<String, String> data) {
        try {
            new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(), Constant.ADD_PRODUCT_TEST_NAME);
            new AddItemToCartUtility().addToCart(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
            new HomePage().clickOnCartIcon(Constant.ADD_PRODUCT_TEST_NAME);
            WebElement checkoutButton = new MyCartPage().getCheckOutButtonElement(Constant.ADD_PRODUCT_TEST_NAME);
            MobileAssertionUtility.assertElementIsDisplayed(checkoutButton);
            new HomePage().clickOnHomeIcon(Constant.ADD_PRODUCT_TEST_NAME);
            //  Save test steps to Excel file
            MobileTestLog.saveExcelFile();
        } catch (RuntimeException e) {
            new HomePage().clickOnHomeIcon(Constant.PLACE_ORDER);
        }

    }

    /**
     * Test to verify adding or subtracting an item from the cart.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author:-Satyajeet Kumar
     */
   @Test(description = "Add or Subtract item to the cart", groups = {"smoke", "regression"})
    public static void addOrSubtractItem(Map<String, String> data) {
        try {
            new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(), Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
            new AddItemToCartUtility().addToCart(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
            new HomePage().clickOnCartIcon(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
            new MyCartPage().removeItemFromCart(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
            int value = new MyCartPage().checkTheAddedItemValue(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
            new FruitCategoryPage().clickOnAddIcon(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
            WebElement Quantity = new MyCartPage().getQuantityElement(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
            MobileAssertionUtility.assertElementTextEquals(Quantity, String.valueOf(value + 1));
            new HomePage().clickOnHomeIcon(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
            //   Save test steps to Excel file
            MobileTestLog.saveExcelFile();
        } catch (RuntimeException e) {
            new HomePage().clickOnHomeIcon(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        }
    }

    /**
     * Test to verify whether customers are able add items to cart with selecting different variant from the dropdown
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             <p>
     * Author:-Varalakshmi
     */
    @Test(description = "TC-2: add item to cart selecting different variant from the dropdown", groups = {"smoke", "regression"})
    public void addToCartWithDifferentVariant(Map<String, String> data) throws InterruptedException {
        new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(), Constant.ADD_DIFFERENT_VARIANT_PRODUCT_TEST_NAME);
        new HomePage().clickOnSearchTextField(Constant.ADD_DIFFERENT_VARIANT_PRODUCT_TEST_NAME);
        new SearchPage().enterValueForSearchTab(Constant.ADD_DIFFERENT_VARIANT_PRODUCT_TEST_NAME, Constant.EGG_PLANT);
        String expectedVariantPrice1 = new SearchPage().selectDifferentVariant(Constant.SECOND_VARIANT, Constant.ADD_DIFFERENT_VARIANT_PRODUCT_TEST_NAME);
        itemPriceList.add(expectedVariantPrice1);
        new SearchPage().clickOnAddIcons(Constant.ADD_DIFFERENT_VARIANT_PRODUCT_TEST_NAME);
        new HomePage().clickOnCartIcon(Constant.DIFFERENT_VARIANT_ADDED_SEPARATELY_TEST_NAME);
        new MyCartPage().validateItemPrice(expectedVariantPrice1, Constant.ADD_DIFFERENT_VARIANT_PRODUCT_TEST_NAME);
        MobileDriverManager.getDriver().navigate().back();
    }

    /**
     * Test to verify whether different variants of an item added separately in cart page
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             <p>
     * Author:-Varalakshmi
     */
    @Test(description = "TC-4: Verify cart page when different variants are added separately", groups = {"smoke", "regression"})
    public void differentVariantsAddedSeparately(Map<String, String> data) throws InterruptedException {
        new HomePage().clickOnSearchTextField(Constant.DIFFERENT_VARIANT_ADDED_SEPARATELY_TEST_NAME);
        new SearchPage().enterValueForSearchTab(Constant.DIFFERENT_VARIANT_ADDED_SEPARATELY_TEST_NAME, Constant.EGG_PLANT);
        String expectedVariantPrice2 = new SearchPage().selectDifferentVariant(Constant.THIRD_VARIANT, Constant.DIFFERENT_VARIANT_ADDED_SEPARATELY_TEST_NAME);
        itemPriceList.add(expectedVariantPrice2);
        new SearchPage().clickOnAddIcons(Constant.DIFFERENT_VARIANT_ADDED_SEPARATELY_TEST_NAME);
        new HomePage().clickOnCartIcon(Constant.DIFFERENT_VARIANT_ADDED_SEPARATELY_TEST_NAME);
        new MyCartPage().validateItemsAddedSeparately(Constant.EGG_PLANT, itemPriceList, Constant.DIFFERENT_VARIANT_ADDED_SEPARATELY_TEST_NAME);
    }
}
