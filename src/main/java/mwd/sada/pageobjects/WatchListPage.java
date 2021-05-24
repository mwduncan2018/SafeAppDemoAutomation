package mwd.sada.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WatchListPage extends BasePage {
	final WebDriver driver;

	@FindBys({ @FindBy(how = How.CSS, using = ".pb-3 h1") })
	private WebElement PAGE_TITLE;

	public WatchListPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goTo() {
		PageFactory.initElements(driver, NavbarPage.class).goToWatchList();
	}

	public Boolean verifyIsOpen() {
		System.out.println(PAGE_TITLE.getTagName());
		System.out.println(PAGE_TITLE.getText());
		if (PAGE_TITLE.getText().equals("The Watch List"))
			return true;
		else
			return false;
	}

}
