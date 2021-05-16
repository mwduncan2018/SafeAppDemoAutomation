package mwd.sada.hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import mwd.sada.steps.ScenarioContext;

public class Hooks {
	private ScenarioContext scenarioContext;

	public Hooks(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	@Before(order = 99)
	public void beforeScenario() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver.manage().window().setSize(new Dimension(1000, 1400));
		driver.navigate().to("http://192.168.1.12:10081/ProductList");
		scenarioContext.getContextBag().put("driver", driver);
	}

	@After(order = 1)
	public void afterScenario() {
		((WebDriver) scenarioContext.getContextBag().get("driver")).close();
	}

}