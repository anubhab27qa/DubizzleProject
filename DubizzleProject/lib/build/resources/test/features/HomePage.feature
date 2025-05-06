Feature: Verify Functionalities on Home Page


Scenario: Search for DODGE under Motors crtiteria
Given User is on dubizzle Home page
When User clicks on MOTORs category
And User Searches for DODGE car
Then Search suggestions drop down should be visible with Dodge car options


Scenario: Click on DODGE challenger from Search suggestions
Given User is on dubizzle Home page
When User clicks on MOTORs category
And User Searches for DODGE car
Then Select DODGE Challenger from suggestions drop down
