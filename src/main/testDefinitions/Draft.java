package main.testDefinitions;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.dataProvider.ConfigFileReader;
import main.testDefinitions.Register;

public class Draft {

	ConfigFileReader configFileReader1 = new ConfigFileReader();
	WebDriverWait wait2;
	WebDriver driver2;

	// Here start the duplicated code as explained on draft.feature. Ideally, all
	// this background steps should not be duplicated.
	// But I would need more time to understand and learn how to properly do it.
	// Anyway, this workaround will serve by now.

	@Given("^any web Browser and an internet User2$")
	public void any_web_Browser_and_an_internet_User() {
		System.setProperty("webdriver.chrome.driver", configFileReader1.getChromeDriverPath());
		driver2 = new ChromeDriver();
		wait2 = new WebDriverWait(driver2, 60);
		driver2.manage().window().fullscreen();
	}

	@Given("^navigating to https://pro\\.packlink\\.es/login2$")
	public void navigating_to_https_pro_packlink_es_login() throws Throwable {
		driver2.get(configFileReader1.getApplicationUrlHome());
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-form\"]/fieldset/legend")));
	}

	@Then("^I use existing data for credentials2$")
	public void i_use_existing_data_for_credentials() throws Throwable {
		WebElement emailLoginElement = driver2.findElement(By.xpath("//*[@id=\"login-email\"]"));
		WebElement passwordLoginElement = driver2.findElement(By.xpath("//*[@id=\"login-password\"]"));

		emailLoginElement.clear(); // email field
		emailLoginElement.sendKeys(configFileReader1.getplProUser());// email field

		passwordLoginElement.clear(); // password field
		passwordLoginElement.sendKeys(configFileReader1.getplProPassword()); // password field
	}

	@Then("^I click on Access button2$")
	public void I_click_on_Access_button() throws Throwable {
		WebElement LoginButtonElement = driver2.findElement(By.xpath("//*[@id=\"login-submit\"]"));

		LoginButtonElement.click();

	}

	@When("^validate pro dashboard is accesible2$")
	public void validate_pro_dashboard_is_accesible() throws Throwable {
		Thread.sleep(13000);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main-app/div[1]/app-header/header/ul/li[1]/a")));
	}

	@When("^clicking on the Anadir envio button2$")
	public void clicking_on_the_Anadir_envio_button() throws Throwable {
		Actions action = new Actions(driver2);
		WebElement we = driver2.findElement(By.xpath("/html/body/div[1]/main-app/div[1]/app-header/header/nav/span"));
		action.moveToElement(we).moveToElement(driver2.findElement(By.className("eb-add-shipment__item"))).click()
				.build().perform();

	}

	@Then("^validate user is on Shipment Details page2$")
	public void validate_user_is_on_Shipment_Details_page() throws Throwable {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/div/div/button")));

	}

	/*
	 * At this step, and after many unsuccesful attemps to make it work, I decided
	 * to download Selenium IDE and record the steps from Chrome to help me identify
	 * the exact xpath names locators. As with the Inspect tool for chrome, the
	 * xpath locators provided were not OK. After checking the xpath locators thanks
	 * to Selenium IDE chrome plug in, the step is now completed.
	 */

	@Then("^User enters Madrid FROM origin and select an item2$")
	public void user_enters_Madrid_FROM_origin_and_select_an_item() throws Throwable {
		Thread.sleep(3000);
		driver2.findElement(By.xpath(
				"/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/fieldset[1]/div/country-postal-code-selector/packlink-selector[2]/div"))
				.click();
		Thread.sleep(2000);
		driver2.findElement(By.xpath("//packlink-selector[2]/div/input[2]")).sendKeys("Madrid");
		Thread.sleep(2000);
		driver2.findElement(By.xpath("//packlink-selector[2]/div/ul/li[6]")).click();
	}

	@Then("^User enters Madrid TO destination and select an item2$")
	public void user_enters_Madrid_TO_destination_and_select_an_item() throws Throwable {
		Thread.sleep(3000);
		driver2.findElement(By.xpath(
				"/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/fieldset[2]/div/country-postal-code-selector/packlink-selector[2]"))
				.click();
		Thread.sleep(2000);
		driver2.findElement(
				By.xpath("//fieldset[2]/div/country-postal-code-selector/packlink-selector[2]/div/input[2]"))
				.sendKeys("Madrid");
		Thread.sleep(2000);
		driver2.findElement(
				By.xpath("//fieldset[2]/div/country-postal-code-selector/packlink-selector[2]/div/ul/li[6]")).click();
	}

	@Then("^add weight2$")
	public void add_weight() throws Throwable {
		driver2.findElement(By.xpath("//*[@id=\"weight-0\"]")).clear();
		driver2.findElement(By.xpath("//*[@id=\"weight-0\"]")).sendKeys("1");
	}

	@Then("^add lenght2$")
	public void add_lenght() throws Throwable {
		driver2.findElement(By.xpath("//*[@id=\"length-0\"]")).clear();
		driver2.findElement(By.xpath("//*[@id=\"length-0\"]")).sendKeys("10");
	}

	@Then("^add width2$")
	public void add_width() throws Throwable {
		driver2.findElement(By.xpath("//*[@id=\"width-0\"]")).clear();
		driver2.findElement(By.xpath("//*[@id=\"width-0\"]")).sendKeys("10");
	}

	@Then("^add height2$")
	public void add_height() throws Throwable {
		driver2.findElement(By.xpath("//*[@id=\"height-0\"]")).clear();
		driver2.findElement(By.xpath("//*[@id=\"height-0\"]")).sendKeys("10");
	}

	@Then("^User click on Prices button2$")
	public void user_click_on_Prices_button() throws Throwable {
		driver2.findElement(By.xpath(
				"/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/div/div/button"))
				.click();

	}

	@When("^validating if User is on next page2$")
	public void validating_if_User_is_on_next_page() throws Throwable {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-services/section/service-list/section/article[1]/div/div/button/span[2]")));

	}

	@Then("^User selects first item on the Services list2$")
	public void user_selects_first_item_on_the_Services_list() throws Throwable {
		driver2.findElement(By.xpath(
				"/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-services/section/service-list/section/article[1]/div/div/button/span[2]"))
				.click();
	}

	@Then("^validate if User is on the next page2$")
	public void validate_if_User_is_on_the_next_page() throws Throwable {
		wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"create-detail-init\"]/form/fieldset[4]/legend")));

	}

	@Then("^click on Save button$")
	public void click_on_Save_button() throws Throwable {
		driver2.findElement(By.xpath(
				"/html/body/div[1]/main-app/div[1]/div[2]/create/article/aside/shipment-sidebar/div/section[1]/button[2]"))
				.click();

	}

	@When("^User is back to dashboard$")
	public void user_is_back_to_dashboard() throws Throwable {
		Thread.sleep(12000);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/main-app/div[1]/app-header/header/ul/li[1]/a")));
	}

	// Here it should be better to add some kind of data validation so instead of
	// looking for an item in the list (that could be already there) check the
	// existence of whatever values are on the list. Due to time constrains this was
	// not implemented in this case, only position.
	@Then("^validate item appears on the draft list$")
	public void validate_item_appears_on_the_draft_list() throws Throwable {
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/main-app/div[1]/div[1]/main/div/div/shipment-row/article")));
		driver2.quit();
	}

}
