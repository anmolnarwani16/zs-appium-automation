package baseTest;

import driver.MobileDriver;
import org.testng.annotations.AfterSuite;


public class MobileBaseTest {


    @AfterSuite
    public void tearDown() {
        MobileDriver.quitDriver();

    }

}
