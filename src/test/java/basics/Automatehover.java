package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automatehover {

	WebDriver driver;

	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/hovers");
		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();

	}

	@Test

	void GeteStudentName() {
		
		WebElement movetoelemt = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
		
		Actions ac=new Actions(driver);
		
		ac.moveToElement(movetoelemt).perform();
		
		
		
		WebElement studentName = driver.findElement(By.xpath("(//h5)[1]"));

		String ss=studentName.getText();
		
		System.out.println("student Name= "+ ss);
		
		

	}

	@AfterMethod

	void AfterTest() {

		driver.quit();
		System.out.println("Browser Closed");

	}

}

