package com.ajay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ajay.automation.base.BaseClass;

public class FormTabPages {
	
	private static  By firstName = By.id("firstName");
//	private static WebElement firstNameElement = BaseClass.getDriver().findElement(firstName);
	
	private static By lastName = By.id("lastName");
//	private static WebElement lastNameElement = BaseClass.getDriver().findElement(lastName);
	
	public static WebElement getLastNameElement() {
		return BaseClass.getDriver().findElement(lastName);
	}
	public void enterFirstName(String name) {
		BaseClass.getDriver().findElement(firstName).sendKeys(name);
		
	}
	
	public static WebElement getFirstNameElement() {
		return BaseClass.getDriver().findElement(firstName);
		
	} 

}
