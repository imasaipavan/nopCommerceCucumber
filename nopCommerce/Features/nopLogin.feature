Feature:  Login

Scenario: Login with valid credentails
Given User launched the Chorme
When User opens URL "https://admin-demo.nopcommerce.com/"
And User enters Emails as "admin@yourstore.com" and password as "admin"
And User clicks on Login
Then Page title should be "Dashboard / nopCommerce administration"
When User clicks on logout link
Then Page title should be "Your store. Login"
And Close browser

Scenario Outline: Login with data driven
Given User launched the Chorme
When User opens URL "https://admin-demo.nopcommerce.com/"
And User enters Emails as "<email>" and password as "<password>"
And User clicks on Login
Then Page title should be "Dashboard / nopCommerce administration"
When User clicks on logout link
Then Page title should be "Your store. Login"
And Close browser

Examples:
 |email|password|
 |admin@yourstore.com|admin|
 |admin1@yourstore.com|admin123|
 