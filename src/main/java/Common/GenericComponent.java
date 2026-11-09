package Common;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.RandomStringUtils;
public class GenericComponent {
	
	WebDriver driver;
	
	
	
	
	public GenericComponent(WebDriver driver) {
		
		
		this.driver=driver;
		
	}


	public void waitForElememtTobeDisplayed(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
	   
	}
	
	
	public String generateName() {
		
		 String name = RandomStringUtils.randomAlphabetic(5);
		
		 return name;
		
	}
	
	
	public String generatePostalcode() {
		
		 String postalCode = RandomStringUtils.randomNumeric(5);
		
		 return postalCode;
		
	}
	
	
	

	
	
}
