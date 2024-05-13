package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import enums.ConfigProperties;
import utiles.MobilePropertyUtils;
import utiles.MobileScreenShotUtils;


public class MobileExtentLogger {
	
	private MobileExtentLogger() {

	}
	
	public static void info(String message) {
		MobileExtentManager.getExtentTest().info(message);
	}


	public static void pass(String message) {
		MobileExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		MobileExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		MobileExtentManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
		if (MobilePropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			MobileExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(MobileScreenShotUtils.getBase64Image()).build());

		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) throws Exception {
		if (MobilePropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			MobileExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(MobileScreenShotUtils.getBase64Image()).build());

		} else {
			MobileExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(MobileScreenShotUtils.getBase64Image()).build());

			fail(message);

		}
	}

	public static void skip(String message, boolean isScreenshotNeeded) throws Exception {
		if (MobilePropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			MobileExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(MobileScreenShotUtils.getBase64Image()).build());

		} else {
			skip(message);
		}
		
	}


}
