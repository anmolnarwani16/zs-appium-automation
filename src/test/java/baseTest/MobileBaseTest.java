package baseTest;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import driver.MobileDriver;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;


public  class MobileBaseTest {
//    @BeforeMethod
//    public void setUp(Object[] data) throws IOException, ParseException {
//        Map<String,String>map= (Map<String, String>) data[0];
//
//        MobileDriver.initDriver(map.get("platformName"));
//    }

    @AfterSuite
    public void tearDown() {
        MobileDriver.quitDriver();

    }

}
