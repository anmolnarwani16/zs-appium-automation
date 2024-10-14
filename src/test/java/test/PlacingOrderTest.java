package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import enums.MobileLogType;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.MyCartPage;
import pages.SearchPage;
import reports.MobileExtentLogger;
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
     *             <p>
     *             Author:-Anmol Narwani
     */
    @Test(description = "Placing an order", groups = {"smoke", "regression"})
    public void placeOrderTest(Map<String, String> data) {
        try {
            new LoginChecker().checkLoginFunctionality(data.get("LoginNeeded"), data.get("UserName"), data.get("Password"), MobileDriverManager.getDriver(),Constant.PLACE_ORDER);
            new HomePage().clickOnCartIcon(Constant.PLACE_ORDER);
            new MyCartPage().clearCart(Constant.PLACE_ORDER);
            new HomePage().clickOnHomeIcon(Constant.PLACE_ORDER);
            new HomePage().clickOnSearchTextField(Constant.PLACE_ORDER);
            new SearchPage().enterValueForSearchTab(Constant.SEARCH_TEST_NAME_2, Constant.AUSTRALIAN_ORGANIC_BEEF);
            //new CheckoutPage().addItemToCartAndCheckLimit(Constant.PLACE_ORDER);
            Thread.sleep(5000);
            new MyCartPage().clickOrderAmountGreaterThanFifty(Constant.PLACE_ORDER);
            new HomePage().clickOnCartIcon(Constant.PLACE_ORDER);
            new MyCartPage().selectSubstitution(Constant.PLACE_ORDER).selectReplaceWithEquivalent(Constant.PLACE_ORDER);
            if (new MyCartPage().orderAmountGreaterThanFifty(Constant.PLACE_ORDER)) {
                new MyCartPage().clickOnCheckoutButton(Constant.PLACE_ORDER);
            } else {
                MobileExtentLogger.log(MobileLogType.INFO, "cart value is less than 50 SAR ");
                new HomePage().clickOnHomeIcon(Constant.PLACE_ORDER);
            }
            new CheckoutPage().enterComment(MobileDriverManager.getDriver(), Constant.PLACE_ORDER).clickDebitCardButton(Constant.PLACE_ORDER).clickOnSavedDebitCard(Constant.PLACE_ORDER).clickOnPlaceOrderButton(Constant.PLACE_ORDER);
            MobileAssertionUtility.assertElementIsDisplayed(new CheckoutPage().getOrderPlacedTab(Constant.PLACE_ORDER));
            MobileTestLog.saveExcelFile();
        } catch (RuntimeException e) {
            new HomePage().clickOnHomeIcon(Constant.PLACE_ORDER);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
