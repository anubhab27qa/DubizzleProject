Feature: Verify Functionalities on Home Page

Scenarios:

# Scenario 1: Search for DODGE Challenger on HomePage
 Scenario: Search for DODGE Challenger on HomePage
  Given I am on dubizzle Home page
  When I Search for "<SearchCar>" car
  Then I should see the search refine page having "<SearchCar>"
Examples:
| SearchCar       |
| DODGE Challenger|

# Scenario 2: Choose Dodge Challenger from search suggestion box
 Scenario: Choose Dodge Challenger from search suggestion box
  Given I am on dubizzle Home page
  When I Search for "<SearchCar>" car
  Then Select "<Model>" from suggestions drop down

Examples:
| SearchCar       | Model     |
| DODGE Challenger| challenger|
