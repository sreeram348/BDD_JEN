Feature: As a  admin ,I want to add a new  member to the group so that i can give permissions to the 
group member.
@tag1
Scenario:To create a new group list and provide access to group members.
Given as an admin
When Entering valid Credentials in Member Login Text box upon Click on submit button of change group Permission 
And Click on new group list box to enter valid credential in comments text box upon 
And click on submit
Then A popup must displayed "Change of group for member name  page should get displayed"
