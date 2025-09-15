Feature: Verify the	Elements section of the demo website

  #	@Sanity
  Scenario: Verify the Text Box section of Element
    Given I am on the Text Box page
    When I enter "FullName" and "Email" and "Currentaddress" and "Permanentaddress"
    And I click on the submit button
    Then All the entered details should be displayed below

  #	@Smoke
  Scenario: Verify the Checkbox section of Element
    Given I am on the Checkbox page
    When I click on arrow icon
    And I check a checkbox
    Then the seleted checkbox name should be displayed along with the you have selected text

  #	@Sanity
  Scenario: Verify the Radio button section of the Element
    Given I am on the Radio button page
    When I select a radio button
    Then The selected radio button name should be displayed along with the you have selected text

  #	@Sanity
  Scenario: Verify the WebTables section of the Element
    Given I am on WebTables page
    When I saerch for "textOfWebTable"
    Then "searchedText" should be displayed in Department column of the table

  	@Sanity
  Scenario: Verify the buttons section of the Element
    Given I am on buttons page
    When I double click on the Double Click Me button
    And I right click on Right Click Me buton
    And I click on Click Me button
    Then You have done a double click text should be displayed
    And You have done a right click text should be displayed
    And You have done a dynamic click text should be displayed

  #	@Sanity
  Scenario: Verify the Links section of the Element
    Given I am on Links page
    When I click on Moved link
    Then Link has responded with staus 301 and status text Moved Permanently should be displayed

  #@Sanity
  Scenario: Verify the Broken links section of the Element
    Given I am on Broken links page
    When I click on Broken link
    Then It should show an error page with status code 500
   
  #@Sanity  
  Scenario: Verify the valid and broken images in the Element
  		Given I am on Broken Links - Images page
  		When I check all images on the page
  		Then the valid images should return status code less than 400
  		And the broken images should be reported with the status code greater than 400
  		
  #@Sanity  
	Scenario: Verify the valid and broken links in the Element
		Given I am on Broken Links - Images page again
		When I check all links on the page
		Then the valid links should return status code less than 400
		And the broken links should be reported with the status code greater than 400
  		
  #@Upload
  Scenario: Verify the Upload section of Element
    Given I am on Upload page
    And I click on choose file button
    Then I should be able to upload a file
  
  #@Download  
  Scenario: Verify the Download section of Element
    Given I am on Download page
    When I click on download button
    Then A file should be downoaded
    
#	@Sanity
  Scenario: Verify the Dynamic properties section of the Element
    Given I am on Dynamic propertied page
    When I wait for "timeouts"
    Then first button should be enabled
    And Third button should be visible
