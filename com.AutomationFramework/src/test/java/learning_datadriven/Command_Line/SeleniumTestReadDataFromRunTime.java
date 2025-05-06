package learning_datadriven.Command_Line;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRunTime {
	
	WebDriver driver;
	@Test
	public void automateVtiger() throws IOException
	{
	String browser = System.getProperty("browser");
	String url= System.getProperty("url");
	String username= System.getProperty("username");
	String password = System.getProperty("password");
	
	Random r = new Random();
	int rand=r.nextInt(100,1000);
	
	String orgname = "QAA";
	
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
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get(url);
	
	driver.findElement(By.name("user_name")).sendKeys(username);
	
	driver.findElement(By.name("user_password")).sendKeys(password);
	
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[contains(@href, 'index.php?module=Accounts&action=i')]/ancestor::td[@class='tabUnSelected']")).click();
	
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	String name= orgname+rand;
	
	driver.findElement(By.xpath("//td[text()='Organization Name 			']/ancestor::tr[@style='height:25px']/descendant::input[@name='accountname']")).sendKeys(orgname+rand);

	driver.findElement(By.name("button")).click();
	
	 WebElement orgname1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
	 
	 System.out.println(orgname1.getText());
	 
	 
	}

}
