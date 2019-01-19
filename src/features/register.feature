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
| email        																 | password               						       | phoneNumber 										 |
| qacandidateppo1@packlink.es | [[password=RegEx([0-9]{6})]] | [[phoneNumber=RegEx([0-9]{9})]] |
  	
  @Registration_KO_existingUser
  Scenario: Existing User registration failed
  	Given going to https://pro.packlink.es/registro
  	When fill any of above fields with already existing user info
  	Then an error will be displayed
  
  @Registration_KO_notValidData
  Scenario: User registration failed Not valid data
  	When going to https://pro.packlink.es/registro
  	Given the registration form with 8 required fields
  	When fill any of above fields not valid/expected data
  	Then an error will be displayed
  	
  @Access_OK
  Scenario: User access
  	Given a previously registered user
		When navigating to https://pro.packlink.es/login WITH credentials <email> and random <password>
		Then it will land into the platform dashboard
		
	@Access_KO
  Scenario: User access unsuccesful
  	Given a previously registered user
		When navigating to https://pro.packlink.es/login WITH credentials <email> and incorrect <password>
		Then login error will be displayed
    
  # @tag2
  # Scenario Outline: Title of your scenario outline
  #  Given I want to write a step with <name>
  # When I check for the <value> in step
  # Then I verify the <status> in step
    # Examples: 
    #  | name  | value | status  |
    #  | name1 |     5 | success |
    #  | name2 |     7 | Fail    |