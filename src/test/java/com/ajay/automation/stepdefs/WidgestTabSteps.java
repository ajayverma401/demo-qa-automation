package com.ajay.automation.stepdefs;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ajay.automation.base.BaseClass;
import com.ajay.automation.pages.WidgetsTabPages;
import com.ajay.automation.utils.ConfiReaderUtils;
import com.ajay.automation.utils.DatePickersUtils;
//import com.ajay.automation.utils.DropdownHandleUtils;
import com.ajay.automation.utils.JSActionsUtils;
import com.ajay.automation.utils.WaitUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WidgestTabSteps extends WidgetsTabPages {

	WaitUtils waitUtils = new WaitUtils(Integer.parseInt(ConfiReaderUtils.get("explicitWait")));

	@Given("The user is on the Widgets section")
	public void the_user_is_on_the_widgets_section() {
		BaseClass.getDriver().get(ConfiReaderUtils.get("widgetsURL"));
	}

	@When("the user clicks on Select Menu and opens the dropdown")
	public void the_user_clicks_on_select_menu_and_opens_the_dropdown() {
		JSActionsUtils.scrollIntoView(WidgetsTabPages.getSelectMenuOptions());
		clickOnSelectMenuOptions();
		clickOnSelecValueDropdown();

		//		clickOnOldStyleSelectMenuDropdown();

	}

	@When("Selects values from the dropdown")
	public void selects_values_from_the_dropdown() {
		//		DropdownHandleUtils.selectByValue(WidgetsTabPages.getOldStyleSelectMenuDropdown(), "5");
		selectValueInSelectValueDropdown("Group 1, option 1");

	}

	@Then("the value should be displayed as selected")
	public void the_value_should_be_displayed_as_selected() {
		//		System.out.println("Selected value is : " + DropdownHandleUtils.getSelectedText(getOldStyleSelectMenuDropdown()));
		//		Assert.assertEquals(DropdownHandleUtils.getSelectedText(getOldStyleSelectMenuDropdown()),"Black");
		System.out.println(getSelectedTextInSelectValueDropdown());
		Assert.assertEquals(getSelectedTextInSelectValueDropdown(), "Group 1, option 1");

	}

	@When("The user clicks on Date Picker section of Widgets")
	public void the_user_clicks_on_date_picker_section_of_widgets()  {

		JSActionsUtils.scrollIntoView(WidgetsTabPages.getDatePickerOption());
		clickOnDatePickerOption();

	}
	@When("The user Selects {string} {string} {string} from the date picker")
	public void the_user_selects_from_the_date_picker(String day, String month, String year) throws InterruptedException  {
		clickOnDatePickerField();
		//		Thread.sleep(2000);
		/*String currentMonthAndYear = getCurrentMonthAndYearOfDatePicker().getText();
		String[] monthAndYear = currentMonthAndYear.split(" ");
		String monthOfDatePicker = monthAndYear[0];
		String yearOfDatePicker = monthAndYear[1];*/

		while(true) {
			//			Thread.sleep(3000);
			waitUtils.waitForElementToBeVisible(getCurrentMonthAndYearOfDatePicker());
			String currentMonthAndYear = getCurrentMonthAndYearOfDatePicker().getText();
			String[] monthAndYear = currentMonthAndYear.split(" ");
			String monthOfDatePicker = monthAndYear[0];
			String yearOfDatePicker = monthAndYear[1];

			if(month.trim().equalsIgnoreCase(monthOfDatePicker.trim()) && year.trim().equals(yearOfDatePicker.trim())){
				break;
				/*
				if(currentMonthAndYear.equalsIgnoreCase(month+" "+year)) {
					break;
				}*/
			}

			int targetYear = Integer.parseInt(year);
			int currentYear = Integer.parseInt(yearOfDatePicker);

			if(currentYear < targetYear || (currentYear == targetYear && !monthOfDatePicker.equalsIgnoreCase(month.trim()))) {
				clickOnNextIconOfDatePicker();	
			} 

			else {
				clickOnPreviousIconOfDatePicker();
			}

		}
		for(WebElement allDays : getDaysOfDatePicker()) {
			if(allDays.getText().equals(day)) {
				allDays.click();
				break;
			}	
		}

		//		DatePickersUtils.sendDateDirectly(getDatePickerField(), ConfiReaderUtils.get("dateToSelect"));
		//		DatePickersUtils.selectDateFromDatePicker(getDaysOfDatePicker(), month, year, getNextIconOfDatePicker() );

	}
	@Then("The user should be able to see the selected date as {string}")
	public void the_user_should_be_able_to_see_the_selected_date_as(String string) {
		String selectedDate = getDatePickerField().getAttribute("value");
		System.out.println("Selected date is : " + selectedDate);
		Assert.assertEquals(selectedDate, string);
	}



}
