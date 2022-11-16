package com.brillio.test;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.brillio.base.WebDriverWrapper;
import com.brillio.utilities.DataUtils;


public class Login extends WebDriverWrapper{
	

	@Test(dataProvider = "commonDataProvider", dataProviderClass= DataUtils.class)
	
	public void validCredentialTest(String username, String password, String language, String expectedTitle)
	{
		
		driver.findElement(By.id("authUser")).sendKeys(username);
		driver.findElement(By.id("clearPass")).sendKeys(password);
		Select select=new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		select.selectByVisibleText(language);
		
		driver.findElement(By.id("login-button")).click();
		
		String actualtitle= driver.getTitle();
		Assert.assertEquals(actualtitle, expectedTitle);
	}
	
	@Test(dataProvider = "commonDataProvider", dataProviderClass= DataUtils.class)
	
	public void invalidCredentialTest(String username, String password, String language, String expectedTitle)
	{
		
		driver.findElement(By.id("authUser")).sendKeys(username);
		driver.findElement(By.id("clearPass")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		Select select=new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		select.selectByVisibleText(language);
		
		String actualerror= driver.findElement(By.xpath("//div[contains(text(),'Invalid username or password')]")).getText();
		
		Assert.assertEquals(actualerror, expectedTitle);
	}

	
}
