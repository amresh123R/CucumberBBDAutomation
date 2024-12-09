package com.multi.stepdefs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "@Smoke or @Regression",
					features = "src/test/resources/featureMutliDefs",
					glue = "com.multi.stepdefs",
					plugin = { "pretty", "html:target/Cucumber-reports.html", "json:target/Cucumber.json",
							"com.test.utility.ExtentReportListener"},
	                  monochrome = true, publish = true)
public class RunnerMultiFile extends AbstractTestNGCucumberTests{

}
