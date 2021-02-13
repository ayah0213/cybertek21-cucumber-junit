Feature: Google search functionality
  Agile story: As a user, when im on the google search page,
  I should be able whatever
  I want , and see the relevant information


  Scenario: Search page title verification
    Given User is on Google home page
    Then User should see in the title


  #test
  Scenario: User search title verification
    Given  User is on Google home page
    When  User searches for apple
    Then User should see apple in the title

    @orange
  Scenario: User search for title verificaion
    Given User is on Google home page
    When User searches for "orange"
    Then User should see "orange" in the title
