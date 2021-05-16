package mwd.sada.pomframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WatchListPage extends BasePage {
	final WebDriver driver;
	
	public WatchListPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goTo() {
		PageFactory.initElements(driver, NavbarPage.class).goToWatchList();
	}

}
