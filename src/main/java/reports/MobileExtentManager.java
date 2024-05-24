package reports;

import com.aventstack.extentreports.ExtentTest;

public class MobileExtentManager {
    private MobileExtentManager() {

    }

    private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>();

    static ExtentTest getExtentTest() {
        return exTest.get();
    }

    static void setExtentTest(ExtentTest test) {

        exTest.set(test);

    }

    static void unload() {
        exTest.remove();
    }

}
