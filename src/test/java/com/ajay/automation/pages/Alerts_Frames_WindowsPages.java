package com.ajay.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajay.automation.base.BaseClass;
import com.ajay.automation.utils.ConfiReaderUtils;
import com.ajay.automation.utils.WaitUtils;

public class Alerts_Frames_WindowsPages extends WaitUtils {
	
	public Alerts_Frames_WindowsPages() {
		super(Integer.parseInt(ConfiReaderUtils.get("explicitWait")));
		PageFactory.initElements(BaseClass.getDriver(), this);
		
	}
	
	
	@FindBy(xpath = "//span[text()='Browser Windows']")
	private WebElement browserWindowsSection;
	
	@FindBy(xpath = "//button[@id='tabButton']")
	private static WebElement newTabButton;
	
	@FindBy(xpath = "//button[@id='windowButton']")
	private static WebElement newWindowButton;
	
	@FindBy(xpath = "//button[@id='messageWindowButton']")
	private static WebElement messageWindowButton;
	
	@FindBy(xpath = "//span[text()='Alerts']")
	private WebElement alertsSection;
	
	@FindBy(xpath = "//button[@id='alertButton']")
	private WebElement clickMeToSeeAlertButton;
	
	@FindBy(xpath = "//span[text()='Nested Frames']")
	private static WebElement nestedFramesSection;
	
	
	@FindBy(xpath = "//iframe[@id='frame1']")	
	private static WebElement parentFrame;
	
	@FindBy(xpath = "//body[text() = 'Parent frame']")
	private static WebElement parentFrameText;
	
	
	@FindBy(xpath = "//iframe[contains(@srcdoc ,'Child')]")
	private static WebElement childFrame;
	
	
	@FindBy(xpath = "//p[normalize-space(text())='Child Iframe']")
	private static WebElement childFrameText;
	
	
	public static WebElement getParentFrameText() {
		return parentFrameText;
	}
	public static WebElement getChildFrameText() {
		return childFrameText;
	}
	
	public static WebElement getChildFrame() {
		return childFrame;
	}
	
	public static WebElement getParentFrame() {
		return parentFrame;
	}
	
	public static WebElement getNestedFramesSection() {
		return nestedFramesSection;
	}
	public void clickOnNestedFramesSection() {
		nestedFramesSection.click();
	}
	
	public void clickOnAlertsSection() {
		alertsSection.click();
	}
	
	public void clickOnClickMeToSeeAlertButton() {
		clickMeToSeeAlertButton.click();
	}
	
	
	public static WebElement getNewTabButton() {
		return newTabButton;
	}
	public static WebElement getNewWindowButton() {
		return newWindowButton;
	}
	public static WebElement getMessageWindowButton() {
		return messageWindowButton;
	}
	
	public void clickOnBrowserWindowsSection() {
		browserWindowsSection.click();
	}
	
	public void clickOnNewTabButton() {
//		newTabButton.click();
		waitForElementToBeClickable(newTabButton).click();
		
	}
	
	public void clickOnNewWindowButton() {
		newWindowButton.click();
	}
	
	public void clickOnMessageWindowButton() {
		messageWindowButton.click();
	}
	
	

}
