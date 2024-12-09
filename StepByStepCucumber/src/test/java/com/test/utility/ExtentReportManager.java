package com.test.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Set up ExtentSparkReporter
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
            sparkReporter.config().setDocumentTitle("BDD Test Report");
            sparkReporter.config().setReportName("BDD Execution Report");
            sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);

            // Initialize ExtentReports
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Add system information
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
