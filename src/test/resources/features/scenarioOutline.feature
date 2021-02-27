Feature: Smartebar order feature
@scenarioOutlineSmarteBear
  Scenario Outline: User oredring a propduct from orders page

    Given User is logged into SmartBear Tester account and on Order page
    Then User fills out the form as followed from the table below:
    And User selects "<product>" from product dropdown
    And User enters "<quantity>" to quantity
    And User enters "<expected name>" to costumer name
    And User enters "<street>" to street
    And User enters "<city>" to city
    And User enters "<state>"  to state
    And User enters "<zip>" to zip
    And User selects "<cardType>" as card type
    And User enters "<card number>" to card number
    And User enters "<expiration date>" to expiration date
    And User clicks process button
    And User verifies "<actual name>" is in the list
    Examples:
      | product | quantity | expected name | street         | city   | state   | zip   | cardType | card number         | expiration date | actual name |  |
      | MyMoney | 2        | jamal         | 122 London str | London | chelsea | 55565 | visa     | card785448725544872 | 12/21           | jamal         |  |