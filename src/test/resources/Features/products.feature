Feature: Product Scenario

  Scenario Outline: Validate product info on products page
    Given the user in on the product page upon successful login
    Then validate the product is listed with title "<title>" and price "<price>"

    Examples:
      | title                   | price  |
      | Sauce Labs Bolt T-Shirt | $15.99 |


  Scenario Outline: Validate product info on product details page
    Given the user is on the product page upon successful login
    When user clicks on the product title "<title>"
    Then user should be on product details page with title "<title>", price "<price>" and "<description>"

    Examples:
      | title               | price  | description                                                                                                                            |
      | Sauce Labs Backpack | $29.99 | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |
