package mwd.sada.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mwd.sada.context.ScenarioContext;
import mwd.sada.pageobjects.AddProductPage;
import mwd.sada.pageobjects.FooterPage;
import mwd.sada.pageobjects.ProductListPage;
import mwd.sada.pageobjects.WatchListPage;

public class NavigationAndFooterSteps {
	private ScenarioContext scenarioContext;

	public NavigationAndFooterSteps(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	@Given("I navigate to the Product List page")
	public void iNavigateToTheProductListPage() {
		WebDriver driver = (WebDriver) scenarioContext.getContextBag().get("driver");
		ProductListPage productListPage = PageFactory.initElements(driver, ProductListPage.class);
		productListPage.goTo();
	}

	@Given("I navigate to the Watch List page")
	public void iNavigateToTheWatchListPage() {
		WebDriver driver = (WebDriver) scenarioContext.getContextBag().get("driver");
		WatchListPage watchListPage = PageFactory.initElements(driver, WatchListPage.class);
		watchListPage.goTo();
	}

	@Then("verify the Product List page is open")
	public void verifyTheProductListPageIsOpen() {
		WebDriver driver = (WebDriver) scenarioContext.getContextBag().get("driver");
		ProductListPage productListPage = PageFactory.initElements(driver, ProductListPage.class);
		assertEquals(true, productListPage.verifyIsOpen());
	}

	@Then("verify the Watch List page is open")
	public void verifyTheWatchListPageIsOpen() {
		WebDriver driver = (WebDriver) scenarioContext.getContextBag().get("driver");
		WatchListPage watchListPage = PageFactory.initElements(driver, WatchListPage.class);
		assertEquals(true, watchListPage.verifyIsOpen());
	}

	@When("I click the Add New Product button")
	public void iClickTheAddNewProductButton() {
		WebDriver driver = (WebDriver) scenarioContext.getContextBag().get("driver");
		ProductListPage productListPage = PageFactory.initElements(driver, ProductListPage.class);
		productListPage.addNewProduct();
	}

	@Then("verify the Add New Product page is open")
	public void verifyTheAddNewProductPageIsOpen() {
		WebDriver driver = (WebDriver) scenarioContext.getContextBag().get("driver");
		AddProductPage addProductPage = PageFactory.initElements(driver, AddProductPage.class);
		assertEquals(true, addProductPage.verifyIsOpen());
	}

	@When("I click the Enable Fuzzy Matching button")
	public void iClickTheEnableFuzzyMatchingButton() {
		WebDriver driver = (WebDriver) scenarioContext.getContextBag().get("driver");
		ProductListPage productListPage = PageFactory.initElements(driver, ProductListPage.class);
		productListPage.enableFuzzyMatching();
	}

	@Then("verify the Fuzzy Matching page is open")
	public void verifyTheFuzzyMatchingPageIsOpen() {
		WebDriver driver = (WebDriver) scenarioContext.getContextBag().get("driver");
		ProductListPage productListPage = PageFactory.initElements(driver, ProductListPage.class);
		assertEquals(true, productListPage.verifyFuzzyMatchingUrl());
	}
	
	@Then("verify the Safe App Demo text is displayed in the footer")
	public void verifyTheSafeAppDemoTextIsDisplayedInTheFooter() {
		WebDriver driver = (WebDriver) scenarioContext.getContextBag().get("driver");
		FooterPage footerPage = PageFactory.initElements(driver, FooterPage.class);
		assertEquals(true, footerPage.verifyCopyrightTextIs("2021 Duncan (Safe App Demo!)"));
	}
}
