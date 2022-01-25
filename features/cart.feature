Feature: Cart Page
  Background:
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
    Given A user is on the main page
    When A user clicks on a product
    Then The user will be redirected to the product page
    Given a user is on the product page
    When a user clicks on the add to cart button
    Then the user will be notified with a message
    When a user clicks the go to cart button
    Then the user will be redirected to the cart page

  Scenario: A user can remove an item from their cart
    Given a user is on the cart page
    When a user deletes an item from cart
    Then the user can see that item was removed
  Scenario: A user can click the checkout button to go to the checkout page
    Given a user is on the cart page
    When a user clicks on the checkout button
    Then the user is redirected to the checkout page
  Scenario: A user can click on the continue shopping button to go back to main page
    Given a user is on the cart page
    When a user clicks on the continue shopping button
    Then the user is redirected to the main page
  Scenario: A user can see the total change to the correct amount
    Given a user is on the cart page
    When a user increases the quantity of an item
    Then the user can see the respective quantity and price is the same as the total