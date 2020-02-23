Feature:As a member,I want to  perform the system payment so that account information details get displayed.
tag@1
Scenario:To verify whether the application allows the member to perform the system payment
Given as an member
When Click on Account tab upon select system payment link 
And  Valid credentials in Amount textbox,Transaction type and Description textbox are entered and selected
And  Click on submit button and Account Information link
Then A popup must be displayed "The payment has been performed"