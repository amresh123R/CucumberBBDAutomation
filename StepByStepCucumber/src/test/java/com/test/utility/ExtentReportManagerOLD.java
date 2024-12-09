package com.test.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManagerOLD {
    private static ExtentReports extent;

    private ExtentReportManagerOLD() {
        // Prevent instantiation
    }

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReports.html");
            sparkReporter.config().setReportName("Cucumber Test Execution Report");
            sparkReporter.config().setDocumentTitle("Test Report");
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
}