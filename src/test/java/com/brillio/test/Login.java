package com.brillio.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver driver;
	
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

	@Test(priority = 1)
	
	public void validCredentialTest()
	{
		
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		driver.findElement(By.id("login-button")).click();
		
		String actualtitle= driver.getTitle();
		Assert.assertEquals(actualtitle, "OpenEMR");
	}
	
	@Test(priority = 2)
	
	public void invalidCredentialTest()
	{
		
		driver.findElement(By.id("authUser")).sendKeys("admin1233");
		driver.findElement(By.id("clearPass")).sendKeys("pass12");
		driver.findElement(By.id("login-button")).click();
		
		String actualerror= driver.findElement(By.xpath("//div[contains(text(),'Invalid username or password')]")).getText();
		
		Assert.assertEquals(actualerror, "Invalid username or password");
	}
}
