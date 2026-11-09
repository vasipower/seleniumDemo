package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FillForm {
	
	

	WebDriver driver;



	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		System.out.println("Browser lunched and navigated to respective page");

	}

	@Test

	void Testcase1() {

		
		//First name field

	//	driver.findElement(By.id("firstName")).sendKeys("Vasista");

		driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).sendKeys("Vasista");
		
		
		
		//lastName name field
		
		driver.findElement(By.id("lastName")).sendKeys("TVN");
		
		
		
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'name@example.com')]")).sendKeys("vasista@gmail.com");
		

		
		driver.findElement(By.id("gender-radio-1")).click();
		
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Mobile Number')]")).sendKeys("88929320119");

		
		
		//driver.findElement(By.id("subjectsInput")).sendKeys("Automation Learning");
		
		driver.findElement(By.xpath("//input[contains(@class,'subjects-auto-complete__input')]")).sendKeys("Automation learining using class");

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	@AfterMethod

	void AfterTest() {

		driver.quit();
		System.out.println("Browser Closed");

	}
	
	
	

}
