package utiles;

import driver.MobileDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;


public class MobileScrollDownUtility {

    public static void scrollDown(WebDriver driver) {
        Dimension dimension = driver.manage().window().getSize();
        int startX = dimension.getWidth() / 2;
        int startY = (int) (dimension.getHeight() * 0.8);
        int endY = (int) (dimension.getHeight() * 0.2);
        int midY = (startY + endY) / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);

        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(new Pause(finger, Duration.ofMillis(200)));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, midY));
        scroll.addAction(new Pause(finger, Duration.ofMillis(200)));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(new Pause(finger, Duration.ofMillis(200)));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        try {
            MobileDriverManager.getDriver().perform(Collections.singletonList(scroll));
        } catch (Exception e) {
            System.out.println("Scroll action failed: " + e.getMessage());
        }
    }

    public static void scrollDownWithRetry(WebDriver driver) {
        int attempts = 0;
        boolean success = false;
        while (attempts < 3 && !success) {
            try {
                scrollDown(driver);
                success = true;
            } catch (Exception e) {
                attempts++;
                System.out.println("Retrying scroll action, attempt: " + attempts);
            }
        }
        if (!success) {
            throw new RuntimeException("Scroll action failed after 3 attempts");
        }
    }

}
