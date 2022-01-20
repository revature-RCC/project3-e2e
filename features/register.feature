Feature: Register Page
  Scenario: Entering valid credentials will redirect user to the login page
    Given a user is on the register page
    When a user inputs valid credentials
    Then a user is redirected to the login page

  Scenario: Entering an invalid username will give user an error
    Given a user is on the register page
    When a user inputs invalid username
    Then a user is given an invalid username message

  Scenario: Entering an invalid email will give user an error
    Given a user is on the register page
    When a user inputs invalid email
    Then a user is given an invalid email message

  Scenario: Entering an empty firstname input will give user an error
    Given a user is on the register page
    When a user leaves firstname input empty
    Then a user is given an please fill out this field notification

  Scenario: Entering an empty lastname input will give user an error
    Given a user is on the register page
    When a user leaves lastname input empty
    Then a user is given an please fill out this field notification

  Scenario: Entering an empty password input will give user an error
    Given a user is on the register page
    When a user leaves password input empty
    Then a user is given an please fill out this field notification

  Scenario: Entering an empty username input will give user an error
    Given a user is on the register page
    When a user leaves username input empty
    Then a user is given an please fill out this field notification

  Scenario: Entering an empty email input will give user an error
    Given a user is on the register page
    When a user leaves email input empty
    Then a user is given an please fill out this field notification
