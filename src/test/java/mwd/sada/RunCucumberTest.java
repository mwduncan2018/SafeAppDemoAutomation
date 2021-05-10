package mwd.sada;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

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
	}

	@AfterClass
	public static void globalTearDown() {
		System.out.println("*******************************************");
		System.out.println("GLOBAL TEAR DOWN");
		System.out.println("*******************************************");
	}
}