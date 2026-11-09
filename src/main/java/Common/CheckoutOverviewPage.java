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

public class CheckoutOverviewPage extends GenericComponent {

	WebDriver driver;

	public CheckoutOverviewPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement productNameInOverviewPage;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement productPriceInOverviewPage;
	

	@FindBy(id = "finish")
	WebElement FinishBtn;
	
	


	By overViewPageIteamName = By.xpath("//div[@class='inventory_item_name']");

	public void waitForElementOfTheCheckoutOverviewPage() {
		waitForElememtTobeDisplayed(overViewPageIteamName);

	}
	
	

	public String getProductNameFromCOverviewPage() {
		return productNameInOverviewPage.getText();
		
	}
	
	

	public String getProductpriceFromCOverviewPage() {
		return productPriceInOverviewPage.getText();
		
	}
	
	
	public void clickOnFinishBtn() {
		FinishBtn.click();
		
	}
	

}