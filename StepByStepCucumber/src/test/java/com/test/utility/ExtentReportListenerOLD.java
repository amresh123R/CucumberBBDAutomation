package com.test.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExtentReportListenerOLD implements ConcurrentEventListener {
    private static ExtentReports extent = ExtentReportManagerOLD.getInstance();
    private static ExtentTest featureTest;
    private static ExtentTest scenarioTest;
    private Map<String, ExtentTest> featureMap = new HashMap<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, this::onTestRunStarted);
        publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::onTestStepFinished);
        publisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
    }

    private void onTestRunStarted(TestRunStarted event) {
        // Test Run Initialization
    }

    private void onTestCaseStarted(TestCaseStarted event) {
        // Capture feature and scenario
        String featureName = event.getTestCase().getUri().toString();
        String scenarioName = event.getTestCase().getName();

        // Tags handling
        List<String> tags = event.getTestCase().getTags();
        String tagString = tags.stream().map(tag -> tag.replace("@", "")).collect(Collectors.joining(", "));

        // Create feature node if it doesn't exist
        if (!featureMap.containsKey(featureName)) {
            featureTest = extent.createTest(featureName);
            featureMap.put(featureName, featureTest);
        }

        // Create scenario node with tags
        scenarioTest = featureMap.get(featureName).createNode(scenarioName).assignCategory(tagString);
    }

    private void onTestStepFinished(TestStepFinished event) {
        String stepName = event.getTestStep().toString();

        // Capture step results
        switch (event.getResult().getStatus()) {
            case PASSED:
                scenarioTest.pass(stepName);
                break;
            case FAILED:
                scenarioTest.fail(stepName);
                break;
            case SKIPPED:
                scenarioTest.skip(stepName);
                break;
            default:
                scenarioTest.info("Step status not recognized: " + stepName);
        }
    }

    private void onTestRunFinished(TestRunFinished event) {
        extent.flush(); // Write results to the report
    }
}
