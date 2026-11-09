package basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
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

public class webdriverMethods {

	WebDriver driver;

	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	//driver.get("https://testautomationpractice.blogspot.com/");
//driver.get("https://www.google.com/");
	driver.get("https://testkru.com/Elements/TextFields");
		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();

	}

	@Test

	void verifyTheAlart2() {
//	
//		String title=driver.getTitle();
//		System.out.println("->>>>"+title);
		
//		
//		String pagesource=	driver.getPageSource();
//		System.out.println("->>>>"+pagesource);
//		
		
		
//		String pageurl=	driver.getCurrentUrl();
//		System.out.println("->>>>"+pageurl);
		
//	WebElement locationcordinates=	driver.findElement(By.xpath("//a[text()='About']"));
//	int xvalue=locationcordinates.getLocation().getX();
//	int yvalue=locationcordinates.getLocation().getY()	;
//	
//	System.out.println("location of button->>> "+xvalue);
//	
//	System.out.println("location of button"+yvalue);
//	
//	
//	
//	WebElement locationcordinates1=	driver.findElement(By.xpath("//a[text()='Gmail']"));
//	int xvalue1=locationcordinates1.getLocation().getX();
//	int yvalue1=locationcordinates1.getLocation().getY()	;
//	
//	System.out.println("x value postion of Gmail->> "+xvalue1);
//	
//	System.out.println("y value postion of Gmail->>  "+yvalue1);
	
	
//	WebElement sizeofButton=	driver.findElement(By.xpath("//button[text()='START']"));
//	int xvalue2=sizeofButton.getSize().getHeight();
//	int yvalu2e=sizeofButton.getSize().getWidth()
//	;
//	System.out.println("Height of the button->>>  "+xvalue2);
//	
//	System.out.println("Width of the button->> "+yvalu2e);
//	
//	
//	WebElement sizeofButton1=	driver.findElement(By.xpath("//button[@id='confirmBtn']"));
//	int xvalue11=sizeofButton1.getSize().getHeight();
//	int yvalue11=sizeofButton1.getSize().getWidth()
//	;
//	System.out.println("Height of the button1->>>  "+xvalue11);
//	
//	System.out.println("Width of the button1->> "+yvalue11);
	
	
	
//		
//	WebElement sizeofButton1=	driver.findElement(By.id("name"));
//	sizeofButton1.click();
//	
//	sizeofButton1.sendKeys("TVN Vasista");
//	try {
//		Thread.sleep(2000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	sizeofButton1.clear();
//	
//	try {
//		Thread.sleep(2000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	sizeofButton1.sendKeys("Vasista");
//	
	
//
		
		
	WebElement nameField=	driver.findElement(By.id("firstName"));
		
	
	String atributeType=	nameField.getAttribute("type");
	System.out.println("Attribute Type ->> "+atributeType);
	
	
//
//	String atributeTypeAsID=	nameField.getAttribute("id");
//	System.out.println("Attribute Type Using ID ->> "+atributeTypeAsID);
//	
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

