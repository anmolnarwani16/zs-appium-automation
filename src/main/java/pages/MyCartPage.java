package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestFailure;
import reports.MobileTestLog;

public class MyCartPage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/button_checkout")
    private WebElement checkOutButton;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/ib_remove']")
    private static WebElement SubtractButton;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/ib_add']")
    private WebElement AddButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_quantity']")
    private static WebElement ProductQuantity;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/toolbar_title']")
    private static WebElement CartTag;
    public MyCartPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }
    public WebElement getCheckOutButtonElement(String testname){
        MobileTestLog.logTestStep(testname,"Validate the checkout button","Validating the display of checkout Button");
        return checkOutButton;
    }

    public void ClickOnAddButton(String testname) {
        MobileExplicitWaitFactories.click(AddButton, WaitStrategy.CLICKABLE,"Clicking the Add Button");
        MobileTestLog.logTestStep(testname,"Add Button Clicked","User clicked on Add Button");
    }
    public void ClickOnSubtractButton(String testname) {
        MobileExplicitWaitFactories.click(SubtractButton, WaitStrategy.CLICKABLE,"Clicking the Subtract Button");
        MobileTestLog.logTestStep(testname,"Subtract Button Clicked","User clicked on Subtract Button");
    }
    public static int  checkTheAddedItemValue(String testname) {
       int value = Integer.parseInt(MobileExplicitWaitFactories.getText(ProductQuantity,null,WaitStrategy.VISIBLE,"Quantity of item in the Cart"));
        if(value<2)
        {
            new FruitCategoryPage().clickOnAddIcon(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
            value++;
        }
        MobileTestLog.logTestStep(testname,"Verifying the Quantity","Verifying the Quantity of Item in Cart");
       return value;
    }
    public static void removeItemFromCart(String testname) {
            MobileExplicitWaitFactories.click(SubtractButton,WaitStrategy.CLICKABLE,"Removing item from Cart");
            MobileTestLog.logTestStep(testname,"RemovingItem","User Clicked on removing Item from Cart");
    }
    public static WebElement getQuantityElement(String testname) {
         MobileTestLog.logTestStep(testname,"Verifying the Quantity Value","Verifying the Quantity Value from Cart");
         return ProductQuantity;
    }
    public static WebElement getCartTag(String testname)
    {
        return CartTag;
    }
}
