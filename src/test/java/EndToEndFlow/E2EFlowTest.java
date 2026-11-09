package EndToEndFlow;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.LandingPgae;
import io.github.bonigarcia.wdm.WebDriverManager;

public class E2EFlowTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	void beforeTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions op = new ChromeOptions();

		op.addArguments("--incognito");

		driver = new ChromeDriver(op);
		driver.get("https://www.saucedemo.com/");
		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(5000);

	}

	@Test

	void VerifyTheE2EFlowTest() throws InterruptedException {

		// landing page
		
	    wait.until(ExpectedConditions.presenceOfElementLocated((By.id("user-name"))));
	    
		LandingPgae LP=	new LandingPgae(driver);
		LP.loginwithUserDetails("standard_user", "secret_sauce");
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.id("password")).sendKeys("");
//		driver.findElement(By.id("login-button")).click();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@data-test='inventory-item-name']"))));
		String prodctName = "Sauce Labs Backpack";

		// product list page

		driver.findElement(By.linkText(prodctName)).click();

		String ActualProductName = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();
		String ActualProductPrice = driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();

		System.out.println("Selected product name--->>>>>>>>> " + ActualProductName);

		System.out.println("Selected product procice-> " + ActualProductPrice);

		driver.findElement(By.id("add-to-cart")).click();

		// cart page
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='inventory_item_price']"))));

		String cartPageProductName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		String cartPageProductPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();

		System.out.println("Cart page Product Name ->  " + cartPageProductName);

		System.out.println("Cart page Product price --->>>>>>>>> " + cartPageProductPrice);

		Assert.assertEquals(ActualProductName, cartPageProductName);
		Assert.assertEquals(ActualProductPrice, cartPageProductPrice);

		driver.findElement(By.id("checkout")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("first-name"))));

		// user details page

		String FirstName = RandomStringUtils.randomAlphabetic(5);
		String LastName = RandomStringUtils.randomAlphabetic(5);
		String postalcode = RandomStringUtils.randomNumeric(5);

		driver.findElement(By.id("first-name")).sendKeys(FirstName);
		driver.findElement(By.id("last-name")).sendKeys(LastName);
		driver.findElement(By.id("postal-code")).sendKeys(postalcode);

		driver.findElement(By.id("continue")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@class='inventory_item_name']"))));

		// xxx page

		String OverviewPageproductName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

		String OverviewPageproductPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']"))
				.getText();

		System.out.println("Overview page Product Name--->>>>>>>>> " + OverviewPageproductName);

		System.out.println("Overview page Product price --->>>>>>>>> " + OverviewPageproductPrice);

		Assert.assertEquals(ActualProductName, OverviewPageproductName);
		Assert.assertEquals(ActualProductPrice, OverviewPageproductPrice);

		driver.findElement(By.id("finish")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("generate-pdf-order"))));

		String OrderCompletitionText = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();

		Assert.assertEquals("Thank you for your order!", OrderCompletitionText);

	}

	@AfterMethod

	void AfterTest() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
		System.out.println("Browser Closed");

	}

}
