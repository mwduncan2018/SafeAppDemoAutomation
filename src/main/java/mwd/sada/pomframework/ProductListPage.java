package mwd.sada.pomframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;

public class ProductListPage {
	// FindAll is OR
	// FindBys is AND

	final WebDriver driver;

	@FindAll({ @FindBy(className = "btn-warning"), @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Enable Fuzzy") })
	private WebElement ENABLE_FUZZY_MATCHING_BTN;

	@FindAll({ @FindBy(className = "btn-danger"), @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Disable Fuzzy") })
	private WebElement DISABLE_FUZZY_MATCHING_BTN;

	@FindBys({ @FindBy(how = How.LINK_TEXT, using = "Add New Product") })
	private WebElement ADD_NEW_PRODUCT_BTN;

	public ProductListPage(WebDriver driver) {
		this.driver = driver;
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



}
