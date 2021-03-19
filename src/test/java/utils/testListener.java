package utils;


import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreports.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.annotation.Annotation;



public class testListener implements ITestListener {

    static ExtentTest test;

    @Override
    public void onTestStart(ITestResult iTestResult) {

        if (iTestResult != null) {
            String testName = iTestResult.getName();
            Log.addLog(testName + " is RUNNING...");

        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        if (iTestResult != null) {
            String testName = iTestResult.getName();
            Log.addLog(testName + " is Passed");
            ExtentReport.shared().getExtentTest().log(Status.PASS, "Test Passed");

        }
    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {

        if (iTestResult != null) {
            String testName = iTestResult.getName();
            Log.addLog(testName + " is FAILED...");
            ExtentReport.shared().getExtentTest().log(Status.FAIL, "Test Failed");
            ExtentReport.shared().getExtentTest().fail(iTestResult.getThrowable());
            if (iTestResult.getStatus() == iTestResult.FAILURE) {
                String screenShotPath = MobileActions.Screenshot("Failed");

                try {
                    ExtentReport.shared().getExtentTest().addScreenCaptureFromPath(screenShotPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {


        if (iTestResult != null) {
            String testName = iTestResult.getName();
            Log.addLog(testName + " is SKIPPED...");
            ExtentReport.shared().getExtentTest().log(Status.SKIP, "Test Skipped");


        }
    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.addLog(" onTestFailedButWithinSuccessPercentage ");

    }


    @Override
    public void onStart(ITestContext iTestContext) {

        Log.addLog("=====START TEST=====");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        Log.addLog("=====FINISH TEST=====");
    }

    private Annotation getAnnotation(ITestResult result, Class T) {
        return result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(T);

    }
}
