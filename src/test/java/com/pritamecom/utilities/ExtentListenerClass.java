package com.pritamecom.utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener
{
	//created 3 objects 
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	//creating configurereport method to configure extent report, html report
	public void configureReport()
	{
		//initialize the object which we created earlier
		htmlReporter = new ExtentSparkReporter("ExtentSparkReportrDemo.html"); //in costructor we pass the html report name(it'll generated in project)
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("user name", "Pritam");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my first Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	//onstart method is called when any test starts
	public void onStart(ITestContext Result) 
	{
		configureReport();
		System.out.println("On start method invoked..");
	}
	
	//onFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result) 
	{
		System.out.println("On Finish method invoked..");
		reports.flush(); //it is mandatory to call finish method  to ensure info is written to the started reporter
	}
	
	//when test case get failed, this method is called
	public void onTestFailure(ITestContext Result) 
	{
		System.out.println("Name of test method failed: "+ Result.getName());
		test = reports.createTest(Result.getName());   //create entery in html report
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: "+ Result.getName(), ExtentColor.RED));
	
		String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + Result.getName() + ".png";
		File screenShotFile = new File (screenShotPath);
		
		if(screenShotFile.exists())
		{
			test.fail("Captured Screenshot is below: " + test.addScreenCaptureFromPath(screenShotPath));
		}
		
		//test.addScreenCaptureFromPath()
	}
	
	
	  //when test case get Skipped, this method is called
		public void onTestSkipped(ITestContext Result) 
		{
			System.out.println("Name of test method Skipped: "+ Result.getName());
			test = reports.createTest(Result.getName());   //create entery in html report
			test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: "+ Result.getName(), ExtentColor.YELLOW));
		}
		
		
		//when test case get started, this method is called
		public void onTestStart(ITestContext Result) 
		{
			System.out.println("Name of test method started: "+ Result.getName());
		}
		
		//when test case get passed, this method is called
		public void onTestSuccess(ITestContext Result) 
		{
			System.out.println("Name of test cases successfuly executed: "+ Result.getName());
			test = reports.createTest(Result.getName());   
			test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: "+ Result.getName(), ExtentColor.GREEN));	
		}
		
		public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
		{
			
		}
		//whenever we implements the interface, we have to address all the abstract methods of it wheather it'll in use or not..
		//So, we implement the onTestFailedButWithinSuccessPercentage()
}
