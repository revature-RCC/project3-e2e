Feature: Admin Page
  Background:
    Given a user is on the login page
    When a user enters admin credentials
    Then the add new product button is visible
    Given A user is on the main page
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
