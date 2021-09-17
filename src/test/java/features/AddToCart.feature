Feature: Search Laptop and add to cart in nop commerce website
  In order to search and add item to cart
  As a User
  User should search for item and add it to cart

  Scenario: Search for Laptop and add item to cart
    Given User navigates to url "https://demo.nopcommerce.com/"
    Then User should be navigated to home page "nopCommerce demo store"
    When User enters search item "Laptop" into Search textbox in Home page
    And  User clicks on Search Store button
    Then User should be navigated to search page "nopCommerce demo store. Search"
    When User clicks on Add to Cart button
    Then User should see "The product has been added to your shopping cart" message on notification bar
    When User clicks on Shopping cart link on the Navigation bar
    Then User should be navigated to Shopping Cart page "nopCommerce demo store. Shopping Cart"


