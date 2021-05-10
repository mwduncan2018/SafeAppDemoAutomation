package mwd.sada.pomframework;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class DemoTest {
	private static Dimension dimension = new Dimension(1200, 1000);

	@Test
	void seleniumTest1() {
		//System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);
		WebDriver x = new FirefoxDriver();
		x.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		x.manage().window().setSize(dimension);
		x.navigate().to("https://www.pnc.com/en/personal-banking.html");
		x.close();
	}
}
