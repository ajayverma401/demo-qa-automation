package com.ajay.automation.stepdefs;

import java.io.IOException;

import org.testng.Assert;

import com.ajay.automation.base.BaseClass;
import com.ajay.automation.pages.ElementsTabPages;
import com.ajay.automation.utils.ConfiReaderUtils;
import com.ajay.automation.utils.JSActionsUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ElementsTabSteps extends ElementsTabPages {



	@Given("I am on the Text Box page")
	public void i_am_on_the_text_box_page() {
		BaseClass.getDriver().get(ConfiReaderUtils.get("elementsTextBoxURL"));
		// Write code here that turns the phrase above into concrete actions

		/* 
		throw new io.cucumber.java.PendingException();
		When thrown, it tells Cucumber: “Hey, this step is defined in code but hasn’t been implemented yet.”

		 */
	}
	@When("I enter {string} and {string} and {string} and {string}")
	public void i_enter_FullName_Email_Currentaddress_Permanentaddress(String string, String string2, String string3, String string4) {
		inputDetails(ConfiReaderUtils.get("fullName"), ConfiReaderUtils.get("email"), ConfiReaderUtils.get("currentAddress"), ConfiReaderUtils.get("permanentAddress"));

	}
	/* @When("I enter {string}")
	public void i_enter_email(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@When("I enter {string}")
	public void i_enter_currentAddress(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@When("I enter {string}")
	public void i_enter_permanentAddress(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	} */

	@When("I click on the submit button")
	public void i_click_on_the_submit_button() {
		JSActionsUtils.scrollIntoView(getSubmitButton());
		clickSubmitButton();

	}
	@Then("All the entered details should be displayed below")
	public void all_the_entered_details_should_be_displayed_below() {
		System.out.println(getOutputDetails());
		Assert.assertEquals(getOutputDetails(), "Name:" + ConfiReaderUtils.get("fullName") + "\nEmail:" + ConfiReaderUtils.get("email") + "\nCurrent Address :" + ConfiReaderUtils.get("currentAddress") + "\nPermananet Address :" + ConfiReaderUtils.get("permanentAddress"));

	}




	@Given("I am on the Checkbox page")
	public void i_am_on_the_checkbox_page() {
		BaseClass.getDriver().get(ConfiReaderUtils.get("elementsCheckBoxURL"));
	}
	
	@When("I click on arrow icon")
	public void i_click_on_arrow_icon() {
		clickToggleButton();
	}
	
	@When("I check a checkbox")
	public void i_check_a_checkbox() {
		clickDesktopCheckbox();
	}
	@Then("the seleted checkbox name should be displayed along with the you have selected text")
	public void the_seleted_checkbox_name_should_be_displayed_along_with_the_you_have_selected_text() {
		System.out.println(getResultText());
		Assert.assertEquals(getResultText(), "You have selected :\ndesktop\nnotes\ncommands");
	}

	@Given("I am on the Radio button page")
	public void i_am_on_the_radio_button_page() {
		BaseClass.getDriver().get(ConfiReaderUtils.get("elementsRadioButtonURL"));
		
	}
	@When("I select a radio button")
	public void i_select_a_radio_button() {
		JSActionsUtils.scrollIntoView(getYesRadioButton());
		selectYesRadioButton();
	}
	@Then("The selected radio button name should be displayed along with the you have selected text")
	public void the_selected_radio_button_name_should_be_displayed_along_with_the_you_have_selected_text() {
		System.out.println(getSelectedText());
		Assert.assertEquals(getSelectedText(),  "You have selected Yes");
	}


	@Given("I am on WebTables page")
	public void i_am_on_web_tables_page() {
		BaseClass.getDriver().get(ConfiReaderUtils.get("elementsWebTablesURL"));
	}
	
	@When("I saerch for {string}")
	public void i_saerch_for(String string) {
		searchFor(ConfiReaderUtils.get("textOfWebTable"));
		
	}
	
	@Then("{string} should be displayed in Department column of the table")
	public void should_be_displayed_in_department_column_of_the_table(String string) {
		System.out.println(getSearchResultText());
		Assert.assertTrue(getSearchResultText().toLowerCase().contains(ConfiReaderUtils.get("textOfWebTable").toLowerCase()));
		}

	@Given("I am on buttons page")
	public void i_am_on_buttons_page() {
		getDriver().get(ConfiReaderUtils.get("elementsButtonsURL"));
		JSActionsUtils.scrollHalf();
	}
	
	@When("I double click on the Double Click Me button")
	public void i_double_click_on_the_double_click_me_button() {
		doubleClickButton();
	}
	
	@When("I right click on Right Click Me buton")
	public void i_right_click_on_right_click_me_buton() throws InterruptedException {
		rightClickButton();
	}
	
	@When("I click on Click Me button")
	public void i_click_on_click_me_button() throws InterruptedException {
		JSActionsUtils.scrollIntoView(getClickMeButton());
		Thread.sleep(2000);
		clickMeButton();
	}
	@Then("You have done a double click text should be displayed")
	public void you_have_done_a_double_click_text_should_be_displayed() {
		System.out.println(getDoubleClickMessage());
		Assert.assertEquals(getDoubleClickMessage(), "You have done a double click");
	}
	
	@Then("You have done a right click text should be displayed")
	public void you_have_done_a_right_click_text_should_be_displayed() {
		System.out.println(getRightClickMessage());
		
		Assert.assertEquals(getRightClickMessage(), "You have done a right click");
	}
	
	@Then("You have done a dynamic click text should be displayed")
	public void you_have_done_a_dynamic_click_text_should_be_displayed() {
		System.out.println(getDynamicClickMessage());
		
		Assert.assertEquals(getDynamicClickMessage(), "You have done a dynamic click");
	}

	@Given("I am on Links page")
	public void i_am_on_links_page() {
		BaseClass.getDriver().get(ConfiReaderUtils.get("elementsLinksURL"));
	}
	
	@When("I click on Moved link")
	public void i_click_on_created_link() throws InterruptedException {
		JSActionsUtils.scrollIntoView(getMovedLink());
		Thread.sleep(5000);
		clickMovedLink();
		
	}
	
	@Then("Link has responded with staus 301 and status text Moved Permanently should be displayed")
	public void link_has_responded_with_301_staus_and_status_text_moved_permanently_should_be_displayed() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(getLinkResponseMessage(), "Link has responded with staus 301 and status text Moved Permanently");	
	}

	@Given("I am on Broken links page")
	public void i_am_on_broken_links_page() {
		BaseClass.getDriver().get(ConfiReaderUtils.get("elementsBrokenLinksURL"));
	}
	
	@When("I click on Broken link")
	public void i_click_on_broken_link() {
		JSActionsUtils.scrollDown();
		clickBrokenLink();
	}
	
	@Then("It should show an error page with status code {int}")
	public void it_should_show_an_error_page_with_status_code(Integer int1) {
		Assert.assertTrue(getBrokenLinkMessage().contains("500"));
	}
	
	@Given("I am on Broken Links - Images page")
	public void i_am_on_broken_links_images_page() {
	    getDriver().get(ConfiReaderUtils.get("elementsBrokenLinksURL"));
	}
	@When("I check all images on the page")
	public void i_check_all_images_on_the_page() throws IOException {
		JSActionsUtils.scrollDown();
		checkAllImagesStatus();
	}
	@Then("the valid images should return status code less than {int}")
	public void the_valid_images_should_return_status_code_less_than(Integer int1) throws IOException {
		System.out.println("Valid images checked successfully.");
	}
	@Then("the broken images should be reported with the status code greater than {int}")
	public void the_broken_images_should_be_reported_with_the_status_code_greater_than(Integer int1) {
	    		System.out.println("Broken images checked successfully.");
		
	}
	
	@Given("I am on Broken Links - Images page again")
	public void i_am_on_broken_links_images_page_again() {
		getDriver().get(ConfiReaderUtils.get("elementsBrokenLinksURL"));
	}
	@When("I check all links on the page")
	public void i_check_all_links_on_the_page() {
		checkAllLinksStatus();
	}
	@Then("the valid links should return status code less than {int}")
	public void the_valid_links_should_return_status_code_less_than(Integer int1) {
		System.out.println("Valid links checked successfully.");
	}
	@Then("the broken links should be reported with the status code greater than {int}")
	public void the_broken_links_should_be_reported_with_the_status_code_greater_than(Integer int1) {
	    System.out.println("Broken links checked successfully.");
	}
	
	
	@Given("I am on Upload page")
	public void i_am_on_upload_page() {
	    getDriver().get(ConfiReaderUtils.get("elementsUploadAndDownloadURL"));
		
	}
	@Given("I click on choose file button")
	public void i_click_on_choose_file_button() {
		uploadFile();
		
	}
	@Then("I should be able to upload a file")
	public void i_should_be_able_to_upload_a_file() {
		Assert.assertTrue(verifyUploadedPath().contains("Ajay"));

	}

	
	@Given("I am on Download page")
	public void i_am_on_download_page() {
		getDriver().get(ConfiReaderUtils.get("elementsUploadAndDownloadURL"));
	}
	@When("I click on download button")
	public void i_click_on_download_button() {
		clickDownloadButton();
		
	}
	@Then("A file should be downoaded")
	public void a_file_should_be_downoaded() throws InterruptedException {
		verifyDownloadedFile();
	}

	@Given("I am on Dynamic propertied page")
	public void i_am_on_dynamic_propertied_page() {
		getDriver().get(ConfiReaderUtils.get("elementsDynamicPropertiesURL"));
	}
	
	@When("I wait for {string}")
	public void i_wait_for(String string) throws InterruptedException {
		Thread.sleep(5000);
	}
	
	@Then("first button should be enabled")
	public void first_button_should_be_enabled() {
		Assert.assertTrue(waitForEnableAfterButton());
	}
	
	@Then("Third button should be visible")
	public void third_button_should_be_visible() {
		Assert.assertTrue(waitForVisibleAfterButton());
	}

}
