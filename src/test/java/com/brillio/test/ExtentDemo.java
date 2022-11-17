package com.brillio.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentDemo {
	public static void main(String[] args) {
		
	// run only once
	
	ExtentSparkReporter spark=new ExtentSparkReporter("target/spark.html");
	
	ExtentReports extent=new ExtentReports();
	
	extent.attachReporter(spark);
	
	// create test - log // @Before Method
	
	ExtentTest test=extent.createTest("TC1");
	
	// run the test method @Test
	
	
	// log the result // @After Method
	test.log(Status.PASS, "Test passed");
	
	// generate report // run only once
	extent.flush();
	}
}
