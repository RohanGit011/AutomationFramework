package com.AutomationFramework.Listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;


public class ListenerImplementation implements ITestListener , ISuiteListener{
	
	public static ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite)
	{
		System.out.println("Report configuration");
		spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		
		spark.config().setDocumentTitle("CRM TEST SUITE RESULT");
		
		spark.config().setReportName("CRM report");
		
		spark.config().setTheme(Theme.STANDARD);
		
		
		report = new ExtentReports();
		
		report.attachReporter(spark);
		
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chrome-10");
	}
	
	@Override
	public void onFinish(ISuite suite)
	{
		report.flush();
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		
		test.log(Status.FAIL, methodName+"====>Failed");
		
		TakesScreenshot t = (TakesScreenshot) BaseClassTest1.sDriver;
		
		String path = t.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(path, methodName+"_"+time);
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		String name =result.getMethod().getMethodName();
		test = report.createTest(name);
		test.log(Status.INFO, name+"====>Started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		String name =result.getMethod().getMethodName();
		test.log(Status.PASS, name+"====>Completed");
	}

}
