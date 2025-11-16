Feature: Calculator
  As a user
  I want to use a calculator
  So that I can perform basic arithmetic operations

  Scenario: Add two positive numbers
    Given I have two numbers: 2 and 8
    When the calculator sums them
    Then I should get 10 as result

  Scenario: Add two negative numbers
    Given I have two numbers: -5 and -3
    When the calculator sums them
    Then I should get -8 as result

  Scenario: Add positive and negative numbers
    Given I have two numbers: 10 and -4
    When the calculator sums them
    Then I should get 6 as result
