package test;

import java.net.MalformedURLException;

import baseTest.MobileBaseTest;
import driver.MobileDriverManager;
import org.openqa.selenium.By;



public class Test extends MobileBaseTest {
	
	@org.testng.annotations.Test
	public void test() throws MalformedURLException, InterruptedException {
		
		
	
	
	MobileDriverManager.getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc='test-Username']")).sendKeys("standard_user");
	MobileDriverManager.getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc='test-Password']")).sendKeys("secret_sauce");
	MobileDriverManager.getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']")).click();
	Thread.sleep(3000);
	MobileDriverManager.getDriver().findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
	Thread.sleep(5000);
	
	
	
		
		
	}

}
