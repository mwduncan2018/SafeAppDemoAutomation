package mwd.sada.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import mwd.sada.dataprovider.ConfigurationProperties;

class ConfigFileReaderTests {

	@Test
	void envTest() {
		new ConfigurationProperties().getEnvironment();
	}

	@Test
	void driverTypeTest() {
		new ConfigurationProperties().getDriverType();
	}

	@Test
	@Disabled
	void windowMaximizeTest() {
		
	}

	@Test
	void browserHorizontalPixelsTest() {
		new ConfigurationProperties().getBrowserHorizontalPixels();
	}

	@Test
	void browserVerticalPixelsTest() {
		new ConfigurationProperties().getBrowserVerticalPixels();
	}

	@Test
	void urlTest() {
		new ConfigurationProperties().getUrl();
	}

	@Test
	void implicitWaitTest() {
		new ConfigurationProperties().getImplicitWait();
	}

	@Test
	void testDataPathTest() {
		new ConfigurationProperties().getTestDataPath();
	}

}
