package com.ajay.automation.utils;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DatePickersUtils {
	// this is required to access non-static variable day

	 static String year = "2025";
	static String month = "October";
	static String day = "10"; 

	public static void sendDateDirectly(WebElement dateField, String date){
		/*dateField.click();
    	dateField.clear();
    	dateField.sendKeys(date); */
		JSActionsUtils.removeExistingValueUsingJS(dateField);
		dateField.sendKeys(date);
		dateField.sendKeys(Keys.ENTER);

	}

	public static void selectDateFromDatePicker(List<WebElement> daysOfDatePicker, String monthOfDatePicker, String yearOfDatePicker, WebElement nextIcon) {
		// DatePickerSUtils datePickerSUtils = new DatePickerSUtils(); // this is required to access non-static variable day
		while(true) {
			if(year.equals(yearOfDatePicker) && month.equalsIgnoreCase(monthOfDatePicker)) {
				break;
			}
			else {
				nextIcon.click();
			}
		}


		for(WebElement dayElement : daysOfDatePicker) {
			if(dayElement.getText().equals(day)) {
				dayElement.click();
				break;
			}
		}
	}

}
