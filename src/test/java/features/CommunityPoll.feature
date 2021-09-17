Feature: Navigate to nop commerce website
  In order to Vote for community poll
  As a user
  User should be registered and click on one of radia buttons and click vote

  Background:
    Given User navigates to url "https://demo.nopcommerce.com/"
    Then User should be navigated to home page "nopCommerce demo store"

  @NegativeTest
  Scenario: Verify Community Poll - Negative Scenario 1 Without logging in
    When User selects any of the radio button "2"
    And  User clicks on the Vote button
    Then User should see an error message "Only registered users can vote."

  @NegativeTest
  Scenario: Verify Community Poll - Negative Scenario 2 Without logging in
    When User clicks on the Vote button
    Then User should see an alert message - "Please select an answer"

  @EndToEnd  @ui
  Scenario: Verify Community Poll - Positive Scenario 3 after logging in
    When User clicks on Log in link on the Navigation bar
    Then User should be navigated to login page "nopCommerce demo store. Login"
    When User enters email "test_user1@nop.com"
    And  User enters password "testuser1"
    And  User clicks on log in button
    And  User selects any of the radio button "2"
    And  User clicks on the Vote button
    Then User should see total number of votes for all the choices