package mwd.sada.pomframework;

import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {
	final WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public void resetDatabase() {
		driver.navigate().to(super.URL + "Admin/ResetDb");
	}

}
