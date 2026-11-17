Feature: Online banking on ParaBank
  As a bank customer
  I need to manage my accounts online
  So that I can register, open accounts, transfer funds and keep my data updated

  Scenario: Register, open a savings account and transfer funds
    Given Daniela is on the ParaBank home page
    When she registers with valid personal data
    And she opens a new savings account
    And she transfers 100 dollars between her accounts
    Then she should see the message "Transfer Complete!"

  Scenario: Update customer information
    Given Mariana is registered and logged in to ParaBank
    When she updates her contact information
    Then she should see the message "Profile Updated"

  Scenario: Login with invalid credentials
    Given Juan Manuel is on the ParaBank home page
    When he logs in with an unknown user
    Then he should see the error "The username and password could not be verified."

  Scenario Outline: Registration fails with missing data
    Given Juan Manuel is on the ParaBank registration page
    When he registers leaving "<field>" empty
    Then he should see the error "<message>"

    Examples:
      | field      | message                 |
      | first name | First name is required. |
      | last name  | Last name is required.  |
      | password   | Password is required.   |