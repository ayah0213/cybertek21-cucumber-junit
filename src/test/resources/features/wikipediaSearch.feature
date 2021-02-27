@wiki
Feature: Wikipidea search feature
  As a user, I should be able to search terms and see related results


  Background: Given user on WIki page
    Given User is on Wiki home page


  Scenario: Wikipedia search functionality title verification
    When User types "Steve Jobs" in the wiki search box
    When User clicks Wiki search button
    Then User sees "Steve Jobs" is in the wiki title

  Scenario: Wikipedia search header verification
    When User types "Steve Jobs" in the wiki search box
    And User clicks Wiki search button
    Then USer sees "Steve Jobs" in the main header

  @scenarioOutlline
  Scenario Outline: Wikipedia search header verification
    When User types "<searchValue>" in the wiki search box
    And User clicks Wiki search button
    Then USer sees "<expectedMainHeader>" in the main header
    Then User sees "<expectedTitle>" is in the wiki title

    Examples: search terms we re going to search in wikipedia
      | searchValue  | expectedMainHeader | expectedTitle |
      | Steve Jobs   | Steve Jobs         | Steve Jobs    |
      | Kuzzat Altay | Kuzzat Altay       | Kuzzat Altay  |
      | Kobe Bryant  | Kobe Bryant        | Kobe Bryant   |
      | Elon Musk    | Elon Musk          | Elon Musk     |
      | Bill Gates   | Bill Gates         | Bill Gates    |
      | Chuck Norris | Chuck Norris       | Chuck Norris  |
      | Marie Curie  | Marie Curie        | Marie Curie   |


