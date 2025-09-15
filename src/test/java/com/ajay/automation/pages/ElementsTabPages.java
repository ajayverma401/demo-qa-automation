package com.ajay.automation.pages;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ajay.automation.base.BaseClass;
import com.ajay.automation.utils.ConfiReaderUtils;

public class ElementsTabPages extends BaseClass{


	Actions actions = new Actions(getDriver());
	// Actions class is used to perform complex user interactions like mouse movements, keyboard actions, etc.

	public ElementsTabPages() {
		PageFactory.initElements(getDriver(),this);

	}

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement fullNameInput;

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement emailInput;

	@FindBy(xpath = "//textarea[@id='currentAddress']")
	private WebElement currentAddressInput;

	@FindBy(xpath = "//textarea[@id='permanentAddress']")
	private WebElement permanentAddressInput;

	@FindBy(xpath = "//button[@id='submit']")
	private static WebElement submitButton;

	@FindBy(xpath = "//div[@id='output']/div")
	private WebElement outputDetails;


	@FindBy(xpath = "//button[@title='Toggle']//*[name()='svg']")
	private WebElement toggleButton;

	@FindBy(xpath = "//label[@for='tree-node-desktop']//span[@class='rct-checkbox']//*[name()='svg']")
	private WebElement desktopCheckbox;

	@FindBy(xpath = "//div[@id='result']")
	private WebElement resultText;


	@FindBy(xpath ="//label[text()='Yes']")
	private static WebElement yesRadioButton;

	@FindBy(xpath = "//p[text()='You have selected ']")
	private WebElement selectedText;


	@FindBy(xpath = "//input[@id='searchBox']")
	private WebElement searchBox;

	@FindBy(xpath = "//div[contains(@class,'rt-tr -odd')]//div[6]")
	private WebElement searchResultText;

	@FindBy(xpath = "//button[@id='doubleClickBtn']")
	private WebElement doubleClickButton;

	@FindBy(xpath = "//button[@id='rightClickBtn']")
	private WebElement rightClickButton;

	/* @FindBy(xpath = "//button[@id='JFiDm']")
	private WebElement clickMeButton; */

	@FindBy(xpath = "//button[text()='Click Me']")
	private static WebElement clickMeButton;


	@FindBy(xpath = "//p[@id='doubleClickMessage']")
	private WebElement doubleClickMessage;

	@FindBy(xpath = "//p[@id='rightClickMessage']")
	private WebElement rightClickMessage;

	@FindBy(xpath = "//p[@id='dynamicClickMessage']")
	private WebElement dynamicClickMessage;

	@FindBy(xpath = "//a[@id='moved']")
	private static WebElement movedLink;

	@FindBy(xpath = "//p[@id='linkResponse']")
	private WebElement linkResponseMessage;

	@FindBy(xpath = "//a[text()='Click Here for Broken Link']")
	private WebElement brokenLink;


	@FindBy(xpath = "//p[contains(text(),'This page returned a 500 status code')]")
	private WebElement brokenLinkMessage;

	private By allImages = By.tagName("img");
	private By allLinks = By.tagName("a");

	//	List <WebElement> allImages = getDriver().findElements(By.tagName("img"));

	//	List <WebElement> allLinks = getDriver().findElements(By.tagName("a"));

	@FindBy(xpath = "//input[@id = 'uploadFile']")
	private WebElement uploadFileInput;

	@FindBy(xpath = "//p[@id = 'uploadedFilePath']")
	private WebElement uploadedFilePath;
	
	@FindBy(xpath = "//a[@id='downloadButton']")
	private WebElement downloadButton;
	
	@FindBy(xpath = "//button[@id='enableAfter']")
	private WebElement enableAfterButton;
	
	@FindBy(xpath = "//button[@id='visibleAfter']")
	private WebElement visibleAfterButton;
	
	public static WebElement getSubmitButton() {
		return submitButton;
	}
	
	public static WebElement getClickMeButton() {
		return clickMeButton;
	}
	
	public static WebElement getMovedLink() {
		return movedLink;
	}
	
	public static WebElement getYesRadioButton() {
		return yesRadioButton;
	}
	


	public void inputDetails(String fullName, String email, String currentAddress, String permanentAddress) {
		fullNameInput.sendKeys(fullName);
		emailInput.sendKeys(email);
		currentAddressInput.sendKeys(currentAddress);
		permanentAddressInput.sendKeys(permanentAddress);

	}

	/* 
	public void enterFullName(String fullName) {
		fullNameInput.sendKeys(fullName);

	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);

	}

	public void enterCurrentAddress(String currentAddress) {
		currentAddressInput.sendKeys(currentAddress);

	}

	public void enterPermanentAddress(String permanentAddress) {
		permanentAddressInput.sendKeys(permanentAddress);

	}  
	 */

	public void clickSubmitButton() {
		submitButton.click();

	}

