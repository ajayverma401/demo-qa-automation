package com.ajay.automation.hooks;

//import java.io.IOException;
import com.ajay.automation.base.BaseClass;
import com.ajay.automation.utils.ScreenshotsUtils;
//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@Before
	public void setupBrowser() {
		browserSetup();
	}

//	@AfterStep
	public void takeScreenshotAtEveryStep(Scenario scenario) {
		/* ScreenshotsUtils.captureScreenshot(scenario.getName().replaceAll("[^a-zA-Z0-9]", "_"));
		scenario.attach(ScreenshotsUtils.captureScreenshot(scenario.getName().replaceAll("[^a-zA-Z0-9]", "_")),
				"image/png", scenario.getName().replaceAll("[^a-zA-Z0-9]", "_"));  */

		byte[] screenshotBytes = ScreenshotsUtils.captureScreenshotAsBytes();

		// 2. Attach the bytes to the Cucumber Scenario
		// ExtentReports will automatically find this attachment and add it to the report
		if (screenshotBytes != null) {
			scenario.attach(screenshotBytes, "image/png", scenario.getName());
		}
	}

	@After
	public void tearDown(){
		browserTearDown();
	}

}
