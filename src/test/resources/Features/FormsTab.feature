Feature: Verify the practice form page of the demo QA site

As a user
I want to Validate the practice form page
So that form can be submitted without any issue

	Background: 
		Given the user is on the practice form page
			
			@KeyBoardActions
			Scenario: Verify if the user is able to copy and paste
				When The user enter firstName in the form
				And The user copies the same name and pastes in the LastName section
				Then the firstName and lastName must be identical