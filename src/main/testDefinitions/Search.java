package main.testDefinitions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.dataProvider.ConfigFileReader;

public class Search {
	
	WebDriver driver;
	WebDriverWait wait;
	
	ConfigFileReader configFileReader = new ConfigFileReader();

	//Background steps are taken from previous Register.java

	 @Given("^validate pro dashboard is accesible$")
	 public void validate_dashboard_is_accesible() throws Throwable { 
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/main-app/div[1]/app-header/header/h1/a"));
		Thread.sleep(10000);
	 }
	
	@When("^clicking on the Anadir envio button$")
	public void clicking_on_the_Anadir_envio_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main-app/div[1]/app-header/header/h1/a")));
		//driver.findElement(By.className("eb-add-shipment__btn ng-binding")).click();
	}
	
	@Then("^validate user is on Shipment Details page$")
	public void validate_user_is_on_Shipment_Details_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/div/div/button")));
		driver.findElement(By.xpath("/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/fieldset[1]/div/country-postal-code-selector/packlink-selector[2]/div/ul/li[5]")).click();
	}

	@Then("^User enters Madrid FROM origin and select an item$")
	public void user_enters_Madrid_FROM_origin_and_select_an_item() throws Throwable {
		driver.findElement(By.xpath("/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/fieldset[1]/div/country-postal-code-selector/packlink-selector[2]/div/label")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/fieldset[1]/div/country-postal-code-selector/packlink-selector[2]/div/label")).sendKeys("Madrid");
		driver.findElement(By.xpath("/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/fieldset[1]/div/country-postal-code-selector/packlink-selector[2]/div/ul/li[5]")).click();

	}

	@Then("^User enters Madrid TO destination and select an item$")
	public void user_enters_Madrid_TO_destination_and_select_an_item() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"cjr593bkd00103e5r3mw6j7le\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"cjr593bkd00103e5r3mw6j7le\"]")).sendKeys("Madrid");
		driver.findElement(By.xpath("/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/fieldset[2]/div/country-postal-code-selector/packlink-selector[2]/div/ul/li[5]")).click();
	}

	@Then("^add weight$")
	public void add_weight() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"weight-0\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"weight-0\"]")).sendKeys("1");
	}

	@Then("^add lenght$")
	public void add_lenght() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"length-0\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"length-0\"]")).sendKeys("10");
	}

	@Then("^add width$")
	public void add_width() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"width-0\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"width-0\"]")).sendKeys("10");
	}

	@Then("^add height$")
	public void add_height() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"height-0\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"height-0\"]")).sendKeys("10");
	}

	@Then("^User click on Prices button$")
	public void user_click_on_Prices_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-info/section/form/div/div/button")).click();

	}

	@When("^validating if User is on next page$")
	public void validating_if_User_is_on_next_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-services/section/service-list/section/article[1]/div/div/button/span[2]")));

	}

	@Then("^User selects first item on the Services list$")
	public void user_selects_first_item_on_the_Services_list() throws Throwable {
		driver.findElement(By.xpath("/html/body/div[1]/main-app/div[1]/div[2]/create/article/div/div/create-services/section/service-list/section/article[1]/div/div/button/span[2]")).click();
	}

	@Then("^validate if User is on the next page$")
	public void validate_if_User_is_on_the_next_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create-detail-init\"]/form/fieldset[4]/legend")));

	}

	

}
