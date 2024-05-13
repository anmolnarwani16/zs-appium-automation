package test;

import baseTest.MobileBaseTest;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.*;
import reports.MobileTestLog;
import utiles.MobileAssertionUtility;
import utiles.MobileLoginUtility;

import java.util.Map;

public class HomepageElementVisibilityTest extends MobileBaseTest {
    @Test(description = "Visibility of Homepage Elements")
    public void homePageElement(Map<String, String> data) {
        new HomePage().clickOnAllowLocationAccess(Constant.HOMEPAGE_ELEMENT_TEST).clickOnAccountButton(Constant.HOMEPAGE_ELEMENT_TEST);
        MobileLoginUtility.login(data.get("UserName"), data.get("Password"), Constant.HOMEPAGE_ELEMENT_TEST);

        //Search Icon Visibility
        new HomePage().clickOnSearchIcon(Constant.HOMEPAGE_ELEMENT_TEST);
        WebElement searchTab = new SearchPage().getSearchTabElement(Constant.HOMEPAGE_ELEMENT_TEST);
        MobileAssertionUtility.assertElementIsDisplayed(searchTab);
        new HomePage().clickBackToHome(Constant.HOMEPAGE_ELEMENT_TEST);
        // Notification Icon Visibility
        new HomePage().clickOnNotificationIcon(Constant.HOMEPAGE_ELEMENT_TEST);
        WebElement notificationImageElement = new HomePage().getNotificationImageElement(Constant.HOMEPAGE_ELEMENT_TEST);
        MobileAssertionUtility.assertElementIsDisplayed(notificationImageElement);
        new HomePage().clickOnHomeIcon(Constant.HOMEPAGE_ELEMENT_TEST);
        //My Cart Icon Visibility
        new HomePage().clickOnCartIcon(Constant.HOMEPAGE_ELEMENT_TEST);
        WebElement cartText = new MyCartPage().getCartTag(Constant.HOMEPAGE_ELEMENT_TEST);
        MobileAssertionUtility.assertElementTextEquals(cartText, Constant.MYCART_TEXT);
        new HomePage().clickOnHomeIcon(Constant.HOMEPAGE_ELEMENT_TEST);
        // My Account Icon Visibility
        new HomePage().clickOnAccountButton(Constant.HOMEPAGE_ELEMENT_TEST);
        WebElement changePasswordElement = new MyAccountPage().getChangePasswordElement(Constant.HOMEPAGE_ELEMENT_TEST);
        MobileAssertionUtility.assertElementIsDisplayed(changePasswordElement);
        new HomePage().clickOnHomeIcon(Constant.HOMEPAGE_ELEMENT_TEST);
        // Weekly Offers Visibility
        new HomePage().clickOnWeeklyOffers(Constant.HOMEPAGE_ELEMENT_TEST);
        WebElement weeklyOffersElement = new HomePage().getWeeklyOffersElement(Constant.HOMEPAGE_ELEMENT_TEST);
        MobileAssertionUtility.assertElementContainsText(weeklyOffersElement, Constant.WeeklyOffers_TEXT);
        new HomePage().clickOnHomeIcon(Constant.HOMEPAGE_ELEMENT_TEST);
        // Exclusive Deals Visibility
        new HomePage().clickOnExclusiveDeals(Constant.HOMEPAGE_ELEMENT_TEST);
        WebElement exclusiveDealsElement = new HomePage().getWeeklyOffersElement(Constant.HOMEPAGE_ELEMENT_TEST);
        MobileAssertionUtility.assertElementContainsText(exclusiveDealsElement, Constant.ExclusiveDeals_TEXT);
        new HomePage().clickOnHomeIcon(Constant.HOMEPAGE_ELEMENT_TEST);
        // View All Visibility
        new HomePage().clickOnViewAllButton(Constant.HOMEPAGE_ELEMENT_TEST);
        WebElement subCategoryElement = new HomePage().getSubCategoryElement(Constant.HOMEPAGE_ELEMENT_TEST);
        MobileAssertionUtility.assertElementTextEquals(subCategoryElement, Constant.SubCategory_Text);
        new HomePage().clickOnHomeIcon(Constant.HOMEPAGE_ELEMENT_TEST);
        // Hamburger Icon Visibility
        new HomePage().clickOnHamburgerIcon(Constant.HOMEPAGE_ELEMENT_TEST);
        WebElement signInLogo = new LeftHandNavigationPage().getSignedInUser(Constant.HOMEPAGE_ELEMENT_TEST);
        MobileAssertionUtility.assertElementIsDisplayed(signInLogo);

        // Save test steps to Excel file
        MobileTestLog.saveExcelFile();
    }
}
