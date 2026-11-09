package Common;

import org.openqa.selenium.By;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends GenericComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(id = "checkout")
	WebElement CartPageCheckoutBtn;
	
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement CartPageProductPrice;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement CartPageProductName;
	
	
	
	
	
	By Product_price_CartPage=By.xpath("//div[@class='inventory_item_price']");
	
	By Product_name_CartPage=By.xpath("//div[@class='inventory_item_name']");
	
	By cancelBtn=By.id("remove-sauce-labs-backpack");
	
	
	
	

	public String getProductNameFromCartPage() {
		return CartPageProductName.getText();
		
	}
	
	
	public String getProductPriceFromCartPage() {
		return CartPageProductPrice.getText();
		
	}
	
	
	
	
	
	
	public void clickOnCheckoutBtn() {
		CartPageCheckoutBtn.click();
		
	}
	
	
	
	

	public void waitForElementOfTheCartPage() {
		waitForElememtTobeDisplayed(Product_price_CartPage);
		waitForElememtTobeDisplayed(Product_name_CartPage);
		waitForElememtTobeDisplayed(cancelBtn);
	}
	

}