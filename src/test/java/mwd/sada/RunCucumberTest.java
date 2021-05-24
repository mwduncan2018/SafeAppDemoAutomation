package mwd.sada;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import mwd.sada.context.TestContext;
import mwd.sada.dataprovider.ConfigurationProperties;
import mwd.sada.managers.WebDriverManager;
import mwd.sada.pageobjects.AdminPage;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/Destination", "json:target/cucumber.json" },
		// "html:target/Destination" puts the HTML report in 'target/Destination'
		// "json:target/cucumber.json" puts the JSON report in 'target/cucumber.json'
		monochrome = true, snippets = SnippetType.UNDERSCORE,
		features = "src/test/resources")
		//features = "classpath:features")
public class RunCucumberTest {

	@BeforeClass
	public static void globalSetup() {
		System.out.println("*******************************************");
		System.out.println("GLOBAL SETUP");
		System.out.println("*******************************************");

		TestContext.getContextBag().put("Start!", 1);
		WebDriver driver = WebDriverManager.getDriver();
		driver.navigate().to(ConfigurationProperties.getUrl());
		PageFactory.initElements(driver, AdminPage.class).resetDatabase();
		driver.close();
	}

	@AfterClass
	public static void globalTearDown() {
		System.out.println("*******************************************");
		System.out.println("GLOBAL TEAR DOWN");
		System.out.println("*******************************************");
	}
}