Feature: verify Products after successful login

  As a user of the SauceDemo website
  I want to be able to log in with my account
  So that I can add items to cart and complete transaction

  Background:
    Given I am on the sauce demo login page
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully


  Scenario: verify missing products
    Given the "Dummy Product" is not present on the page
    Then logout of app

  Scenario Outline: verify product and add to cart
    Given the "<product>" is present on the page
    When the "<product>" is found print its price to console
    And add "<product>" and "<secondProduct>" items to the cart
    When cart icon is clicked
    And verify "<product>" and "<secondProduct>" items price in the cart
    When click checkout button
    And fill "<firstName>" "<lastName>" "<zip>" form details and continue
    Then verify the "<product>" "<secondProduct>" prices and "<totalPrice>" price
    And click Finish button to verify order is complete
    Then logout of app

    Examples:
      | product                 | productPrice | secondProduct         | secondProductPrice | totalPrice | firstName | lastName | zip    |
      | Sauce Labs Bolt T-Shirt | 15.99        | Sauce Labs Bike Light | 9.99               | $25.98     | TestFN    | TestLN   | T3N0P5 |