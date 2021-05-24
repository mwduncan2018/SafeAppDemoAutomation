package mwd.sada.hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import mwd.sada.context.ScenarioContext;
import mwd.sada.dataprovider.ConfigurationProperties;
import mwd.sada.managers.WebDriverManager;

public class Hooks {
	private ScenarioContext scenarioContext;

	public Hooks(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	@Before(order = 99)
	public void beforeScenario() {
		WebDriver driver = WebDriverManager.getDriver();
		driver.navigate().to(ConfigurationProperties.getUrl());
		scenarioContext.getContextBag().put("driver", driver);
	}

	@After(order = 1)
	public void afterScenario() {
		((WebDriver) scenarioContext.getContextBag().get("driver")).close();
	}

}