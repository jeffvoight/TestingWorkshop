@smoke
Feature: Selenium Actions Demonstration
  As a test automation engineer
  I want to test UI features
  so that I can promote my application to production
  

  @search
  Scenario Outline: Simple Selenium Actions
    Given I visit automationpractice.com
    When I shop for Women's clothing
    Then I can select Tshirts
    

    Examples:
    | searchTerm |
    | selenium   |
