Feature: Admin Page
  Background:
    Given a user is on the login page
    When a user enters admin credentials
    Then the add new product button is visible
    Given A user is on the main page
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page

  Scenario: An Admin tries to make a new product without adding a name
    Given An Admin is on the add product page
    When The Admin submits the form without adding a name
    Then The form produces an error message on the name field

  Scenario: An Admin tries to make a new product without adding a description
    Given An Admin is on the add product page
    When The Admin submits the form without adding a description
    Then The form produces an error message on the description field

  Scenario: An Admin tries to make a new product without adding a regular price
    Given An Admin is on the add product page
    When The Admin submits the form without adding a regular price
    Then The form produces an error message on the price field

  Scenario: An Admin tries to make a new product without adding a stock price
    Given An Admin is on the add product page
    When The Admin submits the form without adding a stock price
    Then The form produces an error message on the stock price field
