package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	public static void enterUsername(WebDriver driver, String username)
	{
		driver.findElement(By.id("authUser")).sendKeys(username);
	}

	public static void enterPassword(WebDriver driver, String password)
	{
		driver.findElement(By.id("clearPass")).sendKeys(password);
	}
	
	public static void selectTheLanguageByVisibleText(WebDriver driver, String language)
	{
	Select select=new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
	select.selectByVisibleText(language);
    }
	
	public static void clickOnLogin(WebDriver driver)
	{
	driver.findElement(By.id("login-button")).click();
	}
	
	public static String getErrorMessageByInvalidCredential(WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[contains(text(),'Invalid username or password')]")).getText();
	}
	
}
