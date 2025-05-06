package testNG_practice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.AutomationFramework.Listenerutility.BaseClassTest1;
import com.AutomationFramework.Listenerutility.ListenerImplementation;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@Listeners(com.AutomationFramework.Listenerutility.ListenerImplementation.class)
public class LearningWithReportAndScreenshot extends ListenerImplementation  {


	@Test
	public void createContactTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");

		test.log(Status.INFO, "Login to the application");

		test.log(Status.INFO, "Navigate to the create contact page");

		test.log(Status.INFO, "Create contact");

		if ("HDFC".equals("HDgfFC"))
			test.log(Status.PASS, "Contact is created");

		else {
			test.log(Status.FAIL, "Contact is not created");
			
		}

		test.log(Status.INFO, "Program ends");

	}

}
