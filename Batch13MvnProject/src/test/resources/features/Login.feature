Feature: Login 

Scenario: Verify login with valid credentials 
	Given user is on homepage and navigates to Login page 
	When user login with username "dem7@gmail.com" and password "xyzabc"
	Then verify user is logged in 
	
Scenario: Verify login with invalid credentials 
	Given user is on homepage and navigates to Login page 
	When user login with username "dem77@gmail.com" and password "123"
	Then verify user shouldnot logged in

Scenario: Verify login with empty credentials 
	Given user is on homepage and navigates to Login page 
	When user login with username "" and password ""
	Then verify user shouldnot logged in	
	
	
