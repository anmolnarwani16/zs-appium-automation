package test;

import baseTest.MobileBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FruitCategoryPage;
import pages.HomePage;
import pages.MyCartPage;
import utiles.MobileAssertionUtility;
import utiles.MobileLoginUtility;

import java.util.Map;

public class AddProductToCartTest extends MobileBaseTest {
    @Test(description = "login and add item to the cart")
    public void addProductToCart(Map<String,String> data){
//        new HomePage().clickOnAllowLocationAccess().clickOnAccountButton();
//        MobileLoginUtility.login(data.get("UserName"),data.get("Password"));
//        new HomePage().clickOnFruit();
//        new FruitCategoryPage().clickOnAddIcon();
//        new HomePage().clickOnCartIcon();
//        WebElement checkoutButton = new MyCartPage().getCheckOutButtonElement();
//        MobileAssertionUtility.assertElementIsDisplayed(checkoutButton);
    }
}
