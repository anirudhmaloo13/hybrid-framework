package com.brillio.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	@Test
	
	public void validCredentialTest()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demo.openemr.io/openemr/interface/login/login.php?site=default");
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		driver.findElement(By.id("login-button")).click();
		
		String actualtitle= driver.getTitle();
		Assert.assertEquals(actualtitle, "OpenEMR");
	}
	
	@Test
	
	public void invalidCredentialTest()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demo.openemr.io/openemr/interface/login/login.php?site=default");
		driver.findElement(By.id("authUser")).sendKeys("admin1233");
		driver.findElement(By.id("clearPass")).sendKeys("pass12");
		driver.findElement(By.id("login-button")).click();
		
		String actualerror= driver.findElement(By.xpath("//div[contains(text(),'Invalid username or password')]")).getText();
		
		Assert.assertEquals(actualerror, "Invalid username or password");
	}
}
