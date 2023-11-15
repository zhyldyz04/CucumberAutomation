@regression @product @smoke

Feature: Adding products to Cart


  Scenario Outline: Verifying adding
    Given user is on a demoblaze application
    And user clicks on the product "<product>"
    When user clicks add to cart button
    Then user sees "Product added" message on alert and clicks ok
    And user clicks on Cart button
    Then user verifies the details of the added product

    Examples:
      | product           |
      | Iphone 6 32gb     |
      | Samsung galaxy s7 |
      | Sony xperia z5    |

