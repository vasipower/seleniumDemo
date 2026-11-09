package basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation {

	
	
	@Test
	void test() {
		
		System.out.println("test Method");
		
	}
	
	@BeforeTest
	void beforetest() {
		
		System.out.println("Before test");
		
	}
	
	
	
	
	
	@BeforeMethod
	void beforeMethod() {
		
		System.out.println("Before Method");
		
	}

	

	@BeforeSuite
	void beforesuit() {
		
		System.out.println("Before Suite");
		
	}
	
	
	@AfterMethod
	void AfterMethod() {
		
		System.out.println("After Method");
		
	}
	
	
	
	@AfterClass
	void aferclass() {
		
		System.out.println("After class");
	}
	
	
	@AfterTest 
	void Aftertest() {
		
		System.out.println("After test");
	}
	
	
	@AfterSuite
	void Aftersuit() {
		
		System.out.println("after Suite");
		
	}
	
	
	
	

	@BeforeClass
	void beforeclass() {
		
		System.out.println("Before class");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
