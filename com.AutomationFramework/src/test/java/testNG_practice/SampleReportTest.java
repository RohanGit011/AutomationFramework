package testNG_practice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.AutomationFramework.Listenerutility.BaseClassTest1;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest extends BaseClassTest1{
	

	@Test
	public void createContactTest()
	{
		
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO, "Login to the application");
		
		test.log(Status.INFO, "Navigate to the create contact page");
		
		test.log(Status.INFO, "Create contact");
		
		if("HDFC".equals("HDFC"))
			test.log(Status.PASS, "Contact is created");
		
		else {
			test.log(Status.FAIL, "Contact is not created");
		}
		
		test.log(Status.INFO,"Program ends");
		
	}
	
	
	@Test
	public void createContactWithORG()
	{
		ExtentTest test = report.createTest("createContactWithORG");
		
		test.log(Status.INFO, "Login to the application");
		
		test.log(Status.INFO, "Navigate to the create contact page");
		
		test.log(Status.INFO, "Create contact");
		
		if("HDFC".equals("HFC"))
			test.log(Status.PASS, "Contact is created");
		
		else
			test.log(Status.FAIL, "Contact is not created");
	
		
		test.log(Status.INFO,"Program ends");
	}
	
	@Test
	public void createContactWithPhoneNumber()
	{
		
		ExtentTest test = report.createTest("createContactWithPhoneNumber");
		
		test.log(Status.INFO, "Login to the application");
		
		test.log(Status.INFO, "Navigate to the create contact page");
		
		test.log(Status.INFO, "Create contact");
		
		if("HDFC".equals("HDFC"))
			test.log(Status.PASS, "Contact is created");
		
		else
			test.log(Status.FAIL, "Contact is not created");
		
		test.log(Status.INFO,"Program ends");
		
	}

}
