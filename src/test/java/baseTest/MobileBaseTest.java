package baseTest;

import java.io.IOException;
import java.util.Map;

import driver.MobileDriver;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;


public class MobileBaseTest {


    @AfterSuite
    public void tearDown() {
        MobileDriver.quitDriver();

    }

}
