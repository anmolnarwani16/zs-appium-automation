package utiles;

import pages.MyAccountPage;

public class MobileLogoutUtility {
    public static void logout(){
        new MyAccountPage().clickOnLogoutButton();
    }
}
