Feature: Phone Number Validation

  Scenario Outline: Phone number should not be empty
    Given I have a phone number "<phone>"
    When I check the phone number
    Then the phone number should <result>

    Examples:
      | phone           | result       |
      | 123-456-7890    | not be empty |
      | 098-765-4321    | not be empty |
      | 0672339843      | not be empty |
      |                 | be empty     |