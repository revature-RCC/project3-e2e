Feature: Login Page

  Scenario: Entering valid credentials will redirect user to the main product page
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page

  Scenario: Entering invalid credentials will display error message
    Given a user is on the login page
    When a user inputs invalid credentials
    Then an error message appears telling the user that their credentials are incorrect

  Scenario: Clicking on the register link will redirect user to register page
    Given a user is on the login page
    When a user clicks on the register link
    Then a user is redirected to the register page

  Scenario: An Admin logs in and sees the add new product button in the bottom right corner
    Given a user is on the login page
    When a user enters admin credentials
    Then the add new product button is visible