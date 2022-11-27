package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	private static By usernamelocator=By.id("authUser");
	private static By passwordlocator=By.id("clearPass");
	private static By languagelocator=By.xpath("//select[@name='languageChoice']");
	private static By loginlocator=By.id("login-button");
	private static By errormessagelocator=By.xpath("//div[contains(text(),'Invalid username or password')]");
	
	
	public static void enterUsername(WebDriver driver, String username)
	{
		driver.findElement(usernamelocator).sendKeys(username);
	}

	public static void enterPassword(WebDriver driver, String password)
	{
		driver.findElement(passwordlocator).sendKeys(password);
	}
	
	public static void selectTheLanguageByVisibleText(WebDriver driver, String language)
	{
	Select select=new Select(driver.findElement(languagelocator));
	select.selectByVisibleText(language);
    }
	
	public static void clickOnLogin(WebDriver driver)
	{
	driver.findElement(loginlocator).click();
	}
	
	public static String getErrorMessageByInvalidCredential(WebDriver driver)
	{
		return driver.findElement(errormessagelocator).getText();
	}
	
}
