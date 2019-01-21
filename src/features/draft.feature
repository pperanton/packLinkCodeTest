#Author: pperanton@gmail.com
#Keywords Summary : Code Test - QA Automation Engineer
#Prepare a working, suitable for automation test suite including instructions on how to run it, with the following Gherkin style scenarios as base. Extending the use cases is a plus.
@draft
Feature: Draft
  		User will login and create a new search and select first item in service list.
  		It will be saved then and it will appear on the list of dashboard user.

  #I was unable to solve a NPE that occured when trying to use the webDriver or any other Background step from the other register.feature (Register.java) or search.feature (Search.java). While not declaring it on the Search.java, all the driver.* calls will return an error,
  #but declaring with same name the webDriver and using the same Background step, will result in a NPE.
  #So in the end, mostly by time constrains, I applied a workaround renaming the background steps and search steps. It is not ideal, but it will work for now until I had time to solve this issue.
  
  Background: 
    Given any web Browser and an internet User2
    And navigating to https://pro.packlink.es/login2
    Then I use existing data for credentials2
    Then I click on Access button2

  @Shipment_search&draft
  Scenario: Basic Shipment Search
    When validate pro dashboard is accesible2
    When clicking on the Anadir envio button2
    Then validate user is on Shipment Details page2
    And User enters Madrid FROM origin and select an item2
    And User enters Madrid TO destination and select an item2
    And add weight2
    And add lenght2
    And add width2
    And add height2
    Then User click on Prices button2
    When validating if User is on next page2
    Then User selects first item on the Services list2
    And validate if User is on the next page2
    Then click on Save button
    When User is back to dashboard
    Then validate item appears on the draft list
