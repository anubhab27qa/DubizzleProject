Feature: Verify Functionalities on Home Page

Scenarios:

# Scenario 1: Search for DODGE under Motors criteria
 Scenario: Search for DODGE under Motors criteria
  Given User is on dubizzle Home page
  When User clicks on "<category>" as category
  And User Searches for "<SearchCar>" car
  Then User should see the search refine page having "<SearchCar>"
Examples:
| category | SearchCar       |
| Motors   | DODGE Challenger|

# Scenario 2: Click on DODGE Challenger from Search suggestions
 Scenario: Click on DODGE challenger from Search suggestions
  Given User is on dubizzle Home page
  When User clicks on "<category>" as category
  And User Searches for "<SearchCar>" car
  Then Select "<Model>" from suggestions drop down

Examples:
| category | SearchCar       | Model     |
| Motors   | DODGE Challenger| challenger|
