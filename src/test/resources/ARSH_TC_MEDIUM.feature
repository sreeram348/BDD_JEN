Feature: As a admin, i want to perform payments in the application, so that member can view payment details made by admin.
@tag1
Scenario:  To Verify whether application allows member to view payment details made by admin
Given An application logged in as admin
When i open the payment system to member to enter credentials in Amount textbox upon clicking submit buttons
And click on Logout button to login as a member.
And click on Account tab
Then Member should be able to view payment details added by admin should get displayed.


