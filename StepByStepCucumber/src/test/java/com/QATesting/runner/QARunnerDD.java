package com.QATesting.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				features = {"src/test/resources/featuresDataDriven"}, 
				glue = {"com.QA.DD.test"},
                  plugin = { "pretty",
                		  	"html:target/Cucumber-reports.html",
                		  	"json:target/Cucumber.json",
                		  	"com.test.utility.ExtentReportListener"
                		  	},
                  monochrome = true, publish = true)
public class QARunnerDD extends AbstractTestNGCucumberTests{

}
