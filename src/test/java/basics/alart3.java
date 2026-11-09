package basics;

import java.time.Duration;

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

public class alart3 {

	WebDriver driver;

	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();

	}

	@Test

	void verifyTheAlart2() {
	
		WebElement alartbtn2 = driver.findElement(By.id("confirmButton"));
		alartbtn2.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();

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

