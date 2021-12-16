Feature: Validation of order id in 

Scenario: TC01_Validation of Order id
Given User launch web application
When User enter the login and password
And User clicks on login Button
Then User verify Search Hotel page is displayed
When User select the location, hotels, roomType, numberofRomms, checkInDate, chechOutDate, adultssPerRoom, childrenPerRoom
And User clicks on Search Button
Then User verify Select Hotel page is displayed
And User clicks on radio Button
And User clicks on Continue Button
Then User verify Book A Hotel page is displayed
When User enter the firstName, lastName, billingAddress, creditCardNo, creditCardType, expiryMonth, expiryYear and cvvNumber
And User clciks on Book Now Button
Then User verify Booking Confirmation page is displayed
Then User verify the Order No
And Usre clicks on Logout Button

Scenario Outline: TC02_Validation of Order id
Given User launch web application
When User enter the login and password
And User clicks on login Button
Then User verify Search Hotel page is displayed
When User select the "<location>", "<hotels>", "<roomType>", numberOfRomms, checkInDate, chechOutDate, adultssPerRoom, childrenPerRoom
And User clicks on Search Button
Then User verify Select Hotel page is displayed
And User clicks on radio Button
And User clicks on Continue Button
Then User verify Book A Hotel page is displayed
When User enter the "<firstName>", "<lastName>", "<billingAddress>", "<creditCardNo>", "<creditCardType>", "<expiryMonth>","<expiryYear>" and "<cvvNumber>"
And User clciks on Book Now Button
Then User verify Booking Confirmation page is displayed
Then User verify the Order No
And Usre clicks on Logout Button

Examples:
|location|hotels|roomType|firstName|lastName|billingAddress|creditCardNo|creditCardType|expiryMonth|expiryYear|cvvNumber|
|Sydney|Hotel Sunshine|Standard|Venkatesh|sel|Cuddalore|6473849384756345|VISA|February|2022|6574|
|Melbourne|Hotel Hervey|Double|Venkatesh|sel|Cuddalore|6473849384756546|VISA|February|2022|6374|
|Los Angeles|Hotel Cornice|Double|Venkatesh|sel|Cuddalore|6473849394756546|VISA|February|2022|8374|
|New York|Hotel Hervey|Double|Venkatesh|sel|Cuddalore|6473849384754547|VISA|February|2022|7374|
|New York|Hotel Hervey|Double|Venkatesh|sel|Cuddalore|6473849384754558|VISA|February|2022|7354|
