package main.testDefinitions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.dataProvider.ConfigFileReader;

public class Register {
	
	WebDriver driver;
	WebDriverWait wait;
	
	ConfigFileReader configFileReader = new ConfigFileReader();

	/* 1st try to implement a Before hook. I commented it since was not working as expected and I put a Background instead.
	@Before("@webBrowser")
	public void openBrowser() {
		 System.setProperty("webdriver.chrome.driver", configFileReader.getChromeDriverPath());
		 driver = new ChromeDriver();
		 wait=new WebDriverWait(driver,60);
		 driver.manage().window().fullscreen();
	}*/
	
	//Background open webBrowser
	@Given("^any web Browser and an internet User$")
	public void any_web_Browser_and_an_internet_User() {
		System.setProperty("webdriver.chrome.driver", configFileReader.getChromeDriverPath());
		 driver = new ChromeDriver();
		 wait=new WebDriverWait(driver,60);
		 driver.manage().window().fullscreen();
	}


	//URL&Form scenario
	@When("^going to urlRegister$")
	public void going_to_urlRegister() {
		driver.get(configFileReader.getApplicationUrlregister());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-submit\"]")));
	
	}

	@Then("^I will validate registration form with (\\d+) required fields$")
	public void i_will_validate_registration_form_with_required_fields(int arg1) {
		//EMAIL field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-email\"]")));
		//PASSWORD field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-password\"]")));
		//PHONENUMBER field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-tel\"]")));
		//MONTHLY field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-form\"]/fieldset/fieldset/div[2]/label")));
		//MARKETPLACE
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-form\"]/fieldset/fieldset/div[3]/label")));
		//ONLINE PLATFORM field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-form\"]/fieldset/fieldset/div[4]/label")));
		//TERMS&CONDITIONS field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-form\"]/fieldset/div[3]/label")));
		//PRIVACY POLICY field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-form\"]/fieldset/div[4]/label")));
		
		driver.quit();
	}

	
	//Registration_OK
	@When("^going to https://pro\\.packlink\\.es/registro$")
	public void going_to_https_pro_packlink_es_registro() {
		driver.get(configFileReader.getApplicationUrlregister());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-submit\"]")));
		
	}

	@Then("^fill up the \"([^\"]*)\", \"([^\"]*)\" and  \"([^\"]*)\" field$")
	public void fill_up_the_and_field(String email, String password, String phoneNumber) {
		driver.findElement(By.xpath("//*[@id=\"register-email\"]")).clear(); //email field
		driver.findElement(By.xpath("//*[@id=\"register-email\"]")).sendKeys(email); //email field
		
		driver.findElement(By.xpath("//*[@id=\"register-password\"]")).clear(); //password field
		driver.findElement(By.xpath("//*[@id=\"register-password\"]")).sendKeys(password); //password field
		
		driver.findElement(By.xpath("//*[@id=\"register-tel\"]")).clear(); //phoneNumber field
		driver.findElement(By.xpath("//*[@id=\"register-tel\"]")).sendKeys(phoneNumber); //phoneNumber field;
	}
 
	 @Then("^select a value in the monthly field$")
	 public void select_a_value_in_the_monthly_field() {
		 new Select(driver.findElement(By.xpath("//*[@id=\"register-shipments\"]"))).selectByValue("1 - 10");
	 }

	 @Then("^select a value in marketplace field$")
	 public void select_a_value_in_marketplace_field() {
		 new Select(driver.findElement(By.xpath("//*[@id=\"register-platform\"]"))).selectByValue("Other");
	 }

	 @Then("^select a value in onlinePlatform field$")
	 public void select_a_value_in_onlinePlatform_field() {
		 new Select(driver.findElement(By.xpath("//*[@id=\"register-ecommerce\"]"))).selectByValue("Other");
	 }

	 @Then("^click on terms&conditions field$")
	 public void click_on_terms_conditions_field() {
		 driver.findElement(By.xpath("//*[@id=\"register-termsAndConditions\"]")).click();
	 }

	 @Then("^click on privacyPolicy field$")
	 public void click_on_privacyPolicy_field() {
		 driver.findElement(By.xpath("//*[@id=\"register-dataProcessing\"]")).click();
	 }

	 @Then("^complete the registration process$")
	 public void complete_the_registration_process() throws Throwable {
		 driver.findElement(By.xpath("//*[@id=\"register-submit\"]")).click();
		 
	 }

	 @Then("^validate dashboard is accesible$")
	 public void validate_dashboard_is_accesible() throws Throwable { 
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/main-app/div[1]/app-header/header/h1/a"));
		Thread.sleep(10000);
		driver.quit();
	 }

	 //Registration_KO_existingUser
	 
	 @Then("^fill up the email, password and  phoneNumber field with existing data$")
	 public void fill_up_the_and_field_with_existing_data() throws Throwable {
		 
		 	driver.findElement(By.xpath("//*[@id=\"register-email\"]")).clear(); //email field
			driver.findElement(By.xpath("//*[@id=\"register-email\"]")).sendKeys(configFileReader.getplProUser());//email field
			
			driver.findElement(By.xpath("//*[@id=\"register-password\"]")).clear(); //password field
			driver.findElement(By.xpath("//*[@id=\"register-password\"]")).sendKeys(configFileReader.getplProPassword()); //password field
			
			driver.findElement(By.xpath("//*[@id=\"register-tel\"]")).clear(); //phoneNumber field
			driver.findElement(By.xpath("//*[@id=\"register-tel\"]")).sendKeys("123456"); //phoneNumber field;
	 }
	 
	 @Then("^an Already exists error will be displayed$")
	 public void an_Already_exists_error_will_be_displayed() throws Throwable {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[text()='Client already exists']"));
		 driver.quit();
	 }

	 //Access_OK
	 @Given("^navigating to https://pro\\.packlink\\.es/login$")
	 public void navigating_to_https_pro_packlink_es_login() throws Throwable {
			driver.get(configFileReader.getApplicationUrlHome());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-form\"]/fieldset/legend")));

	 }

	 @Then("^I use existing data for credentials$")
	 public void i_use_existing_data_for_credentials() throws Throwable {
		 
		 	driver.findElement(By.xpath("//*[@id=\"login-email\"]")).clear(); //email field
			driver.findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys(configFileReader.getplProUser());//email field
			
			driver.findElement(By.xpath("//*[@id=\"login-password\"]")).clear(); //password field
			driver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys(configFileReader.getplProPassword()); //password field
	 }

	//Access_KO
	 @Then("^I enter not existing credentials email and incorrect password$")
	 public void i_enter_not_existing_credentials_email_and_incorrect_password() throws Throwable {
			driver.findElement(By.xpath("//*[@id=\"login-email\"]")).clear(); //email field
			driver.findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys("qacandidate@packlink.es");//email field
			
			driver.findElement(By.xpath("//*[@id=\"login-password\"]")).clear(); //password field
			driver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys("2222222222"); //password field
	 }
	 
	 @Then("^login error will be displayed$")
	 public void login_error_will_be_displayed() throws Throwable {
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[text()='Datos incorrectos']"));
		 driver.quit();
	 }
	 
	//Access_common_click
	 @Then("^I click on Access button$")
	 public void I_click_on_Access_button() throws Throwable {
		 driver.findElement(By.xpath("//*[@id=\"login-submit\"]")).click();	
	 }
	

}
	 
	//Here I tried to create a global error validation step for all the errors present on this suite. However I was not able to make it run properly by adding some kind of OR to the findElement call. So I decide to separate them for each specific case.	 
	/* @Then("^an error will be displayed$")
	 public void an_error_will_be_displayed() throws Throwable {
		 Thread.sleep(1000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-error-msg\"]"))); First try capturing error xpath. I end up using expected error message instead as seen below.		
		//driver.findElement(By.xpath("//*[text()='Client already exists']" | "//*[text()='Please select an item in the list.']" | "//*[text()='Please fill in this field.']" | "//*[text()='Please include an ‘@‘ in the email address.']" | "//*[text()='Please tick this box if you want to proceed.']"));
		 
		 driver.quit();
		}*/
	 
	 
