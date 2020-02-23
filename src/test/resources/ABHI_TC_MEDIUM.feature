Feature: As registered user, user want to perform payment to other registered user and wants transaction should be reflected in Account information module

@tag1
Scenario: To Verify whether application allows member to perform payment to other registered member & same should get reflected in accounts information module

Given as a registered user
When User log in and click on account link and then member payment link
	And valid credentials in login,amount and description textbox are entered and submitted
Then click on submit button and then account information link