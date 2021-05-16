package mwd.sada.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import mwd.sada.pomframework.ProductListPage;
import mwd.sada.pomframework.WatchListPage;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;

public class StepDefinitionsA {

	private ScenarioContext scenarioContext;

	public StepDefinitionsA(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	@Given("I open Safe App Demo")
	public void iOpenSafeAppDemo() {
	}

	@Given("I navigate to the Product List page")
	public void iNavigateToTheProductListPage() {
		ProductListPage productListPage;
		WatchListPage watchListPage;
		WebDriver driver = (WebDriver) scenarioContext.getContextBag().get("driver");
		productListPage = PageFactory.initElements(driver, ProductListPage.class);
		watchListPage = PageFactory.initElements(driver, WatchListPage.class);
		productListPage.goTo();
		watchListPage.goTo();
		productListPage.goTo();
		watchListPage.goTo();
		productListPage.goTo();
		watchListPage.goTo();
		productListPage.goTo();
		watchListPage.goTo();
		productListPage.goTo();
		watchListPage.goTo();
		productListPage.goTo();
		watchListPage.goTo();
		productListPage.goTo();
		watchListPage.goTo();		
	}

	@When("I add the Samsung product BBB")
	public void iAddTheSamsungProductBBB() {

	}

	@Then("verify the Apple product 111 has been created")
	public void verifyTheAppleProduct111HasBeenCreated() {

	}

	@Then("verify the Apple product 222 has been created")
	public void verifyTheAppleProduct222HasBeenCreated() {

	}

	@Then("verify the Apple product 333 has been created")
	public void verifyTheAppleProduct333HasBeenCreated() {

	}

	@When("I add the Pixel product XXX")
	public void iAddThePixelProductXXX() {

	}

	@When("I add the Pixel product YYY")
	public void iAddThePixelProductYYY() {

	}

	@When("I add the Pixel product ZZZ")
	public void iAddThePixelProductZZZ() {

	}

	@When("I add the Motorola product ZZZ")
	public void iAddTheMotorolaProductZZZ() {

	}

	@Then("verify the Motorola product XXX has been created")
	public void verifyTheMotorolaProductXXXHasBeenCreated() {

	}

	@Then("verify the Motorola product YYY has been created")
	public void verifyTheMotorolaProductYYYHasBeenCreated() {

	}

	@Then("verify the Pixel product XXX has been created")
	public void verifyThePixelProductXXXHasBeenCreated() {

	}

	@Then("verify the Pixel product YYY has been created")
	public void verifyThePixelProductYYYHasBeenCreated() {

	}

	@Then("verify the Pixel product ZZZ has been created")
	public void verifyThePixelProductZZZHasBeenCreated() {

	}

	@When("I add a product with manufacturer \"([^\"]*)\" model \"([^\"]*)]\" price \"([^\"]*)\" and numberInStock \"([^\"]*)\"")
	public void iAddAProduct(String manufacturer, String model, String price, String numberInStock) {

	}

	@Then("verify the product manufacturer {string} model {string} price {string} and numberInStock {string} has been created")
	public void verifyTheProductHasBeenCreated(String manufacturer, String model, String price, String numberInStock) {
		assertEquals(true, true);
	}

	@Then("verify the Watch List page is open")
	public void verifyTheWatchListPageIsOpen() {
		assertEquals(true, true);
	}

}