package mwd.sada.pageobjects;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			wait.until(ExpectedConditions.visibilityOf(SECRET_MESSAGE_TEXT));
			if (COPYRIGHT_TEXT.getText().equals(expectedText)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
	
}
