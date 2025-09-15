Feature: Handle Alerts Frames and Windows section of the Demo QA page
  As a user
  I want to handle different section
  So that I can verify the correct content inside them
		
  	Background:
   	 Given user is on the Alerts Frames and windows page

  		@Sanity @WindowHandling
  		Scenario Outline: Verify browser window functionality
  			When user click on Browser Windows section
  			And user click on <buttonType>
  			Then a new window gets opened with <expectedText>
  			
  			Examples:
  			| buttonType           |expectedText					  |
  			| "New Tab"						 |"This is a sample page" |
  #			| "New Window"				 |"This is a sample page" |
  #			| "New Window Message" |"Knowledge" 						|		
  			
  			
  		@AlertHandling	
  		Scenario: Verify Alerts Setion functionality
  			When the user clicks on Alerts section
  			And the user clicks on the "Click me" button under "Click Button to see alert"
    		Then an alert should be displayed with text "You clicked a button"
    		And the user accepts the alert
    		
    	@FrameHandling
    	Scenario: Verify Frames section functinality	
   		When The user clicks on Nested Frames section
   		And The user switches to the parent frame
   		And The user switches to the child frame inside the parent frame
   		Then the user should be able to see the text inside the "child frame"
   		And The user should be able to switch back to default page
 