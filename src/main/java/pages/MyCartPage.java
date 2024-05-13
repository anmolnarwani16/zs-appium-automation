package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public class MyCartPage {
    @FindBy(id = "com.zopsmart.stg.scarlet:id/button_checkout")
    private WebElement checkOutButton;
    @FindBy(id = "com.zopsmart.stg.scarlet:id/select_substitution_spinner")
    private WebElement selectSubstitutionButton;
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Replace with equivalent']")
    private WebElement replaceButton;
    public MyCartPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }
    public WebElement getCheckOutButtonElement(String testname){
        MobileTestLog.logTestStep(testname,"Validate the checkout button","Validating the display of checkout Button");
        return checkOutButton;
    }
    public MyCartPage selectSubstitution(String testname){
        MobileExplicitWaitFactories.click(selectSubstitutionButton, WaitStrategy.CLICKABLE,"user clicked on select substitution button");
        MobileTestLog.logTestStep(testname,"user clicked select substitution","user clicked on select substitution button for choosing substition preference");
        return new MyCartPage();
    }
    public MyCartPage selectReplaceWithEquivalent(String testname){
        MobileExplicitWaitFactories.click(replaceButton,WaitStrategy.CLICKABLE,"user clicked on replace with equivalent option");
        MobileTestLog.logTestStep(testname,"user clicked on substitution preference","user clicked on replace with equivalent option");
        return new MyCartPage();
    }
    public CheckoutPage clickOnCheckoutButton(String testname){
        MobileExplicitWaitFactories.click(checkOutButton,WaitStrategy.CLICKABLE,"user clicked on chechout button");
        MobileTestLog.logTestStep(testname,"clicked checkout button","user clicked on checkout button");
        return new CheckoutPage();
    }
}
