package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public class FilterProductPage {
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.zopsmart.stg.scarlet:id/btn_filter']")
    private WebElement filterButton;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/iv_arrow']")
    private WebElement brandButton;
    @FindBy(xpath = "(//android.widget.CheckBox[@resource-id='com.zopsmart.stg.scarlet:id/check_box'])[1]")
    private WebElement particularBrand;
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.zopsmart.stg.scarlet:id/btn_apply']")
    private WebElement applyButton;
    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_count'])[1]")
    private WebElement counttext;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_products_count']")
    private WebElement brandProductCount;
    @FindBy(xpath = "(//android.widget.CheckBox[@resource-id='com.zopsmart.stg.scarlet:id/check_box'])[1]")
    private WebElement brandText;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_brand_text']")
    private WebElement brandName;
    public FilterProductPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }
    public void clickonFilterButton(String testname){
        MobileExplicitWaitFactories.click(filterButton, WaitStrategy.CLICKABLE,"User clicked on FilterButton ");
        MobileTestLog.logTestStep(testname,"Click Filter  Button","User clicked on FilterButton ");
    }
    public void clickonBrandButton(String testname){
        MobileExplicitWaitFactories.click(brandButton, WaitStrategy.CLICKABLE,"User clicked on BrandButton ");
        MobileTestLog.logTestStep(testname,"Click Brand  Button","User clicked on BrandButton ");
    }
    public void clickonparticularBrand(String testname){
        MobileExplicitWaitFactories.click(particularBrand, WaitStrategy.CLICKABLE,"User clicked on particular Brand");
        MobileTestLog.logTestStep(testname,"Select particular Brand","User clicked on particular Brand ");
    }
    public void clickonapplyButton(String testname){
        MobileExplicitWaitFactories.click(applyButton, WaitStrategy.CLICKABLE,"User clicked on Apply button");
        MobileTestLog.logTestStep(testname,"Click on Apply Button","User clicked on apply button ");
    }
    public String getCountText(String testname){
        String value=MobileExplicitWaitFactories.getText(counttext,null,WaitStrategy.VISIBLE,"User clicked on count");
        return value;
    }
    public WebElement getBrandCountElement(String testname)
    {
        MobileTestLog.logTestStep(testname,"Verifying brand product count","Verifying the count of product");
        return brandProductCount;
    }
    public WebElement getBrandTextElement(String testname)
    {
        MobileTestLog.logTestStep(testname,"Verifying brand Text","Verifying the selected brand Text");
        return brandName;
    }
    public String getBrandText(String testname)
    {
        String value=MobileExplicitWaitFactories.getText(brandText,null,WaitStrategy.VISIBLE,"User verifying the brandtext");
        return value;
    }
}
