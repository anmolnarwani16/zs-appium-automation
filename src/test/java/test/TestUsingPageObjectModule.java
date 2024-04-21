package test;

import java.util.Map;

import baseTest.MobileBaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;


public class TestUsingPageObjectModule extends MobileBaseTest {
	
	@Test
	public void testUsingPageObjectModule() throws InterruptedException {
		
		new LoginPage().getUserNameTextField("standard_user").getPasswordTextField("secret_sauce").getLoginButton();
		
		Thread.sleep(3000);
	}

}
