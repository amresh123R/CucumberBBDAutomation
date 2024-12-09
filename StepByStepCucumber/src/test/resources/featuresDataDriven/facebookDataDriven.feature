Feature: Check Data driven functionality in Facebook login page
		Test it for multiple users
		
		Background: Open the facebook website
		Given Open the facebook website
		

		Scenario Outline: Verify the invalid credentails for login functionality for multiple users
		Given Enter the invalid "<username>" and "<password>"
		When Click on login button
		Then Verify the alert message "<alert_message>"
		
		Examples:
		
		|username    |password   |alert_message                  |
		|tom123@ya      |tom@123    |Find your account and log in|
		|jerry23@gm     |jerry@2233 |Find your account and log in|
		
		
		


		
		
		
		 
		

