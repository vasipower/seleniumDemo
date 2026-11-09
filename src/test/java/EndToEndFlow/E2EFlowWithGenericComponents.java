package EndToEndFlow;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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

import Common.BaseTest;
import Common.CartPage;
import Common.CheckoutOverviewPage;
import Common.LandingPgae;
import Common.OrderCompletitionPage;
import Common.ProductDetailsPage;
import Common.ProductListPage;
import Common.UserDetailspage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class E2EFlowWithGenericComponents extends BaseTest{


	WebDriverWait wait;

    @Test (groups = {"sanity99"})
	

	void VerifyTheE2EFlowTest() throws InterruptedException {
	
		// Landing Page
		LandingPgae LP = new LandingPgae(driver);
		LP.loginwithUserDetails(pr.getProperty("username"), pr.getProperty("password"));

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

		AssertJUnit.assertEquals(actualProdouctName, cartPageProdouctName);
		AssertJUnit.assertEquals(actualPriceOfTheProduct, cartPagePriceOfTheProduct);
		cp.clickOnCheckoutBtn();

		UserDetailspage USD = new UserDetailspage(driver);

		USD.waitForElementOfTheUserDetailsPage();
		USD.enterUserDetails();

		CheckoutOverviewPage COP = new CheckoutOverviewPage(driver);

		COP.waitForElementOfTheCheckoutOverviewPage();
		String OverViewPageProdouctName = COP.getProductNameFromCOverviewPage();
		String OverViewPagePriceOfTheProduct = COP.getProductpriceFromCOverviewPage();

		AssertJUnit.assertEquals(actualProdouctName, OverViewPageProdouctName);
		AssertJUnit.assertEquals(actualPriceOfTheProduct, OverViewPagePriceOfTheProduct);
		COP.clickOnFinishBtn();


		OrderCompletitionPage OC = new OrderCompletitionPage(driver);

		OC.waitForElementOfTheCompletionPage();

		String OrderMessage = OC.getProductPriceFromCompletionPage();
		AssertJUnit.assertEquals("Thank you for your order!", OrderMessage);


	}
	


//	@Test (dependsOnMethods = {"VerifyTheE2EFlowTest"})'
	@Test (dependsOnGroups = {"sanity"})
	//@Test (groups = {"uat"})

	void verifyThePageURL() throws InterruptedException {
	
		
		System.out.println("Able to verify the Page URL'S of all the pages");
		
	}
	
	
	
//	@Test (dependsOnMethods = {"VerifyTheE2EFlowTest"})'
	@Test (dependsOnGroups = {"sanity"})
	void verifyThePageURL1() throws InterruptedException {
	
		// Landing Page
				LandingPgae LP = new LandingPgae(driver);
				LP.loginwithUserDetails(pr.getProperty("username"), pr.getProperty("password"));

				// product list page
				ProductListPage PLP = new ProductListPage(driver);
				PLP.SelectTheBackPack();
		System.out.println("Able to verify the Page URL'S of all the pages");
		
	}
	
	


	@Test(groups = {"uat"})
	void verifyThePageURL2() throws InterruptedException {
	
		// Landing Page
				LandingPgae LP = new LandingPgae(driver);
				LP.loginwithUserDetails(pr.getProperty("username"), pr.getProperty("password"));

				// product list page
				ProductListPage PLP = new ProductListPage(driver);
				PLP.SelectTheBackPack();

		
	}
	
	
	@Test
	void verifyThePageURL3() throws InterruptedException {
		
		System.out.println("UAT Test case-2");
		
	}
	
	
	

	void VerifyTheE2EFlowTest1() throws InterruptedException {
		
		System.out.println("only");
	}

	@AfterMethod

	void AfterTest() {

		driver.quit();
		System.out.println("Browser Closed");

	}
	


}
