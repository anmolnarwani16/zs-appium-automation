package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import enums.ConfigProperties;
import enums.MobileLogType;
import utiles.MobilePropertyUtils;
import utiles.MobileScreenShotUtils;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;


public class MobileExtentLogger {

	private MobileExtentLogger(){}

	private static final Consumer<String> PASS = (message)->MobileExtentManager.getExtentTest().pass(message);
	private static final Consumer<String> FAIL = (message)->MobileExtentManager.getExtentTest().fail(message);
	private static final Consumer<String> SKIP = (message)->MobileExtentManager.getExtentTest().skip(message);
	private static final Consumer<String> INFO = (message)->MobileExtentManager.getExtentTest().info(message);
	private static final Consumer<String> CONSOLE = (message) -> System.out.println("INFO---->"+message);
	private static final Consumer<String> EXTENTANDCONSOLE = PASS.andThen(CONSOLE);
	private static final Consumer<String> TAKESCREENSHOT = (message)-> MobileExtentManager.getExtentTest().info("",
			MediaEntityBuilder.createScreenCaptureFromBase64String(MobileScreenShotUtils.getBase64Image()).build());

	private static final Map<MobileLogType,Consumer<String>> MAP = new EnumMap<>(MobileLogType.class);
	private static final Map<MobileLogType,Consumer<String>> SCREENSHOTMAP = new EnumMap<>(MobileLogType.class);

	static {
		MAP.put(MobileLogType.PASS, PASS);
		MAP.put(MobileLogType.FAIL, FAIL.andThen(TAKESCREENSHOT));
		MAP.put(MobileLogType.SKIP, SKIP);
		MAP.put(MobileLogType.INFO, INFO);
		MAP.put(MobileLogType.CONSOLE, CONSOLE);
		MAP.put(MobileLogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE);
		SCREENSHOTMAP.put(MobileLogType.PASS, PASS.andThen(TAKESCREENSHOT));
		SCREENSHOTMAP.put(MobileLogType.FAIL, FAIL.andThen(TAKESCREENSHOT));
		SCREENSHOTMAP.put(MobileLogType.SKIP, SKIP.andThen(TAKESCREENSHOT));
		SCREENSHOTMAP.put(MobileLogType.INFO, INFO);
		SCREENSHOTMAP.put(MobileLogType.CONSOLE, CONSOLE);
		SCREENSHOTMAP.put(MobileLogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE.andThen(TAKESCREENSHOT));
	}

	public static void log(MobileLogType status, String message)  {
        try {
            if(!MobilePropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
                MAP.getOrDefault(status,EXTENTANDCONSOLE).accept(message);
            }
            else{
                SCREENSHOTMAP.getOrDefault(status,EXTENTANDCONSOLE).accept(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

	}

}

