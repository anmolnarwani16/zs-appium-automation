package driver;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;


import frameConstatnt.MobileFrameConstant;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import utiles.JsonFileRederUtils;

public class MobileDriver {

    public static void initDriver() throws IOException, ParseException {

        JSONObject data = JsonFileRederUtils.readJSONFromFile(MobileFrameConstant.jsonFilePath());

        if (Objects.isNull(MobileDriverManager.getDriver())) {

            UiAutomator2Options option = new UiAutomator2Options();
            // optional if not mentioned it will take by default;
            option.setPlatformName(data.get("PlatformName").toString());
            option.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
            option.setAppActivity(data.get("AppActivity").toString());

            // device name have to mention
            option.setDeviceName(data.get("DeviceName").toString());
            option.setApp(MobileFrameConstant.getAndroidApplication());

            MobileDriverManager.setDriver(new AndroidDriver(new URL(data.get("url").toString()), option));

        }
    }


    public static void quitDriver() {

        if (Objects.nonNull(MobileDriverManager.getDriver())) {

            MobileDriverManager.getDriver().quit();
            MobileDriverManager.unload();

        }
    }


}
