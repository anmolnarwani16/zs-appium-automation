package driver;

import io.appium.java_client.android.AndroidDriver;

public class MobileDriverManager {
	
	public static ThreadLocal<AndroidDriver> dri = new ThreadLocal<>();

	public static AndroidDriver getDriver() {
		return dri.get();

	}

	public static void setDriver(AndroidDriver driver) {
		dri.set(driver);

	}
		public static void unload() {
		dri.remove();

	}

}
