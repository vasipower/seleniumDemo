package basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchingBetweenTabs {

	WebDriver driver;

	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();

	}

	@Test

	void swtichingBetweenTabs() {
		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.flipkart.com/");
//		
//		//driver.close();
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.selenium.dev/selenium/web/locators_tests/locators.html");
//		Object[] wh=	driver.getWindowHandles().toArray();
//		driver.switchTo().window((String) wh[1]);
//	
	
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get("https://www.flipkart.com/");
	
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.selenium.dev/selenium/web/locators_tests/locators.html");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	driver.close();
	
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

