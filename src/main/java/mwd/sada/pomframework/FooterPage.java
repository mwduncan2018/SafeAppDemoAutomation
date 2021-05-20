package mwd.sada.pomframework;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FooterPage extends BasePage {
	final WebDriver driver;
	
	@FindBys({ @FindBy(id = "copyright") })
	private WebElement COPYRIGHT_TEXT;
	@FindBys({ @FindBy(id = "secretMessage") })
	private WebElement SECRET_MESSAGE_TEXT;

	public FooterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Boolean verifyCopyrightTextIs(String expectedText) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		return false;		
	}
	
}
