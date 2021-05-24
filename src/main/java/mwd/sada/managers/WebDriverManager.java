package mwd.sada.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import mwd.sada.dataprovider.ConfigurationProperties;
import mwd.sada.dataprovider.DriverType;
import mwd.sada.dataprovider.EnvironmentType;

public class WebDriverManager {
	private static WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;

	public WebDriverManager() {
	}

	public static WebDriver getDriver() {
		driverType = ConfigurationProperties.getDriverType();
		driver = createDriver();
		return driver;
	}
	
	private static WebDriver createDriver() {
		environmentType = ConfigurationProperties.getEnvironment();
		if (environmentType == EnvironmentType.LOCAL)
			driver = createLocalDriver();
		if (environmentType == EnvironmentType.REMOTE)
			driver = createRemoteDriver();
		return driver;
	}
	
	private static WebDriver createRemoteDriver() {
		throw new RuntimeException("createRemoteDriver not implemented");
	}
	
	private static WebDriver createLocalDriver() {
		if (driverType == DriverType.FIREFOX)
			driver = new FirefoxDriver();
		if (driverType == DriverType.CHROME)
			driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ConfigurationProperties.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(ConfigurationProperties.getBrowserHorizontalPixels(),
				ConfigurationProperties.getBrowserVerticalPixels()));
		//driver.navigate().to(new ConfigFileReader().getUrl());
		return driver;
	}	
}
