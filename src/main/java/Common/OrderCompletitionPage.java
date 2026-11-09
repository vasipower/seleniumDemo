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

public class OrderCompletitionPage extends GenericComponent {

	WebDriver driver;

	public OrderCompletitionPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement OrderCompletitionText;

	By PDFDownloadBtn = By.id("generate-pdf-order");

	public String getProductPriceFromCompletionPage() {
		return OrderCompletitionText.getText();

	}

	public void waitForElementOfTheCompletionPage() {
		waitForElememtTobeDisplayed(PDFDownloadBtn);

	}

}