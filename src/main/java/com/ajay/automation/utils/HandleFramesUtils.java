package com.ajay.automation.utils;

//import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ajay.automation.base.BaseClass;

public class HandleFramesUtils extends WaitUtils {
	
	public HandleFramesUtils() {
		super(Integer.parseInt(ConfiReaderUtils.get("explicitWait")));
	}
	
	public static void switchToFrameByIndex(int frameIndex) {
//		BaseClass.getDriver().switchTo().frame(index);
		try {
			getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
		}
		
		catch(Exception e) {
			System.out.println("Unable to switch to frame by index: " + e.getMessage());
			e.printStackTrace();
		}
		
		/* catch(IOException e) {
			System.out.println("Unable to switch to frame by index: " + frameIndex);
			e.printStackTrace();
			IOException belongs to java.io package and is used for file handling, streams, readers/writers etc.
			Don’t use IOException for Selenium unless you’re doing file-related work
			(e.g., reading config files, screenshots, test data).
			
		} */
		
	}
	
	public static void switchToFrameByNameOrId(String nameOrId) {
//		BaseClass.getDriver().switchTo().frame(nameOrId);
		
		try {
			getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
		}
		
		catch(Exception e) {
			System.out.println("Unable to switch to frame by name or id: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	public static void switchToFrameByElement(WebElement Element) {
		//BaseClass.getDriver().switchTo().frame(Element);
		try {
			getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Element));
		}
		
		catch(Exception e) {
			System.out.println("Unable to switch to frame by element: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void switchToParentFrame() {
		BaseClass.getDriver().switchTo().parentFrame();
	}
	
	public static void switchBackToDefault() {
		BaseClass.getDriver().switchTo().defaultContent();
	}
	

}
