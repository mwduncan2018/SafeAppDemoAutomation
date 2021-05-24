package mwd.sada.extensions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ExtensionMethods {
	
	// <summary>
	// Find an element and wait a specified time before giving up.
	// The first Duration is the max time you want to wait for the element to
	// appear.
	// The second Duration is how often to check for the element.
	// </summary>
	// <param name="driver"></param>
	// <param name="by"></param>
	// <param name="timeout"></param>
	// <param name="pollingInterval"></param>
	// <returns>If found, the element is returned.</returns>
	public static WebElement findElement(WebDriver driver, By by, Duration timeout, Duration pollingInterval) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeout)
				.pollingEvery(pollingInterval)
				.ignoring(NoSuchElementException.class);
		return wait.until(x -> {
			return x.findElement(by);
		});
	}
}