@smoke
Feature: Selenium Actions Demonstration
  As a test automation engineer
  I want to test UI features
  so that I can promote my application to production
  

  @search
  Scenario Outline: Simple Selenium Actions
    Given I visit bing.com
    When I search bing for <searchTerm>
    Then bing retrieves more than one page of <searchTerm>
    

    Examples:
    | searchTerm |
    | selenium   |
