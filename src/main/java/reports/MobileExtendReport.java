package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import frameConstatnt.MobileFrameConstant;


public class MobileExtendReport {

    private MobileExtendReport() {

    }

    private static ExtentReports extentReports;
    //public static ExtentTest createTest;

    public static void initReports() throws Exception {

        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(MobileFrameConstant.getExtentReportFilePath());
            extentReports.attachReporter(extentSparkReporter);

            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setDocumentTitle("Mobile test report");
            extentSparkReporter.config().setReportName("Mobile test");
        }
    }

    public static void flushReports() throws Exception {

        if (Objects.nonNull(extentReports)) {
            extentReports.flush();

            try {
                Desktop.getDesktop().browse(new File(MobileFrameConstant.getExtentReportFilePath()).toURI());
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }

    public static void createTest(String testcaseName) {
        //ExtentTest createTest = extentReports.createTest(testcaseName);
        MobileExtentManager.setExtentTest(extentReports.createTest(testcaseName));
    }

}
