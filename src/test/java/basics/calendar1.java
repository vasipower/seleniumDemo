package basics;

import java.time.LocalDate;

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

public class calendar1 {

	WebDriver driver;

	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/datepicker/");
		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();

	}

	@Test

	void uplaodFile() {
		
		
		
		WebElement iframe1 = driver.findElement(By.cssSelector(".demo-frame"));
		
		driver.switchTo().frame(iframe1);
		
		driver.findElement(By.id("datepicker")).click();
		
		
	String currentdate=	String.valueOf(LocalDate.now().getDayOfMonth());
	System.out.println("Today's date -> "+currentdate);
		
		WebElement selectDate=	driver.findElement(By.xpath("//a[text()='"+ currentdate +  "']"));
		selectDate.click();
		

	
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
