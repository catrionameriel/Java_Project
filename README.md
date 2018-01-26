# Concert Venue Booking System
Goal: Practice OO modelling in Java (unit tests, no UI)

You are required to build an app that allows a Music Venue to sell Tickets to Customers.

## MVP
The Venue must be able to:

* Make a Ticket sale
  - The customer funds go down, venue sales go up
* Give a refund
  - The customer funds go up, shop funds go down
* Report on income
  - Total sales minus total refunds
* Add/Remove sales, events, tickets
* Have a capacity which when is full, stops anymore tickets being sold
* Be able to input/change prices

The Customer must:

* Have a collection of possible Payment Methods:
 - CreditCard (default), DebitCard
* Be able to select a Payment Method to pay at any Venue
* Be able to select a Payment Method to receive a refund onto a given Payment Method
(You may find HashMaps useful for this project)

## Project Extensions
* Add seating/unreserved and standing options
* Add age limit
* Add allocated seating
* Add concession prices
* Add collection method
* Add booking/payment fee (could be different for different payment/collection method)
* Add venues
