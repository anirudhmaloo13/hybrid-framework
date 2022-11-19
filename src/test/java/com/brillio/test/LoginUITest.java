package com.brillio.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.brillio.base.WebDriverWrapper;

public class LoginUITest extends WebDriverWrapper {

	@Test(groups= {"high", "login"})
	public void validateLoginTitle() 
	{
		Assert.assertEquals(driver.getTitle(), "OpenEMR Login");
	}
}
