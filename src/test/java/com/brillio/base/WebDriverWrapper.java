package com.brillio.base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWrapper {
    protected  WebDriver driver;
    private ExtentReports extent;
    protected ExtentTest test;
    
    @BeforeSuite
    public void start()
    {
    	ExtentSparkReporter spark=new ExtentSparkReporter("target/spark.html");
    	
    	extent=new ExtentReports();
    	
    	extent.attachReporter(spark);
    }
	
    @AfterSuite
    public void end()
    {
    	extent.flush();	
    }
    
	@BeforeMethod
	@Parameters({"browser"})
	// Before Method will trigger before each test method
	public void setup(@Optional("ch") String browsername, Method method)
	{
		test=extent.createTest(method.getName());
		// String browser="ch";
		
		if (browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			
		    driver= new ChromeDriver();
		}
       
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demo.openemr.io/openemr/interface/login/login.php?site=default");
	}
	
	
	@AfterMethod
	//  After Method will trigger after each test method
	public void teardown(ITestResult result)
	{
		// test.log(Status.PASS, "Test passed"); --> hard coded
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAILED", ExtentColor.RED));
			test.fail(result.getThrowable());
		}else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "PASSED", ExtentColor.GREEN));
		}else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		
		driver.quit();
	}
}
