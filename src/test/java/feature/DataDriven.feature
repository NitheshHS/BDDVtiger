Feature: Data driven testing

 # Scenario: As a user I want login to application
  #  Given I will launch "chrome" browser
  #  And I will enter the url "http://localhost:8888"
  #  When login page is displayed I will enter username "admin" and password "manager"
  #  And I Will click on login
  # Then I will validate Home page title

  Scenario Outline: Create a multiple organization provided in examples
    Given I will launch "chrome" browser
    And I will enter the url "http://localhost:8888"
    And login page is displayed I will enter username "admin" and password "manager"
    And I Will click on login
    When Home page is displayed click on organization
    And click on create new organization image link
    And enter the organization name "<orgaizationName>" and select industry drop down "<industryType>"
    Then validate organization is created or not "<orgaizationName>"

    Examples: 
      | orgaizationName | industryType |
      | google          | Technology   |
      | azure devops    | Hospitality  |
      | spring boot     | Utilities    |
      | react js        | Technology   |
