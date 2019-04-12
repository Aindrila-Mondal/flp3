#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Giving rating to a particular product

Background:	
	Given user is on orderedproductlist page
	And   authentic user is logged in
	And   customerid is available in session
	
Scenario: adding rating to the orderedproduct
	Given orderid is passed as named parameter
	And productid brought is passed as named parameter
	When user input a rating and  hit on submit rating button
	Then rating is successfully added in database
	And  prompt is generated having message 'rating is successfully added'
	
Scenario: User is providing rating on already rating provided product
  Given user has given a rating
  When  providing rating on already rated product
  Then  alert box is generated having message 'rating is unsuccessfull'
  
Scenario: User is providing rating other than 1 to 5

  When  providing rating not in 1 to 5
  Then  alert box is generated having message 'rating is unsuccessfull'
  
  
  	
Scenario: Updating product average rating
	When User successfully added rating to the orderedproduct
	Then Average rating of that product is updated
	
Scenario: Updating merchant rating
	When User successfully added rating to the orderedproduct
	And  Updating product average rating is done successfully
	Then Rating of that particular merchant is updated based on all its products
