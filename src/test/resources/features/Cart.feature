@Cart
Feature: Cart
    this test case is to make sure that user could 
    login and add product to cart

  Background: The user is already login
    Given user is on url "https://www.saucedemo.com/"
    Given user is navigated to Login Page
    When user fill "standard_user" in "Username" Textbox
    Then Textbox "Username" is filled by "standard_user"
    When user fill "secret_sauce" in "Password" Textbox
    Then Textbox "Password" is filled by "secret_sauce"
    When user click on LOGIN Button
    Then user is navigated to "Products" page

  @Test-1
  Scenario: Test-1 User add 1 item to cart
    When user click Button "Add to cart" on product "Sauce Labs Backpack"
    Then on product "Sauce Labs Backpack" Button "Remove" is "appear"
    And on product "Sauce Labs Backpack" Button "Add to cart" is "disappear"
    And ICON CART BADGE is filled by number 1
    When user click on ICON CART
    Then user is navigated to "Your Cart" page
    Then validate product "Sauce Labs Backpack" is "exists"
