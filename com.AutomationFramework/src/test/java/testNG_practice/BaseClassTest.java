package testNG_practice;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.AutomationFramework.generic.fileutility.DatabaseUtility;
import com.AutomationFramework.generic.fileutility.FileUtility;
import com.AutomationFramework.generic.webdriverutility.JavaUtility;
import com.AutomationFramework.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClassTest {
	
	public WebDriver driver;
	
	DatabaseUtility db = new DatabaseUtility();
	WebDriverUtility wu = new WebDriverUtility();
	FileUtility fLib = new FileUtility();
	
	
	@BeforeSuite
	public void beforeSuiteMethodTest() throws SQLException
	{
		System.out.println("This is before suite method");
		System.out.println("We do db connection and report configuration");
		db.getConnection("root", "root");
		
	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void beforeClassMethodTest() throws Throwable
	{
		System.out.println("This is Before class Method");
		
		String browser = fLib.getDataFromPropertyFile("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver(); 
		}
		else
			driver=new ChromeDriver();
		
		driver.manage().window().maximize();

	}
	
	@BeforeMethod
	public void beforeMethodTest() throws Throwable
	{
		System.out.println("This is before method");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(fLib.getDataFromPropertyFile("url"),"admin", "admin");
	}
	
	@AfterMethod
	public void afterMethodTest()
	{
		HomePage hp = new HomePage(driver);

		System.out.println("This is after Method");
		wu.moveMouseCursor(driver,hp.getAcountLink());
		hp.getLogoutLink().click();
	}
	
	@AfterClass
	public void afterClassMethodTest()
	{
		System.out.println("This is after class Method");
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuiteMethodTest() throws SQLException
	{
		System.out.println("This is after suite Method");
		db.closeDatabase();
	}

}
