package com.skunkworks.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.skunkworks.reporting.ExtentManager;
import com.skunkworks.reporting.ExtentTestManager;
import com.skunkworks.utils.BasicUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.setTest(ExtentManager.getExtent().createTest(result.getMethod().getMethodName()));
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        Throwable t = result.getThrowable();

        String TestImage = BasicUtils.capture();
        if (TestImage != null) {
            ExtentTestManager.getTest().fail(t.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(TestImage).build());
        } else {
            ExtentTestManager.getTest().fail(t.getMessage());
        }
        ExtentTestManager.getTest().info("Exception Type: " + t.getClass().getSimpleName());
    }
    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtent().flush();
    }
}
