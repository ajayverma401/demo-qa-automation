package com.ajay.automation.stepdefs;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.ajay.automation.base.BaseClass;
import com.ajay.automation.pages.FormTabPages;
import com.ajay.automation.utils.ConfiReaderUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormTabSteps extends FormTabPages{

	
	@Given("the user is on the practice form page")
	public void the_user_is_on_the_practice_form_page() {
	    BaseClass.getDriver().get(ConfiReaderUtils.get("practiceFormURL"));
	}
	@When("The user enter firstName in the form")
	public void the_user_enter_first_name_in_the_form() {
		enterFirstName("Ajay Verma");
	}
	@When("The user copies the same name and pastes in the LastName section")
	public void the_user_copies_the_same_name_and_pastes_in_the_last_name_section() {
	    Actions act = new Actions(BaseClass.getDriver());
	    act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
	    act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
	    act.sendKeys(Keys.TAB).perform();
	    act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
	}
	@Then("the firstName and lastName must be identical")
	public void the_first_name_and_last_name_must_be_identical() {
//	    String firstNameValue = BaseClass.getDriver().findElement(FormTabPages.getFirstName();
		String firstName = FormTabPages.getFirstNameElement().getText();
		String lastName = FormTabPages.getLastNameElement().getText();
	    if(firstName.equals(lastName)) {
	    	System.out.println("Both names are identical");
	    }else {
	    	System.out.println("Names are not identical");
	    }
		
	}

}
