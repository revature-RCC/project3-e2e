Feature: Main Page

  Scenario: A user can go to register page
    Given A user is on the main page
    When A user clicks on the register button
    Then The user will be redirected to register page
  Scenario: A user can go to login page
    Given A user is on the main page
    When A user clicks on the login button
    Then The user will be redirected to login page
  Scenario: A user can go to a product page
    Given A user is on the main page
    When A user clicks on a product
    Then The user will be redirected to the product page
  Scenario: A user can search for a product
    Given A user is on the main page
    When A user inputs a search in the search bar
    Then The user will be able to see searched items
  Scenario: A user can go to cart page
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
    Given A user is on the main page
    When A user clicks on the cart icon
    Then The user will be redirected to the cart page
  Scenario: A user can alternate between light and dark mode
    Given A user is on the main page
    When The user clicks on the dark mode button
    Then Then the color scheme will change
  Scenario: A user will see a sale tag and a sale price
    Given A user is on the main page
    Then The user can see sale tags and sale prices
