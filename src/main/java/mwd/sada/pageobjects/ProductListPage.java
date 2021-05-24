package mwd.sada.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

// FindAll is OR
// FindBys is AND
public class ProductListPage extends BasePage {
	final WebDriver driver;

	@FindAll({ @FindBy(className = "btn-warning"), @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Enable Fuzzy") })
	private WebElement ENABLE_FUZZY_MATCHING_BTN;
	@FindAll({ @FindBy(className = "btn-danger"), @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Disable Fuzzy") })
	private WebElement DISABLE_FUZZY_MATCHING_BTN;
	@FindBys({ @FindBy(how = How.LINK_TEXT, using = "Add New Product") })
	private WebElement ADD_NEW_PRODUCT_BTN;
	@FindBys({ @FindBy(how = How.CSS, using = ".pb-3 h1") })
	private WebElement PAGE_TITLE;

	public ProductListPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goTo() {
		PageFactory.initElements(driver, NavbarPage.class).goToProducts();
	}

	public void enableFuzzyMatching() {
		ENABLE_FUZZY_MATCHING_BTN.click();
	}

	public void disableFuzzyMatching() {
		DISABLE_FUZZY_MATCHING_BTN.click();
	}

	public void addNewProduct() {
		ADD_NEW_PRODUCT_BTN.click();
	}

	public Boolean verifyIsOpen() {
		System.out.println(PAGE_TITLE.getTagName());
		System.out.println(PAGE_TITLE.getText());
		if (PAGE_TITLE.getText().equals("Product List"))
			return true;
		else
			return false;
	}

	public Boolean verifyFuzzyMatchingUrl() {
		if (driver.getCurrentUrl().contains("ProductList/Fuzzy"))
			return true;
		else
			return false;

	}

}
