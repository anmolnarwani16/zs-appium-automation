package listeners;

import enums.MobileLogType;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.MobileExtendReport;
import reports.MobileExtentLogger;
import reports.MobileTestFailure;


public class MobileListenersClass implements ITestListener, ISuiteListener {


    @Override
    public void onStart(ISuite suite) {
        try {
            MobileExtendReport.initReports();
            System.out.println("Suite started: " + suite.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            MobileExtendReport.flushReports();
            System.out.println("Suite finished: " + suite.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        MobileExtendReport.createTest(methodName);
        System.out.println("Test started: " + methodName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            MobileExtentLogger.log(MobileLogType.PASS,result.getMethod().getMethodName() + " is passed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            // MobileExtentLogger.log(MobileLogType.FAIL, result.getMethod().getMethodName() + " has failed");
            Throwable throwable = result.getThrowable();
            if (throwable != null) {
                // Log the exception message
                MobileExtentLogger.log(MobileLogType.FAIL, throwable.getMessage());
                // Get the stack trace elements
                StackTraceElement[] stackTrace = throwable.getStackTrace();
                // Check if the stack trace is not empty
                if (stackTrace.length > 0) {
                    // Get the first element of the stack trace
                    StackTraceElement errorLine = stackTrace[0];
                    // Log and print only the error line
                    // MobileExtentLogger.log(MobileLogType.FAIL, errorLine.toString());
                    System.out.println("Test failed: " + result.getMethod().getMethodName());
                    System.out.println("    " + errorLine.toString());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            MobileExtentLogger.log(MobileLogType.FAIL,result.getMethod().getMethodName() + " is Skipped");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /* For now, we are not using this */
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        /* For now, we are not using this */
    }

    @Override
    public void onStart(ITestContext context) {
        /*
         * We are having just one test in our suite, so we don't have any special
         * implementation as of now
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
         * We are having just one test in our suite, so we don't have any special
         * implementation as of now
         */
    }

}
