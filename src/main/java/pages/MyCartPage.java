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
import utiles.MobileRegExUtility;

public final   class MyCartPage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/button_checkout")
    private WebElement checkOutButton;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/ib_remove'])[1]")
    private  WebElement SubtractButton;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/ib_add']")
    private WebElement AddButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_quantity']")
    private  WebElement ProductQuantity;
    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_quantity'])[1]")
    private  WebElement ItemQuantity;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/toolbar_title']")
    private  WebElement CartTag;
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Replace with equivalent']")
    private WebElement replaceButton;
    @FindBy(id = "com.zopsmart.stg.scarlet:id/select_substitution_spinner")
    private WebElement selectSubstitutionButton;
    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_item_name'])[1]")
    private WebElement firstItemName;
    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_item_name'])[1]")
    private WebElement itemName;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_item_name' and @text='Fancy Flower Bouquet - 1PCS']/../android.view.ViewGroup/android.widget.ImageView[2]")
    private WebElement itemNameAddButton;
    @FindBy(id = "com.zopsmart.stg.scarlet:id/tv_sub_total_amount")
    private WebElement subTotal;
    @FindBy(id = "com.zopsmart.stg.scarlet:id/tv_total_vat_amount")
    private WebElement vatAmount;
    public MyCartPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }
    public WebElement getCheckOutButtonElement(String testname){
        MobileTestLog.logTestStep(testname,"Validate the checkout button","Validating the display of checkout Button");
        return checkOutButton;
    }

    public void clickOnAddButton(String testname) {
        MobileExplicitWaitFactories.click(AddButton, WaitStrategy.CLICKABLE,"Clicking the Add Button");
        MobileTestLog.logTestStep(testname,"Add Button Clicked","User clicked on Add Button");
    }
    public void clickOnSubtractButton(String testname) {
        MobileExplicitWaitFactories.click(SubtractButton, WaitStrategy.CLICKABLE,"Clicking the Subtract Button");
        MobileTestLog.logTestStep(testname,"Subtract Button Clicked","User clicked on Subtract Button");
    }
    public  int  checkTheAddedItemValue(String testname) {
        int value = Integer.parseInt(MobileExplicitWaitFactories.getText(ItemQuantity,null,WaitStrategy.VISIBLE,"Quantity of item in the Cart"));
//        if(value<2)
//        {
//            new FruitCategoryPage().clickOnAddIcon(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
//            value++;
//        }
        MobileTestLog.logTestStep(testname,"Verifying the Quantity","Verifying the Quantity of Item in Cart");
        return value;
    }
    public  void removeItemFromCart(String testname) {
        MobileExplicitWaitFactories.click(SubtractButton,WaitStrategy.CLICKABLE,"Removing item from Cart");
        MobileTestLog.logTestStep(testname,"RemovingItem","User Clicked on removing Item from Cart");
    }
    public  WebElement getQuantityElement(String testname) {
        MobileTestLog.logTestStep(testname,"Verifying the Quantity Value","Verifying the Quantity Value from Cart");
        return ItemQuantity;
    }
    public  WebElement getCartTag(String testname)
    {
        return CartTag;
    }
    public MyCartPage selectReplaceWithEquivalent(String testname){
        MobileExplicitWaitFactories.click(replaceButton,WaitStrategy.CLICKABLE,"user clicked on replace with equivalent option");
        MobileTestLog.logTestStep(testname,"user clicked on substitution preference","user clicked on replace with equivalent option");
        return new MyCartPage();
    }
    public MyCartPage selectSubstitution(String testname){
        MobileExplicitWaitFactories.click(selectSubstitutionButton, WaitStrategy.CLICKABLE,"user clicked on select substitution button");
        MobileTestLog.logTestStep(testname,"user clicked select substitution","user clicked on select substitution button for choosing substition preference");
        return new MyCartPage();
    }
    public CheckoutPage clickOnCheckoutButton(String testname){
        MobileExplicitWaitFactories.click(checkOutButton,WaitStrategy.CLICKABLE,"user clicked on chechout button");
        MobileTestLog.logTestStep(testname,"clicked checkout button","user clicked on checkout button");
        return new CheckoutPage();
    }
    public String clickOnItemName(String testname)
    {
        String ItemName=MobileExplicitWaitFactories.getText(firstItemName,null,WaitStrategy.VISIBLE,"User clicked on Item Name");
        return ItemName;
    }
    public String checkTheText(String testname)
    {
        String str=itemName.getText();
        new HomePage().clickOnCartIcon(Constant.ADDORSUBTRACT_PRODUCT_TEST_NAME);
        String dynamicXPath = String.format("//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_item_name' and @text='%s']/../android.view.ViewGroup/android.widget.ImageView[2]",str);
        return str;
    }


public boolean orderAmountGreaterThanFifty(String testname){
    MobileTestLog.logTestStep(testname,"check for cart value greater than 50","checking if the cart value is greater than 50 or not");
    double subTotalAmount = MobileRegExUtility.extractNumbersFromString(subTotal);
    double vatTotalAmount = MobileRegExUtility.extractNumbersFromString(vatAmount);
    if(subTotalAmount+vatTotalAmount >= 50){
        return true;
    }else{
        return false;
    }
}
}

