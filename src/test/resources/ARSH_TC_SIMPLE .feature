Feature: As a Registered user, i want to login to the application, so that i can access the application securely.
@tag1
Scenario:  To verify whether application allows user to login as a member on the application
Given An application 
When Entering valid credentials in Login name, Password textbox
And Click upon submit button
Then Member home page should get displayed
  

 