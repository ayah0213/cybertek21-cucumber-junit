Feature: Google search functionality
  Agile story: As a user, when im on the google search page,
  I should be able whatever
  I want , and see the relevant information

  //test
  Scenario: User search title verification
    Given  User is on Google home page
    When User searches for apple
    Then User should see apple in the title