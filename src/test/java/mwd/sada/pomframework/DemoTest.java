package mwd.sada.pomframework;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

class DemoTest {
	private static Dimension dimension = new Dimension(1200, 1000);

	@Test
	void pageFactoryTest() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver.manage().window().setSize(dimension);
		driver.navigate().to("http://192.168.1.12:10081/ProductList");
		
		ProductListPage productListPage = PageFactory.initElements(driver, ProductListPage.class);
		productListPage.enableFuzzyMatching();
		Thread.sleep(500);
		productListPage.disableFuzzyMatching();
		Thread.sleep(500);
		productListPage.addNewProduct();
		Thread.sleep(500);
		driver.close();
	}

}
