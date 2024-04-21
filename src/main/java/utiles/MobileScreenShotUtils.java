package utiles;

import driver.MobileDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;





public class MobileScreenShotUtils {
	public static String getBase64Image() {
		return ((TakesScreenshot) MobileDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}


}
