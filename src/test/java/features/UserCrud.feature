Feature: CRUD on users 

Background: 
	Given the user with user id 1 and user name "user1" and user password "1234" 
	When  the client calls "/users" with the given details 
	
Scenario: Create user 
	Then the client receives status code of 201 
	And the response contains user name "user1" 
	
	
Scenario: retrieve the user with user id 
	When the client calls GET "/users/{id}" with user id as 1 
	Then the client receives status code of 200 
	And the response contains user name "user1" 
	
Scenario: delete the user with user id 

	When the client calls DELETE "/users/{id}" with user id as 1 
	Then the client receives status code of 204 
	And the response contain GET "/users/{id}" with user id as 1 is 401 
	
Scenario: Update the user with user id 
	When the client calls PUT "/users/{id}" with user id as 1 and user name "jack" and user password "123"
	Then the client receives status code of 200 
	And the response contains user name "jack" 
	
	
	
	
