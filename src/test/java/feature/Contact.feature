Feature: Contact module

  Scenario: create a new contact with mandatory information
    When login page is displayed I will enter username "admin" and password "manager"
    And I Will click on login
    And click on contact
    And click on create new contact
    And enter contact name "Nithesh"
    And click on save
    Then validate contact Name "Nithesh"
