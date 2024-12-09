@Important
Feature: To check the facebook login functionality
 	As a user check all the possible scenarios to cover login functionality

	Background: Launching facebook site
	Given Open the facebook home page

	@Smoke
	Scenario: Validate the valid username and invalid password for login functionality1
		
		When Enter the valid username 
		Then Verify the entered username
		When Enter the invalid password
		Then Verify the entered password
		When Click on login button
		Then Verify the login error message
		
		@Regression
		Scenario: Validate the invalid username and click on login button2
		
		When Enter the invalid "hvfjhdhfvv@gmail45.com" username
		Then Verify the entered invalid "hvfjhdhfvv@gmail45.com" username
		When Click on login button
		Then Verify the alert message
		
		@Smoke
		Scenario: Validate the valid username and invalid password for login functionality3
		
		When Enter the valid username 
		Then Verify the entered username
		When Enter the invalid password
		Then Verify the entered password
		When Click on login button
		Then Verify the login error message
		
		Scenario: Validate the invalid username and click on login button4
		
		When Enter the invalid "hvfjhdhfvv@gmail45.com" username
		Then Verify the entered invalid "hvfjhdhfvv@gmail45.com" username
		When Click on login button
		Then Verify the alert message
		
		@Smoke @Regression
		Scenario: Validate the invalid username and click on login button5
		
		When Enter the invalid "hvfjhdhfvv@gmail45.com" username
		Then Verify the entered invalid "hvfjhdhfvv@gmail45.com" username
		When Click on login button
		Then Verify the alert message
		
		
		


		
		

