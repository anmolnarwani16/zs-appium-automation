package test;

import baseTest.MobileBaseTest;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FruitCategoryPage;
import pages.HomePage;
import pages.MyCartPage;
import reports.MobileTestLog;
import utiles.MobileAssertionUtility;
import utiles.MobileLoginUtility;

import java.util.Map;

public class AddProductToCartTest extends MobileBaseTest {
    @Test(description = "login and add item to the cart")
    public void addProductToCart(Map<String,String> data){
        new HomePage().clickOnAllowLocationAccess(Constant.ADD_PRODUCT_TEST_NAME).clickOnAccountButton(Constant.ADD_PRODUCT_TEST_NAME);
        MobileLoginUtility.login(data.get("UserName"),data.get("Password"),Constant.ADD_PRODUCT_TEST_NAME);
        new HomePage().clickOnFruit(Constant.ADD_PRODUCT_TEST_NAME);
        new FruitCategoryPage().clickOnAddIcon(Constant.ADD_PRODUCT_TEST_NAME);
        new HomePage().clickOnCartIcon(Constant.ADD_PRODUCT_TEST_NAME);
        WebElement checkoutButton = new MyCartPage().getCheckOutButtonElement(Constant.ADD_PRODUCT_TEST_NAME);
        MobileAssertionUtility.assertElementIsDisplayed(checkoutButton);
        // Save test steps to Excel file
        MobileTestLog.saveExcelFile();
    }
}
