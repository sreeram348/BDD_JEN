
Feature: As a registered user, user want to change user's login password for the application so that, user uses new password to login and Home Page is displayed
@tag1
Scenario: TO verify whether application allows member to change login password
Given As a registered user
When user click on personal link and then click on Change password link
	And valid credentials are entered in the New Password textbox
Then password is changed and user able to login with new Password