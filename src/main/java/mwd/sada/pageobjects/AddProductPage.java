package mwd.sada.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class AddProductPage extends BasePage {
	final WebDriver driver;

	@FindBys({ @FindBy(id = "Manufacturer") })
	private WebElement MANUFACTURER_INPUT;
	@FindBys({ @FindBy(css = "#Model") })
	private WebElement MODEL_INPUT;
	@FindBys({ @FindBy(id = "Price") })
	private WebElement PRICE_INPUT;
	@FindBys({ @FindBy(id = "NumberInStock") })
	private WebElement NUMBER_IN_STOCK_INPUT;
	@FindAll({ @FindBy(how = How.CSS, using = ".form-group input[value='Add']") })
	private WebElement ADD_BUTTON;
	@FindBys({ @FindBy(how = How.LINK_TEXT, using = "Back to List") })
	private WebElement BACK_TO_LIST_LINK;
	@FindBys({ @FindBy(how = How.CSS, using = ".pb-3 h1") })
	private WebElement PAGE_TITLE;

	public AddProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addProduct(String manufacturer, String model, String price, String numberInStock) {
		MANUFACTURER_INPUT.sendKeys(manufacturer);
		MODEL_INPUT.sendKeys(model);
		PRICE_INPUT.sendKeys(price);
		NUMBER_IN_STOCK_INPUT.sendKeys(numberInStock);
		ADD_BUTTON.submit();
	}

	public void backToList() {
		BACK_TO_LIST_LINK.click();
	}

	public Boolean verifyIsOpen() {
		if (PAGE_TITLE.getText().equals("Add Product"))
			return true;
		else
			return false;
	}

}