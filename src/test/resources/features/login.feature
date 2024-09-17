Feature: Unsuccessful Login Functionality for SauceDemo Website

  As a user of the SauceDemo website
  I want to be able to open login page
  So that I can verify invalid logins

  Background:
    Given I am on the sauce demo login page


  Scenario Outline: Unsuccessful login with invalid credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username        | password     | error_message                                       |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
