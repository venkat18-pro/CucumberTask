Feature: Validation of order id in 

Scenario: TC01_Validation of Order id
Given User launch web application
When User enter the login and password
And User clicks on login Button
Then User verify Search Hotel page is displayed
When User select the Location, Hotels, Room Type, Number of Romms, Check in date, chech out date, adultss per room, children per room
And User clicks on Search Button
Then User verify Select Hotel page is displayed
And User clicks on radio Button
And User clicks on Continue Button
Then User verify Book A Hotel page is displayed
When User enter the firstName, lastName, Billing address, Credit Card No, Credit Card Type, Expiry date, and cvv Number
And User clciks on Book Now Button
Then User verify Booking Confirmation page is displayed
Then User verify the Order No
And Usre clicks on Logout Button