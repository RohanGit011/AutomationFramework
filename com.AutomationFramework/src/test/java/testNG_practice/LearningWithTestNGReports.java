package testNG_practice;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class LearningWithTestNGReports {
	
	@Test
	public void method1Test(Method mtd) throws IOException
	{
		WebDriver driver = new ChromeDriver();
		Reporter.log(mtd.getName(),true);
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
	}

}
