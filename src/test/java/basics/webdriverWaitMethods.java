package basics;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webdriverWaitMethods {

	WebDriver driver;

	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");

		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();

	}

	@Test

	void verifyWaitConditions() {
		
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
	
		driver.findElement(By.id("firstName"));
		
		
	wait.until(ExpectedConditions.presenceOfElementLocated((By.id("firstName"))));
	wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("firstName"))));
	wait.until(ExpectedConditions.elementToBeClickable((By.id("submit"))));
	wait.until(ExpectedConditions.attributeContains(By.id("userEmail"), "placeholder", "name@example.com"));
			
			
	
	driver.findElement(By.id("gender-radio-1")).click();    
	wait.until(ExpectedConditions.elementToBeSelected(By.id("gender-radio-1")));
	
	
	wait.until(ExpectedConditions.titleIs("demosite"));
	wait.until(ExpectedConditions.urlContains("automation-practice-form"));
	
	
	
	//driver.findElement(By.id("submit")).click();
		
		

		
		
		
		

	}

	@AfterMethod

	void AfterTest() {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
		System.out.println("Browser Closed");

	}

}
