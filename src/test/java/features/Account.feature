Feature: Application Login

@SmokeTest
Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "user2" and password "4321"
Then Home page is populated
And Cards displayed are "false"  
