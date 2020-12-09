Feature: Google Search Feature
  @googleSearh
  Scenario Outline: Performing google search for keywords
      Given I am on the open browser and open google
      When  Then I search for "<keyword>" on google page
    Examples:
      | keyword    |
      | java       |
      | webdriver  |
      | docker     |
      | kubernetes |

#  @ddgSearch
#  Scenario Outline: I want to search on duck-duck-go site
#    Given I am on the website duck-duck-go
#    And   I enter the "<keyword>" to search
#    And   I navigate to videos search
#    Then  I should get minimum "<seachCount>" search results
#
#    Examples:
#      | keyword    | seachCount|
#      | java       |      4    |
#      | webdriver  |      4    |
#      | docker     |      4    |
#      | kubernetes |      59   |
#      | aajtak     |      59   |
