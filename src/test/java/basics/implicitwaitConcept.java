package basics;

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

public class implicitwaitConcept {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	void beforeTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions op = new ChromeOptions();

		op.addArguments("--incognito");

		driver = new ChromeDriver(op);
		
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Thread.sleep(10000);
		 
		 
		 
		 
		 
		driver.get("https://www.saucedemo.com/");
		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(5000);

	}

	@Test

	void verifyimplicitWait() throws InterruptedException {

		
	
	    driver.findElement(By.id("user-1111")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		
		
		
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
