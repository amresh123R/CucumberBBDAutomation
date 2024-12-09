package com.test.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import java.util.HashMap;
import java.util.Map;

public class ExtentReportListenerwithouttag implements ConcurrentEventListener {
    private static ExtentReports extent = ExtentReportManagerOLD.getInstance();
    private static ExtentTest featureTest;
    private static ExtentTest scenarioTest;
    private Map<String, ExtentTest> featureMap = new HashMap<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, this::onTestRunStarted);
        publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::onTestStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
        publisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
    }

    private void onTestRunStarted(TestRunStarted event) {
        // Initialize the report at the start of the test run
    }

    private void onTestCaseStarted(TestCaseStarted event) {
        String featureName = event.getTestCase().getUri().toString();
        if (!featureMap.containsKey(featureName)) {
            featureTest = extent.createTest(featureName);
            featureMap.put(featureName, featureTest);
        }
        scenarioTest = featureMap.get(featureName).createNode(event.getTestCase().getName());
    }

    private void onTestStepFinished(TestStepFinished event) {
        if (event.getResult().getStatus() == Status.PASSED) {
            scenarioTest.pass(event.getTestStep().getCodeLocation());
        } else if (event.getResult().getStatus() == Status.FAILED) {
            scenarioTest.fail(event.getTestStep().getCodeLocation());
            System.out.println("Test case failed and need to take screenshot");
        }
    }

    private void onTestCaseFinished(TestCaseFinished event) {
        // Optional: Additional logic after each scenario
    }

    private void onTestRunFinished(TestRunFinished event) {
        extent.flush(); // Write the results to the report
    }
}
