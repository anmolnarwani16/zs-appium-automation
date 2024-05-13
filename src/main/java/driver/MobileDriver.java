package driver;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;


import com.google.common.collect.ImmutableMap;
import frameConstatnt.MobileFrameConstant;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import utiles.JsonFileRederUtils;

public class MobileDriver {

    public static void initDriver(String platformName) throws IOException, ParseException {

        JSONObject data = JsonFileRederUtils.readJSONFromFile(MobileFrameConstant.jsonFilePath());

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

                MobileDriverManager.setDriver(new AndroidDriver(new URL(data.get("url").toString()), option));


            } else if (platformName.equalsIgnoreCase("ios")) {
                XCUITestOptions options = new XCUITestOptions();
                options.setAutomationName(AutomationName.IOS_XCUI_TEST);
                options.setWdaLaunchTimeout(Duration.ofMinutes(10));
                options.setDeviceName("iPhone 13");
                options.setFullReset(false);
                options.setApp(System.getProperty("user.dir") + "application address");

            }
        }
    }


    public static void quitDriver() {

        if (Objects.nonNull(MobileDriverManager.getDriver())) {

            MobileDriverManager.getDriver().quit();
            MobileDriverManager.unload();

        }
    }


}
