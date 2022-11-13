package com.brillio.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWrapper {
    protected  WebDriver driver;
	
	@BeforeMethod
	// Before Method will trigger before each test method
	public void setup()
	{
       WebDriverManager.chromedriver().setup();
		
	    driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demo.openemr.io/openemr/interface/login/login.php?site=default");
	}
	
	
	@AfterMethod
	//  After Method will trigger after each test method
	public void teardown()
	{
		driver.quit();
	}
}
