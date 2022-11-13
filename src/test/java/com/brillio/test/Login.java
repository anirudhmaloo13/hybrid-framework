package com.brillio.test;



import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.brillio.base.WebDriverWrapper;


public class Login extends WebDriverWrapper{
	
	

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
