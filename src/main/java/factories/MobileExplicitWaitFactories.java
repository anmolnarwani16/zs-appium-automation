package factories;

import java.time.Duration;

import driver.MobileDriverManager;
import enums.MobileLogType;
import enums.WaitStrategy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.MobileExtentLogger;


public class MobileExplicitWaitFactories {

    public static void click(WebElement element, WaitStrategy waitStrategy, String description) {
        waitUntilCondition(element, waitStrategy);
        element.click();

        try {
            MobileExtentLogger.log(MobileLogType.PASS, description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendKeys(WebElement element, String value, WaitStrategy waitStrategy, String description) {
        waitUntilCondition(element, waitStrategy);
        element.sendKeys(value);

        try {
            MobileExtentLogger.log(MobileLogType.PASS, "User entered *********" + description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getText(WebElement element, String enterExpectedText, WaitStrategy waitStrategy, String description) {
        waitUntilTextVisible(element, waitStrategy, enterExpectedText);
        String str = element.getText();

        try {
            MobileExtentLogger.log(MobileLogType.PASS, description);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private static void waitUntilCondition(WebElement element, WaitStrategy waitStrategy) {
        WebDriverWait wait = new WebDriverWait(MobileDriverManager.getDriver(), Duration.ofSeconds(10));

        switch (waitStrategy) {
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case PRESENCE:
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case INVISIBLE:
                wait.until(ExpectedConditions.invisibilityOf(element));
                break;
            case SELECTED:
                wait.until(ExpectedConditions.elementToBeSelected(element));
                break;
            case ATTRIBUTE_CONTAINS:
                String attributeName = "data-id";
                String attributeValue = element.getAttribute(attributeName);
                wait.until(ExpectedConditions.attributeContains(element, attributeName, attributeValue));
                break;
            case URL_CONTAINS:
                String partialUrl = MobileDriverManager.getDriver().getCurrentUrl();
                wait.until(ExpectedConditions.urlContains(partialUrl));
                break;
            case ALERT_PRESENT:
                wait.until(ExpectedConditions.alertIsPresent());
                break;
            case ELEMENT_TO_BE_SELECTED:
                wait.until(ExpectedConditions.elementToBeSelected(element));
                break;
            case ELEMENT_TO_HAVE_TEXT:
                // Infer expected text dynamically
                String expectedText = element.getText();
                wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
                break;
            // Add more cases for other wait strategies if needed
        }
    }

    public static void pressEnter(String description) {
        MobileDriverManager.getDriver().pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        try {
            MobileExtentLogger.log(MobileLogType.PASS, description);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void waitUntilTextVisible(WebElement element, WaitStrategy waitStrategy, String enterExpectedText) {
        WebDriverWait wait = new WebDriverWait(MobileDriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(element, enterExpectedText));


    }
}
