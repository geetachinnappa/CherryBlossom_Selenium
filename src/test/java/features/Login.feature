Feature: Login to nop Commerce website
  In order to Login
  As a user
  User should provide valid registered email and password

  @EndToEnd @ui
  Scenario Outline: 1. Verify Login functionality giving valid credentials
    Given User navigates to url "https://demo.nopcommerce.com/"
    Then User should be navigated to home page "nopCommerce demo store"
    When User clicks on Log in link on the Navigation bar
    Then User should be navigated to login page "nopCommerce demo store. Login"
    When User enters email "<email>"
    And  User enters password "<password>"
    And  User clicks on log in button
    Then User should be logged in successfully

    Examples:
      |       email         |   password    |
      | test_user1@nop.com  |   testuser1   |
      | test_user2@nop.com  |   testuser2   |
      | test_user3@nop.com  |   testuser3   |
