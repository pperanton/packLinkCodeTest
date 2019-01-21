#Author: pperanton@gmail.com
#Keywords Summary : Code Test - QA Automation Engineer
#Prepare a working, suitable for automation test suite including instructions on how to run it, with the following Gherkin style scenarios as base. Extending the use cases is a plus.
@register
Feature: Register
  To validate register form & to be able to register into Packlin Pro
  Convering Possitive as well as Negative workflows

  Background: 
    Given any web Browser and an internet User

  @URL&form
  Scenario: URL & registration form
    When going to urlRegister
    Then I will validate registration form with 8 required fields

  @Registration_OK
  Scenario Outline: User registration
		When going to https://pro.packlink.es/registro
    Then fill up the "<email>", "<password>" and  "<phoneNumber>" field
    And select a value in the monthly field
    And select a value in marketplace field
    And select a value in onlinePlatform field
    And click on terms&conditions field
    And click on privacyPolicy field
    Then complete the registration process
    And validate dashboard is accesible

    Examples: 
      | email                         | password | phoneNumber |
      | qacandidateppo200@packlink.es |   123456 |   999999999 |
			| qacandidateppo201@packlink.es |   123456 |   999999999 |
  
  
  
  # Here I tried to add some kind of randomizer to the below values but this idea was rejected due to time constrains.
  # 	Examples:
  #| email        																 | password               						       | phoneNumber 										 |
  #| qacandidateppo1@packlink.es | [[password=RegEx([0-9]{6})]] | [[phoneNumber=RegEx([0-9]{9})]] |
  
  
  
  @Registration_KO_existingUser
  Scenario: User registration with existing data
    When going to https://pro.packlink.es/registro
    Then fill up the email, password and  phoneNumber field with existing data
    And select a value in the monthly field
    And select a value in marketplace field
    And select a value in onlinePlatform field
    And click on terms&conditions field
    And click on privacyPolicy field
    Then complete the registration process
    Then an Already exists error will be displayed

  @Access_OK
  Scenario: User access
    Given navigating to https://pro.packlink.es/login
    Then I use existing data for credentials
    Then I click on Access button
    And validate dashboard is accesible

  @Access_KO
  Scenario: User access unsuccesful
    Given navigating to https://pro.packlink.es/login
 		Then I enter not existing credentials email and incorrect password
		Then I click on Access button
    Then login error will be displayed

    
    
    
    
    
    
#To create a proper test suite for this required/not valid data I would need more time and requirements to identify the expected
  #lenght of each field, and the accepted values for them. Then create a suite to test those possible outcomes.
  #For the time being I will focus only on empty field data and mail address validation.
  #Update: as described on Register.java code, I reject this Scenarios due to some of the error warnings were not traceable as web components.
  
  #@Registration_KO_notinputValidData
  #Scenario Outline: User registration with no input on email, password or phonenumber
  #  When going to https://pro.packlink.es/registro
  #  And I dont fill up the "<email>", "<password>" or  "<phoneNumber>" field
  #  Then complete the registration process
  #  Then an Please fill in this field. error will be displayed

#    Examples: 
#      | email                         | password | phoneNumber |
#      |                               |   123456 |   999999999 |
#      | qacandidateppo200@packlink.es |          |   999999999 |
#      | qacandidateppo201@packlink.es |   123456 |             |

#  @Registration_KO_monthlynotSelected
#  Scenario: Monthly field error display
#    When going to https://pro.packlink.es/registro
#    Then fill up the email, password and  phoneNumber field with existing data
#    Then I dont select a value in the monthly field
#    Then complete the registration process
#    Then an error Please select an item in the list. will be displayed

#  @Registration_KO_marketplacenotSelected
#  Scenario: Marketplace field error display
#    When going to https://pro.packlink.es/registro
#    Then fill up the email, password and  phoneNumber field with existing data
#    And select a value in the monthly field
#    And I dont select a value in marketplace field
#    Then complete the registration process
#   Then an error Please select an item in the list. will be displayed

# @Registration_KO_onlineplatformnotSelected
# Scenario: OnlinePlatform field error display
#   When going to https://pro.packlink.es/registro
#   Then fill up the email, password and  phoneNumber field with existing data
#   And select a value in the monthly field
#   And select a value in marketplace field
#   And I dont select a value in onlinePlatform field
#   Then complete the registration process
#   Then an error Please tick this box if you want to proceed. will be displayed

# @Registration_KO_termsConditionsnotSelected
# Scenario: Terms&Conditions field error display
#   When going to https://pro.packlink.es/registro
#   Then fill up the email, password and  phoneNumber field with existing data
#   And select a value in the monthly field
#   And select a value in marketplace field
#   And select a value in onlinePlatform field
#   And I dont click on terms&conditions field
#   Then complete the registration process
#   Then an error Please tick this box if you want to proceed. will be displayed

# @Registration_KO_privacynotSelected
# Scenario: Privacy Policy field error display
#   When going to https://pro.packlink.es/registro
#   Then fill up the email, password and  phoneNumber field with existing data
#   And select a value in the monthly field
#   And select a value in marketplace field
#   And select a value in onlinePlatform field
#   And click on terms&conditions field
#   And I dont click on privacyPolicy field
#   Then complete the registration process
#   Then an error Please select an item in the list. will be displayed