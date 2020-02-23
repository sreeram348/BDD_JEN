

Feature: As a Admin, I want to view the Loan details in view Loans.

@tag1
Scenario: To verify whether application allows admin to view loan details in view loans
Given As an Admin.
When  enters  Member's valid credentials
And Click on Submit button
Then Loan details page displayed
