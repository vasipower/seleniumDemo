package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateCheckbox {


	WebDriver driver;



	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/checkboxes");
		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();

	}

	@Test

	void ValidateCheckbox() {
		
		
	WebElement checkbox1=	driver.findElement(By.id("checkbox1"));
		
		
//	if(!checkbox1.isSelected()) {
//		checkbox1.click();
//		
//	}else {
//		
//		System.out.println("Checkbox Already Selected");
//	}
//	
	if(!checkbox1.isEnabled()) {
		
	
		System.out.println("Checkbox is disabled");
	}
else {
		
	checkbox1.click();

	System.out.println("Checkbox is enabeled");
	}
		
		
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

