package utiles;

import pages.MyAccountPage;

public class MobileLogoutUtility {
    public static void logout(String testname) {
        new MyAccountPage().clickOnLogoutButton(testname);
    }
}
