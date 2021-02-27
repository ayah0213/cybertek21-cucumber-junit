@1
Feature: Library app login feature
  As a user, I should be able to login with credentials to different accounts. And dashboard
  Accounts are: librarian, student, admin

  Background:  User is already in login page
    Given user is on login page

    # Backround works by order
    # once we used Background will applied for all
    # if the step is repeated

@librarian @employee
  Scenario: Login as librarian
    # Given user is on login page

    When user enters librarian username
    And user enter librarian password
    Then user should see dashboard

 @student
  Scenario: Login as students
  #Given user is on login page
  When user enters student username
  And user enters student password
  Then user should see dashboard

@admin @employee @db
  Scenario: Login as admin
    #Given user is on login page
    When user enters admin username
    And user enters admin password
    Then user should see dashboard




    # Windows alt+ enter
  #MAc opt +enter
