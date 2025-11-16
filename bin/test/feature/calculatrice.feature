Feature: Calculatrice
  Scenario: Additionner deux nombres positifs
    Given I have two numbers: 2 and 8
    When the calculator sums them
    Then I receive 10 as a result

  Scenario: Additionner deux nombres négatifs
    Given I have two numbers: -5 and -3
    When the calculator sums them
    Then I receive -8 as a result

  Scenario: Additionner un positif et un négatif
    Given I have two numbers: 10 and -4
    When the calculator sums them
    Then I receive 6 as a result
