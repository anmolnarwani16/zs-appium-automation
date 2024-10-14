package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public final class SearchPage {
    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_search']")
    private WebElement searchTab;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_page_name']")
    private WebElement categoryTitle;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_item_name' and @text='Chilli Crushed-100G']")
    private WebElement item;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_item_name']")
    private WebElement itemTitle;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/navigation_icon']")
    private WebElement backButton;
    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_choose_variants'])[1]")
    private WebElement variantDropdown;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/ib_add']")
    private WebElement addIcons;
    public static String itemNamePath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_item_name' and contains(@text,'${text}')]";
    public static String variantPath ="(//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_selling_price'])[${i}]";

    public SearchPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }
    public void enterValueForSearchTab(String testname,String text){
        MobileExplicitWaitFactories.click(searchTab,WaitStrategy.VISIBLE,"user clicked the searchTab");
        MobileTestLog.logTestStep(testname, "Search Tab Clicked", "User clicked the searchTab");
        MobileExplicitWaitFactories.sendKeys(searchTab, text,WaitStrategy.VISIBLE,"user entered the text:- "+text);
        MobileTestLog.logTestStep(testname, "Entered Value", "User entered the text:- "+text);
        MobileExplicitWaitFactories.pressEnter("Pressed Enter button after entering search value");
        MobileTestLog.logTestStep(testname, "View the Search", "Pressed Enter button after entering search value");
    }
    public void itemInfo()
    {
        MobileExplicitWaitFactories.click(item,WaitStrategy.CLICKABLE,"user clicked on the item");
    }
    public WebElement getSearchedCategory(String testname){
        MobileTestLog.logTestStep(testname, "Validate Category", "Valid Category is displayed");
        return categoryTitle;
    }
    public WebElement getSearchedItem(String testname){
        MobileTestLog.logTestStep(testname, "Validate Item", "Valid Item is displayed");
        return itemTitle;
    }
    public void clickOnBackButton(String testname){
        MobileExplicitWaitFactories.click(backButton,WaitStrategy.CLICKABLE,"Going Back On Home Page");
        MobileTestLog.logTestStep(testname, "Back On HomePage", "Going Back On Home Page");

    }
    public WebElement  getSearchTabElement(String testname) {
        MobileTestLog.logTestStep(testname,"SearchTab Visibility","Verifying the appearance of Search Tab");
        return searchTab;
    }

    public SearchPage clickOnItem(String testname, String itemName){
        WebElement itemNameElement=MobileDriverManager.getDriver().findElement(By.xpath(itemNamePath.replaceAll("\\$\\{.+?\\}", itemName)));
        MobileExplicitWaitFactories.click(itemNameElement,WaitStrategy.CLICKABLE,"user clicked on search text field");
        MobileTestLog.logTestStep(testname, "clickOnSearchTextField", "User clicked on search text field");
        return new SearchPage();
    }

    public String selectDifferentVariant(String variant_index, String testname) {
        MobileExplicitWaitFactories.click(variantDropdown, WaitStrategy.CLICKABLE, "user clicked on variant dropdown");
        WebElement variantToBeSelected=MobileDriverManager.getDriver().findElement(By.xpath(variantPath.replaceAll("\\$\\{.+?\\}", variant_index)));
        MobileTestLog.logTestStep(testname, "user clicked on variant dropdown", "user clicked on variant dropdown");
        String variantItemPrice = variantToBeSelected.getText();
        MobileExplicitWaitFactories.click(variantToBeSelected, WaitStrategy.CLICKABLE, "user clicked on second variant");
        MobileTestLog.logTestStep(testname, "user clicked on second variant", "user clicked on second variant");
        return variantItemPrice;

    }

    public void clickOnAddIcons(String testname){
        MobileExplicitWaitFactories.click(addIcons, WaitStrategy.CLICKABLE,"User clicked on add icon to add product into the cart");
        MobileTestLog.logTestStep(testname,"Click Add  Button","User clicked on add icon to add product into the cart");
    }
}
