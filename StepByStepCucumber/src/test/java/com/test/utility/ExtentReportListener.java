package com.test.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

public class ExtentReportListener implements ConcurrentEventListener {
    private ExtentReports extent = ExtentReportManager.getInstance();
    private ExtentTest featureTest;
    private ExtentTest scenarioTest;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::onTestStepFinished);
        publisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
    }

    private void onTestCaseStarted(TestCaseStarted event) {
        featureTest = extent.createTest(event.getTestCase().getUri().toString());
        scenarioTest = featureTest.createNode(event.getTestCase().getName());
    }

    private void onTestStepFinished(TestStepFinished event) {
        if (event.getResult().getStatus().is(Status.PASSED)) {
            scenarioTest.pass(event.getTestStep().toString());
        } else if (event.getResult().getStatus().is(Status.FAILED)) {
            scenarioTest.fail(event.getTestStep().toString() + " Exception: " + event.getResult().getError());
        } else {
            scenarioTest.skip(event.getTestStep().toString());
        }
    }

    private void onTestRunFinished(TestRunFinished event) {
        extent.flush();
    }
}
