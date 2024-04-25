package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicElementByXPath {

    @FindBy(xpath = "//android.widget.FrameLayout")
    private WebElement performClickAction;

    public DynamicElementByXPath(){
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    public void performClickActionOnGivenElement(String elementNameAsText){

        String formattedElemet=String.format("//android.widget.FrameLayout[@content-desc='%s']",elementNameAsText);
       WebElement finalElement= performClickAction.findElement(By.xpath(formattedElemet));
        MobileExplicitWaitFactories.click(finalElement, WaitStrategy.CLICKABLE," user clicke on the "+elementNameAsText+" icon");


    }
}
