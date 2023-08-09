Feature: Customer
Background: Below are the common steps

Given User launched the Chorme
When User opens URL "https://admin-demo.nopcommerce.com/"
And User enters Emails as "admin@yourstore.com" and password as "admin"
And User clicks on Login
Then User views Dashbord

Scenario: Add Customer

When User clicks Add Customer menu
And clicks on customer menu item
And clicks on Add new button
Then user can view add new customer page
When user enter customer info
And clicks on save button
Then user can veiw the message "The new customer has beeen added successfully."
And Close browser


Scenario: Search a Customer by Email

When User clicks Add Customer menu
And clicks on customer menu item
And Enter customer email
When click on search button
Then user should found email in search table
And Close browser

@Sanity
Scenario: Search a Customer by First and Last Names

When User clicks Add Customer menu
And clicks on customer menu item
And Enter customer firstName and lastName
When click on search button
Then user should found Name in search table
And Close browser


