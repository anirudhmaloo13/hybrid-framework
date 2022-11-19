package com.brillio.test;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.brillio.base.WebDriverWrapper;
import com.brillio.pages.LoginPage;
import com.brillio.utilities.DataUtils;


public class Login extends WebDriverWrapper{
	

	@Test(dataProvider = "commonDataProvider", dataProviderClass= DataUtils.class, groups= {"low", "login"})
	
	public void validCredentialTest(String username, String password, String language, String expectedTitle)
	{
		
		//driver.findElement(By.id("authUser")).sendKeys(username);
		LoginPage.enterUsername(driver, username);
		test.log(Status.INFO, "Enter username as "+ username);
		
		//driver.findElement(By.id("clearPass")).sendKeys(password);
		LoginPage.enterPassword(driver, password);
		test.log(Status.INFO, "Enter password as "+ password);
		//Select select=new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		//select.selectByVisibleText(language);
		LoginPage.selectTheLanguageByVisibleText(driver, language);
		
		test.log(Status.INFO, "Enter language as "+ language);
		
		//driver.findElement(By.id("login-button")).click();
		LoginPage.clickOnLogin(driver);
		test.log(Status.INFO, "Clicked on login");
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("OpenEMR"));
		
		String actualtitle= driver.getTitle();
		test.log(Status.INFO, "Title is "+ actualtitle);
		Assert.assertEquals(actualtitle, expectedTitle);
	}
	
	@Test(dataProvider = "commonDataProvider", dataProviderClass= DataUtils.class, groups= {"high", "login"})
	
	public void invalidCredentialTest(String username, String password, String language, String expectedTitle)
	{
		
		//driver.findElement(By.id("authUser")).sendKeys(username);
		LoginPage.enterUsername(driver, username);
		test.log(Status.INFO, "Enter username as "+ username);
		//driver.findElement(By.id("clearPass")).sendKeys(password);
		LoginPage.enterPassword(driver, password);
		test.log(Status.INFO, "Enter password as "+ password);
		
		
		Select select=new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		select.selectByVisibleText(language);
		test.log(Status.INFO, "Enter language as "+ language);
		
		driver.findElement(By.id("login-button")).click();
		test.log(Status.INFO, "Clicked on login");
		
		//String actualerror= driver.findElement(By.xpath("//div[contains(text(),'Invalid username or password')]")).getText();
		String actualerror=LoginPage.getErrorMessageByInvalidCredential(driver);
		
		test.log(Status.INFO, "Title is "+ actualerror);
		Assert.assertEquals(actualerror, expectedTitle);
	}

	
}
