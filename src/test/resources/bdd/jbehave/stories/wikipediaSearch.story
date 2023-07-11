Scenario:  TDD search on wikipedia

Given I go to Wikipedia homepage
When I enter the value Test-driven development on a field named searchInput
When I click the button cdx-search-input__end-button
Then the page title contains Test-driven development
