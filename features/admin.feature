Feature: Admin Page
  Background:
    Given a user is on the login page
    When a user enters admin credentials
    Then the add new product button is visible
    Given A user is on the main page

  Scenario: An Admin tries to make a new product without adding a name
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When The Admin submits the form without adding a name
    Then The form produces an error message on the name field

  Scenario: An Admin tries to make a new product without adding a description
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When The Admin submits the form without adding a description
    Then The form produces an error message on the description field

  Scenario: An Admin tries to make a new product without adding a regular price
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When The Admin submits the form without adding a regular price
    Then The form produces an error message on the price field

  Scenario: An Admin tries to make a new product without adding an image
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When The Admin submits the form without adding image
    Then The form produces an stays the same and has place holder image

  Scenario: User successfully changed the name of the product
    When An admin clicks on a product
    Then The admin is redirected to the product page
    Given The admin is redirected to the product page
    When The admin changes the name of the product
    Then The admin is redirected to the main page and can see the product name changed

  Scenario: User successfully changed the description of the product
    When An admin clicks on a product
    Then The admin is redirected to the product page
    Given The admin is redirected to the product page
    When The admin changes the description of the product
    Then The admin is redirected to the main page and can see the product description changed

  Scenario: User successfully changed the price of the product
    When An admin clicks on a product
    Then The admin is redirected to the product page
    Given The admin is redirected to the product page
    When The admin changes the price of the product
    Then The admin is redirected to the main page and can see the product price changed

  Scenario: User successfully changed the sale price of the product
    When An admin clicks on a product
    Then The admin is redirected to the product page
    Given The admin is redirected to the product page
    When The admin changes the sale price of the product
    Then The admin is redirected to the main page and can see the product sale price changed

  Scenario: User successfully changed the stock amount of the product
    When An admin clicks on a product
    Then The admin is redirected to the product page
    Given The admin is redirected to the product page
    When The admin changes the stock amount of the product
    Then The admin is redirected to the main page and can see the product stock amount changed

