package utiles;

import pages.SignInPage;

public class MobileLoginUtility {
    public static void login(String username,String password){
        new SignInPage().enterUserName(username).enterPassword(password).performClickOnLoginButton();
    }
}
