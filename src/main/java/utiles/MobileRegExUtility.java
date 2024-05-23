package utiles;

import driver.MobileDriverManager;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileRegExUtility {


    public static Double extractNumbersFromString(WebElement element) {
        // Define the regular expression to find all numbers (integer or decimal)
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(element.getText());

        // Use a StringBuilder to collect the numbers
        StringBuilder numberString = new StringBuilder();

        // Find all matching number patterns
        while (matcher.find()) {
            numberString.append(matcher.group());
        }

        // Convert the collected digits to a double if any digits were found
        if (numberString.length() > 0) {
            return Double.parseDouble(numberString.toString());
        } else {
            return null;  // Return null if no digits were found
        }
    }

}
