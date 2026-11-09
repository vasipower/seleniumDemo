package Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
public Properties pr;

	
	
	@BeforeMethod(alwaysRun = true)
	public void browsersetup() throws IOException {
		
		
		 pr=new Properties();
		
		FileInputStream fi=new FileInputStream("src/test/resources/config.properties");
		pr.load(fi);
		
		String browserName=pr.getProperty("browser");
		String env=pr.getProperty("env");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();

			ChromeOptions op = new ChromeOptions();

			op.addArguments("--incognito");

			driver = new ChromeDriver(op);
			
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			
			
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
			
		}
		
		else {
			
			throw new RuntimeException("Browser is not supported ->> " +browserName);
			
		}
		
		if (env.equalsIgnoreCase("stage")) {

			driver.get(pr.getProperty("stage_url"));

		} else {

			driver.get(pr.getProperty("Prod_url"));
		}
		
		driver.manage().window().maximize();

	}



}
