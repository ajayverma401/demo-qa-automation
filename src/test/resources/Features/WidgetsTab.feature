Feature: Verify Widgets section of the QA website

	Background: 
		Given The user is on the Widgets section
		
			@Dropdowns		
			Scenario: Verify the Select menu of Widgest section
				When the user clicks on Select Menu and opens the dropdown
				And Selects values from the dropdown
				Then the value should be displayed as selected
			
			
			@DatePicker	
			Scenario Outline: Verify the Date pickers functionality
				When The user clicks on Date Picker section of Widgets
				And The user Selects "<day>" "<month>" "<year>" from the date picker
				Then The user should be able to see the selected date as "<expectedDate>" 
#			"<year>" -> the quotes ensure that if the year contains spaces or special characters,
#			the whole thing is captured as one string."" - not mandate but recommended	

					
					Examples:
						|	day		|	month			|	year		|	expectedDate 	| 
#						|	10			| October 		| 2025		|	10/10/2025	   	| 
#						|	22			| November		| 2025		|	11/22/2025	   	| 
#						|	10			| June 			| 2025		|	06/10/2025	   	|
						|	19			| December		| 2023		|	12/19/2023	   	|
						|	19			| December		| 2024		|	12/19/2024	   	|
#						|	19			| December		| 2026		|	12/19/2026	   	|
						
# 			Cucumber automatically treats each cell in the Examples table as a string.
#			So whether it’s 28, October, or 10/28/2025, they’re passed as string arguments to your step definition. 
						
				
				