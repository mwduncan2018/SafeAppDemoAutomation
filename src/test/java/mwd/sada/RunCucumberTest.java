package mwd.sada;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import mwd.sada.pomframework.AdminPage;

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
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver.manage().window().setSize(new Dimension(1000, 1000));
		driver.navigate().to("http://192.168.1.12:10081/ProductList");
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