	public String getOutputDetails() {
		return outputDetails.getText();

	}

	public void clickToggleButton() {
		toggleButton.click();

	}
	public void clickDesktopCheckbox() {
		desktopCheckbox.click();

	}

	public String getResultText() {
		return resultText.getText();

	}

	public void selectYesRadioButton() {
		yesRadioButton.click();
	}

	public String getSelectedText() {
		return selectedText.getText();
	}

	public void searchFor(String searchText) {
		searchBox.sendKeys(searchText);

	}

	public String getSearchResultText() {
		return searchResultText.getText();

	}


	public void doubleClickButton() {
		actions.doubleClick(doubleClickButton).perform();
	}

	public void rightClickButton() throws InterruptedException {
		Thread.sleep(2000);
		actions.contextClick(rightClickButton).perform();
	}

	public void clickMeButton() {
		clickMeButton.click();
	}

	public String getDoubleClickMessage() {
		return doubleClickMessage.getText();
	}

	public String getRightClickMessage() {
		return rightClickMessage.getText();
	}

	public String getDynamicClickMessage() {
		return dynamicClickMessage.getText();
	}

	public void clickMovedLink() {
		movedLink.click();
	}

	public String getLinkResponseMessage() {
		return linkResponseMessage.getText();
	}

	public void clickBrokenLink() {
		brokenLink.click();
	}

	public String getBrokenLinkMessage() {
		return brokenLinkMessage.getText();

	}

	public void checkAllImagesStatus() {
		List<WebElement> images = getDriver().findElements(allImages); // Get all <img> elements on the page
		int valid = 0, broken = 0;
		for (WebElement img : images) {
			String src = img.getAttribute("src"); // Get the image URL
			if (src != null && !src.isEmpty()) {
				try {
					HttpURLConnection connection = (HttpURLConnection) (new URL(src).openConnection()); // Open HTTP connection to the image URL
					connection.setRequestMethod("GET"); // Set HTTP method to GET
					connection.connect(); // Connect to the URL
					int code = connection.getResponseCode(); // Get the HTTP response code
					System.out.println("Image URL: " + src + " | Status Code: " + code); // Print the image URL and status code
					if (code < 400) valid++; // If status code is less than 400, it's valid
					else broken++; // Otherwise, it's broken
					// You can assert here if you want: Assert.assertTrue(code < 400, "Broken image: " + src);
				} catch (IOException e) {
					broken++; // If there's an exception, count as broken
					System.out.println("Image URL: " + src + " | Exception: " + e.getMessage());
				}
			}
		}
		System.out.println("Total valid images: " + valid);
		System.out.println("Total broken images: " + broken);
	}

	public void checkAllLinksStatus() {
		List<WebElement> links = getDriver().findElements(allLinks); // Get all <a> elements on the page
		int valid = 0, broken = 0;
		for (WebElement link : links) {
			String href = link.getAttribute("href"); // Get the link URL
			if (href != null && !href.isEmpty() && href.startsWith("http")) {
				try {
					HttpURLConnection connection = (HttpURLConnection) (new URL(href).openConnection()); // Open HTTP connection to the link URL
					connection.setRequestMethod("GET"); // Set HTTP method to GET
					connection.connect(); // Connect to the URL
					int code = connection.getResponseCode(); // Get the HTTP response code
					System.out.println("Link URL: " + href + " | Status Code: " + code); // Print the link URL and status code
					if (code < 400) valid++; // If status code is less than 400, it's valid
					else broken++; // Otherwise, it's broken
					// You can assert here if you want: Assert.assertTrue(code < 400, "Broken link: " + href);
				} catch (IOException e) {
					broken++; // If there's an exception, count as broken
					System.out.println("Link URL: " + href + " | Exception: " + e.getMessage());
				}
			}
		}
		System.out.println("Total valid links: " + valid);
		System.out.println("Total broken links: " + broken);
	}

	public void uploadFile() {
		uploadFileInput.sendKeys(ConfiReaderUtils.get("filePath"));

	}

	public String verifyUploadedPath() {
		return uploadedFilePath.getText();
	}
	
	public void clickDownloadButton() {
		downloadButton.click();
	}
	
	public void verifyDownloadedFile() throws InterruptedException {
		
		Thread.sleep(15000); // Wait for the file to download, adjust as necessary
		String downloadPath = "C:\\Users\\Rahul Kumar Verma\\Downloads";
		String fileName = "sampleFile.jpeg";
		
		
		File downloadedFile = new File(downloadPath+"\\"+fileName);
		Assert.assertTrue(downloadedFile.exists(), "File not found in download directory!");
		}
	
	public boolean waitForEnableAfterButton() {
		return enableAfterButton.isEnabled();
	}

	public boolean waitForVisibleAfterButton() {
		return visibleAfterButton.isDisplayed();
	}

}


