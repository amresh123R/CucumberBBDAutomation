package com.QATesting.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@Smoke or @Regression",
				features = {"src/test/resources/features"}, glue = {"com.QATesting.Stepdefs"},
                  plugin = { "pretty",
                		  	"html:target/Cucumber-reports.html",
                		  	"json:target/Cucumber.json",
                		  	"com.test.utility.ExtentReportListener"
                		  	},
                  monochrome = true, publish = true)
public class QARunner extends AbstractTestNGCucumberTests{

}
