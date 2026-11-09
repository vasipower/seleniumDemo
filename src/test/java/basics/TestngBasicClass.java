package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngBasicClass {

	WebDriver driver;



	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Before Test");

	}

	@Test

	void Testcase1() {

		System.out.println("Test case 1");

	}
	
	
	
	@AfterMethod

	void AfterTest() {

		driver.quit();
		System.out.println("After Test");

	}
	

}
