#Author: pperanton@gmail.com
#Keywords Summary : Code Test - QA Automation Engineer
#Prepare a working, suitable for automation test suite including instructions on how to run it, with the following Gherkin style scenarios as base. Extending the use cases is a plus.
@search
Feature: Search
  I want to use this template for my feature file

	Background:
		Given any web Browser and an internet User
		And navigating to https://pro.packlink.es/login
    Then I use existing data for credentials
    Then I click on Access button

  @Shipment_search
  Scenario: Basic Shipment Search
    Given validate pro dashboard is accesible
    When clicking on the Anadir envio button
    Then validate user is on Shipment Details page
    And User enters Madrid FROM origin and select an item
    And User enters Madrid TO destination and select an item
    And add weight
    And add lenght
    And add width
    And add height
    Then User click on Prices button
    When validating if User is on next page
    Then User selects first item on the Services list
    And validate if User is on the next page