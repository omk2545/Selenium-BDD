Feature: Google Search Feature
  @googleSearh  @sanity
  Scenario Outline: Performing google search for keywords
      Given I am on the open browser and open google
      When  Then I search for "<keyword>" on google page
    Examples:
      | keyword    |
      | java       |
      | webdriver  |
      | docker     |
      | kubernetes |