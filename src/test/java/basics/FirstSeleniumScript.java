package basics;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumScript {

	public static void main(String[] args) {
	
		
		
		//Selection browser 
		//creation of object with driver with respect to  selected browser 
		//where to go 
		
		
		//chrome browser 
		
		
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		


	}

}
