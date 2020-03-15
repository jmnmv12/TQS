Feature: Finding words
  Everybody wants to find words

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"