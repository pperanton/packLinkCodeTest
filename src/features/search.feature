#Author: pperanton@gmail.com
#Keywords Summary : Code Test - QA Automation Engineer
#Prepare a working, suitable for automation test suite including instructions on how to run it, with the following Gherkin style scenarios as base. Extending the use cases is a plus.
@search
Feature: Search
  User will login and create a new search and select first item in service list.

  #I was unable to solve a NPE that occured when trying to use the webDriver or any other Background step from the
  #other register.feature (Register.java). While not declaring it on the Search.java, all the driver.* calls will
  #return an error, but declaring with same name the webDriver and using the same Background step, will result in a NPE.
  #So in the end, mostly by time constrains, I applied a workaround renaming the background steps. It is not ideal
  #but it will work for now until I had time to solve this issue.
  
  Background: 
    Given any web Browser and an internet User1
    And navigating to https://pro.packlink.es/login1
    Then I use existing data for credentials1
    Then I click on Access button1

  @Shipment_search
  Scenario: Basic Shipment Search
    When validate pro dashboard is accesible
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
