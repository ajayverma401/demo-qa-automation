package com.ajay.automation.pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajay.automation.base.BaseClass;

public class WidgetsTabPages {

	private WebDriver driver;

	public WidgetsTabPages() {
		this.driver = BaseClass.getDriver();
		PageFactory.initElements(driver, this); 
	} /*
	a constructor in java always a non static
	this is best practice to use this.driver instead of BaseClass.getDriver() directly in the methods of this class. 
	Encapsulation: Each page object has its own driver.
	Flexibility: Easy to switch driver initialization strategies later.
	Readability: Anyone reading the code sees immediately that this page works with a WebDriver.
	 */

	/* public WidgetsTabPages() {
		PageFactory.initElements(BaseClass.getDriver(), this); 

	} */

	@FindBy(xpath = "//span[text()='Select Menu']")
	private static WebElement selectMenuOptions;

	public static WebElement getSelectMenuOptions() {
		return selectMenuOptions;
	}

	@FindBy(xpath = "//div[text()='Select Option']")
	private static WebElement selectValueDropdown;

	public static WebElement getSelectOptionDropdown() {
		return selectValueDropdown;
	}

	@FindBy(id = "oldSelectMenu")
	private static WebElement oldStyleSelectMenuDropdown;

	public static WebElement getOldStyleSelectMenuDropdown() {
		return oldStyleSelectMenuDropdown;
	}

	@FindBy(css = "input[id *= 'react-select']")
	private static WebElement multiSelectDropdown;

	public static WebElement getMultiSelectDropdown() {
		return multiSelectDropdown;
	}

	@FindBy(xpath = "//div[text()='Group 1, option 1']")
	private static WebElement selectedTextInSelectValueDropdown;


	@FindBy(xpath = "//span[normalize-space(text()) = 'Date Picker']")
	private static WebElement datePickerOption;

	@FindBy(id = "datePickerMonthYearInput")
	private static WebElement datePickerField;


	@FindBy(xpath = "//button[normalize-space(text())='Next Month']")
	private static WebElement nextIconOfDatePicker;

	@FindBy(xpath = "//button[normalize-space(text())='Previous Month']")
	private static WebElement previousIconOfDatePicker;


	public static WebElement getPreviousIconOfDatePicker() {
		return previousIconOfDatePicker;

	}
	
	public void clickOnPreviousIconOfDatePicker() {
		previousIconOfDatePicker.click();
	}
	
	public static WebElement getNextIconOfDatePicker() {
		return nextIconOfDatePicker;
	}

	@FindBy(xpath = "//div[starts-with(@class,'react-datepicker__day react-datepicker__day')]")
	private static List<WebElement> daysOfDatePicker;


	@FindBy(xpath = "//div[starts-with(@class,'react-datepicker__current-month')]")
	private static WebElement currentMonthAndYearOfDatePicker;



	public static WebElement getCurrentMonthAndYearOfDatePicker() {
		return currentMonthAndYearOfDatePicker;
	}
	public static List<WebElement> getDaysOfDatePicker() {
		return daysOfDatePicker;
	}

	public void clickOnNextIconOfDatePicker() {
		nextIconOfDatePicker.click();
	}

	public static WebElement getDatePickerField() {
		return datePickerField;
	}
	public void clickOnDatePickerField() {
		datePickerField.click();
	}

	public static WebElement getDatePickerOption() {
		return datePickerOption;
	}

	public void clickOnDatePickerOption() {
		datePickerOption.click();
	}


	public void clickOnSelectMenuOptions() {
		selectMenuOptions.click();
	}

	public void clickOnSelecValueDropdown() {
		selectValueDropdown.click();
	}

	public void clickOnOldStyleSelectMenuDropdown() {
		oldStyleSelectMenuDropdown.click();
	}

	public void selectValueInSelectValueDropdown(String input) {
		multiSelectDropdown.sendKeys(input);
		multiSelectDropdown.sendKeys(Keys.ENTER);
	}

	public String getSelectedTextInSelectValueDropdown() {
		return selectedTextInSelectValueDropdown.getText();
	}




}
