Feature: Demo Blaze shopping

  Scenario Outline: Demo blaze login
    Given I am on Demo Blaze home page
    When I login using "<user_name>" and "<password>"
    Then I should see "Welcome" "<user_name>" message
    And the page title should be "STORE"
    Examples:
      | user_name | password |
      | admin     | admin    |