@Demo
Feature: As a potential client i want to interact with the mobile application
  Background:
    Given The app is loaded correctly
  
  @RegisterNewUser
  Scenario Outline:  registers a new user
    When The user goes to the Sign Up page
    And The user registers a new user with: <username>, <email>, <password>
    Then Home page is displayed
    Examples:
      | username   | email                | password |
      | automation | automation@gmail.com | 123456   |
      | automation | automation@gmail.com | 456789   |
  
  @LoginApp
  Scenario Outline:log in to the app
    When The user logs in the application with: <email>, <password>
    Then Home page is displayed
    Examples:
      | email                | password |
      | automation@gmail.com | 123456   |
      | automation@gmail.com | 456789   |
  
  @ChangesLanguage
  Scenario: changes the language and log out of the app
    And The user logs in the application with: automation@gmail.com, 123456
    And Home page is displayed
    When The user changes the language
    And The user log out of the app
    Then Login page is displayed