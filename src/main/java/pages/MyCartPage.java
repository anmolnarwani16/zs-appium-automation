package pages;

import driver.MobileDriverManager;
import enums.MobileLogType;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import frameConstatnt.testConstant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import reports.MobileExtentLogger;
import reports.MobileTestLog;
import utiles.MobileRegExUtility;
import utiles.MobileScrollDownUtility;

import java.util.ArrayList;
import java.util.List;

import static pages.SearchPage.itemNamePath;

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
    @FindBy(id ="(//android.view.ViewGroup[@resource-id='com.zopsmart.stg.scarlet:id/variant_layout_container'])[2]/android.view.ViewGroup")
    private WebElement secondVariant;
    @FindBy(xpath ="//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_price']")
    private WebElement itemPrice;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_item_selling_price']")
    private List<WebElement> sellingPrice;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/ib_add']")
    private List<WebElement> addIcon;
    @FindBy(xpath ="//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_quantity']")
    private List<WebElement> itemQuantity;
    @FindBy(xpath ="//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_value']")
    private WebElement quantityTextField;
    @FindBy(xpath ="//android.widget.Button[@resource-id='com.zopsmart.stg.scarlet:id/btn_YES']")
    private WebElement submitBtn;
    @FindBy(xpath ="//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement continueBtn;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/textView4']")
    private WebElement cartEmptyText;
    String itemPriceLocator="//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_price']";

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

    public String selectDifferentVariant(String testname){
        String variantPrice=secondVariant.getText();
        MobileExplicitWaitFactories.click(secondVariant,WaitStrategy.CLICKABLE,"user clicked on second variant");
        MobileTestLog.logTestStep(testname,"user clicked on substitution preference","user clicked on second variant");
        return variantPrice;
    }

    public void validateItemPrice(String expectedItemPrice, String testname){
        MobileTestLog.logTestStep(testname, "Get item price text", "Get item price text");
        String actualItemPrice=itemPrice.getText();
        Assert.assertEquals(expectedItemPrice, actualItemPrice);
    }

    public void validateItemsAddedSeparately(String itemName, ArrayList<String> expectedItemPrice, String testname) {
        for (int i = 1; i <= expectedItemPrice.size(); i++) {
            WebElement itemNameElement = MobileDriverManager.getDriver().findElement(By.xpath("(" + itemNamePath.replaceAll("\\$\\{.+?\\}", itemName) + ")[" + i + "]"));
            String actualItemName = itemNameElement.getText();

            MobileTestLog.logTestStep(testname, "Get item price text", "Get item price text");
            WebElement itemPriceElement = MobileDriverManager.getDriver().findElement(By.xpath("(" + itemPriceLocator + ")[" + i + "]"));
            String actualItemPrice = itemPriceElement.getText();

            if (actualItemName.contains(itemName) && actualItemPrice.contains(expectedItemPrice.get(i - 1))) {
                MobileExtentLogger.log(MobileLogType.PASS, "Validated items added separately");
            } else {
                MobileExtentLogger.log(MobileLogType.FAIL, "Unable to validated items added separately");
            }
        }
    }

        public void clickOrderAmountGreaterThanFifty(String testname){
            MobileTestLog.logTestStep(testname,"check for cart value greater than 50","checking if the cart value is greater than 50 or not");
            MobileScrollDownUtility.scrollDown(MobileDriverManager.getDriver());
            for (int i = 1; i < sellingPrice.size(); i++) {
                // Get the price element at index i
                WebElement priceElement = sellingPrice.get(i);
                Double itemPrice = MobileRegExUtility.extractNumbersFromString(priceElement);
                String addCartLocator="(//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/iv_item_image'])["+i+"]/following-sibling::android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_out_of_stock']";

                if (itemPrice > 50.00 && MobileExplicitWaitFactories.getCount(addCartLocator) == 0) {
                    WebElement addIconElement = addIcon.get(i);
                    MobileExplicitWaitFactories.click(addIconElement, WaitStrategy.CLICKABLE, "User clicked on add icon to add product into the cart");
                }

            }
        }

    public void clearCart(String testname){
        System.out.println("itemQuantity.size()==="+itemQuantity.size());
        while(itemQuantity.size()>0){
            MobileExplicitWaitFactories.click(itemQuantity.get(0), WaitStrategy.CLICKABLE,"Clicking the quantity field on cart page");
            MobileTestLog.logTestStep(testname,"Quantity text field Clicked","Clicking the quantity field on cart page");
            MobileExplicitWaitFactories.sendKeys(quantityTextField, "0", WaitStrategy.VISIBLE, "quantity value");
            MobileTestLog.logTestStep(testname, "Enter Current Password", "User enter current password");
            MobileExplicitWaitFactories.click(submitBtn, WaitStrategy.CLICKABLE,"Clicking the submit btn on quantity change panel");
            MobileTestLog.logTestStep(testname,"Submit button Clicked","Clicking the submit btn on quantity change panel");
            MobileExplicitWaitFactories.click(continueBtn, WaitStrategy.CLICKABLE,"Clicking the continue btn on quantity change panel");
            MobileTestLog.logTestStep(testname,"Continue button Clicked","Clicking the continue btn on quantity change panel");
        }

        if(cartEmptyText.getText().contains("Your cart is empty")) {
            MobileExtentLogger.log(MobileLogType.PASS, "Cart is empty");
        }else{
            MobileExtentLogger.log(MobileLogType.FAIL, "Cart is not empty");
        }
    }
}

