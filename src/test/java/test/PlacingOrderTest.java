package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.FruitCategoryPage;
import pages.HomePage;
import pages.MyCartPage;
import reports.MobileTestLog;
import utiles.MobileAssertionUtility;
import utiles.MobileLoginUtility;

import java.util.Map;

public class PlacingOrderTest extends MobileBaseTest {
    @Test(description = "Placing an order")
    public void placeOrderTest(Map<String, String> data) {
        new HomePage().clickOnAllowLocationAccess(Constant.PLACE_ORDER).clickOnAccountButton(Constant.PLACE_ORDER);
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"), Constant.PLACE_ORDER);
        new HomePage().clickOnFruit(Constant.PLACE_ORDER);
        for (int i = 0; i < 10; i++) {
            new FruitCategoryPage().clickOnAddIcon(Constant.PLACE_ORDER);
        }
        new HomePage().clickOnCartIcon(Constant.PLACE_ORDER);
        new MyCartPage().selectSubstitution(Constant.PLACE_ORDER).selectReplaceWithEquivalent(Constant.PLACE_ORDER).clickOnCheckoutButton(Constant.PLACE_ORDER);
        new CheckoutPage().enterComment(MobileDriverManager.getDriver(),Constant.PLACE_ORDER).clickDebitCardButton(Constant.PLACE_ORDER).clickOnSavedDebitCard(Constant.PLACE_ORDER).clickOnPlaceOrderButton(Constant.PLACE_ORDER);
        WebElement orderPlacedElement = new CheckoutPage().getOrderPlacedTab(Constant.PLACE_ORDER);
        MobileAssertionUtility.assertElementIsDisplayed(orderPlacedElement);
        // Save test steps to Excel file
        MobileTestLog.saveExcelFile();
    }
}
