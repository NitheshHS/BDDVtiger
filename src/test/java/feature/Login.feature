Feature: Login feature

#browser launch and url entry moved to hook class
#Background:
#Given I will launch browser
#And I will enter the url

@SmokeTest
Scenario: As a user I want to login as valid user
When Login page is displayed I will enter username and password
And click on login
Then validate the home page is displayed or not

@RegressionTest
Scenario: As a user I will pass invalid credentials for login
When login page is displayed enter invalid username and password
And click on login
Then error message should display 


