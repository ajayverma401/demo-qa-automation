package com.ajay.automation.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandleUtils {
	
	static Select select;
	
	public static void selectByVisibleText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
		}
	
	public static void selectByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
		}
	
	public static void selectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
		
	}
	
	public static void deselectByVisibleText(WebElement element, String text) {
		select = new Select(element);
		select.deselectByVisibleText(text);
		}
	
	public static void deselectByValue(WebElement element, String value) {
		select = new Select(element);
		select.deselectByValue(value);
		}
	
	public static void deselectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.deselectByIndex(index);
	}

	public static void deselectAllOptions(WebElement element) {
		select = new Select(element);
		select.deselectAll();
	}
	
	public static String getSelectedText(WebElement element) {
		select =new Select(element);
		return select.getFirstSelectedOption().getText();
		// getFirstSelectedOption() - Returns the first selected option in the dropdown in WebElement format
		
	}
	
	public static List<WebElement> getAlloptions(WebElement element) {
		select = new Select(element);
		List<WebElement> allOptions = select.getOptions();
		/* return allOptions;
		
		for(int i=0; i< allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getText());
			
		} */  
		//return before loop - As soon as Java hits return, the method exits, so your for loop will never run.
		return allOptions;
		
	}
	
	public static void printAllOptions(WebElement element) {
	    select = new Select(element);
	    List<WebElement> allOptions = select.getOptions();
	    for (WebElement option : allOptions) {
	        System.out.println(option.getText());
	    }
	}
	
	public static void selectFromCustomDropdown(WebElement parentElement, String input) {
		parentElement.click();
		
	}
	
	
}