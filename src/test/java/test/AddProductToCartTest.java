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

    @Test(description = "Add or Subtract item to the cart")
    public void addOrSubtractItem (Map<String,String> data){
        new HomePage().clickOnAllowLocationAccess(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME).clickOnAccountButton(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        MobileLoginUtility.login(data.get("UserName"),data.get("Password"),Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        new HomePage().clickOnFruit(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        new FruitCategoryPage().clickOnAddIcon(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        int value= new MyCartPage().checkTheAddedItemValue(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        new HomePage().clickOnCartIcon(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        new MyCartPage().removeItemFromCart(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        new FruitCategoryPage().clickOnAddIcon(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        WebElement Quantity = new MyCartPage().getQuantityElement(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        MobileAssertionUtility.assertElementTextEquals(Quantity,String.valueOf(value));
//         Save test steps to Excel file
        MobileTestLog.saveExcelFile();
    }

}
