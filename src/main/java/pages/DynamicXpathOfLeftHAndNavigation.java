package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicXpathOfLeftHAndNavigation {

    @FindBy(xpath = "//android.widget.TextView")
    private WebElement performClickAction1;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_subcategory_name' and @text='FRESH']")
    private WebElement clickOnFresh;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_hot_deals']")
    private WebElement hotDealsLink;

    public DynamicXpathOfLeftHAndNavigation(){
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    public DynamicXpathOfLeftHAndNavigation clickOnHotDealsLink() {
        MobileExplicitWaitFactories.click(hotDealsLink, WaitStrategy.CLICKABLE, " user clciked on the hotDealsLink");
        return this;
    }

    public DynamicXpathOfLeftHAndNavigation clickOnFresh() {
        MobileExplicitWaitFactories.click(clickOnFresh, WaitStrategy.CLICKABLE, " user clciked on the clickOnFresh");
        return this;
    }

    public void performClickActionOnGivenElementInLeftHandNavigation(String elementNameAsText1, WebDriver driver){

            String formattedElemet1 = String.format("//android.widget.TextView[@text='%s']", elementNameAsText1);
            WebElement finalElement1 = performClickAction1.findElement(By.xpath(formattedElemet1));
             finalElement1.click();
            //MobileExplicitWaitFactories.click(finalElement1, WaitStrategy.CLICKABLE, " user clicke on the " + elementNameAsText1 + " icon");




        //android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_hot_deals']

        //android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_subcategory_name' and @text='FRESH']
        //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/tv_subcategory_name" and @text="FOOD & BEVERAGES"]
        //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/tv_subcategory_name" and @text="HEALTHY LIVING"]
        //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/tv_subcategory_name" and @text="HEALTH & BEAUTY"]
        //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/tv_subcategory_name" and @text="BBQ ACCESSORIES"]
        //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/tv_subcategory_name" and @text="BABY"]
        //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/tv_subcategory_name" and @text="HOUSEHOLD"]
        //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/tv_subcategory_name" and @text="PETS"]
        //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/tv_subcategory_name" and @text="TAMIMI"]
        //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/tv_subcategory_name" and @text="IMPORTED ✈"]
        //android.widget.TextView[@resource-id="com.zopsmart.stg.scarlet:id/tv_subcategory_name" and @text="RECIPES"]

        //android.widget.TextView[@text='Facebook']
        //android.widget.TextView[@text="Twitter"]
        //android.widget.TextView[@text="Logout"]

    }

    private WebElement waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(MobileDriverManager.getDriver(), Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
