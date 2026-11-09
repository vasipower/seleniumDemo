package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateDropdown {

	WebDriver driver;

	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dropdown");
		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();

	}

	@Test

	void ValidateDropdown() {
		WebElement dropdownSelect = driver.findElement(By.id("dropdown"));

		Select s = new Select(dropdownSelect);
		// s.selectByVisibleText("Option 1");

		s.selectByIndex(1);

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
