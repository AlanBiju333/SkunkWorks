package com.skunkworks.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/extent-report/ExtentReport.html");
            reporter.config().setReportName("SkunkWorks Automation Report");
            reporter.config().setDocumentTitle("Test Execution Report");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
