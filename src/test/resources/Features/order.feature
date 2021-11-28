@smoke
Feature: To test the functionality of shopping website

  Background: Sign-in to website
    Given user is navigated to automationpractise url
    And registered user should be able to login successfully

  Scenario Outline: Order T-Shirt and Verify in Order History
    When user orders Tshirt via Tshirt tab
    And Click on proceed to checkout button for further processing
    And verify details in summary and signed terms & conditions
    And Make a payment and click on Confirm my order
    Then User should be able to view the <orderref> in Order history

    Examples: 
      | orderref  |
      | CAFLARSRB |
      | JHHQLOIBQ |
      | PNTVJSKHS |

  Scenario: Update Personal Information (First Name) in My Account
    When user navigate to My personal information section
    Then user should able to update below firstnames
      | firstname |
      | TESTLM    |
      | TESTKM    |
      | TESTFM    |
      | TESTDM    |
