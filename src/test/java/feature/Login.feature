Feature: Login feature

Scenario: As a user I want to login as valid user
Given I will launch browser
And I will enter the url
When Login page is displayed I will enter username and password
And click on login
Then validate the home page is displayed or not

Scenario: As a user I will pass invalid credentials for login
Given I will launch browser
And I will enter the url
When login page is displayed enter invalid username and password
And click on login
Then error message should display 


