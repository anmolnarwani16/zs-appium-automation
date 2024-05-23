package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public class LanguagePreferencePage {
    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.zopsmart.stg.scarlet:id/tv_select_arab']")
    private WebElement arabicLanguage;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_header']")
    private WebElement languageTitle;

    public LanguagePreferencePage() {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    public void selectLanguage(String testname) {
        MobileExplicitWaitFactories.click(arabicLanguage, WaitStrategy.CLICKABLE, "User selected Arabic Language");
        MobileTestLog.logTestStep(testname, "Arabic Language selected", "User selected Arabic Language");
    }

    public WebElement getLanguage(String testname) {
        MobileTestLog.logTestStep(testname, "Validate Language", "Valid Language is dispalyed");
        return languageTitle;
    }
}

