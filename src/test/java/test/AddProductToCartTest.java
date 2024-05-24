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
import reports.MobileTestLog;
import utiles.LoginChecker;
import utiles.MobileAssertionUtility;

import java.util.Map;

public final class AddProductToCartTest extends MobileBaseTest {
    private AddProductToCartTest() {

    }

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
}
