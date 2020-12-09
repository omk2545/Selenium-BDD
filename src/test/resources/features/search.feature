Feature: Duck Duck Go Search

@duckDuckGoFeature
  Scenario Outline: I want to search on duck-duck-go site
    Given I am on the website duck-duck-go
    And   I enter the "<keyword>" to search
    And   I navigate to videos search
    Then  I should get minimum "<seachCount>" search results

  Examples:
    | keyword    | seachCount|
    | java       |      4    |
    | webdriver  |      4    |
    | docker     |      4    |
    | kubernetes |      11   |
