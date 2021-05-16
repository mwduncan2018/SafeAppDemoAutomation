package mwd.sada.pomframework;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

class DemoTest {
	private static Dimension dimension = new Dimension(1600, 1200);

	@Test
	void multipleDriversTest() throws InterruptedException {
		WebDriver driver1 = new FirefoxDriver();
		driver1.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver1.manage().window().setSize(new Dimension(1000, 1400));
		driver1.navigate().to("http://192.168.1.12:10081/ProductList");

		WebDriver driver2 = new FirefoxDriver();
		driver2.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver2.manage().window().setSize(new Dimension(1400, 1000));
		driver2.navigate().to("http://192.168.1.12:10081/ProductList");

		ProductListPage productListPage1;
		AddProductPage addProductPage1;
		AdminPage adminPage1;
		productListPage1 = PageFactory.initElements(driver1, ProductListPage.class);
		addProductPage1 = PageFactory.initElements(driver1, AddProductPage.class);
		adminPage1 = PageFactory.initElements(driver1, AdminPage.class);

		ProductListPage productListPage2;
		AddProductPage addProductPage2;
		AdminPage adminPage2;
		productListPage2= PageFactory.initElements(driver2, ProductListPage.class);
		addProductPage2 = PageFactory.initElements(driver2, AddProductPage.class);
		adminPage2 = PageFactory.initElements(driver2, AdminPage.class);

		Thread.sleep(3000);
		
		productListPage1.enableFuzzyMatching();
		productListPage1.disableFuzzyMatching();
		productListPage1.addNewProduct();
		addProductPage1.addProduct("Samsung", "aaa", "180", "5");
		productListPage1.addNewProduct();
		addProductPage1.addProduct("Samsung", "bbb", "180", "5");
		productListPage1.addNewProduct();
		addProductPage1.addProduct("Samsung", "ccc", "180", "5");
		productListPage1.addNewProduct();
		addProductPage1.addProduct("Samsung", "ddd", "180", "5");

		productListPage2.enableFuzzyMatching();
		productListPage2.disableFuzzyMatching();
		productListPage2.addNewProduct();
		addProductPage2.addProduct("Apple", "111", "180", "5");
		productListPage2.addNewProduct();
		addProductPage2.addProduct("Apple", "222", "180", "5");
		productListPage2.addNewProduct();
		addProductPage2.addProduct("Apple", "333", "180", "5");
		productListPage2.addNewProduct();
		addProductPage2.addProduct("Apple", "444", "180", "5");

		adminPage1.resetDatabase();
		adminPage2.resetDatabase();
	}

	@Test
	@Disabled
	void pageFactoryTest() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver.manage().window().setSize(dimension);
		driver.navigate().to("http://192.168.1.12:10081/ProductList");

		ProductListPage productListPage;
		AddProductPage addProductPage;
		AdminPage adminPage;

		productListPage = PageFactory.initElements(driver, ProductListPage.class);
		addProductPage = PageFactory.initElements(driver, AddProductPage.class);
		adminPage = PageFactory.initElements(driver, AdminPage.class);

		productListPage.enableFuzzyMatching();
		productListPage.disableFuzzyMatching();
		productListPage.addNewProduct();
		addProductPage.addProduct("Samsung", "A2", "180", "5");

		adminPage.resetDatabase();
	}

}
