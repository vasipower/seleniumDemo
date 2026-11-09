package EndToEndFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ReadUtils.DataProviderExample;
import io.github.bonigarcia.wdm.WebDriverManager;

public class dataReadFromExcel {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	 WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/"); 
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderExample.class)
    public void testLogin(String username, String password) throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));


        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        
        Thread.sleep(5000);
        loginButton.click();

        System.out.println("The DataDriven test executed successfully");

        Assert.assertTrue(driver.getTitle().contains("Swag Labs"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); 
    }
}