/*Here, after the above @Then("^an error will be displayed$") was not working, I tried to separate all of the errors present and just create a specific error validation for each one.
However, some of the errors were still not traceable as a web components. So I reject this idea due to time constrains and not enough technical knownledge of the web itself.	 
*/	 
	 
/*Registration_KO_notValidData
	 @When("^I dont fill up the \"([^\"]*)\", \"([^\"]*)\" or  \"([^\"]*)\" field$")
	 public void i_dont_fill_up_the_or_field(String email, String password, String phoneNumber) throws Throwable {
		 driver.findElement(By.xpath("//*[@id=\"register-email\"]")).clear(); //email field
			driver.findElement(By.xpath("//*[@id=\"register-email\"]")).sendKeys(email); //email field
			
			driver.findElement(By.xpath("//*[@id=\"register-password\"]")).clear(); //password field
			driver.findElement(By.xpath("//*[@id=\"register-password\"]")).sendKeys(password); //password field
			
			driver.findElement(By.xpath("//*[@id=\"register-tel\"]")).clear(); //phoneNumber field
			driver.findElement(By.xpath("//*[@id=\"register-tel\"]")).sendKeys(phoneNumber); //phoneNumber field;
	 }

	 @Then("^I dont select a value in the monthly field$")
	 public void i_dont_select_a_value_in_the_monthly_field() throws Throwable {
			//MONTHLY field
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-form\"]/fieldset/fieldset/div[2]/label")));
	 }

	 @Then("^I dont select a value in marketplace field$")
	 public void i_dont_select_a_value_in_marketplace_field() throws Throwable {
		
			//MARKETPLACE
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-form\"]/fieldset/fieldset/div[3]/label")));
			 }

	 @Then("^I dont select a value in onlinePlatform field$")
	 public void i_dont_select_a_value_in_onlinePlatform_field() throws Throwable {
		
			//ONLINE PLATFORM field
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-form\"]/fieldset/fieldset/div[4]/label")));
			
	 }

	 @Then("^I dont click on terms&conditions field$")
	 public void i_dont_click_on_terms_conditions_field() throws Throwable {
	
			//TERMS&CONDITIONS field
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-form\"]/fieldset/div[3]/label")));
	 }

	 @Then("^I dont click on privacyPolicy field$")
	 public void i_dont_click_on_privacyPolicy_field() throws Throwable {

			//PRIVACY POLICY field
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register-form\"]/fieldset/div[4]/label")));
	 }
	 


	 @Then("^an Please fill in this field\\. error will be displayed$")
	 public void an_Please_fill_in_this_field_error_will_be_displayed() throws Throwable {
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[text()='Please fill in this field.']"));
		 driver.quit();
	 }

	 @Then("^an error Please select an item in the list\\. will be displayed$")
	 public void an_error_Please_select_an_item_in_the_list_will_be_displayed() throws Throwable {
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[text()='Please select an item in the list.']"));
		 driver.quit();
	 }
	 
	 @Then("^an error Please tick this box if you want to proceed\\. will be displayed$")
	 public void an_error_Please_tick_this_box_if_you_want_to_proceed_will_be_displayed() throws Throwable {
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[text()='Please tick this box if you want to proceed.']"));
		 driver.quit();
	 }
*/
	
	 
