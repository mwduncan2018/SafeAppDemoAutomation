package mwd.sada.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties {
	private static final String propertyFilePath = "configs/Configuration.properties";

	private static String errorMessage(String propertyName) {
		return propertyName + " was not speicified in the Configuration.properties file.";
	}

	private static Properties readConfigFile() {
		Properties properties;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		return properties;
	}

	public static long getImplicitWait() {
		String implicitWait = readConfigFile().getProperty("implicitWait");
		if (implicitWait != null)
			return Long.parseLong(implicitWait);
		else
			throw new RuntimeException(errorMessage("implicitWait"));
	}

	public static String getUrl() {
		String url = readConfigFile().getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException(errorMessage("url"));
	}

	public static int getBrowserHorizontalPixels() {
		String browserHorizontalPixels = readConfigFile().getProperty("browserHorizontalPixels");
		if (browserHorizontalPixels != null)
			return Integer.parseInt(browserHorizontalPixels);
		else
			throw new RuntimeException(errorMessage("browserHorizontalPixels"));
	}

	public static int getBrowserVerticalPixels() {
		String browserVerticalPixels = readConfigFile().getProperty("browserVerticalPixels");
		if (browserVerticalPixels != null)
			return Integer.parseInt(browserVerticalPixels);
		else
			throw new RuntimeException(errorMessage("browserVerticalPixels"));
	}

	public static EnvironmentType getEnvironment() {
		String env = readConfigFile().getProperty("environment");
		if (env.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (env.equalsIgnoreCase("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new RuntimeException(errorMessage("environment"));
	}

	public static DriverType getDriverType() {
		String driverType = readConfigFile().getProperty("driverType");
		if (driverType.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (driverType.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else
			throw new RuntimeException(errorMessage("driverType"));
	}

	public static String getTestDataPath() {
		String testDataPath = readConfigFile().getProperty("testDataPath");
		if (testDataPath != null)
			return testDataPath;
		else
			throw new RuntimeException(errorMessage("testDataPath"));
	}

}
