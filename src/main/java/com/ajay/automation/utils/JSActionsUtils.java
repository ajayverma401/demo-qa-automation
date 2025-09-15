package com.ajay.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ajay.automation.base.BaseClass;

public class JSActionsUtils {
	
	static JavascriptExecutor js =  (JavascriptExecutor) BaseClass.getDriver();
	
	public static void scrollDown() {
		js.executeScript("window.scrollBy(0,3000)");
		// Scrolls down the page by 3000 pixels
	}
	
	public static void scrollHalf() {
		js.executeScript("window.scrollBy(0,1500)");
		// Scrolls down the page by 3000 pixels
	}
	
	public static void scrollUp() {
		js.executeScript("window.scrollBy(0,-3000)");
		// Scrolls down the page by 3000 pixels
	}
	
	public static void scrollRight() {
		js.executeScript("window.scrollBy(3000,0)");
		// Scrolls down the page by 3000 pixels
	}
	
	public static void scrollLeft() {
		js.executeScript("window.scrollBy(-3000,0)");
		// Scrolls down the page by 3000 pixels
	}
	
	public static void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element );
		
	}
	
	public static void clickElementByJS(WebElement element) {
		js.executeScript("arguments[0].click();", element );
		
	}
	
	public static void removeExistingValueUsingJS(WebElement element) {
		js.executeScript("arguments[0].value='';", element ); //clear value
		
	}
	

}
