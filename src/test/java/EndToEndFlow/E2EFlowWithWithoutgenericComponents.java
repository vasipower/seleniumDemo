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

import Common.CartPage;
import Common.CheckoutOverviewPage;
import Common.LandingPgae;
import Common.OrderCompletitionPage;
import Common.ProductDetailsPage;
import Common.ProductListPage;
import Common.UserDetailspage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class E2EFlowWithWithoutgenericComponents {

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

		// Landing Page
		LandingPgae LP = new LandingPgae(driver);
		LP.loginwithUserDetails("standard_user", "secret_sauce");

		// product list page
		ProductListPage PLP = new ProductListPage(driver);
		PLP.SelectTheBackPack();

		// product details page
		ProductDetailsPage PDP = new ProductDetailsPage(driver);
		PDP.waitForElementOfTheProductPage();

		String actualProdouctName = PDP.getProductName();
		String actualPriceOfTheProduct = PDP.getProductPrice();

		PDP.addToCart();
		PDP.clickCartIcon();

		CartPage cp = new CartPage(driver);

		cp.waitForElementOfTheCartPage();

		String cartPageProdouctName = cp.getProductNameFromCartPage();
		String cartPagePriceOfTheProduct = cp.getProductPriceFromCartPage();

		Assert.assertEquals(actualProdouctName, cartPageProdouctName);
		Assert.assertEquals(actualPriceOfTheProduct, cartPagePriceOfTheProduct);
		cp.clickOnCheckoutBtn();

		UserDetailspage USD = new UserDetailspage(driver);

		USD.waitForElementOfTheUserDetailsPage();
		USD.enterUserDetails();

		CheckoutOverviewPage COP = new CheckoutOverviewPage(driver);

		COP.waitForElementOfTheCheckoutOverviewPage();
		String OverViewPageProdouctName = COP.getProductNameFromCOverviewPage();
		String OverViewPagePriceOfTheProduct = COP.getProductpriceFromCOverviewPage();

		Assert.assertEquals(actualProdouctName, OverViewPageProdouctName);
		Assert.assertEquals(actualPriceOfTheProduct, OverViewPagePriceOfTheProduct);
		COP.clickOnFinishBtn();


		OrderCompletitionPage OC = new OrderCompletitionPage(driver);

		OC.waitForElementOfTheCompletionPage();

		String OrderMessage = OC.getProductPriceFromCompletionPage();
		Assert.assertEquals("Thank you for your order!", OrderMessage);


	}

	

}
