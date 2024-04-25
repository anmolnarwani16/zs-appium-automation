package test;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import org.testng.annotations.Test;
import pages.*;

import java.util.Map;

public class DynamicElementByXpathTest extends MobileBaseTest {
    @Test
    public void dynamicElementByXpathTest(Map<String, String> data) throws InterruptedException {

        new HomePage().clickOnAllowNotificationButton().performClickActionOnGivenElement("Account");

        new SignInPage().enterUserNameInTxtField(data.get("UserName")).enterPasswordInTxtField(data.get("Password")).clickOnLoginButton();
        Thread.sleep(15000);


       new HomePage().clickOnHamburgerIcon();

       new DynamicXpath1().clickOnElementWithText("FRESH");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpath1().clickOnElementWithText("FOOD & BEVERAGES");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpath1().clickOnElementWithText("HEALTHY LIVING");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpath1().clickOnElementWithText("HEALTH & BEAUTY");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpath1().clickOnElementWithText("BBQ ACCESSORIES");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpath1().clickOnElementWithText("HOUSEHOLD");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpath1().clickOnElementWithText("PETS");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpath1().clickOnElementWithText("Facebook");
        MobileDriverManager.getDriver().navigate().back();


       //new DynamicXpathOfLeftHAndNavigation().performClickActionOnGivenElementInLeftHandNavigation("FOOD & BEVERAGES",MobileDriverManager.getDriver());
       //MobileDriverManager.getDriver().navigate().back();



        //new DynamicXpathOfLeftHAndNavigation().performClickActionOnGivenElementInLeftHandNavigation("HEALTHY LIVING");
        MobileDriverManager.getDriver().navigate().back();

       /*/* new DynamicXpathOfLeftHAndNavigation().performClickActionOnGivenElementInLeftHandNavigation("HEALTH & BEAUTY");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpathOfLeftHAndNavigation().performClickActionOnGivenElementInLeftHandNavigation("BBQ ACCESSORIES");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpathOfLeftHAndNavigation().performClickActionOnGivenElementInLeftHandNavigation("BABY");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpathOfLeftHAndNavigation().performClickActionOnGivenElementInLeftHandNavigation("HOUSEHOLD");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpathOfLeftHAndNavigation().performClickActionOnGivenElementInLeftHandNavigation("PETS");
        MobileDriverManager.getDriver().navigate().back();

        new DynamicXpathOfLeftHAndNavigation().performClickActionOnGivenElementInLeftHandNavigation("Facebook");
        MobileDriverManager.getDriver().navigate().back();





       // new DynamicElementByXPath().performClickActionOnGivenElement("Cart");*/



    }

}
