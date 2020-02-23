
Feature: Title of your feature
	As A admin, I want to add an advertisement in the application so that the member can view the advertisments

@tag1
Scenario: To verify whether application allows member  to view added advertisement by the admin
Given as an Application logged in as admin
When I open the manage advertisments of a valid user to insert new credentials , check the radio button upon clicking submit buttons
And Click on Logout button to login as a member.
And click on personal tab
Then Member should  be able to view the Advertisement added by admin should get displayed
