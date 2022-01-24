Feature: Product Page
  Scenario: A user can increase the quantity to add to cart
    Given A user is on the main page
    When A user clicks on a product
    Then The user will be redirected to the product page
    Given a user is on the product page
    When a user increments the quantity of the product
    Then a user can see the quantity increases

  Scenario: A guest user clicks on the add to cart button
    Given A user is on the main page
    When A user clicks on a product
    Then The user will be redirected to the product page
    Given a user is on the product page
    When a user clicks on the add to cart button
    Then a error message appears and the user is redirected to the login page

  Scenario: A registered user clicks on the add to cart button
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

