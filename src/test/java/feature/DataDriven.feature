Feature: Data driven testing

  # background will be exceuted for each and scenario inside this feature file
  Background: 
   # Given I will launch "chrome" browser
    #And I will enter the url "http://localhost:8888"
    When login page is displayed I will enter username "admin" and password "manager"
    And I Will click on login

  Scenario: As a user I want login to application
    Then I will validate Home page title

@fast
  Scenario Outline: Create a multiple organization provided in examples
    When Home page is displayed click on organization
    And click on create new organization image link
    And enter the organization name
    Then validate organization is created or not

    Examples: 
      | organizationName |
      | Google           |
      | amazon           |
      | Jira             |
      | Microsfot azure  |
