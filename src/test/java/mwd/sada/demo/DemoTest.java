package mwd.sada.demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mwd.sada.dataprovider.ConfigurationProperties;
import mwd.sada.managers.WebDriverManager;
import mwd.sada.pageobjects.AddProductPage;
import mwd.sada.pageobjects.AdminPage;
import mwd.sada.pageobjects.ProductListPage;
import mwd.sada.testdata.Product;
import mwd.sada.testdata.Root;
import mwd.sada.testdata.WatchListEntry;

class DemoTest {
	private static Dimension dimension = new Dimension(1600, 1200);

	@Test
	@Disabled
	void createJsonTestData() throws JsonProcessingException {
		Product product1 = new Product();
		product1.setManufacturer("Gibson");
		product1.setModel("Les Paul");
		product1.setPrice("2000");
		product1.setNumberInStock("5");
		Product product2 = new Product();
		product2.setManufacturer("Fender");
		product2.setModel("Telecaster");
		product2.setPrice("1500");
		product2.setNumberInStock("3");
		Product[] products = new Product[2];
		products[0] = product1;
		products[1] = product2;

		WatchListEntry watchListEntry1 = new WatchListEntry();
		watchListEntry1.setManufacturer("ESP");
		watchListEntry1.setModel("Alexi");
		WatchListEntry watchListEntry2 = new WatchListEntry();
		watchListEntry2.setManufacturer("Fender");
		watchListEntry2.setModel("Telecaster");
		WatchListEntry[] watchListEntries = new WatchListEntry[2];
		watchListEntries[0] = watchListEntry1;
		watchListEntries[1] = watchListEntry1;

		Root root = new Root();
		root.setProducts(products);
		root.setWatchListEntries(watchListEntries);

		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
		System.out.println(result);
	}

	@Test
	void webDriverManagerTest() {
		WebDriver driver = WebDriverManager.getDriver();
		driver.navigate().to(ConfigurationProperties.getUrl());
		PageFactory.initElements(driver, AdminPage.class).resetDatabase();
		driver.close();

	}

	@Test
	@Disabled
	void configurationFileTest() throws InterruptedException {
		System.out.println(ConfigurationProperties.getImplicitWait());
		System.out.println(ConfigurationProperties.getUrl());
		System.out.println(ConfigurationProperties.getBrowserHorizontalPixels());
		System.out.println(ConfigurationProperties.getBrowserVerticalPixels());

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(ConfigurationProperties.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(ConfigurationProperties.getBrowserHorizontalPixels(),
				ConfigurationProperties.getBrowserVerticalPixels()));
		driver.navigate().to(ConfigurationProperties.getUrl());

		ProductListPage productListPage;
		AddProductPage addProductPage;
		AdminPage adminPage;
		productListPage = PageFactory.initElements(driver, ProductListPage.class);
		addProductPage = PageFactory.initElements(driver, AddProductPage.class);
		adminPage = PageFactory.initElements(driver, AdminPage.class);

		productListPage.enableFuzzyMatching();
		productListPage.disableFuzzyMatching();
		productListPage.addNewProduct();
		addProductPage.addProduct("Samsung", "aaa", "180", "5");
		productListPage.addNewProduct();
		addProductPage.addProduct("Samsung", "bbb", "180", "5");
		productListPage.addNewProduct();
		addProductPage.addProduct("Samsung", "ccc", "180", "5");
		productListPage.addNewProduct();
		addProductPage.addProduct("Samsung", "ddd", "180", "5");
		Thread.sleep(1000);
		adminPage.resetDatabase();
		Thread.sleep(1000);
		driver.close();
	}

	@Test
	@Disabled
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
		productListPage2 = PageFactory.initElements(driver2, ProductListPage.class);
		addProductPage2 = PageFactory.initElements(driver2, AddProductPage.class);
		adminPage2 = PageFactory.initElements(driver2, AdminPage.class);

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

		driver1.close();
		driver2.close();
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

		driver.close();
	}

	@Test
	@Disabled
	void concurrentHashMapTest() {
		ConcurrentHashMap<Integer, String> cMap = new ConcurrentHashMap<>();
		cMap.put(1, "one");
		cMap.put(2, "one");
		cMap.put(3, "one");
		cMap.forEach((x, y) -> System.out.println(String.valueOf(x) + ", " + y));
	}
}
