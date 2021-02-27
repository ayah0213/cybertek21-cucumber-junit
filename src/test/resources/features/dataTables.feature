@fruits
Feature: Simple example of how dataTable work


  @SmartBear
  Scenario: User should be able to login with correct credentials
    Given User is on the login page of SmartBEar
    When USer enters below inform
    |username|Tester|
    |password| test |
    Then User sould see title changed to Web Orders





  Scenario: something happens
   # Given User does something
    Then User should see below words displayed
      | Apple    |
      | Orange   |
      | Cilek    |
      | Banana   |
      | Pineaple |
      | Peach    |



    @months
  Scenario: User hsould be able to see all 12 months in months dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
  | June      |
  | July      |
  | August    |
  | September |
  | October   |
  | November  |
  | December  |

   # To organized pipes cntrl+alt+L
  # for muptiple PIPES = ctrl +D