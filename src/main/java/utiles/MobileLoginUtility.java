package utiles;

import pages.SignInPage;

public class MobileLoginUtility {
    public static void login(String username,String password,String testname){
        new SignInPage().enterUserName(username,testname).enterPassword(password,testname).performClickOnLoginButton(testname);
    }
}
