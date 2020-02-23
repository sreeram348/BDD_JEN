
Feature: As a Customer, I want to modify my profile details, so that I can enter my valid Address details.

@tag1
Scenario: Registered user can modify his credentials in his profile page.
Given Registered user
When User modify his profile page
And Click on Submit
Then A pop up message displays regarding changes made in profile page.

