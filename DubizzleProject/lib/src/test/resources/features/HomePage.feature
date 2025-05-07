Feature: Verify Car Search Functionalities on Home Page

Scenarios:

# Scenario 1: Search for DODGE Challenger on HomePage
 Scenario: Search for DODGE Challenger on HomePage
  Given I am on dubizzle Home page
  When I Search for "<SearchCar>" car
  Then I should see the search refine page having "<SearchCar>"
Examples:
| category | SearchCar       |
| Motors   | DODGE Challenger|

# Scenario 2: Click on DODGE Challenger from Search suggestions
 Scenario: Click on DODGE challenger from Search suggestions
  Given I am on dubizzle Home page
  When I Search for "<SearchCar>" car
  Then Select "<Model>" from suggestions drop down

Examples:
| category | SearchCar       | Model     |
| Motors   | DODGE Challenger| challenger|
