Feature: Application Login

@WebTest
Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "user1" and password "1234"
Then Home page is populated
And Cards displayed are "true" 

@MobileTest
Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "user2" and password "4321"
Then Home page is populated
And Cards displayed are "false"  

@MobileTest
Scenario: Home page default sign up
Given User is on NetBanking sign up page
When User sign up with following details
| user | 1234 | user@email.com | Asia | 33333 |

Then Home page is populated
And Cards displayed are "false" 

@WebTest
Scenario Outline:  Home page default login
Given User is on NetBanking landing page
When User login in to application with <username> and password <password>
Then Home page is populated
And Cards displayed are "true"  

Examples:
|username   |password  |
|user1      |pass1     |
|user2      |pass2     |
|user3      |pass3     |
|user4      |pass4     |
|user5      |pass5     |
|user6      |pass6     |