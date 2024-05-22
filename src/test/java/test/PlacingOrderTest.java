package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.MyCartPage;
import pages.SearchPage;
import reports.MobileTestLog;
import utiles.LoginChecker;
import utiles.MobileAssertionUtility;

import java.util.Map;

public final class PlacingOrderTest extends MobileBaseTest {

    private PlacingOrderTest() {
    }

    /**
     * Test to verify whether customers are able to place order
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *
     *             Author:-Ashif Alam
     */

    @Test(description = "Placing an order",groups = {"regression"})
    public void placeOrderTest(Map<String, String> data) {
        try {
            new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver());
            new HomePage().clickOnFruit(Constant.PLACE_ORDER);
            new HomePage().clickOnSearchIcon(Constant.PLACE_ORDER);
            new SearchPage().enterValueForSearchTab(Constant.SEARCH_TEST_NAME_2, Constant.ITEM_NAME3);
            new CheckoutPage().addItemToCartAndCheckLimit(Constant.PLACE_ORDER);
            new HomePage().clickOnCartIcon(Constant.PLACE_ORDER);
            new MyCartPage().selectSubstitution(Constant.PLACE_ORDER).selectReplaceWithEquivalent(Constant.PLACE_ORDER).clickOnCheckoutButton(Constant.PLACE_ORDER);
            new CheckoutPage().enterComment(MobileDriverManager.getDriver(), Constant.PLACE_ORDER).clickDebitCardButton(Constant.PLACE_ORDER).clickOnSavedDebitCard(Constant.PLACE_ORDER).clickOnPlaceOrderButton(Constant.PLACE_ORDER);
            WebElement orderPlacedElement = new CheckoutPage().getOrderPlacedTab(Constant.PLACE_ORDER);
            MobileAssertionUtility.assertElementIsDisplayed(orderPlacedElement);
            MobileDriverManager.getDriver().navigate().back();
            new HomePage().clickOnHomeIcon(Constant.PLACE_ORDER);
            MobileTestLog.saveExcelFile();
        } catch (RuntimeException e) {
            new HomePage().clickOnHomeIcon(Constant.PLACE_ORDER);
        }
    }
}