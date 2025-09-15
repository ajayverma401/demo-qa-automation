package com.ajay.automation.utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ajay.automation.base.BaseClass;

public class WaitUtils {
	
	private WebDriver driver;
	private static WebDriverWait wait;
	
	public WaitUtils(int timeOutInSeconds) {
		this.driver = BaseClass.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		
	}
	
	public  static WebDriverWait getWait() {
		return wait;
	}
	
	
	public WebElement waitForElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public boolean waitForElementToBeSelected(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeSelected(element));
		
	}
	
	public WebElement fluentWait(WebElement element, int timeOutsInSeconds, int polling) {
		
		Wait <WebDriver> fluentWait = new FluentWait<>(driver)
		        .withTimeout(Duration.ofSeconds(timeOutsInSeconds))
		        .pollingEvery(Duration.ofSeconds(polling))
		        .ignoring(NoSuchElementException.class);
		        
		        return fluentWait.until(driver -> element);
	
	}
	
	public void staticWait(int timeInMiliis) {
		try {
			Thread.sleep(timeInMiliis);
		}
		
		catch(InterruptedException e) {
			e.printStackTrace();
			
		}
	}
	
	

}
