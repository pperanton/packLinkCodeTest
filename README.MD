# PACKLINK PRO CODE TEST

## INTRODUCTION
This full suite automatization test code has been developped to cover the expected Features covered by the _Code_Test_QA_Engineer.pdf_ document.

The tests will cover the following:
* Feature: Register
* Feature: Search
* Feature: Draft Shipments


## INSTALLATION GUIDE

In order to run this test suite, follow the instructions below:
1. Download the repository to local.
2. Using an IDE (Eclipse or Netbeans) load it to the project list.
3. Add all the jars contained in lib/jars/ to the project. To do so:
   - Right-click on the project name on IDE.
   - Properties > Java Build Path > Libraries > Add external JARs...
   - Then select the jar files contained in lib/jars/
4. Use the testRunner.java to `Run As` a JUnit Test.
5. You can uncomment the tags value on testRunner.java file and add any of the Features needed.

```
Note: installing webDrivers won't be needed are they are loaded from lib/drivers/ folder.
Note: JDK version used in this project: jdk1.8.0_121.jdk
```

### Supported OS

This project was build on a Mac OS, so the ChromeDriver it is set by default to the Mac one. In order to run it on other OS, please modify the following lines from _configuration.properties_ file under src/config/ folder:

```
# Mac ChromeDriver
ChromeDriverPath = lib/drivers/chromedriver

# Linux ChromeDriver
#ChromeDriverPath = lib/drivers/chromedriverlinux

# Windows ChromeDriver 
#ChromeDriverPath = lib/drivers/chromedriver.exe
```

Comment and uncomment depending on your OS. Please note that this has not been tested properly.


## KNOWN ISSUES / AREAS TO IMPROVE

### Known Issues
* Inside the code you will find some comments regarding issues I encountered during the development of this test Suite.
The most big Known Issue will be that I duplicated some of the common steps from one feature to another, since the webDriver value declaration was returning a NPE when running the JUnit Test.

* I also found some issues trying to control every error present on the register form. Some of them were not client base, so it was the web browser itself the one that were returning them. I was not able to catch those errors and validate, so an entire section of error validation was commented.

### Areas to improve

- I would like to have more time to add an automatization for launching the same suite for different web browsers. By default this suite will be run under Chrome.
- To create a data randomizer to use on User registration suite, so we can ensure we are not failing this test due to that user was previously registered.
- More technical knownledge from the web would be advisable to identify the exact xpath to some of the elements. Specially on the dashboard, where I've found some issues regarding it and, at the end, I decide to install Selenium IDE for Chrome, record the steps and then identify the actual xpath values for some of the fields on the Search.java.
- Investigate a way to implement common variables and how to store them and use them from any .java file.

