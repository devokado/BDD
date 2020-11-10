Feature: CRUD on users

  Scenario: Create user
    Given the user with user id 1 and user name "user1" and user password "1234"
    When  the client calls "/users" with the given details
    Then the client receives status code of 200
    And the response contains user name "user1"
    
    
 
  Scenario: retrieve the user with user id
    Given the user saved with user id 1 and user name "jack" and user password "1234"
    When the client calls GET "/users/{id}" with user id as 1
    Then the client receives status code of 200
    And the response contains user name "jack"
    

