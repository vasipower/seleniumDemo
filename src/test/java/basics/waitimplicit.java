package basics;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitimplicit {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions op = new ChromeOptions();

		op.addArguments("--incognito");

		WebDriver 	driver = new ChromeDriver(op);
		
		
  // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	// Thread.sleep(10000);
		 
		 
			driver.get("https://www.saucedemo.com/");
			
			
			Wait<WebDriver> fluentWait =new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);
			
			fluentWait.until(ExpectedConditions.presenceOfElementLocated((By.id("user-name11111"))));
			
		  //  wait.until(ExpectedConditions.presenceOfElementLocated((By.id("user-name"))));
		  //  
		    driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
	
			driver.findElement(By.id("login-button")).click();

			
			
	//	Fluent wait
			
			
			
			
			
			//	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			
		
	}

}
