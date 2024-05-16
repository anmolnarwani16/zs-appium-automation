package driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;
import frameConstatnt.MobileFrameConstant;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import utiles.JsonFileRederUtils;

public class MobileDriver {

    private MobileDriver(String platformName ,String udid , String platformVersion){
        JSONObject data = null;
        try {
            data = JsonFileRederUtils.readJSONFromFile(MobileFrameConstant.jsonFilePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if (Objects.isNull(MobileDriverManager.getDriver())) {
            if (platformName.equalsIgnoreCase("Android")) {

                UiAutomator2Options option = new UiAutomator2Options();
                // optional if not mentioned it will take by default;
                option.setPlatformName(data.get("PlatformName").toString());
                option.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
                option.setAppActivity(data.get("AppActivity").toString());

                // device name have to mention
                option.setUdid(data.get("DeviceName").toString());
                option.setApp(MobileFrameConstant.getAndroidApplication());
                option.setMjpegServerPort(9103);

                try {
                    MobileDriverManager.setDriver(new AndroidDriver(new URL(data.get("url").toString()), option));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }


            } else if (platformName.equalsIgnoreCase("ios")) {
                XCUITestOptions options = new XCUITestOptions();
                options.setAutomationName(AutomationName.IOS_XCUI_TEST);
                options.setWdaLaunchTimeout(Duration.ofMinutes(10));
                options.setDeviceName("iPhone 13");
                options.setFullReset(false);
                options.setApp(System.getProperty("user.dir") + "application address");

            } else if (platformName.equalsIgnoreCase("browserStack")) {
                UiAutomator2Options option = new UiAutomator2Options();

                option.setCapability("browserstack.user", "sameerrathod_Vf9kdJ"); //update your user
                option.setCapability("browserstack.key", "KzoKV6HYE3Ev15RLcfXT"); //update your key
                option.setCapability("project", "Test Java Project");
                option.setCapability("build", "Java Android demo");
                option.setCapability("name", "some name");
                option.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
                option.setApp("bs://a8c5841ab33d67a0ec6020bf5b1d56f831efe6e3");
                option.setPlatformName(data.get("PlatformName").toString());


                try {
                    MobileDriverManager.setDriver(new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), option));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }


            }



        }

    }
    public static void initialize(String platformName ,String udid , String platformVersion)  {
        if(MobileDriverManager.getDriver()==null)
            new MobileDriver(platformName,udid,platformVersion);
    }

    public static void quitDriver() {

        if (Objects.nonNull(MobileDriverManager.getDriver())) {

            MobileDriverManager.getDriver().quit();
            MobileDriverManager.unload();

        }
    }


}
