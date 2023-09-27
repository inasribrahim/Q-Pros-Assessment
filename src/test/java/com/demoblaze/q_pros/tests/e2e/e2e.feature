Feature: E2E
  As a user,
  I want to be able to log into the DemoBlaze website,
  So that I can browse and select products, add them to my cart, place an order, and provide my account details for purchase

  Scenario Outline: Log into DemoBlaze and Complete Purchase
    Given click on sign up button in home page
    When  user enter a username "<username>" and password "<password>" in sign up page
    Then  validate that message should be "<successMessage>" in alert
    When  user enter a username "<username>" and password "<password>" and login
    Then  validate that "<username>" should be appear in menu
    Then  validate that logout button should be appear in home page
    When  user click on product name "<productName>"
    Then  validate that product name should be "<productName>"
    And   validate that price of product should be the same
    When  click on add to cart button in product page
    Then  validate that message should be "<message>" in alert
    When  click on cart button in header
    Then  validate that product name should be "<productName>" in cart page
    And   validate that price of product name "<productName>" should be the same in cart page
    And   validate that total price should be correct for all products
    When  click on place order button in cart page
    And   validate that total price should be correct in place order page
    And   fill country "<country>" and city "<city>" and credit cart "<creditCart>" and month "<month>" and year "<year>"
    And   click on purchase button in place order screen
    And   validate that message after adding order in place order should be "<messageSuccess>"
    Examples:
      | username     | password | successMessage      | productName        | message        | country | city     | creditCart     | month    | year     | messageSuccess |
      | ibrahim      |  1234    | Sign up successful. | Samsung galaxy s7  | Product added. | Egypt   | Cairo    | 12312456       | 9        |  2023    | Thank you for your purchase! |
