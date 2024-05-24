package pages.CommonUtility;

import pages.CheckoutPage;
import pages.HomePage;
import pages.SearchPage;

public final class AddItemToCartUtility {
    public void addToCart(String testname) {
        new HomePage().clickOnSearchIcon(testname);
        new SearchPage().enterValueForSearchTab(testname, "Floral");
        new CheckoutPage().addItemToCartAndCheckLimit(testname);

    }
}
