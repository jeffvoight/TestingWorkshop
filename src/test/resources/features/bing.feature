@smoke
Feature: Bing Search Demonstration
  As a beginner cook
  I want to search bing.com for recipes
  so that I can cook meals for my friends and family
  

  @search
  Scenario Outline: Simple Bing Search
    Given I visit bing.com
    When I search bing for <searchTerm>
    Then bing retrieves more than one page of <searchTerm>
    

    Examples:
    | searchTerm |
    | fish lip recipes |

