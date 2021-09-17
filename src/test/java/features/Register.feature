Feature: Register to nop commerce website
  In order to Register
  As a user
  User should provide required credentials in register page

  Background:
    Given User navigates to url "https://demo.nopcommerce.com/"
    Then User should be navigated to home page "nopCommerce demo store"
    When User clicks on Register link on the Navigation bar
    Then User should be navigated to Register page "nopCommerce demo store. Register"

  @NegativeTest
  Scenario: 1. Verify Register functionality leaving all required credentials blank - Negative scenario
    When User Clicks on Register button
    Then User should be prompted to enter the required fields to Register

  @EndToEnd
  Scenario: 2. Verify Register functionality filling all required credentials  - Positive scenario
    When User enters gender firstName lastName day month year eMail companyName password confirmPassword
      | gender | firstName | lastName |  day | month | year     |   email             | companyName | password    | confirmPassword |
      |   F    | test      | user     |   4  | 6     | 2000     | test_user1@nop.com  |             | testuser1   | testuser1       |
    When User Clicks on Register button
    Then User should see message "Your registration completed"

