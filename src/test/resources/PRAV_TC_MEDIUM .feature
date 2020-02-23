
Feature: As a customer, I want to repay the amount, so that the admin can view pending loan amount


@tag1
Scenario: Admin should be able to view pending loans of the members
Given Registered User
When User logs into his account and repay the amount
And Click on Ok and logs out
Then Admin logs into his account and can see pending loans

