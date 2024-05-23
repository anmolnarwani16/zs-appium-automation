package utiles;

import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LeftHandNavigationPage;

public class LoginChecker {


    public void checkLoginFunctionality(String loginNeeded, String userName, String password, WebDriver driver,String testname) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new HomePage().clickOnHamburgerIcon(testname);
        String str = MobileDriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_sign_in']")).getText();
        System.out.println(str);

        switch (loginNeeded.toLowerCase()) {
            case "yes":
                if (str.equals("Sign In / Sign Up")) {
                    driver.navigate().back();
                    new HomePage().clickOnAccountButton(testname);
                    MobileLoginUtility.login(userName, password, testname);
                } else {
                    driver.navigate().back();
                }
                break;

            case "no":
                if (!str.equals("Sign In / Sign Up")) {
                    new LeftHandNavigationPage().clickOnUserName(testname);
                    MobileLogoutUtility.logout(testname);
                } else {
                    driver.navigate().back();
                }
                break;

            default:
                throw new IllegalArgumentException("Unexpected value: " + loginNeeded);
        }
    }
}