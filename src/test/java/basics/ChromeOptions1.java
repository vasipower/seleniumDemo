package basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptions1 {

	WebDriver driver;

	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions op = new ChromeOptions();

		op.addArguments("--incognito");
		op.addArguments("--start-maximized");
		//op.addArguments("--headless");

		op.addArguments("--disable-notifications");
		driver = new ChromeDriver(op);

		driver.get("https://testkru.com/Elements/TextFields");

		System.out.println("Browser lunched and navigated to respective page");

	}

	@Test

	void verifyChromeOptions() {

		WebElement nameField = driver.findElement(By.id("firstName"));
		String atributeType = nameField.getAttribute("type");
		System.out.println("Attribute Type ->> " + atributeType);

	}

	@AfterMethod

	void AfterTest() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// driver.quit();
		System.out.println("Browser Closed");

	}

}

//	ChromeOptions options = new ChromeOptions();
