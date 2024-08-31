@Pages
Feature: Pages
    this test case is to make sure that user could 
    login and navigating to all

  Background: The user is already login
    Given user is on url "https://www.saucedemo.com/"
    Given user is navigated to Login Page
    When user fill "standard_user" in "Username" Textbox
    Then Textbox "Username" is filled by "standard_user"
    When user fill "secret_sauce" in "Password" Textbox
    Then Textbox "Password" is filled by "secret_sauce"
    When user click on LOGIN Button
    Then user is navigated to "Products" page

  @Test-2
  Scenario: Test-2 User add 1 item to cart
    When user click on BURGER MENU Button
    Then MENU BAR is "expanded"
    And MENU "About" is "appear"
    When user click on MENU "About"
    Then user is navigated to ABOUT page
