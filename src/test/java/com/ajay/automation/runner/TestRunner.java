package com.ajay.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (

		features =  "src/test/resources/Features",
		
		plugin = {
				"pretty",
				"html:target/cucumber-report.html",
				"json:target/cucumber-reports.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		
		glue = {"com.ajay.automation.stepdefs",
				"com.ajay.automation.hooks"},
		//  in @CucumberOptions, the glue should be the package name(s) where your step definitions and hooks are located.

//		tags = "@AlertHandling",
//		tags = {"@Sanity" , "@WindowHandling"}, not the correct way
//		tags = "not @WindowHandling",  //run all except @WindowHandling
		tags = "@KeyBoardActions",
//		tags = "@WindowHandling and @AlertHandling",
		dryRun = false, 
		monochrome = true


		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	//Extending AbstractTestNGCucumberTests is what allows TestNG to run your Cucumber scenarios.
	

}
