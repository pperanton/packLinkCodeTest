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

	/* 1st try to implement a Before hook. I was commented since was not working as expected and I put a Background instead.
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
	public void fill_up_the_and_field(String arg1, String arg2, String arg3) {
		driver.findElement(By.xpath("//*[@id=\"register-email\"]")).clear(); //email field
		driver.findElement(By.xpath("//*[@id=\"register-email\"]")).sendKeys(arg1); //email field
		
		driver.findElement(By.xpath("//*[@id=\"register-password\"]")).clear(); //password field
		driver.findElement(By.xpath("//*[@id=\"register-password\"]")).sendKeys(arg2); //password field
		
		driver.findElement(By.xpath("//*[@id=\"register-tel\"]")).clear(); //phoneNumber field
		driver.findElement(By.xpath("//*[@id=\"register-tel\"]")).sendKeys(arg3); //phoneNumber field;
	}
 
	 @Then("^select a value in the monthly field$")
	 public void select_a_value_in_the_monthly_field() {
		 new Select(driver.findElement(By.xpath("//*[@id=\"register-shipments\"]"))).selectByValue("1 - 10");
	 }

	 @Then("^select a value in marketplace field$")
	 public void select_a_value_in_marketplace_field() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @Then("^select a value in onlinePlatform field$")
	 public void select_a_value_in_onlinePlatform_field() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @Then("^click on terms&conditions field$")
	 public void click_on_terms_conditions_field() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @Then("^click on privacyPolicy field$")
	 public void click_on_privacyPolicy_field() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @Then("^complete the registration process$")
	 public void complete_the_registration_process() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @Then("^validate dashboard is accesible$")
	 public void validate_dashboard_is_accesible() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @Given("^the registration form with (\\d+) required fields$")
	 public void the_registration_form_with_required_fields(int arg1) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @When("^navigating to https://pro\\.packlink\\.es/login WITH credentials <email> and incorrect <password>$")
	 public void navigating_to_https_pro_packlink_es_login_WITH_credentials_email_and_incorrect_password() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @Then("^login error will be displayed$")
	 public void login_error_will_be_displayed() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

 
	@When("^accessing to dashboard$")
	public void accessing_to_dashboard() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^logout back to urlRegistration$")
	public void logout_back_to_urlRegistration() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	//
	@When("^fill any of above fields with already existing user info$")
	public void fill_any_of_above_fields_with_already_existing_user_info() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^an error will be displayed$")
	public void an_error_will_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


	@When("^fill any of above fields not valid/expected data$")
	public void fill_any_of_above_fields_not_valid_expected_data() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}



	

	@Given("^a previously registered user$")
	public void a_previously_registered_user() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^navigating to https://pro\\.packlink\\.es/login WITH credentials <email> and random <password>$")
	public void navigating_to_https_pro_packlink_es_login_WITH_credentials_email_and_random_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	@Then("^it will land into the platform dashboard$")
	public void it_will_land_into_the_platform_dashboard() {}
	    // Write code here that turns the phrase above into concrete actions
	    
	}


