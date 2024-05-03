package test;

import baseTest.MobileBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LeftHandNavigationPage;
import pages.SignInPage;
import utiles.MobileLoginUtility;
import utiles.MobileLogoutUtility;

import java.util.Map;

public class SignInSignOutTest extends MobileBaseTest {

    @Test(description = "performing logIn and logOut test")
    public void signinSignoutTest(Map<String,String> data){
        new HomePage().clickOnAllowLocationAccess().clickOnAccountButton();
        MobileLoginUtility.login(data.get("UserName"),data.get("Password"));
        String loggedInUser = new HomePage().clickOnHamburgerIcon().getUserName();
        Assert.assertNotEquals(loggedInUser,"Sign In / Sign Up");
        new LeftHandNavigationPage().clickOnUserName();
        MobileLogoutUtility.logout();
        new HomePage().clickOnAccountButton();
        String signUpHeading = new SignInPage().getHeading();
        Assert.assertEquals(signUpHeading,"Signup / Login");
    }
}
