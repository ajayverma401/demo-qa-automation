package com.ajay.automation.stepdefs;

//import org.openqa.selenium.Alert;
import org.testng.Assert;

//import org.openqa.selenium.WebDriver;

import com.ajay.automation.base.BaseClass;
import com.ajay.automation.pages.Alerts_Frames_WindowsPages;
import com.ajay.automation.utils.ConfiReaderUtils;
import com.ajay.automation.utils.HandleAlertsUtils;
import com.ajay.automation.utils.HandleFramesUtils;
import com.ajay.automation.utils.JSActionsUtils;
import com.ajay.automation.utils.WindowHandleUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Alerts_Tabs_WindowTabSteps extends Alerts_Frames_WindowsPages {
	
		
	@Given("user is on the Alerts Frames and windows page")
	public void user_is_on_the_alerts_frames_and_windows_page() {
		BaseClass.getDriver().get(ConfiReaderUtils.get("alertsWindow"));
	}
	
	@When("user click on Browser Windows section")
	public void user_click_on_browser_windows_section() {
		clickOnBrowserWindowsSection();
	}
	
	@When("user click on {string}")
	public void user_click_on(String buttonType) throws InterruptedException {
		
		
		switch(buttonType) {
	    case "New Tab" :
//	    	Thread.sleep(5000);
	    	JSActionsUtils.scrollIntoView(getNewTabButton());
//	    	Thread.sleep(5000);
	    	clickOnNewTabButton();
	    	break;
	    	
	    case "New Window" :
//	    	Thread.sleep(5000);
	    	JSActionsUtils.scrollIntoView(getNewWindowButton());
//	    	Thread.sleep(5000);
	    	clickOnNewWindowButton();
	    	break;
	    	
	    case "New Window Message" :
//	    	Thread.sleep(5000);
	    	JSActionsUtils.scrollIntoView(getMessageWindowButton());
//	    	Thread.sleep(5000);
	    	clickOnMessageWindowButton();
	    	break;
	    	
	    default:
	    	System.out.println("Invalid button type: " + buttonType);
	    	break;
	    }
	}
	
	
	@Then("a new window gets opened with {string}")
	public void a_new_window_gets_opened_with(String expectedText) {
	    String parentWindow = BaseClass.getDriver().getWindowHandle();
	    WindowHandleUtils.switchToChild();
	    Assert.assertTrue(BaseClass.getDriver().getPageSource().contains(expectedText));
	    WindowHandleUtils.closeChildAndSwitchBack(parentWindow);
	}
	
	@When("the user clicks on Alerts section")
	public void the_user_clicks_on_Alerts_section() {
		clickOnAlertsSection();
	}
	
	@When("the user clicks on the {string} button under {string}")
	public void the_user_clicks_on_the_button_under(String buttonText, String sectionText) throws InterruptedException {
		clickOnClickMeToSeeAlertButton();
		
	}
	
	@Then("an alert should be displayed with text {string}")
	public void an_alert_should_be_displayed_with_text(String expectedText) {
		String alertTxtNew = HandleAlertsUtils.getAlertText();
		/* Alert alert = BaseClass.getDriver().switchTo().alert();
		String alertText = alert.getText(); */
		System.out.println("Alert Text: " + alertTxtNew);
	    Assert.assertEquals(alertTxtNew, expectedText);
	}
	
	@Then("the user accepts the alert")
	public void the_user_accepts_the_alerts() {
		/* Alert alert = BaseClass.getDriver().switchTo().alert();
	    alert.accept(); */
		HandleAlertsUtils.acceptAlert();
	}
	
	
	@When("The user clicks on Nested Frames section")
	public void the_user_clicks_on_nested_frames_section() {
	    JSActionsUtils.scrollIntoView(getNestedFramesSection());
	    clickOnNestedFramesSection();
	}
	
	@When("The user switches to the parent frame")
	public void the_user_switches_to_the_parent_frame() {
		HandleFramesUtils.switchToFrameByElement(getParentFrame());
		System.out.println("Text inside the parentFrame is: "+getParentFrameText().getText());
	}
	
	@When("The user switches to the child frame inside the parent frame")
	public void the_user_switches_to_the_child_frame_inside_the_parent_frame() {
		HandleFramesUtils.switchToFrameByIndex(0);
		
	}
	
	@Then("the user should be able to see the text inside the {string}")
	public void the_user_should_be_able_to_see_the_text_inside_the(String string) {
		String childFrameText = getChildFrameText().getText();
	    System.out.println("Text inside child frame: " + childFrameText);
	    Assert.assertEquals(childFrameText, "Child Iframe");
	}
	
	@Then("The user should be able to switch back to default page")
	public void the_user_should_be_able_to_switch_back_to_default_page() {
		HandleFramesUtils.switchBackToDefault();
		String DefaultPageTitle = BaseClass.getDriver().getTitle();
		System.out.println(DefaultPageTitle);
		Assert.assertEquals(DefaultPageTitle, "DEMOQA");
	}

	
}