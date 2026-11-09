package basics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionPractice {

	WebDriver driver;

	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println("Browser lunched and navigated to respective page");

	}

	@Ignore
	@Test

	void ValidateThePageURL() {

		String ExpectedUrl = "https://www.yahoo.com/";

		String actualURL = driver.getCurrentUrl();

		assertEquals(actualURL, ExpectedUrl, "Page URL is not valid");

	}

	@Ignore
	@Test

	void ValidateThePageTitle() {

		String unexpectedTitle = "Yahoo";

		String actualTitle = driver.getTitle();

		assertNotEquals(actualTitle, unexpectedTitle, "Both Titles are same");

	}

	@Test
	
	@Ignore
	void validateTheLinkinHomeScreen() {

		WebElement aboutlink = driver.findElement(By.xpath("//a[text()='About']"));
		WebElement BrainstormBtn = driver.findElement(By.xpath("//span[text()='Brainstorm']"));
		String curretURL = driver.getCurrentUrl();

		assertTrue(aboutlink.isDisplayed(), "About link not Present in the Google Home screen ");
		assertTrue(BrainstormBtn.isDisplayed(), "Brainstorm  button not Present in the Google Home screen ");

		assertTrue(curretURL.contains("Yahoo"), "URL does not contain Google ");

	}
	
	
	
	
	@Test
	@Ignore
	void validateAssertionFalse() {

	Boolean isvisible= driver.findElements(By.xpath("//a[text()='About1']")).size()>0;
	
	assertFalse(isvisible, "About1 btn is displayed ");

	}
	
	
	
	
	@Test
	void Validatetittle() {
		
	String tittleOFWebsite=	driver.getTitle();
	
	
	assertNotNull(tittleOFWebsite, "Title is not present");
		
	
	}
	
	

	
	


	@AfterMethod

	void AfterTest() {

		driver.quit();
		System.out.println("Browser Closed");

	}

}
