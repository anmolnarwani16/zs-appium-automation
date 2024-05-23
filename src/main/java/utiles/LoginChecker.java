package utiles;

import driver.MobileDriverManager;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;

public class LoginChecker {
    public void checkLoginFunctionality(String loginNeeded, String userName, String password, WebDriver driver){
        new HomePage().clickOnHamburgerIcon(Constant.SIGNINSIGNOUT_TEST);
        WebElement element = MobileDriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_sign_in']"));
        String str = element.getText();
        if(loginNeeded.equalsIgnoreCase("yes")){
            if(str.equalsIgnoreCase("Sign In / Sign Up")){
                driver.navigate().back();
                new HomePage().clickOnAccountButton(Constant.SIGNINSIGNOUT_TEST);
                MobileLoginUtility.login(userName,password,Constant.SIGNINSIGNOUT_TEST);
            }else{
                driver.navigate().back();
            }
        }else if (loginNeeded.equalsIgnoreCase("no")){
            if(!str.equalsIgnoreCase("Sign In / Sign Up")){
                new HomePage().clickOnAccountButton(Constant.SIGNINSIGNOUT_TEST);
                MobileLogoutUtility.logout(Constant.SIGNINSIGNOUT_TEST);
            }else {
                driver.navigate().back();
            }
        }


    }
}
