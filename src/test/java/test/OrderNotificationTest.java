package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OrderNotificationPage;
import reports.MobileTestLog;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public final class OrderNotificationTest extends MobileBaseTest {
    private OrderNotificationTest() {
    }

    /**
     * Test to verify Notification appearance on placing an order.
     *
     * @param data Test data containing username, password, Execution(Yes or No), udid, platformName.
     *             Author:-Satyajeet Kumar
     */
    @Test(description = "Visibilty of Notification on placing an order", groups = {"smoke", "regression"})
    public static void orderNotification(Map<String, String> data) {
        try {
            String value = new OrderNotificationPage().getOrderId(Constant.ORDER_NOTIFICATION, "orderText", MobileDriverManager.getDriver());
            MobileDriverManager.getDriver().navigate().back();
            new HomePage().clickOnNotificationIcon(Constant.ORDER_NOTIFICATION);
            String value1 = new OrderNotificationPage().getOrderId(Constant.ORDER_NOTIFICATION, "orderNumber", MobileDriverManager.getDriver());
            assertEquals(value, value1);
            new HomePage().clickOnHomeIcon(Constant.ORDER_NOTIFICATION);
            // Save test steps to Excel file
            MobileTestLog.saveExcelFile();
        } catch (RuntimeException e) {
            new HomePage().clickOnHomeIcon(Constant.PLACE_ORDER);
        }
    }
}

