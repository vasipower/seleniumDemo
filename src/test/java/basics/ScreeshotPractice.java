package basics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class ScreeshotPractice {

	WebDriver driver;

	@BeforeMethod
	void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		System.out.println("Browser lunched and navigated to respective page");
		driver.manage().window().maximize();

	}

	@Test

	void takeTheScreenshot() {
		
		
		File fromFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				
		//File tofolderFile=new File("/Users/user/eclipse-workspace/LearnSelenium/screenshots/demo1.png");	
		
		
		String projPath =System.getProperty("user.dir");
		
		String CreateFolder=projPath+File.separator +"screeshot" +File.separator;
		
		String timePattern=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hhmmss"));
		
		String finalFolderName ="Google_"+timePattern+".png";
		
		
		
	File Tofile=new File(	CreateFolder + finalFolderName);
		
	Tofile.getParentFile().mkdirs();
		
		try {
			FileUtils.copyFile(fromFile, Tofile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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

