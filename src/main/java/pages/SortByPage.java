package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public class SortByPage {
    @FindBy(id = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_category_title' and @text='FRUITS & VEGETABLES']")
    private WebElement enterCategory;
    @FindBy(id = "//android.widget.Button[@resource-id='com.zopsmart.stg.scarlet:id/btn_sort']")
    private WebElement sortByButton;

    @FindBy(id = "//android.widget.RadioButton[@text='Newest']")
    private WebElement newestButton;

    @FindBy(id = "//android.widget.RadioButton[@text='Oldest']")
    private WebElement oldestButton;
    @FindBy(id = "//android.widget.RadioButton[@text='Popularity']")
    private WebElement popularityButton;
    public SortByPage() {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }


    public SortByPage performClickOnCategory(String testname) {
        MobileExplicitWaitFactories.click(enterCategory, WaitStrategy.CLICKABLE,"user clicked on  fruit and vegetable category");
        MobileTestLog.logTestStep(testname, "Perform Click On Category", "User clicked on Category");
        return new SortByPage();
    }
    public SortByPage performClickOnSortBy(String testname) {
        MobileExplicitWaitFactories.click(sortByButton, WaitStrategy.CLICKABLE,"user clicked on sort by button");
        MobileTestLog.logTestStep(testname, "Perform Click On Sort By Button", "User clicked on sort by button");
        return new SortByPage();
    }
    public SortByPage performClickOnNewest(String testname) {
        MobileExplicitWaitFactories.click(newestButton, WaitStrategy.CLICKABLE,"user clicked on newest button");
        MobileTestLog.logTestStep(testname, "Perform Click On Newest  Button", "User clicked on newest button");
        return new SortByPage();
    }
    public SortByPage performClickOnOldest(String testname) {
        MobileExplicitWaitFactories.click(sortByButton, WaitStrategy.CLICKABLE,"user clicked on sort by button");
        MobileExplicitWaitFactories.click(oldestButton, WaitStrategy.CLICKABLE,"user clicked on newest button");
        MobileTestLog.logTestStep(testname, "Perform Click On Newest  Button", "User clicked on newest button");
        return new SortByPage();
    }
    public SortByPage performClickOnPopularity(String testname) {
        MobileExplicitWaitFactories.click(sortByButton, WaitStrategy.CLICKABLE,"user clicked on sort by button");
        MobileExplicitWaitFactories.click(popularityButton, WaitStrategy.CLICKABLE,"user clicked on newest button");
        MobileTestLog.logTestStep(testname, "Perform Click On Newest  Button", "User clicked on newest button");
        return new SortByPage();
    }



}
