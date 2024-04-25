package utiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MobileActionClassUtils {
	
	public static void mouseHoverActions(WebElement element ,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public static void rightClickActions(WebElement element ,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).contextClick().build().perform();
	}
	
	public static void doubleClickActions(WebElement element ,WebDriver driver){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).doubleClick().build().perform();
		
	}
	
	public static void clickOffsetFromElement(WebDriver driver){
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 1).click().build().perform();
		
	}
	
	public static void scrollDown(WebDriver driver,WebElement scrollToElement){
		Actions actions = new Actions(driver);
		actions.scrollToElement(scrollToElement).build().perform();
		
	}
	
	public static void clickAction(WebDriver driver,WebElement scrollToElement){
		Actions actions = new Actions(driver);
		actions.moveToElement(scrollToElement).click().build().perform();
		
	}
	
	public static void clickHoldAndDrop(WebDriver driver,WebElement sourceElement , int xAxis , int yAxis){
		Actions actions = new Actions(driver);
		actions.clickAndHold(sourceElement).moveByOffset(xAxis, yAxis).release().build().perform();
		
	}
	
	public static void drangAndDrop(WebDriver driver,WebElement sourceElement , WebElement targetElement){
		Actions actions = new Actions(driver);
		actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
		
	}

}
