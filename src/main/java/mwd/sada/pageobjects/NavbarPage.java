package mwd.sada.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class NavbarPage extends BasePage {
	final WebDriver driver;
	
	@FindBys({ @FindBy(how = How.LINK_TEXT, using = "Products") })
	private WebElement PRODUCTS_LINK;
	@FindBys({ @FindBy(how = How.LINK_TEXT, using = "Watch List!") })
	private WebElement WATCH_LIST_LINK;

	public NavbarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToProducts() {
		PRODUCTS_LINK.click();
	}
	
	public void goToWatchList() {
		WATCH_LIST_LINK.click();
	}

}
