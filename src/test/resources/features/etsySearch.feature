
Feature: Etsy serach feature
  @q1
  Scenario:  Etsy default title verification
    Given user is on the Etsy landing page
    Then user should see Etsy title as wxpected

    # expected Etsy title : Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  @q2
  Scenario: Etsy search title verification
    Given  user is on the Etsy landing page
    When user seraches for "wooden spoon"
    Then user should see "Wooden Spoon"in the Etsy title