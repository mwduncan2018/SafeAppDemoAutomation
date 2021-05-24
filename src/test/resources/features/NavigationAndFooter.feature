Feature: Navigation and Footer

  Scenario: Safe App Demo footer
    Given I navigate to the Product List page
    Then verify the Safe App Demo text is displayed in the footer
    
  Scenario: Navigation to the Product List page
    Given I navigate to the Watch List page
    When I navigate to the Product List page
  	Then verify the Product List page is open
  
  Scenario: Navigation to the Watch List page
  	Given I navigate to the Product List page
    When I navigate to the Watch List page
    Then verify the Watch List page is open
    
  Scenario: Navigation to the Add New Product page
    Given I navigate to the Product List page
    When I click the Add New Product button
    Then verify the Add New Product page is open

  Scenario: Navigation to the Fuzzy Matching page
    Given I navigate to the Product List page
    When I click the Enable Fuzzy Matching button
    Then verify the Fuzzy Matching page is open