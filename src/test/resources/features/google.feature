@smoke
Feature: Google Search Demonstration
  As a beginner cook
  I want to search google.com for recipes
  so that I can cook meals for my friends and family
  

  @search
  Scenario Outline: Simple Google Search
    Given I visit google.com
    When I search for <searchTerm>
    Then I can see more than one page of <searchTerm>
    

    Examples:
    | searchTerm |
        | chicken beak recipes |
    | banana shake conflict |
    | mango shake recipes  |
    | Chicken banana recipes |
    | testing |
    | testing 2 |
    |ice tea |

